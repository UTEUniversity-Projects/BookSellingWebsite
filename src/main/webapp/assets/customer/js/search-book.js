import { toast } from './toast.js';
import { debounce } from '../../commons/js/debounce.js';

$(document).ready(() => {
	class SearchBook {
		constructor () {

		}

		search (searchInput) {

			const searchData = {
				title: searchInput
			};

			$.ajax({
				url: `${contextPath}/search`,
				type: 'POST',
				data: JSON.stringify(searchData),
				contentType: 'application/json',
				success: function (result) {
					console.log(result);
					const bookList = document.querySelector('.book-list');
					if (!result) {
						bookList.innerHTML = `<p class="text-xl text-[#269a37] text-center">Không tìm thấy sản phẩm nào với từ khóa <b>${searchInput}</b>.</p>`;
						$(".cr-pagination").hide();
					} else {
						bookList.innerHTML = result;
						$(".cr-pagination").show();
					}
				},
				error: function (error) {
					console.log(error);
				}
			});
		}
	}

	const searchBook = new SearchBook();

	const searchInput = $('.search-input');
	$('.btn-search').click(function (event) {
		event.preventDefault();

		if (searchInput === '') {
			toast({
				title: 'Tìm kiếm',
				message: 'Vui lòng nhập thông tin tìm kiếm!'
			});
		} else {
			if (!window.location.pathname.includes('/search')) {
				window.location.href = `${contextPath}/search`;
			}
			searchBook.search(searchInput.val());
		}
	});

	if (window.location.pathname.includes('/search')) {
		searchInput.on('input', debounce(function () {

			const newUrl = `/search?keyword=${encodeURIComponent(searchInput.val())}`;
			window.history.pushState({ path: newUrl }, '', newUrl);

			const urlParams = new URLSearchParams(window.location.search);
			const keyword = urlParams.get('keyword');
			console.log(keyword);

			//searchBook.search(keyword);
		}, 500));
	}

});