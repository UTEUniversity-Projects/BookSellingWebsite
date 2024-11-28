// Main function to control the action based on action type
function rowAction(itemId, action) {
    switch (action) {
        case "delete":
            confirmDelete(itemId);
            break;
        case "view":
            executeViewOrUpdateAction(itemId, "view");
            break;
        case "update":
            executeViewOrUpdateAction(itemId, "update");
            break;
        default:
            console.error(`Unsupported action: ${action}`);
    }
}

// Handles delete action with confirmation popup
function confirmDelete(itemId) {
    const popup = document.getElementById("delete-popup");
    popup.style.display = "flex";

    // Confirm delete
    document.getElementById("confirm-delete").onclick = () => {
        popup.style.display = "none";
        executeDeleteAction(itemId);
    };

    // Cancel delete
    document.getElementById("cancel-delete").onclick = () => {
        popup.style.display = "none";
    };
}

// Executes delete action using HTTP DELETE
function executeDeleteAction(itemId) {
    fetch(`${contextPath}/owner/author/delete`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ authorId: itemId }),
    })
        .then((response) => response.json())
        .then((data) => {
            // Show success or failure popup based on server response
            if (data.status === "success") {
                showPopup("success-popup", 2000);
            } else {
                showPopup("fail-popup", 3000);
            }
        })
        .catch((error) => {
            console.error("Error:", error);
            showPopup("fail-popup", 3000);
        });
}

// Handles view or update action and redirects based on server response
function executeViewOrUpdateAction(itemId, action) {
    fetch(`${contextPath}/session/owner/author/set-info`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            authorId: itemId,
            authorAction: action,
        }),
    })
        .then((response) => response.json())
        .then((data) => {
            if (data.status === "success") {
                // Redirect to the appropriate URL based on the action
                window.location.href = `${contextPath}/owner/author/${action}`;
            } else {
                alert("Error occurred during redirection.");
            }
        })
        .catch((error) => console.error("Error:", error));
}

// Displays a popup with an optional auto-hide feature
function showPopup(popupId, autoHideDuration) {
    const popup = document.getElementById(popupId);
    popup.style.display = "flex";

    if (autoHideDuration) {
        const autoHideTimeout = setTimeout(() => {
            fadeOutPopup(popup);
        }, autoHideDuration);

        const closeButton = popup.querySelector(".popup-close-button");
        if (closeButton) {
            closeButton.onclick = () => {
                clearTimeout(autoHideTimeout);
                fadeOutPopup(popup);
            };
        }
    }
}

// Handles popup fade-out animation and hides it
function fadeOutPopup(popupElement, callback) {
    popupElement.classList.add("fade-out");
    setTimeout(() => {
        popupElement.style.display = "none";
        popupElement.classList.remove("fade-out");
        if (callback) callback();
    }, 500); // Matches CSS transition duration
}

// Function to handle table row click events
function initializeTableRowClickHandler() {
    const tableBody = document.querySelector(".item-data-table tbody");

    if (tableBody) {
        tableBody.addEventListener("click", function (event) {
            const row = event.target.closest(".item-row");

            if (row && !event.target.closest("button") && !event.target.closest(".dropdown-menu")) {
                const authorId = row.getAttribute("data-id");
                rowAction(authorId, "view"); // Trigger "view" action
            }
        });
    }
}

// Function to initialize Lottie animations
function initializeLottieAnimations() {
    const animations = [
        { containerId: 'lottie-danger', jsonPath: '/assets/owner/json/danger.json' },
        { containerId: 'lottie-success', jsonPath: '/assets/owner/json/success.json' },
        { containerId: 'lottie-fail', jsonPath: '/assets/owner/json/fail.json' },
    ];

    animations.forEach(animation => {
        lottie.loadAnimation({
            container: document.getElementById(animation.containerId), // Animation container
            renderer: 'svg', // Render type: SVG
            loop: true, // Loop the animation
            autoplay: true, // Start automatically
            path: `${contextPath}${animation.jsonPath}` // Path to the animation JSON file
        });
    });
}

// Wait for the DOM content to be fully loaded
document.addEventListener("DOMContentLoaded", function () {
    initializeTableRowClickHandler();
    initializeLottieAnimations();
});

document.addEventListener("DOMContentLoaded", () => {
    const avatarInput = document.querySelector("#avatar");
    const createButton = document.querySelector("#create");

    const uploadImage = async (dir, inputSelector) => {
        try {
            const fileInput = document.querySelector(inputSelector);
            const files = fileInput?.files;
            if (!files || files.length === 0) return null;

            const formData = new FormData();
            formData.append("files", files[0]);
            formData.append("dir", dir);
            formData.append("fileName", `${Date.now()}-${files[0].name}`);
            formData.append("typeAction", "nonContextPath");

            const response = await fetch(`${contextPath}/upload`, {
                method: "POST",
                body: formData
            });

            if (response.ok) {
                const result = await response.json();
                return result.imageLinks[0];
            } else {
                console.error("Upload failed:", response.statusText);
                return null;
            }
        } catch (error) {
            console.error("Error uploading file:", error);
            return null;
        }
    };

    const handleCreateAuthor = async () => {
        let avatar = await uploadImage("author", "#avatar");
        if (!avatar) {
            avatar = `/images/anonymous/author.jpg`;
        }

        const form = document.getElementById("authorForm");
        const formData = new FormData(form);

        const introduction = editor.root.innerHTML.trim();
        if (!formData.get("name") || !introduction || introduction === "<p><br></p>") {
            alert("Tên tác giả và giới thiệu không được để trống!");
            return;
        }

        formData.append("avatar", avatar);
        formData.append("introduction", introduction);

        const authorData = Object.fromEntries(formData.entries());

        try {
            const response = await fetch(`${contextPath}/owner/author/create`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(authorData)
            });

            const result = await response.json();

            if (result.success) {
                alert("Thêm mới thành công!");
                window.location.href = `${contextPath}/owner/author/list`;
            } else {
                alert("Thêm mới thất bại!");
                console.error("Create failed:", result.message || response.statusText);
            }
        } catch (error) {
            console.error("Error creating:", error);
            alert("Đã xảy ra lỗi khi thêm mới!");
        }
    };

    const handleUpdateAuthor = async () => {
        const formData = new FormData(document.getElementById("authorUpdateForm"));

        // Lấy giá trị từ input ẩn
        let avatar = formData.get("originAvatar");

        // Kiểm tra nếu người dùng upload avatar mới
        const avatarInput = document.getElementById("avatar");
        if (avatarInput.files && avatarInput.files.length > 0) {
            avatar = await uploadImage("author", "#avatar");
            if (!avatar) {
                alert("Không thể upload hình ảnh, vui lòng thử lại.");
                return;
            }
        }

        // Lấy nội dung từ Quill Editor
        const introduction = editor.root.innerHTML.trim();
        const name = formData.get("name");

        if (!name || !introduction || introduction === "<p><br></p>") {
            alert("Tên tác giả và giới thiệu không được để trống!");
            return;
        }

        // Chuẩn bị dữ liệu gửi đi
        const authorData = {
            id: formData.get("id"),
            name: name,
            avatar: avatar,
            introduction: introduction
        };

        try {
            const response = await fetch(`${contextPath}/owner/author/update`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(authorData)
            });

            const result = await response.json();

            if (result.success) {
                rowAction(authorData.id, "view");
            } else {
                alert("Cập nhật thất bại!");
                console.error("Update failed:", result.message || response.statusText);
            }
        } catch (error) {
            console.error("Error updating:", error);
            alert("Đã xảy ra lỗi khi cập nhật!");
        }
    };

    createButton.addEventListener("click", (e) => {
        e.preventDefault();
        handleCreateAuthor();
    });
    document.getElementById("update").addEventListener("click", function (event) {
        event.preventDefault(); // Ngăn hành vi mặc định khi bấm nút
        handleUpdateAuthor();   // Gọi hàm cập nhật
    });
});

