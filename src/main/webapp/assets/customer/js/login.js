import { toast } from './toast.js';
import Validator from './validator.js';

$(document).ready(() => {

	class Login {
		constructor () {
		}

		login ({ username, password }) {
			const loginButton = $('.btn-login');
			const spinner = loginButton.find('.spinner');
			const buttonText = loginButton.find('.button-text');

			const loginData = { username, password };

			loginButton.prop('disabled', true);
			buttonText.addClass('hidden');
			spinner.removeClass('hidden');

			$.ajax({
				url: `${contextPath}/api/login`,
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(loginData),
				success: function (response) {
					console.log(response);
					if (response.status === 'success') {
						toast({
							title: 'Đăng nhập',
							message: 'Đăng nhập thành công !',
							type: 'success',
							duration: 3000
						});
						window.location.href = `${contextPath}/waiting`;
					} else {
						toast({
							title: 'Đăng nhập',
							message: 'Đăng nhập thất bại !',
							type: 'error',
							duration: 3000
						});
						Object.keys(response).forEach(key => {
							if (key !== 'code') {
								$(`#${key}`).next().text(response[key]);
							}
						});
					}
				},
				error: function (xhr, status, error) {
					toast({
						title: 'Đăng nhập',
						message: 'Có lỗi kết nối đến server !',
						type: 'error',
						duration: 3000
					});
				},
				complete: function () {
					// Show button text, hide loading spinner, and enable button
					loginButton.prop('disabled', false);
					buttonText.removeClass('hidden');
					spinner.addClass('hidden');
				}
			});
		}
	}

	const login = new Login();

	Validator({
		form: '#loginForm',
		formGroupSelector: '.form-group',
		errorSelector: '.form-message',
		rules: [
			Validator.isRequired('#username', 'Vui lòng nhập username !'),
			Validator.isRequired('#password', 'Vui lòng nhập password !')
		],
		onSubmit: function (data) {
			login.login(data);
		}
	});

});
