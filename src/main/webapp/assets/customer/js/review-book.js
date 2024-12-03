import {toast} from "./toast.js";

$(document).ready(function() {
    $(".btn-review").on("click", function() {
        const productItem = $(this).closest('.product-item');
        const productId = productItem.data('product-id');
        console.log(productId);

        const reviewModal = new bootstrap.Modal($('#reviewModal')[0]);
        $('#reviewModal').find('.product-id').val(productId);
        reviewModal.show();
    });

    $("#btn-submit-review").on("click", function() {
        const reviewContent = $("#exampleFormControlTextarea1").val();

        const productId = $('#reviewModal').find(".product-id").val();

        let ratingValue = null;
        $("input[name='rating']:checked").each(function() {
            ratingValue = $(this).val();
            return false;
        });

        const isReady = $("#is-ready").prop("checked");

        const orderId = $("#order-id").data("order-id");

        console.log("Review Content:", reviewContent);
        console.log("Product ID:", productId);
        console.log("Rating:", ratingValue);
        console.log("Ready to recommend:", isReady);

        $.ajax({
            url: `${contextPath}/api/customer/review/add`,
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify({
                content: reviewContent,
                rate: ratingValue,
                bookTemplateId: productId,
                readyToIntroduce: isReady,
                orderId: orderId
            }),
            success: function(data) {
                toast({
                    title: "Thành công", message: data.message, type: 'success', duration: 3000
                });
                console.log(data);
                $('#reviewModal').modal('hide');
                reloadStepper(orderId);

                $("#exampleFormControlTextarea1").val("");
                $("input[name='rating']:checked").prop('checked', false);
                $("#is-ready").prop('checked', false);
            },
            error: function(xhr, status, error) {
                toast({
                    title: "Thất bại", message: error, type: 'error', duration: 3000
                });
            }
        });
    });
});