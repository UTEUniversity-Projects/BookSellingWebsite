import { toast } from "./toast.js";

$(document).ready(() => {
	class SearchBook {
		constructor() {

		}

		search() {

		}
	}

	const searchBook = new SearchBook();

	$(".btn-search").click(function(event) {
		event.preventDefault();

		const searchInput = $(".search-input").val();

		if (searchInput === "") {
			toast({
				title: "Tìm kiếm",
				message: "Vui lòng nhập thông tin tìm kiếm!",
			});
		} else {
			if (!window.location.pathname.includes("/search")) {
				window.location.href = `${contextPath}/search`;
			}
		}
	});

});