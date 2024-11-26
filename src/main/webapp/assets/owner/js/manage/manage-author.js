function rowAction(itemId, action) {
    if (action === "delete") {
        const popup = document.getElementById("delete-popup");
        popup.style.display = "flex";

        document.getElementById("confirm-delete").onclick = function () {
            popup.style.display = "none";
            executeDeleteAction(itemId, action);
        };

        document.getElementById("cancel-delete").onclick = function () {
            popup.style.display = "none";
        };

        return;
    }
    executeAction(itemId, action);
}
function executeDeleteAction(itemId, action) {
    fetch(`${contextPath}/owner/session-author-info`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            authorId: itemId,
            authorAction: action
        })
    })
        .then(response => response.json())
        .then(data => {
            if (data.status === "success") {
                const successPopup = document.getElementById("success-popup");
                successPopup.style.display = "flex";

                const autoHideTimeout = setTimeout(() => {
                    fadeOutPopup(successPopup);
                }, 2000);

                document.getElementById("success-ok").onclick = () => {
                    clearTimeout(autoHideTimeout);
                    fadeOutPopup(successPopup);
                };
            } else {
                const failPopup = document.getElementById("fail-popup");
                failPopup.style.display = "flex";

                const autoHideTimeout = setTimeout(() => {
                    fadeOutPopup(failPopup);
                }, 3000);

                document.getElementById("fail-ok").onclick = () => {
                    clearTimeout(autoHideTimeout);
                    fadeOutPopup(failPopup);
                };
            }
        })
        .catch(error => {
            console.error("Error:", error);

            const failPopup = document.getElementById("fail-popup");
            failPopup.style.display = "flex";

            const autoHideTimeout = setTimeout(() => {
                fadeOutPopup(failPopup);
            }, 3000);

            document.getElementById("fail-ok").onclick = () => {
                clearTimeout(autoHideTimeout);
                fadeOutPopup(failPopup);
            };
        });
}
function fadeOutPopup(popupElement, callback) {
    popupElement.classList.add("fade-out");
    setTimeout(() => {
        popupElement.style.display = "none";
        popupElement.classList.remove("fade-out");
        if (callback) callback();
    }, 500); // Thời gian khớp với transition trong CSS
}
function executeAction(itemId, action) {
    fetch(`${contextPath}/owner/session-author-info`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            authorId: itemId,
            authorAction: action
        })
    })
        .then(response => response.json())
        .then(data => {
            if (data.status === "success") {
                if (action === "view") {
                    window.location.href = `${contextPath}/owner/author-profile`;
                } else if (action === "update") {
                    window.location.href = `${contextPath}/owner/author-update`;
                }
            } else {
                alert("Có lỗi xảy ra khi chuyển hướng.");
            }
        })
        .catch(error => console.error("Error:", error));
}

document.addEventListener("DOMContentLoaded", function () {
  const tableBody = document.querySelector(".item-data-table tbody");

  if (tableBody) {
    tableBody.addEventListener("click", function (event) {
      const row = event.target.closest(".item-row");

      if (row && !event.target.closest("button") && !event.target.closest(".dropdown-menu")) {
        const authorId = row.getAttribute("data-id");
          rowAction(authorId, "view");
      }
    });
  }
});
document.addEventListener("DOMContentLoaded", function () {
    lottie.loadAnimation({
        container: document.getElementById('lottie-danger'),
        renderer: 'svg',
        loop: true,
        autoplay: true,
        path: `${contextPath}/assets/owner/json/danger.json`
    });

    lottie.loadAnimation({
        container: document.getElementById('lottie-success'),
        renderer: 'svg',
        loop: true,
        autoplay: true,
        path: `${contextPath}/assets/owner/json/success.json`
    })

    lottie.loadAnimation({
        container: document.getElementById('lottie-fail'),
        renderer: 'svg',
        loop: true,
        autoplay: true,
        path: `${contextPath}/assets/owner/json/fail.json`
    });
});
