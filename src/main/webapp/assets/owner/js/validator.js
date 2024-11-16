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
            // Lấy giá trị từ form và xử lý
            formData.forEach((value, key) => {
                if (key === "dateeffective") {
                    const { effectiveDate, expirationDate } = parseDateRange(value);
                    data["effectiveDate"] = effectiveDate;
                    data["expirationDate"] = expirationDate;

                    const effectiveDateObj = new Date(effectiveDate);
                    const currentDate = new Date();
                    data["status"] = effectiveDateObj > currentDate ? "COMING_SOON" : "EFFECTIVE";
                } else {
                    data[key] = value.trim();
                }
            });

            // Lấy thông tin về checkbox "unlimited" và quantity
            const unlimitedCheckbox = form.querySelector('input[name="unlimited"]');
            let quantity = parseInt(data["quantity"], 10);
            const isInfinite = unlimitedCheckbox.checked || isNaN(quantity) || quantity <= 0;
            data["isInfinite"] = isInfinite;
            if (isInfinite) quantity = 1;
            switch (data["formType"]) {
                case "addVoucher":
                    data["type"] = "VOUCHER"; // Đặt type là VOUCHER
                    data["percentDiscount"] = 100; // Phần trăm giảm giá là 100%
                    data["discountLimit"] = parseFloat(100); // Đặt giới hạn giảm giá là 100
                    break;
                case "addFreeShip":
                    data["type"] = "FREESHIP"; // Đặt type là FREESHIP
                    data["percentDiscount"] = 100; // Miễn phí vận chuyển
                    data["minValueApplied"] = 0.0; // Giá trị tối thiểu áp dụng là 0
                    break;
                default:
                    console.error("Loại form không hợp lệ"); // Xử lý lỗi khi formType không đúng
                    return;
            }

            // Tạo danh sách promotionInsertRequests
            const promotionInsertRequests = [];
            for (let i = 0; i < quantity; i++) {
                promotionInsertRequests.push({
                    title: data["title"] || "Default Title",
                    description: data["description"] || "Default Description",
                    percentDiscount: parseFloat(data["percentDiscount"]) || 0.0,
                    discountLimit: parseFloat(data["discountLimit"]) || 0.0,
                    minValueApplied: parseFloat(data["minValueApplied"]) || 0.0,
                    effectiveDate: data["effectiveDate"],
                    expirationDate: data["expirationDate"],
                    status: "NOT_USE",
                    promotionTargets: [
                        {
                            applicableObjectId: -1,
                            type: "WHOLE"
                        }
                    ]
                });
            }
            const responseData = {
                code: data["code"],
                isInfinite: isInfinite,
                status: data["status"],
                type: data["type"],
                promotionInsertRequests: promotionInsertRequests
            };
            
            // Gửi request AJAX
            $.ajax({
                url: '/owner/promotion/add',
                type: 'POST',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(responseData),
                success: function (result) {
                    toast({
                        title: result.isCodeExisted ? "Thất bại!" : "Thành công!",
                        message: result.isCodeExisted ? 'Mã khuyến mãi đã tồn tại.' : 'Khuyến mãi đã được thêm thành công!',
                        type: result.isCodeExisted ? "warning" : "success",
                        duration: 3000,
                    });
                    if (!result.isCodeExisted) {
                        form.reset();
                        form.querySelector('input[name="quantity"]').disabled = false;

                    }
                },
                error: function (xhr, status, error) {
                    console.error("Lỗi khi gọi API:", error);

                    toast({
                        title: "Lỗi!",
                        message: 'Đã xảy raaaaaaaa lỗi trong quá trình thêm khuyến mãi.',
                        type: "error",
                        duration: 3000,
                    });
                }
            });
        }
    });
});







