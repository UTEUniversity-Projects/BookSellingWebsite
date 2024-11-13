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
        "code": "2",
        "title": "Giảm giá cuối năm",
        "description": "Khuyến mãi giảm giá 20% cho khách hàng.",
        "percentDiscount": 20.0,
        "discountLimit": 100000.0,
        "minValueApplied": 50000.0,
        "status": "EFFECTIVE",
        "effectiveDate": "2024-11-20 00:00:00.000000",
        "expirationDate": "2024-12-31 23:59:59.000000",
        "type": "VOUCHER",
        "promotionTargets": [
            {
                "applicableObjectId": "WHOLE",
                "quantity": -1,
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



