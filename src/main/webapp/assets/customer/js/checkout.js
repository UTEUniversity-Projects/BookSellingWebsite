import {toast} from "./toast.js";
import {formatCurrencyVND} from "../../commons/js/format-currency.js"

function disablesInputAndButton(input, applyButton) {
    input.disabled = true;
    input.classList.add("disabled-input");
    applyButton.disabled = true;
    applyButton.classList.add("disabled-button");
}

function applyPromotionCode(code, input, applyButton) {
    fetch(`${contextPath}/api/owner/promotion/apply-code?code=${encodeURIComponent(code)}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            toast({
                title: "Thông báo",
                message: data.message,
                type: data.promotionId !== null ? "success" : "info",
                duration: 3000
            });

            if (data.promotionId !== null) {
                const promotionData = {
                    promotionId: data.promotionId,
                    discountLimit: data.discountLimit,
                    minValueToBeApplied: data.minValueToBeApplied,
                    type: data.type,
                    message: data.message
                };

                console.log(data.type);

                if (data.type === "FREESHIP") {
                    const freeshipElement = document.getElementById('price-freeship');
                    freeshipElement.textContent = `-${formatCurrencyVND(data.discountLimit)}`;
                    freeshipElement.setAttribute('data-price', data.discountLimit);
                }

                if (data.type === "VOUCHER") {
                    const voucherElement = document.getElementById('price-voucher');
                    voucherElement.textContent = `-${formatCurrencyVND(data.discountLimit)}`;
                    voucherElement.setAttribute('data-price', data.discountLimit);
                }

                const totalPriceElement = document.getElementById('price-total');
                let totalPrice = parseFloat(totalPriceElement.getAttribute('data-price'));
                totalPrice -= data.discountLimit;


                totalPriceElement.textContent = formatCurrencyVND(totalPrice.toFixed(2));
                totalPriceElement.setAttribute('data-price', totalPrice.toFixed(2));

                disablesInputAndButton(input, applyButton);
            }
        })
        .catch(error => {
            console.error('Có lỗi xảy ra khi gọi API:', error);
            toast({
                title: "Lỗi",
                message: "Đã có lỗi xảy ra khi áp dụng mã khuyến mãi.",
                type: "error",
                duration: 3000
            });
        });
}

$(document).ready(() => {
    const btnCheckouts = document.querySelectorAll(".btn-checkout");
    const checkout = document.querySelector(".checkout");
    const overlay = document.querySelector(".checkout-overlay");
    const qr = ["https://api.viqr.net/vietqr/VietinBank/113366668888/10000/compact.jpg?FullName=Quy%20Vacxin%20Covid&NDck=UngHoCV",
        "https://homepage.momocdn.net/blogscontents/momo-upload-api-220808102122-637955508824191258.png",
        "https://kalite.vn/wp-content/uploads/2021/09/maqrkalite.jpg"];

    const freeshipInput = document.getElementById('freeship');
    const voucherInput = document.getElementById('voucher');
    const applyFreeshipButton = document.getElementById('applyFreeship');
    const applyVoucherButton = document.getElementById('applyVoucher');

    applyFreeshipButton.addEventListener('click', function () {
        const freeshipCode = freeshipInput.value.trim();
        if (freeshipCode) {
            console.log(freeshipCode)
            applyPromotionCode(freeshipCode, freeshipInput, applyFreeshipButton);
        } else {
            toast({
                title: "Thông báo",
                message: "Vui lòng nhập mã freeship",
                type: "info",
                duration: 3000
            });
        }
    });

    applyVoucherButton.addEventListener('click', function () {
        const voucherCode = voucherInput.value.trim();
        if (voucherCode) {
            applyPromotionCode(voucherCode, voucherInput, applyVoucherButton);
        } else {
            alert('Vui lòng nhập mã voucher');
        }
    });

    const checkoutQR = checkout.querySelector('img');

    const MY_BANK = {
        BANK_ID: 'MB',
        ACCOUNT_NO: '8383352888888',
        ACCOUNT_NAME: 'TRANG KIM LOI'
    };

    const amount = 10000;
    const text = `TEST 649`;

    let interval;
    let isSuccess = false;
    let count = 0;

    const generateQR = (amount, text) => {
        return `https://img.vietqr.io/image/${MY_BANK.BANK_ID}-${MY_BANK.ACCOUNT_NO}-compact2.png?amount=${amount}&addInfo=${text}&accountName=${MY_BANK.ACCOUNT_NAME}`;
    };

    btnCheckouts.forEach((btnCheckout) => {
        btnCheckout.addEventListener('click', () => {
            checkout.classList.add('active');
            checkoutQR.src = '';
            const qrImageSrc = generateQR(amount, text);
            $('.checkout-loading').removeClass('hidden');
            checkoutQR.onload = () => $('.checkout-loading').addClass('hidden');
            checkoutQR.src = qrImageSrc;
            isSuccess = false;
            count = 0;
            setTimeout(() => {
                interval = setInterval(() => {
                    checkPaid(amount, text);
                }, 1000);
            }, 3000);
        });
    });

    overlay.addEventListener('click', () => {
        checkout.classList.remove('active');
        if (interval) {
            clearInterval(interval);
        }
        isSuccess = false;
        count = 0;
    });

    async function checkPaid(amount, text) {
        if (!isSuccess) {
            try {
                const response = await fetch('https://script.google.com/macros/s/AKfycbzDcjdyyF8jBuq4FVdme-76-x8DGrtMGuL4vuJlQcf2h_XeyJ3bMdDeilEGBhql9039YA/exec');
                const data = await response.json();
                const lastPaid = data.data[data.data.length - 1];
                const lastPrice = lastPaid['Giá trị'];
                const lastContent = lastPaid['Mô tả'];
                if (lastPrice >= amount && lastContent.includes(text)) {
                    isSuccess = true;
                    clearInterval(interval);
                    if (count < 1) {
                        toast({
                            message: 'Thanh toán thành công !'
                        });
                        // setTimeout(() => {
                        //         window.location.href = `${contextPath}/register`;
                        //     },
                        //     1000);
                    }
                } else {
                    if (count === 0) {
                        toast({
                            message: 'Đang chờ thanh toán'
                        });
                    }
                    count++;
                }
            } catch (error) {
                console.log(error);
            }
        }
    }
})
