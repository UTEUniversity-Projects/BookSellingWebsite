import { toast } from "./toast.js";

class ForgotPassword {
	constructor() {
	}

	forgotPassword() {

		$(".btn-forgot").click(function () {
			const username = $(this).closest(".cr-content-form").find("#username");
			const usernameValue = username.val().trim();

			console.log(usernameValue);

			username.next(".error-message").remove();

			if (usernameValue.length === 0) {
				username.parent().append("<div class=\"error-message text-[16px] text-red-500\">Trường này không được để trống</div>");
				return;
			}

			const forgotButton = $('.btn-forgot');
			const spinner = forgotButton.find('.spinner');
			const buttonText = forgotButton.find('.button-text');

			forgotButton.prop('disabled', true);
			buttonText.addClass('hidden');
			spinner.removeClass('hidden');

			const formContainer = $(this).closest('.cr-content-form');
			$.ajax({
				url: `${contextPath}/forgot`,
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify({
					username: usernameValue
				}),
				success: function (response) {
					if (response.code === 200) {
						toast({
							title: 'Thông báo',
							message: response.message,
							type: 'success',
							duration: 1000
						});
						setTimeout(() => {
							formContainer.empty();
							formContainer.append('<div class="form-group mb-2">\n' +
								'                            <label for="otp" class="text-md mb-1 ml-2">Mã OTP:</label>\n' +
								'                            <input id="otp" type="text" autocomplete="on" placeholder="Nhập mã OTP..." maxlength="6"\n' +
								'                                   class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]" />\n' +
								'                        </div>\n' +
								'                        <span id="countdown" class="countdown"></span>\n' +
								'                        <button type="button"\n' +
								'                                class="btn-verify-otp px-8 py-2 rounded text-white bg-[#64b595] hover:bg-[#64b595]/90 transition-all duration-300">\n' +
								'                            Gửi\n' +
								'                        </button>');
						}, 2000)
					} else {
						toast({
							title: 'Thông báo',
							message: response.message,
							type: 'error',
							duration: 1000
						});
					}
				},
				error: function (xhr, status, error) {
					console.error('Error: ', xhr.responseText);
				},
				complete: function () {
					forgotButton.prop('disabled', false);
					buttonText.removeClass('hidden');
					spinner.addClass('hidden');
				}
			});

		});

		$(document).on("click", ".btn-verify-otp",function (e) {
			e.preventDefault();

			const otp = $("#otp");
			const otpCode = otp.val().trim();

			otp.next(".error-message").remove();

			if (otpCode.length === 0) {
				otp.parent().append(
					"<div class=\"error-message text-[16px] text-red-500\">Trường này không được để trống</div>"
				);
				return;
			}

			if (!/^\d{6}$/.test(otpCode)) {
				otp.parent().append(
					"<div class=\"error-message text-[16px] text-red-500\">Mã OTP phải là 6 chữ số</div>"
				);
				return;
			}

			const formContainer = $('.cr-content-form');
			$.ajax({
				url: `${contextPath}/verify-otp`,
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify({ otpCode: otpCode }),
				success: function (response) {
					if (response.code === 200) {
						toast({
							title: "Thông báo",
							message: response.message,
							type: "success",
							duration: 1000,
						});
						setTimeout(() => {
							formContainer.empty();
							formContainer.append('<div class="form-group mb-2">\n' +
								'                            <label for="password" class="text-md mb-1 ml-2">Mật khẩu mới:</label>\n' +
								'                            <input id="password" type="text" autocomplete="on" placeholder="Nhập mật khẩu mới..." minlength="8"\n' +
								'                                   class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]" />\n' +
								'                            <label for="confirm-password" class="text-md mb-1 ml-2">Mã OTP:</label>\n' +
								'                            <input id="confirm-password" type="text" autocomplete="on" placeholder="Nhập lại mật khẩu..." minlength="8"\n' +
								'                                   class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]" />\n' +
								'                        </div>\n' +
								'                        <button type="button"\n' +
								'                                class="btn-reset-password px-8 py-2 rounded text-white bg-[#64b595] hover:bg-[#64b595]/90 transition-all duration-300">\n' +
								'                            Gửi\n' +
								'                        </button>')
						}, 2000)
					} else {
						toast({
							title: "Thông báo",
							message: response.message,
							type: "error",
							duration: 1000,
						});
					}
				},
				error: function (xhr, status, error) {
					console.error("Error: ", xhr.responseText);
				}
			});
		});
		$(document).on("click", ".btn-reset-password",function (e) {
			e.preventDefault();

			const password = $(this).closest(".cr-content-form").find("#password");
			const confirmPassword = $("#confirm-password");

			const passwordValue = password.val().trim();
			const confirmPasswordValue = confirmPassword.val().trim();

			password.next(".error-message").remove();
			confirmPassword.next(".error-message").remove();

			if (passwordValue.length < 8) {
				password.parent().append(
					"<div class=\"error-message text-[16px] text-red-500\">Mật khẩu phải có ít nhất 8 ký tự</div>"
				);
				return;
			}

			if (passwordValue !== confirmPasswordValue) {
				confirmPassword.parent().append(
					"<div class=\"error-message text-[16px] text-red-500\">Mật khẩu xác nhận không khớp</div>"
				);
				return;
			}

			$.ajax({
				url: `${contextPath}/reset-password`,
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify({
					newPassword: passwordValue
				}),
				success: function (response) {
					if (response.code === 200) {
						toast({
							title: "Thông báo",
							message: response.message,
							type: "success",
							duration: 1000,
						});
						setTimeout(() => {
							window.location.href = `${contextPath}/login`;
						}, 1000)
					}
				},
				error: function (xhr, status, error) {
					console.error("Error: ", xhr.responseText);
				}
			});
		});
	}
}

const forgotPassword = new ForgotPassword();
forgotPassword.forgotPassword();