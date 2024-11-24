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
                btnContainer.style.setProperty('display', 'none', 'important');

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