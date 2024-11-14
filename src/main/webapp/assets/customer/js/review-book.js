import { toast } from "./toast.js";

$(document).ready(() => {
	class ReviewBook {
		constructor() {
		}

		sendReview() {
			let prev = 0;
			let next = 0;
			$("input[type='radio']").each(function (index, item) {
				const label = $(this).next("label");
				label.click(function () {
					toast({
						title: "Đánh giá",
						message: `Bạn đã chọn ${item.value} sao !`,
						type: 'info',
						duration: 2000
					});
				})
			});
		}
	}

	const reviewBook = new ReviewBook();

	reviewBook.sendReview();
});
