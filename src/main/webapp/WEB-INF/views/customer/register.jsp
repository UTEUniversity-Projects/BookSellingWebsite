<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Register -->
<section class="section-register padding-tb-100">
    <div class="container-md mx-auto">
        <div class="row justify-center">
            <div class="col-sm-8 col-md-12">
                <div
                        class="cr-register"
                        data-aos="fade-up"
                        data-aos-duration="2000"
                        data-aos-delay="400"
                >
                    <div class="form-logo">
                        <img src="${pageContext.request.contextPath}/customer/img/logo/biblio.png" alt="logo"/>
                    </div>
                    <form action="#" class="cr-content-form">
                        <div class="row">
                            <div class="col-sm-12 col-md-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2"
                                    >Họ và tên*</label
                                    >
                                    <input
                                            type="text"
                                            placeholder="Nhập họ và tên của bạn"
                                            class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]"
                                    />
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2"
                                    >Tên đăng nhập*</label
                                    >
                                    <input
                                            type="text"
                                            placeholder="Nhập tên đăng nhập"
                                            class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]"
                                    />
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2">Email*</label>
                                    <input
                                            type="email"
                                            placeholder="Nhập email của bạn"
                                            class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]"
                                    />
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2"
                                    >Số điện thoại*</label
                                    >
                                    <input
                                            type="tel"
                                            placeholder="Nhập số điện thoại của bạn"
                                            class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]"
                                    />
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2">Ngày sinh</label>
                                    <input id="" type="date"
                                           class="bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-3 p-2.5"
                                           placeholder="Ngày sinh">
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2">Giới tính*</label>
                                    <ul class="w-full flex justify-around items-center w-48 text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-lg">
                                        <li class="w-full border-b border-gray-200 rounded-t-lg dark:border-gray-600">
                                            <div class="w-full flex justify-center items-center ps-3">
                                                <input id="male" type="radio" value="" name="list-radio"
                                                       class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 cursor-pointer">
                                                <label for="male"
                                                       class="py-3 ms-2 text-sm font-medium text-black cursor-pointer">Nam</label>
                                            </div>
                                        </li>
                                        <li class="w-full border-b border-gray-200 rounded-t-lg dark:border-gray-600">
                                            <div class="w-full flex justify-center items-center ps-3">
                                                <input id="female" type="radio" value="" name="list-radio"
                                                       class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 cursor-pointer">
                                                <label for="female"
                                                       class="py-3 ms-2 text-sm font-medium text-black cursor-pointer">Nữ</label>
                                            </div>
                                        </li>
                                        <li class="w-full border-b border-gray-200 rounded-t-lg dark:border-gray-600">
                                            <div class="w-full flex justify-center items-center ps-3">
                                                <input id="other" type="radio" value="" name="list-radio"
                                                       class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 cursor-pointer">
                                                <label for="other"
                                                       class="py-3 ms-2 text-sm font-medium text-black cursor-pointer">Khác</label>
                                            </div>
                                        </li>
                                    </ul>
                                </div>

                            </div>
                            <div class="col-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2"
                                    >Mật khẩu*</label
                                    >
                                    <input
                                            type="password"
                                            placeholder="Nhập mật khẩu"
                                            class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]"
                                    />
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2"
                                    >Nhập lại mật khẩu*</label
                                    >
                                    <input
                                            type="password"
                                            placeholder="Nhập mật lại khẩu"
                                            class="block w-full py-2 px-4 text-gray-900 border-1 border-gray-300 rounded-lg text-[16px] focus:ring-blue-500 focus:border-blue-500 transition-all ease-linear bg-white focus:shadow-lg focus:shadow-[rgba(3,_102,_214,_0.3)_0px_0px_0px_3px]"
                                    />
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12">
                                <div class="form-group mb-2">
                                    <label
                                            for="city"
                                            class="text-md text-slate-700 mb-1 ml-2"
                                    >Tỉnh thành phố</label
                                    >
                                    <select
                                            id="city"
                                            class="bg-gray-50 border border-gray-300 text-gray-900 text-md rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected>Thành phố</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12">
                                <div class="form-group mb-2">
                                    <label
                                            for="district"
                                            class="text-md text-slate-700 mb-1 ml-2"
                                    >Quận Huyện</label
                                    >
                                    <select
                                            id="district"
                                            class="bg-gray-50 border border-gray-300 text-gray-900 text-md rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected>Quận Huyện</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12">
                                <div class="form-group mb-2">
                                    <label
                                            for="ward"
                                            class="text-md text-slate-700 mb-1 ml-2"
                                    >Phường Xã</label
                                    >
                                    <select
                                            id="ward"
                                            class="bg-gray-50 border border-gray-300 text-gray-900 text-md rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected>Phường Xã</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-12 col-md-12">
                                <div class="form-group mb-2">
                                    <label
                                            for="hamlet"
                                            class="text-md text-slate-700 mb-1 ml-2"
                                    >Số nhà | Ấp | Tổ</label
                                    >
                                    <select
                                            id="hamlet"
                                            class="bg-gray-50 border border-gray-300 text-gray-900 text-md rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected>Số nhà | Ấp | Tổ</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group mb-2">
                                    <label class="text-md text-slate-700 mb-1 ml-2" for="avatar">Tải lên avatar</label>
                                    <input type="file" class="form-control" id="avatar"
                                           aria-describedby="inputGroupFileAddon04" aria-label="Upload"
                                           placeholder="Tải lên ảnh...." name="avatar">

                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group mb-2 flex justify-center items-center">
                                    <div class="mt-4 hidden border-2 border-solid border-gray-100 rounded">
                                        <img id="preview"
                                             class="object-contain w-full h-full"
                                             alt="Ảnh xem trước">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="mb-5 inline-flex items-center flex-wrap">
                                    <label
                                            class="flex items-center cursor-pointer relative"
                                            for="check-with-link"
                                    >
                                        <input
                                                type="checkbox"
                                                class="peer h-5 w-5 cursor-pointer transition-all appearance-none rounded shadow hover:shadow-md border border-slate-200 checked:bg-[#26aa99] checked:border-[#26bb99]"
                                                id="check-with-link"
                                        />
                                        <span
                                                class="absolute text-white opacity-0 peer-checked:opacity-100 top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 flex items-center justify-center w-[12px] h-[12px]"
                                        >
                          <svg
                                  xmlns="http://www.w3.org/2000/svg"
                                  version="1.1"
                                  width="10"
                                  height="10"
                                  viewBox="0 0 1080 1080"
                                  xml:space="preserve"
                          >
                            <defs></defs>
                            <rect
                                    x="0"
                                    y="0"
                                    width="100%"
                                    height="100%"
                                    fill="transparent"
                            ></rect>
                            <g
                                    transform="matrix(1 0 0 1 540 540)"
                                    id="8f5a25e9-c421-4450-b54c-cac6ab86c1ce"
                            ></g>
                            <g
                                    transform="matrix(1 0 0 1 540 540)"
                                    id="a986aab8-9d4c-4b79-84b5-670a6c9dd99d"
                            >
                              <rect
                                      style="
                                  stroke: none;
                                  stroke-width: 1;
                                  stroke-dasharray: none;
                                  stroke-linecap: butt;
                                  stroke-dashoffset: 0;
                                  stroke-linejoin: miter;
                                  stroke-miterlimit: 4;
                                  fill: rgb(255, 255, 255);
                                  fill-rule: nonzero;
                                  opacity: 1;
                                  visibility: hidden;
                                "
                                      vector-effect="non-scaling-stroke"
                                      x="-540"
                                      y="-540"
                                      rx="0"
                                      ry="0"
                                      width="1080"
                                      height="1080"
                              />
                            </g>
                            <g transform="matrix(67.51 0 0 67.51 540 595.68)">
                              <path
                                      style="
                                  stroke: rgb(255, 255, 255);
                                  stroke-width: 1;
                                  stroke-dasharray: none;
                                  stroke-linecap: butt;
                                  stroke-dashoffset: 0;
                                  stroke-linejoin: miter;
                                  stroke-miterlimit: 4;
                                  fill: rgb(255, 251, 251);
                                  fill-rule: evenodd;
                                  opacity: 1;
                                "
                                      transform=" translate(-10.01, -10)"
                                      d="M 16.707 5.293 C 17.097381938332862 5.683499851485814 17.097381938332862 6.316500148514186 16.707 6.707000000000001 L 8.707 14.707 C 8.316500148514187 15.097381938332862 7.6834998514858155 15.097381938332864 7.293000000000001 14.707 L 3.293000000000001 10.707 C 2.9140277904919127 10.314621113035688 2.9194476261029205 9.690915222978894 3.3051814245409075 9.305181424540908 C 3.6909152229788935 8.91944762610292 4.314621113035688 8.914027790491913 4.707000000000001 9.293000000000001 L 8 12.586 L 15.293 5.293 C 15.683499851485813 4.902618061667136 16.316500148514187 4.902618061667136 16.707 5.292999999999999 z"
                                      stroke-linecap="round"
                              />
                            </g>
                          </svg>
                        </span>
                                    </label>
                                    <label
                                            class="cursor-pointer ml-2 "
                                            for="check-with-link"
                                    >
                                        <p class="text-[12px] sm:text-[14px] md:text-[16px]">
                                            Tôi đồng ý với
                                            <a
                                                    href="policy"
                                                    class="font-medium text-emerald-700"
                                            >
                                                điều khoản và chính sách
                                            </a>
                                            của Biblio.
                                        </p>
                                    </label>
                                </div>
                            </div>
                            <div class="flex justify-between flex-nowrap gap-x-2">
                                <button
                                        type="button"
                                        class="btn-register btn--success font-medium text-md bg-emerald-600 px-4 py-2 rounded-md text-white hover:bg-emerald-700 transition-all duration-300"
                                >
                                    Đăng Ký
                                </button>
                                <a
                                        href="login"
                                        class="py-2 border border-solid px-4 inline-block rounded-md hover:bg-gray-100 transition-all duration-300"
                                >
                                    Bạn đã có tài khoản?
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
        integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>

	$(document).ready(function () {
		$('#avatar').on('change', function (event) {
			const file = event.target.files[0];
			if (file) {
				const reader = new FileReader();

				reader.onload = function (e) {
					$('#preview').attr('src', e.target.result).parent().show();
				};

				reader.readAsDataURL(file);
			}
		});
	});
</script>
<script src="customer/js/register.js" type="module"></script>