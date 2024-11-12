$(function () {
    $('input[name="dateeffective"]').daterangepicker({
        timePicker: true,
        startDate: moment().startOf('hour'),
        endDate: moment().startOf('hour').add(32, 'hour'),
        minDate: moment(), // Ngày tối thiểu là ngày hiện tại, không thể chọn quá khứ
        locale: {
            format: 'M/DD hh:mm A'
        }
    });
});
document.addEventListener("DOMContentLoaded", function () {
    // Tìm tất cả các checkbox có name="unlimited"
    const unlimitedCheckboxes = document.querySelectorAll('input[name="unlimited"]');

    unlimitedCheckboxes.forEach(function (checkbox) {
        checkbox.addEventListener("click", function () {
            // Tìm input quantity trong cùng form với checkbox
            const form = checkbox.closest("form");
            const quantityInput = form.querySelector('input[name="quantity"]');

            // Kiểm tra trạng thái checkbox để vô hiệu hóa hoặc kích hoạt trường nhập quantity
            if (checkbox.checked) {
                quantityInput.value = ''; // Xóa giá trị
                quantityInput.disabled = true;
            } else {
                quantityInput.disabled = false;
            }
        });
    });
});

$(document).ready(() => {

    const formData = new FormData(document.querySelector("form"));

    const promotionData = {
        "code": "COUPON1",
        "title": "Black Friday Discount",
        "description": "Get amazing discounts on selected items",
        "percentDiscount": 20.5,
        "discountLimit": 50.0,
        "minValueApplied": 100.0,
        "status": "EFFECTIVE",
        "effectiveDate": "2024-11-25",
        "expirationDate": "2024-12-01",
        "type": "FREESHIP",
        "promotionTargets": [
            {
                "applicableObjectId": "WHOLE",
                "quantity": 10,
                "type": "WHOLE"
            }
        ]
    };

    $(".btn-voucher").click(function (event) {
        event.preventDefault();

        $.ajax({
            url: `${contextPath}/owner/promotion/add`,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(promotionData),
            success: function (response, status, xhr) {
                alert(response.isCodeExisted);
            },
            error: function (xhr, error) {
                console.log(error);
            }
        });
    });


});
