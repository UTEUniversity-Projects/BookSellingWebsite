<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="max-w-[1200px] mx-auto mt-5">
  <h3
          class="text-3xl uppercase font-bold bg-[#f5f5f5] px-4 py-2 rounded text-[#26a397]"
  >
    Đặt hàng
  </h3>
  <div class="w-full mt-5">
    <div class="flex bg-[#f5f5f5] px-2 py-2">
      <div class="col-sm-6">
        <p class="text-md font-medium ml-7 text-[#26a397]">Sách</p>
      </div>
      <div class="col-sm-2 text-center">
        <p class="text-md font-medium text-[#26a397]">Đơn giá</p>
      </div>
      <div class="col-sm-2 text-center">
        <p class="text-md font-medium text-[#26a397]">Số lượng</p>
      </div>
      <div class="col-sm-2 text-center">
        <p class="text-md font-medium text-[#26a397]">Thành tiền</p>
      </div>
    </div>
    <div class="bg-[#f5f5f5] rounded">
      <a
              class="flex rounded items-center hover:bg-gray-200 p-2 transition-all duration-300"
              href="product"
      >
        <div class="col-sm-6">
          <div class="flex items-center justify-between gap-x-5 mr-5">
            <div class="w-[100px] h-[100px] flex-shrink-0">
              <img
                      class="w-full h-full object-cover"
                      src="${pageContext.request.contextPath}/customer/img/product/10.jpg"
                      alt="Product"
              />
            </div>
            <p
                    class="text-justify"
                    style="
                    display: -webkit-box;
                    -webkit-line-clamp: 2;
                    -webkit-box-orient: vertical;
                    text-overflow: ellipsis;
                    word-break: break-word;
                    overflow: hidden;
                  "
            >
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam
              exercitationem impedit voluptatum ducimus tempore aperiam
              consequuntur voluptates quaerat repellat minus adipisci dolor,
              velit iste molestiae quasi ut cumque? Commodi, deserunt?
            </p>
          </div>
        </div>
        <div class="col-sm-2 text-center">
          <p>₫<span class="price">52.000</span></p>
        </div>
        <div class="col-sm-2 text-center">
          <span class="quantity">1</span>
        </div>
        <div class="col-sm-2 text-center">
          <p>₫<span class="total">52.000</span></p>
        </div>
      </a>
    </div>
    <div class="mt-5 bg-[#f5f5f5] px-4 py-2 rounded">
      <div class="w-full">
        <h3 class="text-2xl font-bold text-[#26a397]">Địa chỉ</h3>
      </div>
      <div class="w-full flex justify-between items-center">
        <p class="information">
              <span class="fullname font-bold text-[16px] mr-2"
              >Tao nè mày | 09090990999</span
              >
          <span class="address"
          >Hẻm 201/10, Đường Lê Văn Việt, Phường Hiệp Phú, Thành Phố Thủ
                Đức, TP. Hồ Chí Minh</span
          >
          <span
                  class="text-[#26a397] font-medium text-md border border-solid border-[#26a397] rounded px-2 ml-2"
          >Mặc định</span
          >
        </p>
        <button
                class="text-white py-1 px-2 bg-[#26a397] rounded hover:bg-[#63b597] transition-all duration-300 ml-auto"
        >
          Thay đổi
        </button>
      </div>
    </div>
    <div
            class="mt-5 bg-[#f5f5f5] flex justify-between items-center px-10 py-2 rounded"
    >
      <div class="col-sm-6">
        <div class="flex gap-x-5 items-center">
          <svg
                  fill="none"
                  viewBox="0 -2 23 22"
                  class="fill-[#26a397] h-[50px] w-[50px]"
          >
            <g filter="url(#voucher-filter0_d)">
              <mask id="a" fill="#fff">
                <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M1 2h18v2.32a1.5 1.5 0 000 2.75v.65a1.5 1.5 0 000 2.75v.65a1.5 1.5 0 000 2.75V16H1v-2.12a1.5 1.5 0 000-2.75v-.65a1.5 1.5 0 000-2.75v-.65a1.5 1.5 0 000-2.75V2z"
                ></path>
              </mask>
              <path
                      d="M19 2h1V1h-1v1zM1 2V1H0v1h1zm18 2.32l.4.92.6-.26v-.66h-1zm0 2.75h1v-.65l-.6-.26-.4.91zm0 .65l.4.92.6-.26v-.66h-1zm0 2.75h1v-.65l-.6-.26-.4.91zm0 .65l.4.92.6-.26v-.66h-1zm0 2.75h1v-.65l-.6-.26-.4.91zM19 16v1h1v-1h-1zM1 16H0v1h1v-1zm0-2.12l-.4-.92-.6.26v.66h1zm0-2.75H0v.65l.6.26.4-.91zm0-.65l-.4-.92-.6.26v.66h1zm0-2.75H0v.65l.6.26.4-.91zm0-.65l-.4-.92-.6.26v.66h1zm0-2.75H0v.65l.6.26.4-.91zM19 1H1v2h18V1zm1 3.32V2h-2v2.32h2zm-.9 1.38c0-.2.12-.38.3-.46l-.8-1.83a2.5 2.5 0 00-1.5 2.29h2zm.3.46a.5.5 0 01-.3-.46h-2c0 1.03.62 1.9 1.5 2.3l.8-1.84zm.6 1.56v-.65h-2v.65h2zm-.9 1.38c0-.2.12-.38.3-.46l-.8-1.83a2.5 2.5 0 00-1.5 2.29h2zm.3.46a.5.5 0 01-.3-.46h-2c0 1.03.62 1.9 1.5 2.3l.8-1.84zm.6 1.56v-.65h-2v.65h2zm-.9 1.38c0-.2.12-.38.3-.46l-.8-1.83a2.5 2.5 0 00-1.5 2.29h2zm.3.46a.5.5 0 01-.3-.46h-2c0 1.03.62 1.9 1.5 2.3l.8-1.84zM20 16v-2.13h-2V16h2zM1 17h18v-2H1v2zm-1-3.12V16h2v-2.12H0zm1.4.91a2.5 2.5 0 001.5-2.29h-2a.5.5 0 01-.3.46l.8 1.83zm1.5-2.29a2.5 2.5 0 00-1.5-2.3l-.8 1.84c.18.08.3.26.3.46h2zM0 10.48v.65h2v-.65H0zM.9 9.1a.5.5 0 01-.3.46l.8 1.83A2.5 2.5 0 002.9 9.1h-2zm-.3-.46c.18.08.3.26.3.46h2a2.5 2.5 0 00-1.5-2.3L.6 8.65zM0 7.08v.65h2v-.65H0zM.9 5.7a.5.5 0 01-.3.46l.8 1.83A2.5 2.5 0 002.9 5.7h-2zm-.3-.46c.18.08.3.26.3.46h2a2.5 2.5 0 00-1.5-2.3L.6 5.25zM0 2v2.33h2V2H0z"
                      mask="url(#a)"
              ></path>
            </g>
            <path
                    clip-rule="evenodd"
                    d="M6.49 14.18h.86v-1.6h-.86v1.6zM6.49 11.18h.86v-1.6h-.86v1.6zM6.49 8.18h.86v-1.6h-.86v1.6zM6.49 5.18h.86v-1.6h-.86v1.6z"
            ></path>
            <defs>
              <filter
                      id="voucher-filter0_d"
                      x="0"
                      y="1"
                      width="20"
                      height="16"
                      filterUnits="userSpaceOnUse"
                      color-interpolation-filters="sRGB"
              >
                <feFlood
                        flood-opacity="0"
                        result="BackgroundImageFix"
                ></feFlood>
                <feColorMatrix
                        in="SourceAlpha"
                        values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0"
                ></feColorMatrix>
                <feOffset></feOffset>
                <feGaussianBlur stdDeviation=".5"></feGaussianBlur>
                <feColorMatrix
                        values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.09 0"
                ></feColorMatrix>
                <feBlend
                        in2="BackgroundImageFix"
                        result="effect1_dropShadow"
                ></feBlend>
                <feBlend
                        in="SourceGraphic"
                        in2="effect1_dropShadow"
                        result="shape"
                ></feBlend>
              </filter>
            </defs>
          </svg>
          <span>Biblio Voucher</span>
        </div>
      </div>
      <div class="col-sm-6">
        <div class="text-right">
          <button
                  class="px-4 py-2 rounded bg-[#26a397] hover:bg-[#63b597] transition-all duration-300 text-white text-md"
          >
            Chọn voucher
          </button>
        </div>
      </div>
    </div>
    <div class="mt-5 bg-[#f5f5f5] rounded px-4 py-4">
      <h3 class="text-xl text-[#26a397] font-medium">
        Phương thức thanh toán
      </h3>
      <div class="flex items-center mx-auto justify-evenly h-10 mt-5 mb-5">
        <div
                class="px-4 py-2 hover:bg-[#63b597] rounded cursor-pointer bg-[#26a397] transition-all duration-300"
        >
          <p class="text-white">Chuyển khoản</p>
        </div>
        <div
                class="px-4 py-2 text-white hover:bg-[#63b597] rounded cursor-pointer bg-[#26a397] transition-all duration-300"
        >
          <p class="text-white">Thẻ tín dụng</p>
        </div>
        <div
                class="px-4 py-2 text-white rounded cursor-pointer transition-all duration-300 h-full"
        >
          <img
                  class="w-full h-full object-cover scale-[1]"
                  src="https://cdn.haitrieu.com/wp-content/uploads/2022/10/Logo-VNPAY-QR.png"
          />
        </div>
        <div
                class="px-4 py-2 text-white hover:bg-[#a50164] rounded cursor-pointer bg-[#a50164] transition-all duration-300 h-full"
        >
          <img
                  class="w-full h-full object-cover scale-[1.5]"
                  src="https://static.ybox.vn/2022/4/4/1650508432111-tut.png"
          />
        </div>
        <div
                class="px-4 py-2 text-white hover:bg-gray-50 rounded cursor-pointer bg-white transition-all duration-300 h-full"
        >
          <img
                  class="w-full h-full object-cover scale-[1.2]"
                  src="https://res.cloudinary.com/taskmanagereaglob123/image/upload/v1641970995/VietQR.46a78cbb_utwzzh.png"
          />
        </div>
      </div>
      <div class="w-full h-[1px] bg-gray-200"></div>
      <div class="flex flex-col items-end mt-5">
        <div class="col-sm-3">
          <div class="flex justify-between text-md text-[#63b597]">
                <span class=""
                >Tổng tiền <span class="total-quantity">(2): </span></span
                >
            <span class="total-all text-xl text-[#219075]">50.000</span>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="flex justify-between text-md text-[#63b597]">
            <span class="">Tổng phí vận chuyển: </span>
            <span class="total-all text-xl text-[#219075]">50.000</span>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="flex justify-between text-md text-[#63b597]">
            <span class="">Tổng tiền</span>
            <span class="total-all text-xl text-[#219075]">50.000</span>
          </div>
        </div>
      </div>
      <div class="w-full h-[1px] bg-gray-200"></div>
      <div class="mt-5 text-right">
        <button
                class="px-4 py-2 rounded bg-[#26a397] hover:bg-[#63b597] transition-all duration-300 text-white text-md"
        >
          Đặt hàng
        </button>
      </div>
    </div>
  </div>
</section>
