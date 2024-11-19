function validateInput(input) {
    const errorSpan = input.closest('.col-12').querySelector('.' + input.name + 'Error');

    // Kiểm tra nếu input rỗng
    if (input.value.trim() === "") {
        errorSpan.textContent = "Mục này không được để trống.";
        return;
    } else {
        errorSpan.textContent = ""; // Xóa lỗi khi nhập hợp lệ
    }

    // Kiểm tra số nguyên dương cho các trường 'discountLimit', 'minValueApplied', và 'quantity'
    if (["discountLimit", "minValueApplied", "quantity"].includes(input.name)) {
        if (!Number.isInteger(Number(input.value)) || Number(input.value) < 0) {
            errorSpan.textContent = "Giá trị không được là số âm.";
            return;
        } else {
            errorSpan.textContent = "";
        }
    }

    // Kiểm tra 'percentDiscount' phải trong khoảng từ 0 đến 100
    if (input.name === "percentDiscount") {
        const value = Number(input.value);
        if (value < 1 || value > 100) {
            errorSpan.textContent = "Giá trị phải nằm trong khoảng từ 1% đến 100%.";
            return;
        } else {
            errorSpan.textContent = "";
        }
    }
}

// Áp dụng sự kiện 'input' cho tất cả các input để xóa lỗi khi người dùng bắt đầu nhập
document.querySelectorAll('.promotionForm .form-control').forEach(input => {
    input.addEventListener('input', () => validateInput(input));
});

// Sự kiện cho checkbox "Không giới hạn"
document.querySelectorAll('.promotionForm input[name="unlimited"]').forEach(checkbox => {
    checkbox.addEventListener('change', function () {
        const quantityError = checkbox.closest('.col-12').querySelector('.quantityError');
        if (checkbox.checked) {
            quantityError.textContent = ""; // Xóa lỗi khi chọn "Không giới hạn"
        }
    });
});

function validateForm(form) {
    let isValid = true;
    const inputs = form.querySelectorAll('.form-control');
    const codeInput = form.querySelector('input[name="code"]');
    const codeValue = codeInput ? codeInput.value.trim() : "";
    inputs.forEach(input => {
        const errorSpan = input.closest('.col-12').querySelector('.' + input.name + 'Error');

        // Bỏ qua kiểm tra 'quantity' nếu 'unlimited' được chọn
        if (input.name === "quantity") {
            const unlimitedCheckbox = input.closest('.col-12').querySelector('input[name="unlimited"]');
            if (unlimitedCheckbox && unlimitedCheckbox.checked) {
                errorSpan.textContent = "";
                return;
            }
        }

        // Kiểm tra nếu input rỗng
        if (input.value.trim() === "") {
            errorSpan.textContent = "Mục này không được để trống.";
            isValid = false;
            return;
        }

        // Kiểm tra số nguyên dương cho các trường 'discountLimit', 'minValueApplied', và 'quantity'
        if (["discountLimit", "minValueApplied", "quantity"].includes(input.name)) {
            if (!Number.isInteger(Number(input.value)) || Number(input.value) < 0) {
                errorSpan.textContent = "Giá trị không được là số âm.";
                isValid = false;
                return;
            } else {
                errorSpan.textContent = "";
            }
        }

        // Kiểm tra 'percentDiscount' phải trong khoảng từ 1 đến 100
        if (input.name === "percentDiscount") {
            const value = Number(input.value);
            if (value < 1 || value > 100) {
                errorSpan.textContent = "Giá trị phải nằm trong khoảng từ 1% đến 100%.";
                isValid = false;
                return;
            } else {
                errorSpan.textContent = "";
            }
        }
    });

    return isValid;
}

document.querySelectorAll('.promotionForm').forEach(form => {
    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Ngăn chặn submit mặc định

        const submitButton = form.querySelector(".btn-voucher");
        const isEditing = submitButton.dataset.editing === "true"; // Kiểm tra trạng thái của nút

        if (!isEditing) {
            // Nếu không ở trạng thái chỉnh sửa, chuyển sang trạng thái chỉnh sửa
            toggleForm(submitButton);
        } else if (!validateForm(form)) {
            // Nếu đang chỉnh sửa nhưng form không hợp lệ
            toast({
                title: "Thất bại!",
                message: 'Vui lòng điền đầy đủ thông tin',
                type: "warning",
                duration: 3000,
            });
        } else {
            toast({
                title: "Thành Công!",
                message: 'Chỉnh sửa thành công',
                type: "success",
                duration: 3000,
            });
            // Submit form nếu hợp lệ
            form.submit();
        }
    });
});

// Hàm toggleForm để xử lý chuyển trạng thái nút và form
function toggleForm(editButton) {
    const form = editButton.closest("form");
    const isEditing = editButton.dataset.editing === "true";

    const inputs = form.querySelectorAll("input, textarea, select");

    if (isEditing) {
        // Khóa form
        inputs.forEach(input => {
            if (input.name !== "code") {
                input.disabled = true;
            }

        });
        editButton.innerText = "Chỉnh sửa";
        editButton.dataset.editing = "false";
    } else {
        // Mở khóa form
        inputs.forEach(input => {
            if (input.name !== "code") {
                input.disabled = false;
            }
            if (input.name === "quantity" && input.value === "") {
                input.disabled = true;
            }

        });
        editButton.innerText = "Lưu";
        editButton.dataset.editing = "true";
    }
}







