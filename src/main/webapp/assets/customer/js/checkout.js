import { toast } from './toast.js';

$(document).ready(() => {
	const btnCheckouts = document.querySelectorAll('.btn-checkout');
	const checkout = document.querySelector('.checkout');
	const overlay = document.querySelector('.checkout-overlay');
	const checkoutQR = checkout.querySelector('img');

	const MY_BANK = {
		BANK_ID: 'MB',
		ACCOUNT_NO: '8383352888888',
		ACCOUNT_NAME: 'TRANG KIM LOI'
	};

	const amount = 10000;
	const text = `TEST 2`;

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

	async function checkPaid (amount, text) {
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
						setTimeout(() => {
								window.location.href = `${contextPath}/register`;
							},
							1000);
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
});
