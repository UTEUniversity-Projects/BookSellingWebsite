export function register() {
  $('.btn-register').on('click', function (event) {
    event.preventDefault();

    $('.form-group').removeClass('has-error');
    $('.error-message').remove();

    let isValid = true;

    $('.cr-form-control').each(function () {
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
          '<div class="error-message text-[16px] text-red-500">Mật khẩu không khớp</div>'
        );
    }

    const termsCheckbox = $('#check-with-link')[0];
    const errorMsg =
      '<div class="ml-[30px] error-message text-[16px] text-red-500">Bạn cần đồng ý với các điều khoản</div>';
    if (!termsCheckbox.checked) {
      isValid = false;
      termsCheckbox.parentNode.parentNode.insertAdjacentHTML(
        'beforeend',
        errorMsg
      );
    }

    if (isValid) {
      alert('Form is valid!');
    }
  });
}
