document.addEventListener("DOMContentLoaded", function() {
    // Lấy tất cả các form
    const forms = document.querySelectorAll(".promotion-form");

    forms.forEach(form => {
        const editButton = form.querySelector("#edit-button");
        const saveButton = form.querySelector("#save-button");
        const formElements = form.querySelectorAll("input, textarea");
        const promotionQuantityInput = form.querySelector("#promotion-quantity");
        const unlimitedCheckbox = form.querySelector("#unlimited-checkbox");

        // Khóa checkbox "Không giới hạn" khi mới tải trang
        if (unlimitedCheckbox) {
            unlimitedCheckbox.disabled = true;
        }

        // Sự kiện khi nhấn nút "Chỉnh sửa"
        editButton.addEventListener("click", function() {
            // Kích hoạt tất cả các input để chỉnh sửa
            formElements.forEach(element => element.disabled = false);

            if (unlimitedCheckbox) {
                unlimitedCheckbox.disabled = false;

                if (unlimitedCheckbox.checked) {
                    promotionQuantityInput.disabled = true; // Khóa input nếu checkbox được chọn
                }
            }

            // Ẩn nút "Chỉnh sửa" và hiển thị nút "Lưu"
            editButton.style.display = "none";
            saveButton.style.display = "inline-block";
        });

        // Sự kiện khi nhấn nút "Lưu"
        saveButton.addEventListener("click", function() {
            // Khóa lại tất cả các input sau khi lưu
            formElements.forEach(element => element.disabled = true);

            if (unlimitedCheckbox) {
                unlimitedCheckbox.disabled = true;
            }

            // Hiển thị lại nút "Chỉnh sửa" và ẩn nút "Lưu"
            editButton.style.display = "inline-block";
            saveButton.style.display = "none";

            // Thông báo lưu thành công
            alert("Dữ liệu đã được lưu thành công!");
        });

        // Sự kiện khi checkbox "Không giới hạn" thay đổi trạng thái
        if (unlimitedCheckbox) {
            unlimitedCheckbox.addEventListener("change", function() {
                if (unlimitedCheckbox.checked) {
                    promotionQuantityInput.disabled = true;
                    promotionQuantityInput.value = "";
                } else {
                    promotionQuantityInput.disabled = false;
                }
            });
        }
    });
});