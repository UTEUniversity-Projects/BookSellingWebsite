import { toast } from "./toast.js";

const urlParams = new URLSearchParams(window.location.search);

if (urlParams.get("message") === "success") {
	toast({
		title: "Thành công!",
		message: "Cảm ơn bạn đã đánh giá!!",
		type: "success",
		duration: 3000,
	});
	setTimeout(() => {
		history.back();
	}, 3000);
}

if (urlParams.get("message") === "error") {
	toast({
		title: "Lỗi!",
		message: "Đã xảy ra lỗi trong quá trình gửi đánh giá.",
		type: "error",
		duration: 3000,
	});
	setTimeout(() => {
		history.back();
	}, 3000);
}

$(document).ready(() => {
	class ReviewBook {
		constructor() {}

		sendReview() {
			$("input[type='radio']").each(function (index, item) {
				const label = $(this).next("label");
				label.click(function () {
					toast({
						title: "Đánh giá",
						message: `Bạn đã chọn ${item.value} sao!`,
						type: 'info',
						duration: 2000
					});
				});
			});
		}
	}

	const reviewBook = new ReviewBook();
	reviewBook.sendReview();
});
