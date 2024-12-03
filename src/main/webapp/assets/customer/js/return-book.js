import {toast} from "./toast.js";
import {uploadImage} from "../../commons/js/upload-image.js";

document.addEventListener("DOMContentLoaded", () => {
    const selectAllCheckbox = document.getElementById("select-all");
    const productCheckboxes = document.querySelectorAll(".product-checkbox");

    selectAllCheckbox.addEventListener("change", function () {
        productCheckboxes.forEach(checkbox => {
            checkbox.checked = this.checked;
        });
    });

    productCheckboxes.forEach(checkbox => {
        checkbox.addEventListener("change", function () {
            const allChecked = Array.from(productCheckboxes).every(cb => cb.checked);
            selectAllCheckbox.checked = allChecked;
        });
    });
});

$('#btn-confirm').on('click', async function () {
    const orderId = $('#order-id').data('order-id');

    let returnBookItems = [];

    $('.return-quantity').each(function () {
        let bookTemplateId = $(this).attr('id').replace('return-quantity-', '');

        let returnQuantity = $(this).val();

        returnBookItems.push({
            bookTemplateId: bookTemplateId, quantity: parseInt(returnQuantity)
        });
    });

    console.log(returnBookItems);

    const reason = $('#reason').val();
    if (!reason) {
        $('#reason-error').show();
        return;
    } else {
        $('#reason-error').hide();
    }

    let description = $('#description').val();
    $('#description').on('blur', function () {
        if (!description || description.trim().length === 0) {
            $('#description-error').show();
        } else {
            $('#description-error').hide();
        }
    });

    const files = $('#uploadImage')[0].files;
    let mediaFiles = []
    if (files.length === 0) {
        $('#file-error').show();
        return;
    } else {
        $('#file-error').hide();
        await uploadImage('return_book', '#uploadImage').then(response => {
            console.log('Tải lên thành công:', response);
            for (let i = 0; i < response.imageLinks.length; i++) {
                mediaFiles.push({
                    fileName: response.fileName, storedCode: response.imageLinks[i]
                });
            }
            console.log(mediaFiles);
        })
            .catch(error => {
                console.error('Lỗi tải lên:', error);
            });
    }
    console.log("----")
    let data = {
        orderId: orderId,
        reason: reason,
        description: description,
        returnBookItems: returnBookItems,
        mediaFiles: mediaFiles
    };

    console.log(data);

    $.ajax({
        url: `${contextPath}/return-order`,
        type: 'POST',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(data),
        success: function (data) {
            toast({
                title: data.type, message: data.message, type: data.type, duration: 3000
            });
            console.log(data);
            if (data.type === "success") {
                window.location.href = `${contextPath}/order-detail?orderId=${orderId}`;
            }
        },
        error: function (xhr, status, error) {
            toast({
                title: "Thất bại", message: "Kiểm tra lại thông tin!", type: 'error', duration: 3000
            })
        }
    });
});


