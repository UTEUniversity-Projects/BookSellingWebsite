import { toast } from "./toast.js";

$(document).ready(() => {

	class Register {
		constructor(props) {

		}

		validate() {
			$('.btn--success').on('click', function (event) {
				// event.preventDefault();

				$('.form-group').removeClass('has-error');
				$('.error-message').remove();

				let isValid = true;

				$('.form-group')
					.slice(0, -1)
					.each(function () {
						let input = $(this).find('input');
						if (input.attr('type') !== 'radio' && input.val() === '') {
							isValid = false;
							$(this).addClass('has-error');

							if ($(this).find('.error-message').length === 0) {
								input.after(
									'<div class="error-message text-[16px] text-red-500">Trường này không được để trống.</div>'
								);
							}
						}
					});

				const email = $('input[type="email"]').val();
				const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
				if (email && !emailPattern.test(email)) {
					isValid = false;
					$('input[type="email"]').closest('.form-group').addClass('has-error');
					$('input[type="email"]').after(
						'<div class="error-message text-[16px] text-red-500">Email không hợp lệ.</div>'
					);
				}

				const password = $('input[type="password"]').eq(0).val();
				const confirmPassword = $('input[type="password"]').eq(1).val();
				if (password !== confirmPassword) {
					isValid = false;
					$('input[type="password"]')
						.eq(1)
						.closest('.form-group')
						.addClass('has-error');
					$('input[type="password"]')
						.eq(1)
						.after(
							'<div class="error-message text-[16px] text-red-500">Mật khẩu không khớp.</div>'
						);
				}

				const gender = $("input[type='radio']:checked");
				if (gender.length === 0) {
					isValid = false;
					const genderUl = $("input[type='radio']").closest('ul');
					genderUl.after(
						'<div class="error-message text-[16px] text-red-500">Vui lòng chọn giới tính.</div>'
					);
				}

				const termsCheckbox = $('#check-with-link')[0];
				const errorMsg =
					'<div class="ml-[30px] error-message text-[16px] text-red-500">Bạn cần đồng ý với các điều khoản.</div>';
				if (!termsCheckbox.checked) {
					isValid = false;
					termsCheckbox.parentNode.parentNode.insertAdjacentHTML(
						'beforeend',
						errorMsg
					);
				}

				if (isValid) {
					toast({
						title: "Đăng ký",
						message: "Đăng ký thành công",
						type: "success",
						duration: 3000,
					});

					// setTimeout(() => {
					// 	window.location.href = "login";
					// }, 1000);
				}
			});
		}

		register() {
			$("#registerForm").submit(function (event) {
				event.preventDefault();

				const formData = new FormData(this);

				$.ajax({
					url: `${contextPath}/api/customer/register`,
					type: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(formData),
					success: function (response, status, xhr) {
						console.log(response);
					},
					error: function (xhr, status, error) {
						console.error('Lỗi:', error);
						alert('Có lỗi xảy ra, vui lòng thử lại!');
					}
				});


			});

		}

		getAddress() {
			const BASE_URL = 'https://web.giaohangtietkiem.vn/api/v1/public/address';

			$.getJSON(`${BASE_URL}/list`, async function (city) {
				if (city.success) {
					$.each(city.data, function (key, value) {
						$('#city').append(`<option value="${value.id}" data-name="${value.name}">${value.name}</option>`);
					});

					$('#city').change(function (e) {
						const cityId = $(this).val();

						$.getJSON(
							`${BASE_URL}/list?parentId=${cityId}&type=3`,
							function (district) {
								if (district.success) {
									$('#district').html(`<option value="0">Quận Huyện</option>`);
									$('#ward').html(`<option value="0">Phường Xã</option>`);
									$('#hamlet').html(`<option value="0">Số nhà | Ấp | Tổ</option>`);

									$.each(district.data, function (key, value) {
										$('#district').append(
											`<option value="${value.id}" data-name="${value.name}">${value.name}</option>`
										);
									});
								}
							}
						);
					});

					$('#district').change(function (e) {
						const wardId = $(this).val();

						$('#ward').html(`<option value="0">Phường Xã</option>`);
						$('#hamlet').html(`<option value="0">Số nhà | Ấp | Tổ</option>`);

						$.getJSON(
							`${BASE_URL}/list?parentId=${wardId}&type=1`,
							function (ward) {
								if (ward.success) {
									$.each(ward.data, function (key, value) {
										$('#ward').append(
											`<option value="${value.id}" data-name="${value.name}">${value.name}</option>`
										);
									});
								}
							}
						);
					});

					// $('#ward').change(function (e) {
					// 	const hamletId = $(this).val();
					// 	$('#hamlet').html(`<option value="0">Số nhà | Ấp | Tổ</option>`);
					//
					// 	$.getJSON(`${BASE_URL}/hamlet?parentId=${hamletId}`, function (hamlet) {
					// 		if (hamlet.success) {
					// 			$.each(hamlet?.data?.hamlet_address, function (key, value) {
					// 				$('#hamlet').append(
					// 					`<option value="${value.id}" data-name="${value.name}">${value.name}</option>`
					// 				);
					// 			});
					// 		}
					// 	});
					// });
				}
			});
		}

	}

	const register = new Register();
	// register.validate();
	register.register();
	register.getAddress();
});