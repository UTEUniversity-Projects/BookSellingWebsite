$(document).ready(() => {
	const btnCheckouts = document.querySelectorAll(".btn-checkout");
	const checkout = document.querySelector(".checkout");
	const overlay = document.querySelector(".checkout-overlay");
	const qr = ["https://api.viqr.net/vietqr/VietinBank/113366668888/10000/compact.jpg?FullName=Quy%20Vacxin%20Covid&NDck=UngHoCV",
				"https://homepage.momocdn.net/blogscontents/momo-upload-api-220808102122-637955508824191258.png",
				"https://kalite.vn/wp-content/uploads/2021/09/maqrkalite.jpg"];

	btnCheckouts.forEach((btnCheckout, index) => {
		btnCheckout.addEventListener("click", () => {
			checkout.classList.add("active");
			checkout.querySelector("img").src = qr[index];
		})
	});

	overlay.addEventListener("click", () => {
		checkout.classList.remove("active");
		checkout.querySelector("img").src = "";
	});

});