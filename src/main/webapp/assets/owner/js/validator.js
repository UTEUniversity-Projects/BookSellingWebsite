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

// document.querySelectorAll('.promotionForm').forEach(form => {
//     form.addEventListener('submit', function (event) {
//         // Ngăn submit ngay lúc đầu
//         event.preventDefault();
//
//         // Kiểm tra các trường trong form
//         if (!validateForm(form)) {
//             toast({
//                 title: "Thất bại!",
//                 message: 'Vui lòng điền đầy đủ thông tin',
//                 type: "warning",
//                 duration: 3000,
//             });
//         } else {
//             // Lấy giá trị của input name="code"
//             const codeInput = form.querySelector('input[name="code"]');
//             const codeValue = codeInput ? codeInput.value.trim() : "";
//
//             // Tạo JSON từ codeValue
//             const data = { code: codeValue };
//
//             // Gửi yêu cầu đến API bằng AJAX
//             $.ajax({
//                 url: '/owner/promotion/check-code',
//                 type: 'POST',
//                 contentType: 'application/json; charset=UTF-8',
//                 data: JSON.stringify(data),
//                 success: function(result) {
//                     if (result.isCodeExisted) {
//                         // Nếu mã tồn tại, hiển thị cảnh báo và ngăn submit
//                         toast({
//                             title: "Thất bại!",
//                             message: 'Mã khuyến mãi đã tồn tại.',
//                             type: "warning",
//                             duration: 3000,
//                         });
//                     } else {
//                         // Nếu mã không tồn tại, cho phép submit form
//                         toast({
//                             title: "Thành công!",
//                             message: 'Thêm thành công',
//                             type: "success",
//                             duration: 3000,
//                         });
//
//                         // Submit form sau khi kiểm tra thành công
//                         form.submit();
//                     }
//                 },
//                 error: function(xhr, status, error) {
//                     console.error("Lỗi khi gọi API:", error);
//                     toast({
//                         title: "Lỗi!",
//                         message: 'Đã xảy ra lỗi trong quá trình kiểm tra mã khuyến mãi.',
//                         type: "error",
//                         duration: 3000,
//                     });
//                 }
//             });
//         }
//     });
// }
function parseDateRange(input) {
    const currentYear = new Date().getFullYear();
    const [start, end] = input.split(" - ");

    function formatDate(dateString) {
        const [monthDay, time, period] = dateString.split(" ");
        const [month, day] = monthDay.split("/");
        const [hour, minute] = time.split(":");

        let hours = parseInt(hour, 10);
        if (period === "PM" && hours !== 12) hours += 12;
        if (period === "AM" && hours === 12) hours = 0;

        // Tạo đối tượng Date với múi giờ cục bộ
        const date = new Date();
        date.setFullYear(currentYear);
        date.setMonth(month - 1);
        date.setDate(day);
        date.setHours(hours);
        date.setMinutes(minute);
        date.setSeconds(0);
        date.setMilliseconds(0);

        // Định dạng thành chuỗi theo yêu cầu
        const formattedDate = `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, '0')}-${String(date.getDate()).padStart(2, '0')} ${String(date.getHours()).padStart(2, '0')}:${String(date.getMinutes()).padStart(2, '0')}:00.000000`;
        return formattedDate;
    }

    const effectiveDate = formatDate(start);
    const expirationDate = formatDate(end);

    return { effectiveDate, expirationDate };
}

document.querySelectorAll('.promotionForm').forEach(form => {
    form.addEventListener('submit', function (event) {
        event.preventDefault();

        if (!validateForm(form)) {
            toast({
                title: "Thất bại!",
                message: 'Vui lòng điền đầy đủ thông tin',
                type: "warning",
                duration: 3000,
            });
        } else {
            const formData = new FormData(form);
            const data = {};

            formData.forEach((value, key) => {
                if (key === "dateeffective") {
                    const { effectiveDate, expirationDate } = parseDateRange(value);
                    data["effectiveDate"] = effectiveDate;
                    data["expirationDate"] = expirationDate;

                    // Thiết lập status dựa trên ngày bắt đầu
                    const effectiveDateObj = new Date(effectiveDate);
                    const currentDate = new Date();
                    data["status"] = effectiveDateObj > currentDate ? "COMING_SOON" : "EFFECTIVE";
                } else if (key === "quantity") {
                    const unlimitedCheckbox = form.querySelector('input[name="unlimited"]');
                    const quantity = unlimitedCheckbox.checked ? -1 : parseInt(value.trim(), 10);

                    // Thiết lập promotionTargets
                    data["promotionTargets"] = [
                        {
                            applicableObjectId: "WHOLE",
                            quantity: quantity,
                            type: "WHOLE"
                        }
                    ];
                } else {
                    data[key] = value.trim();
                }
            });

            // Thiết lập type và các giá trị khác dựa trên formType
            const formType = data["formType"];
            switch (formType) {
                case "addVoucher":
                    data["type"] = "VOUCHER";
                    data["percentDiscount"] = 100;
                    break;
                case "addCoupon":
                    data["type"] = "COUPON";
                    data["minValueApplied"] = 0;
                    break;
                case "addFreeShip":
                    data["type"] = "FREESHIP";
                    data["percentDiscount"] = 100;
                    data["minValueApplied"] = 0.0;
                    break;
                default:
                    console.error("Loại form không hợp lệ");
                    return;
            }

            // Xóa formType khỏi data trước khi gửi nếu không cần trong API
            delete data["formType"];

            // Gửi data xuống API bằng AJAX
            $.ajax({
                url: '/owner/promotion/add',
                type: 'POST',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(data),
                success: function(result) {
                    toast({
                        title: result.isCodeExisted ? "Thất bại!" : "Thành công!",
                        message: result.isCodeExisted ? 'Mã khuyến mãi đã tồn tại.' : 'Khuyến mãi đã được thêm thành công!',
                        type: result.isCodeExisted ? "warning" : "success",
                        duration: 3000,
                    });
                    if (!result.isCodeExisted) form.reset();
                },
                error: function(xhr, status, error) {
                    console.error("Lỗi khi gọi API:", error);
                    toast({
                        title: "Lỗi!",
                        message: 'Đã xảy ra lỗi trong quá trình thêm khuyến mãi.',
                        type: "error",
                        duration: 3000,
                    });
                }
            });
        }
    });
});






