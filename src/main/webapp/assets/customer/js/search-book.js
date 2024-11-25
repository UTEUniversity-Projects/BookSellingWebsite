import { toast } from './toast.js';
import { debounce } from '../../commons/js/debounce.js';
import { zoomImage } from '../../commons/js/zoom-image.js';
import { formatCurrencyVND } from '../../commons/js/format-currency.js';

$(document).ready(() => {
	class SearchBook {
		constructor () {

		}

		async search (title, categoryId, sortBy) {

			const generateStars = (reviewRate) => {
				let stars = '';
				for (let i = 1; i <= 5; i++) {
					if (reviewRate >= i) {
						stars += '<i class="ri-star-fill"></i>';
					} else if (reviewRate > i - 1 && reviewRate < i) {
						stars += '<i class="ri-star-half-line"></i>';
					} else {
						stars += '<i class="ri-star-line"></i>';
					}
				}
				return stars;
			};

			const generateBook = (book) => {
				return `
							<div data-book-id="${book.id}" class="mix col-xxl-3 col-xl-4 col-6 cr-product-box mb-5">
                            <div class="cr-product-card">
                                <div class="cr-product-image">
                                    <div class="cr-image-inner image-zoom"
								         style="--url: url(${book.imageUrl.replace(/\\/g, '/')});
								            --zoom-x: 0%;
								            --zoom-y: 0%;
								            --display: none;">
                                    <img src="${book.imageUrl}" alt="${book.title}">
                                    <img role="presentation" alt="" src="http://localhost:8080/assets/owner/img/book/TrenDuongBang/image1.jpg" class="zoomImg" style="position: absolute; top: -2141.2px; left: -1465.35px; opacity: 0; width: 2560px; height: 2560px; border: none; max-width: none; max-height: none;"></div>
                                    <div class="cr-side-view">
                                        <a class="model-oraganic-product" data-bs-toggle="modal" href="#quickview-${book.id}" role="button">
                                            <i class="ri-eye-line"></i>
                                        </a>
                                    </div>
                                    <a class="cr-shopping-bag" href="javascript:void(0)">
                                        <i class="ri-shopping-bag-line"></i>
                                    </a>
                                </div>
                                <div class="cr-product-details">
                                    <div class="cr-brand">
                                        <p>${book.categoryName}</p>
                                        <div class="cr-star">
                                            ${generateStars(book.reviewRate)}
                                            <p>(${book.reviewRate})</p>
                                        </div>
                                    </div>
                                    <a href="${contextPath}/book?id=${book.id}" class="title">${book.title}</a>
                                    <p class="cr-price">
                                        <span class="new-price price-value">${formatCurrencyVND(book.sellingPrice)}</span>
                                        <span class="old-price price-value">${formatCurrencyVND(book.sellingPrice)}</span>
                                    </p>
                                </div>
                            </div>
                        </div>
						`;
			};

			const generateModal = (book) => {
				return `
				<div class="modal fade quickview-modal" id="quickview-${book.id}" aria-hidden="true" tabindex="-1">
			        <div class="modal-dialog modal-dialog-centered cr-modal-dialog">
			            <div class="modal-content">
			                <button type="button" class="cr-close-model btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			                <div class="modal-body">
			                    <div class="row">
			                        <div class="col-md-5 col-sm-12 col-xs-12">
			                            <div class="zoom-image-hover modal-border-image" style="position: relative; overflow: hidden;">
			                                <img src="${contextPath}${book.imageUrl}" alt="product-tab-2" class="product-image">
			                            <img role="presentation" alt="" src="${contextPath}${book.imageUrl}" class="zoomImg" style="position: absolute; top: 0px; left: 0px; opacity: 0; width: 750px; height: 750px; border: none; max-width: none; max-height: none;"></div>
			                        </div>
			                        <div class="col-md-7 col-sm-12 col-xs-12">
			                            <div class="cr-size-and-weight-contain">
			                                <h2 class="heading">
			                                        ${book.title}
			                                </h2>
			                            </div>
			                            <div class="cr-size-and-weight">
			                                <div class="cr-review-star">
			                                    <div class="cr-star">
			                                        ${generateStars(book.reviewRate)}                                     
			                                    </div>
			                                    <p>( ${book.numberOfReviews} Reviews)</p>
			                                </div>
			                                <div class="cr-product-price">
			                                    <span class="new-price">${formatCurrencyVND(book.sellingPrice)}</span>
			                                        
			                                </div>
			                                <div class="cr-size-weight">
			                                    <h5><span>Tình trạng</span> :</h5>
			                                    <div class="cr-kg">
			                                        <ul>
			                                            <li class="active-color">${book.condition}</li>
			                                        </ul>
			                                    </div>
			                                </div>
			                                <div class="cr-add-card">
			                                    <div class="cr-qty-main">
			                                        <input type="text" placeholder="." value="1" minlength="1" maxlength="20" class="quantity">
			                                        <button type="button" class="plus">+</button>
			                                        <button type="button" class="minus">-</button>
			                                    </div>
			                                    <div class="cr-add-button">
			                                        <button type="button" class="cr-button cr-btn-secondary cr-shopping-bag">
			                                            Thêm vào giỏ hàng
			                                        </button>
			                                    </div>
			                                    <div class="cr-buy-button">
			                                        <button type="button" class="cr-button">
			                                            Mua ngay
			                                        </button>
			                                    </div>
			                                </div>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
				`;
			};

			const searchData = {
				title,
				categoryId,
				sortBy
			};

			$('.book-list').html('                    <div class="loading">\n' +
				'                        <div class="mx-auto w-[30px] h-[30px] rounded-full border-[4px] border-solid border-green-400 border-t-transparent animate-spin"></div>\n' +
				'                    </div>');
			$('.cr-pagination').hide();
			await $.ajax({

				url: `${contextPath}/api/customer/search-book`,
				type: 'POST',
				data: JSON.stringify(searchData),
				contentType: 'application/json',
				success: function (result) {
					const bookList = document.querySelector('.book-list');
					console.log(result);
					if (result.response.length === 0) {
						bookList.innerHTML = `<p class="text-xl text-[#269a37] text-center">Không tìm thấy sản phẩm nào với từ khóa <b>${title}</b>.</p>`;
						$('.cr-pagination').hide();
					} else {
						bookList.innerHTML = result.response.map(generateBook).join('');

						$('.modal.fade.quickview-modal').remove();
						document.querySelector('body').insertAdjacentHTML('beforeend', result.response.map(generateModal).join(''));

						$('.cr-pagination').show();
						zoomImage('.image-zoom');
					}
					if (title?.trim() !== '' || categoryId) {
						$('.search-result-label').text(` ${title} (${result.quantity} kết quả)`);
					} else {
						$('.search-result-label').text('');
					}
				},
				error: function (error) {
					console.log(error);
				},
				complete: function () {
					$('.loading').addClass('hidden');
					$('.book-list').removeClass('hidden');
				}
			});

		}
	}

	const searchBook = new SearchBook();

	const searchInput = $('.search-input');
	const urlParams = new URLSearchParams(window.location.search);
	let title = urlParams.get('title');
	let categoryId = null;

	$('.btn-search').click(function (event) {
		if (!window.location.pathname.includes('/search'))
			return;
		event.preventDefault();

		if (searchInput.val() === '') {
			toast({
				title: 'Tìm kiếm',
				message: 'Vui lòng nhập thông tin tìm kiếm!'
			});
		} else {
			if (window.location.pathname.includes('/search')) {
				searchBook.search(searchInput.val());
			}
		}
	});

	if (window.location.pathname.includes('/search')) {
		searchInput.on('input', debounce(function () {

			const newUrl = `/search?title=${encodeURIComponent(searchInput.val())}`;
			window.history.pushState({ path: newUrl }, '', newUrl);

			const urlParams = new URLSearchParams(window.location.search);
			title = urlParams.get('title');

			searchBook.search(title, categoryId);
		}, 500));
	}

	if (title) {
		searchInput.val(title);
		searchBook.search(title, categoryId);
	}

	$('.category-item').on('click', function() {
		$('.category-item').each(function () {
			$(this)[0].checked = false;
		});
		$(this)[0].checked = true;
		categoryId = $(this).val() != "on" ? $(this).val() : null;
		console.log(categoryId);
		searchBook.search(title, categoryId)
	});
});
