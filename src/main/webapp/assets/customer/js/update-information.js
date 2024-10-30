$(document).ready(() => {
	import { toast } from "./toast.js";

	class UpdateInformation {
		constructor() {
		}

		updateInformation() {
			$(".btn-update-information").click(function (e) {
				event.preventDefault();

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

				if (isValid) {
					toast({
						title: "Cập nhật thông tin",
						message: "Cập nhật thông tin cá nhân thành công !",
						type: "success"
					});

					setTimeout(() => {
						window.location.href = "user-information";
					}, 1000);
				}
			})
		}
	}

	const updateInformation = new UpdateInformation();
	updateInformation.updateInformation();
});