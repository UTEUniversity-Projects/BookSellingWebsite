$(document).ready(() => {
    import { toast } from "./toast.js";

    class VerifyEmail {
        constructor(props) {

        }

        verifyEmail() {

            $(".btn-verify").click(function (e) {
                e.preventDefault();

                const email = $("input[type='email']");
                const emailValue = email.val().trim();

                email.next(".error-message").remove();

                if (emailValue.length === 0) {
                    email.parent().append("<div class=\"error-message text-[16px] text-red-500\">Trường này không được để trống</div>");
                    return;
                }

                const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
                if (!emailRegex.test(emailValue)) {
                    email.parent().append("<div class=\"error-message text-[16px] text-red-500\">Email không đúng định dạng</div>");
                    return;
                }

                toast({
                    title: "Xác thực",
                    message: "Tin nhắn xác thực đã được đến email của bạn !",
                    type: "success",
                });

            });
        }

    }

    const verifyEmail = new VerifyEmail();
    verifyEmail.verifyEmail();

});