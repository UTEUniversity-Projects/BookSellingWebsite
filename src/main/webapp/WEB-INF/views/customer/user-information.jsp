<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="section-register padding-tb-100">
    <div class="container-md">
        <div class="row justify-center">
            <div class="col-sm-8 col-md-12">
                <div
                        class="cr-register"
                        data-aos="fade-up"
                        data-aos-duration="2000"
                        data-aos-delay="400"
                >
                    <div class="flex">
                        <div class="form-logo basis-[70%]">
                            <img src="${pageContext.request.contextPath}/assets/customer/img/logo/biblio.png" alt="logo"
                                 class="w-full h-full object-contain"/>
                        </div>
                        <div class="form-logo col-6 basis-[30%] rounded-full border-2 border-solid border-gray-100 p-2 overflow-hidden shadow:md">
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-Javwn-7MizS4Uur3j8_A-sk6T_TRToe6Uw&s"
                                 class="w-full h-full object-cover"
                                 alt="avatar"/>
                        </div>
                    </div>
                    <form action="#" class="cr-content-form">
                        <div class="row">
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2"
                                    >Họ và tên*</label
                                    >
                                    <input
                                            type="text"
                                            placeholder="Nhập họ và tên của bạn"
                                            readonly
                                            class="select-none pointer-events-none block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]"
                                    />
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2"
                                    >Tên đăng nhập*</label
                                    >
                                    <input
                                            type="text"
                                            placeholder="Nhập tên đăng nhập"
                                            readonly
                                            class="select-none pointer-events-none block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]"
                                    />
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2">Email*</label>
                                    <div class="flex items-center justify-between border-1 border-solid border-gray-300 rounded-lg">
                                        <input readonly="" type="email" placeholder="Email"
                                               class="block w-full py-2 px-4 text-gray-900 rounded-lg bg-gray-50 text-[16px] transition-all ease-linear bg-white select-none pointer-events-none">
                                        <div class="text-red-500 flex items-center justify-center bg-red-200/60 hover:bg-red-200/80 transition-all ease-linear w-5 h-5 rounded-full mr-2 relative group">
                                            <span><i class="fa-regular fa-circle-xmark"></i></span>
                                            <div class="absolute verify-email absolute bg-red-200/50 px-3 py-2 text-center hover:bg-red-200/80 transition-all ease-linear rounded-md transition-all ease-linear opacity-0 invisible scale-0 group-hover:opacity-100 group-hover:visible group-hover:scale-100 duration-300 w-[250px] translate-x-2/4 origin-[50%_-20px] right-2/4 top-10">
                                                <p>Email chưa được xác thực</p>
                                                <a href="#" class="inline-block p-2 rounded-md bg-red-200">Xác thực
                                                    ngay</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2"
                                    >Số điện thoại*</label
                                    >
                                    <input
                                            type="tel"
                                            placeholder="Nhập số điện thoại của bạn"
                                            readonly
                                            class="select-none pointer-events-none block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]"
                                    />
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2">Ngày sinh</label>
                                    <input id="" type="date" readonly
                                           class="select-none pointer-events-none select-none bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-3 p-2.5"
                                           placeholder="Ngày sinh">
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2">Giới tính*</label>
                                    <ul class="w-full flex justify-around items-center w-48 text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-lg">
                                        <li class="w-full border-b border-gray-200 rounded-t-lg dark:border-gray-600">
                                            <div class="w-full flex justify-center items-center ps-3">
                                                <input readonly id="male" type="radio" value="" name="list-radio"
                                                       class="select-none pointer-events-none w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 cursor-pointer">
                                                <label for="male"
                                                       class="select-none pointer-events-none   py-3 ms-2 text-sm font-medium text-black cursor-pointer">Nam</label>
                                            </div>
                                        </li>
                                        <li class="w-full border-b border-gray-200 rounded-t-lg dark:border-gray-600">
                                            <div class="w-full flex justify-center items-center ps-3">
                                                <input readonly id="female" type="radio" value="" name="list-radio"
                                                       class="select-none pointer-events-none w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 cursor-pointer">
                                                <label for="female"
                                                       class="select-none pointer-events-none py-3 ms-2 text-sm font-medium text-black cursor-pointer">Nữ</label>
                                            </div>
                                        </li>
                                        <li class="w-full border-b border-gray-200 rounded-t-lg dark:border-gray-600">
                                            <div class="w-full flex justify-center items-center ps-3">
                                                <input readonly id="other" type="radio" value="" name="list-radio"
                                                       class="select-none pointer-events-none w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 cursor-pointer">
                                                <label for="other"
                                                       class="select-none pointer-events-none py-3 ms-2 text-sm font-medium text-black cursor-pointer">Khác</label>
                                            </div>
                                        </li>
                                    </ul>
                                </div>

                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group mb-2">
                                    <label
                                            for="city"
                                            class="text-md text-slate-700 mb-1 ml-2"
                                    >Tỉnh thành phố</label
                                    >
                                    <select
                                            id="city"
                                            class="select-none pointer-events-none bg-gray-50 border border-gray-300 text-gray-900 text-md rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected>Thành phố</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group mb-2">
                                    <label
                                            for="district"
                                            class="text-md text-slate-700 mb-1 ml-2"
                                    >Quận Huyện</label
                                    >
                                    <select
                                            id="district"
                                            class="select-none pointer-events-none bg-gray-50 border border-gray-300 text-gray-900 text-md rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected>Quận Huyện</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group mb-2">
                                    <label
                                            for="ward"
                                            class="text-md text-slate-700 mb-1 ml-2"
                                    >Phường Xã</label
                                    >
                                    <select
                                            id="ward"
                                            class="select-none pointer-events-none bg-gray-50 border border-gray-300 text-gray-900 text-md rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected>Phường Xã</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group mb-2">
                                    <label
                                            for="hamlet"
                                            class="text-md text-slate-700 mb-1 ml-2"
                                    >Số nhà | Ấp | Tổ</label
                                    >
                                    <select
                                            id="hamlet"
                                            class="select-none pointer-events-none bg-gray-50 border border-gray-300 text-gray-900 text-md rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected>Số nhà | Ấp | Tổ</option>
                                    </select>
                                </div>
                            </div>
                            <div class="flex justify-between flex-nowrap gap-x-2 mt-2">
                                <button
                                        type="button"
                                        class="btn-register font-medium text-md bg-emerald-600 px-4 py-2 rounded-md text-white hover:bg-emerald-700 transition-all duration-300"
                                >
                                    Đăng Ký
                                </button>
                                <a
                                        href="update-information"
                                        class="py-2 border border-solid px-4 inline-block rounded-md hover:bg-gray-100 transition-all duration-300"
                                >
                                    Cập nhật thông tin
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>