function showSuccessToast() {
    toast({
        title: "Thành công!", message: "Bạn đã xác nhận đơn hàng thành công.", type: "success", duration: 1000,
    });
    console.log("CLick")
}

function showErrorToast() {
    toast({
        title: "Thất bại!", message: "Có lỗi xảy ra, vui lòng liên hệ quản trị viên.", type: "error", duration: 1000,
    });
}

/* Product Image Zoom */
$('.zoom-image-hover').zoom();

/* Slider room details */
$('.slider-for').slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    arrows: false,
    fade: true,
    asNavFor: '.slider-nav',
});

$('.slider-nav').slick({
    slidesToShow: 5,
    slidesToScroll: 1,
    arrows: false,
    asNavFor: '.slider-for',
    focusOnSelect: true,
    responsive: [
        {
            breakpoint: 1200,
            settings: {
                slidesToShow: 4,
            },
        },
        {
            breakpoint: 768,
            settings: {
                slidesToShow: 5,
            },
        },
        {
            breakpoint: 420,
            settings: {
                slidesToShow: 4,
            },
        },
    ],
});

/* Range Slider */
$(function () {
    $('#slider-range').slider({
        range: true,
        min: 20,
        max: 300,
        values: [0, 250],
        slide: function (event, ui) {
            $('#amount').val('$' + ui.values[0] + ' - $' + ui.values[1]);
        },
    });
    $('#amount').val(
        '$' +
        $('#slider-range').slider('values', 0) +
        ' - $' +
        $('#slider-range').slider('values', 1)
    );
});

function showModal(modalId, orderId) {
    const modalElement = document.getElementById(modalId);
    if (modalElement) {
        const modal = new bootstrap.Modal(modalElement);
        modalElement.querySelector(".order-id").value = orderId;
        modal.show();
    } else {
        showErrorToast();
    }
}

function hideModal(modalId) {
    const modalElement = document.getElementById(modalId);

    if (modalElement) {
        const modal = bootstrap.Modal.getInstance(modalElement) || new bootstrap.Modal(modalElement);

        modal.hide();

        modal._element.addEventListener('hidden.bs.modal', () => {
            window.scrollTo({
                top: 0,
                behavior: 'smooth'
            });
        });
    } else {
        showErrorToast();
    }
}

function sendRequest(url, requestData) {
    return fetch(`${contextPath}${url}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=UTF-8',
        },
        body: JSON.stringify(requestData)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Có lỗi xảy ra khi gửi phản hồi");
            }
        });
}

function updateStatus(data, modalId) {
    toast({
        title: data.type === "success" ? "Thành công" : "Cảnh báo",
        message: data.message,
        type: data.type,
        duration: 3000
    })

    if (data.type === "success") {
        const orderStatusElement = document.getElementById("order-status");
        orderStatusElement.innerHTML = data.status;
        orderStatusElement.className = `cr-card-status cr-card-status--${data.statusStyle}`;
        orderStatusElement.setAttribute("data-status", data.statusType);

        const btnContainer = document.querySelector(".btn-container");
        if (btnContainer) {
            btnContainer.classList.add('d-none');
        }
        const transportBtnContainer = document.querySelector(".btn-container-transport");
        if (transportBtnContainer) {
            if (data.statusType === "PACKING") {
                transportBtnContainer.classList.remove('d-none');
                transportBtnContainer.classList.add('d-flex');
            } else if (data.statusType === "SHIPPING") {
                transportBtnContainer.classList.remove('d-flex');
                transportBtnContainer.classList.add('d-none');
            }
        }
        hideModal(modalId);
    }
}

// Confirm order
document.querySelector("#btn-confirm").addEventListener('click', function (event) {
    const orderElement = document.getElementById("order-id");
    if (orderElement) {
        const orderId = orderElement.dataset.orderId;
        console.log(orderId);
        showModal('confirmOrderModal', orderId);
    } else {
        showErrorToast();
    }
});

document.getElementById("confirmOrder").addEventListener("click", function (event) {
    const orderId = document.getElementById("confirmOrderModal").querySelector(".order-id").value;
    console.log(orderId);

    const orderStatusElement = document.getElementById("order-status");
    const orderStatus = orderStatusElement.dataset.status;
    console.log(orderStatus);

    if (orderStatus == "WAITING_CONFIRMATION") {
        const requestData = {
            orderId: orderId,
        }
        console.log("Context path" + contextPath);

        sendRequest(`${contextPath}/api/staff/order/confirm-order`, requestData)
            .then(data => {
                updateStatus(data, 'confirmOrderModal');
            })
            .catch(error => {
                console.error("Error:", error);
                showErrorToast();
            });
    } else if (orderStatus === "REQUEST_REFUND") {
        const returnBookId = document.getElementById("return-book-id").value;
        const requestData = {
            orderId: orderId,
            returnBookId: returnBookId
        }

        sendRequest(`${contextPath}/api/staff/order/confirm-refund-order`, requestData)
            .then(data => {
                updateStatus(data, 'confirmOrderModal');
            })
            .catch(error => {
                console.error("Error:", error);
                showErrorToast();
            });
    }

})

// Cancel order
document.querySelector("#btn-cancel").addEventListener('click', function (event) {
    const orderElement = document.getElementById("order-id");
    if (orderElement) {
        const orderId = orderElement.dataset.orderId;
        console.log(orderId);
        showModal('cancelOrderModal', orderId);
    } else {
        showErrorToast();
    }
});

document.getElementById("sendReason").addEventListener('click', function (event) {
    const cancelContent = document.getElementById("cancelContent").value;
    const errorMessage = document.getElementById("error-message");

    if (!cancelContent.trim()) {
        errorMessage.style.display = "block";
    } else {
        errorMessage.style.display = "none";
        const orderId = document.getElementById("cancelOrderModal").querySelector(".order-id").value;

        const requestData = {
            orderId: orderId,
            content: cancelContent,
        };

        console.log(requestData.content)
        sendRequest(`${contextPath}/api/staff/order/cancel-order`, requestData)
            .then(data => {
                updateStatus(data, 'cancelOrderModal');
            })
            .catch(error => {
                console.error("Error:", error);
                showErrorToast();
            });
    }
})

// Transport order
document.querySelector("#btn-transport").addEventListener('click', function (event) {
    const orderElement = document.getElementById("order-id");
    if (orderElement) {
        const orderId = orderElement.dataset.orderId;
        console.log(orderId);
        showModal('transportOrderModal', orderId);
    } else {
        showErrorToast();
    }
});

document.getElementById("transportOrder").addEventListener("click", function (event) {
    const orderId = document.getElementById("transportOrderModal").querySelector(".order-id").value;
    console.log(orderId);

    const requestData = {
        orderId: orderId,
    }

    sendRequest(`${contextPath}/api/staff/order/transport-order`, requestData)
        .then(data => {
            updateStatus(data, 'transportOrderModal');
        })
        .catch(error => {
            console.error("Error:", error);
            showErrorToast();
        });
})