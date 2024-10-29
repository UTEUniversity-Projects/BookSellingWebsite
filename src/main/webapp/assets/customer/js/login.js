import { toast } from "./toast.js";

export function login() {

	$('.btn-login').on('click', function (event) {

		$('.form-group').removeClass('has-error');
		$('.error-message').remove();

		let isValid = true;

		$('.input').each(function () {
			if ($(this).val() === '') {
				isValid = false;
				$(this).closest('.form-group').addClass('has-error');
				$(this).after(
					'<div class="error-message text-[16px] text-red-500">Trường này không được để trống</div>'
				);
			}
		});

		const email = $('input[type="email"]').val();
		const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		if (email && !emailPattern.test(email)) {
			isValid = false;
			$('input[type="email"]').closest('.form-group').addClass('has-error');
			$('input[type="email"]').after(
				'<div class="error-message text-[16px] text-red-500">Email không hợp lệ</div>'
			);
		}

		if (isValid) {
			toast({
				title: "Đăng nhập thành công",
				message: "",
				type: "success"
			});
			setTimeout(() => {
				window.location.href = "home";
			}, 500);
		} else {
			event.preventDefault();
		}
	});
}
