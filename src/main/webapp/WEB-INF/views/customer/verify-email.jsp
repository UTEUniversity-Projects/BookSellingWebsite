<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Verify email page -->
<section class="section-login padding-tb-100">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="cr-login" data-aos="fade-up" data-aos-duration="2000" data-aos-delay="400">
                    <div class="form-logo">
                        <img src="customer/img/logo/biblio.png" alt="logo">
                    </div>
                    <form class="cr-content-form">
                        <div class="form-group mb-2">
                            <label for="email" class="text-md mb-1 ml-2">Địa chỉ email:</label>
                            <input id="email" type="email" autocomplete="on" placeholder="Nhập email..."
                                   class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]" />
                        </div>
                        <button type="button"
                                class="btn-verify px-8 py-2 rounded text-white bg-[#64b595] hover:bg-[#64b595]/90 transition-all duration-300">
                            Gửi
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="modal-email inset-0 z-[999] transition-all duration-300">
    <div class="overlay cursor-pointer opacity-0 bg-black/20 inset-0 z-[1000]"></div>
    <div class="modal-content absolute z-[1000] top-[30%] left-1/2 bg-white rounded w-[400px] h-[200px] bottomup">
        <div class="checkmark-wrapper">
            <svg class="checkmark" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 52 52">
                <circle class="checkmark-circle" cx="26" cy="26" r="25" fill="none"/>
                <path class="checkmark-check" fill="none" d="M14 27l7 7 16-16"/>
            </svg>
            <p class="success-message"></p>
        </div>
    </div>
</div>
