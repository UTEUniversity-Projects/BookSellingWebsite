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

// Confirm order
document.querySelector("#btn-confirm").addEventListener('click', function (event) {
    const orderElement = document.getElementById("order-id");
    if (orderElement) {
        const orderId = orderElement.dataset.orderId;
        console.log(orderId);
        const confirmOrderModal = new bootstrap.Modal(document.getElementById('confirmOrderModal'));
        document.getElementById('confirmOrderModal').querySelector(".order-id").value = orderId;
        confirmOrderModal.show();
    } else {
        showErrorToast();
    }
});

document.getElementById("confirmOrder").addEventListener("click", function (event) {
    const orderId = document.getElementById("confirmOrderModal").querySelector(".order-id").value;
    console.log(orderId);
    /*const finalPrice = document.getElementById("finalPrice").value;*/

    const requestData = {
        orderId: orderId,
        /*finalPrice:finalPrice*/
    }

    fetch('/BookSellingWebsite/staff/order/confirm-order', {
        method: 'POST', headers: {
            'Content-Type': 'application/json',
        }, body: JSON.stringify(requestData)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Có lỗi xảy ra khi gửi phản hồi");
            }
        })
        .then(data => {
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

                const btnContainer = document.querySelector(".btn-container");
                console.log(btnContainer);
                console.log(data)
                if (btnContainer && data.statusType === "PACKING") {
                    btnContainer.classList.add('d-none');
                    const transportBtnContainer = document.querySelector(".btn-container-transport");
                    transportBtnContainer.classList.remove('d-none');
                    transportBtnContainer.classList.add('d-flex');
                    console.log("CLick");
                }


                const modal = bootstrap.Modal.getInstance(document.getElementById('confirmOrderModal'));
                modal.hide();

                modal._element.addEventListener('hidden.bs.modal', () => {
                    window.scrollTo({
                        top: 0,
                        behavior: 'smooth'
                    });
                });
            }
        })
        .catch(error => {
            console.error("Error:", error);
            showErrorToast();
        });
})

// Cancel order
document.querySelector("#btn-cancel").addEventListener('click', function (event) {
    const orderElement = document.getElementById("order-id");
    if (orderElement) {
        const orderId = orderElement.dataset.orderId;
        console.log(orderId);
        const confirmOrderModal = new bootstrap.Modal(document.getElementById('cancelOrderModal'));
        document.getElementById('cancelOrderModal').querySelector(".order-id").value = orderId;
        confirmOrderModal.show();
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

        fetch('/BookSellingWebsite/staff/order/cancel-order', {
            method: 'POST', headers: {
                'Content-Type': 'application/json; charset=UTF-8',
            }, body: JSON.stringify(requestData)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Có lỗi xảy ra khi gửi phản hồi");
                }
            })
            .then(data => {
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

                    const btnContainer = document.querySelector(".btn-container");
                    btnContainer.style.setProperty('display', 'none', 'important');

                    const modal = bootstrap.Modal.getInstance(document.getElementById('cancelOrderModal'));
                    modal.hide();

                    modal._element.addEventListener('hidden.bs.modal', () => {
                        window.scrollTo({
                            top: 0,
                            behavior: 'smooth'
                        });
                    });
                }
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
        const confirmOrderModal = new bootstrap.Modal(document.getElementById('transportOrderModal'));
        document.getElementById('transportOrderModal').querySelector(".order-id").value = orderId;
        confirmOrderModal.show();
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

    console.log(requestData.orderId)

    fetch('/staff/order/transport-order', {
        method: 'POST', headers: {
            'Content-Type': 'application/json',
        }, body: JSON.stringify(requestData)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Có lỗi xảy ra khi gửi phản hồi");
            }
        })
        .then(data => {
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


                const transportBtnContainer = document.querySelector(".btn-container-transport");
                console.log(transportBtnContainer);
                if (transportBtnContainer) {
                    transportBtnContainer.classList.remove('d-flex');
                    transportBtnContainer.classList.add('d-none');
                    console.log("click")
                }


                const modal = bootstrap.Modal.getInstance(document.getElementById('transportOrderModal'));
                modal.hide();

                modal._element.addEventListener('hidden.bs.modal', () => {
                    window.scrollTo({
                        top: 0,
                        behavior: 'smooth'
                    });
                });
            }
        })
        .catch(error => {
            console.error("Error:", error);
            showErrorToast();
        });
})