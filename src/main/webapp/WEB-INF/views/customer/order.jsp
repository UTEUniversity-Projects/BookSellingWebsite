<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Track Order section -->
<div class="bg-gray-100 py-5">
  <div class="max-w-[1024px] mx-auto justfy-spacebetween">
    <ul class="order-nav flex justify-evenly items-center bg-white">
      <li
              data-tab="all"
              class="order_item active cursor-pointer relative text-[#a0a0a0] tracking-[0.5px] transition duration 300 ease-linear hover:text-[#26aa99] text-[16px] py-2 whitespace-nowrap"
      >
        Tất cả
      </li>
      <li
              data-tab="confirming"
              class="order_item cursor-pointer relative text-[#a0a0a0] tracking-[0.5px] transition duration 300 ease-linear hover:text-[#26aa99] text-[16px] py-2 whitespace-nowrap"
      >
        Chờ xác nhận
      </li>
      <li
              data-tab="delivering"
              class="order_item cursor-pointer relative text-[#a0a0a0] tracking-[0.5px] transition duration 300 ease-linear hover:text-[#26aa99] text-[16px] py-2 whitespace-nowrap"
      >
        Đang vận chuyển
      </li>
      <li
              data-tab="completed"
              class="order_item cursor-pointer relative text-[#a0a0a0] tracking-[0.5px] transition duration 300 ease-linear hover:text-[#26aa99] text-[16px] py-2 whitespace-nowrap"
      >
        Hoàn tất giao hàng
      </li>
      <li
              data-tab="cancelled"
              class="order_item cursor-pointer relative text-[#a0a0a0] tracking-[0.5px] transition duration 300 ease-linear hover:text-[#26aa99] text-[16px] py-2 whitespace-nowrap"
      >
        Đã hủy
      </li>
      <li
              data-tab="returning"
              class="order_item cursor-pointer relative text-[#a0a0a0] tracking-[0.5px] transition duration 300 ease-linear hover:text-[#26aa99] text-[16px] py-2 whitespace-nowrap"
      >
        Hoàn trả
      </li>
    </ul>

    <div class="w-full mt-5">
      <div
              data-tab="completed"
              class="flex flex-wrap mb-5 p-2 bg-white rounded fade-in"
      >
        <div
                class="flex-1 items-center border-b-[1px] mb-5 border-solid border-[rgba(0,0,0,0.12)] flex ml-[0] my-[0] text-right basis-full justify-end px-4 py-2"
        >
          <a href="order-detail" class="items-center inline-flex m-0">
                <span class="text-[#26aa99] no-underline align-middle">
                  <svg
                          enable-background="new 0 0 15 15"
                          viewBox="0 0 15 15"
                          x="0"
                          y="0"
                          class="text-[#00bfa5] text-[1rem] mt-[0] mr-[4px] mb-px ml-[0] align-middle stroke-[#26aa99] inline-block h-[1em] w-[1em] fill-current relative"
                  >
                    <g>
                      <line
                              fill="none"
                              stroke-linejoin="round"
                              stroke-miterlimit="10"
                              x1="8.6"
                              x2="4.2"
                              y1="9.8"
                              y2="9.8"
                      ></line>
                      <circle
                              cx="3"
                              cy="11.2"
                              fill="none"
                              r="2"
                              stroke-miterlimit="10"
                      ></circle>
                      <circle
                              cx="10"
                              cy="11.2"
                              fill="none"
                              r="2"
                              stroke-miterlimit="10"
                      ></circle>
                      <line
                              fill="none"
                              stroke-miterlimit="10"
                              x1="10.5"
                              x2="14.4"
                              y1="7.3"
                              y2="7.3"
                      ></line>
                      <polyline
                              fill="none"
                              points="1.5 9.8 .5 9.8 .5 1.8 10 1.8 10 9.1"
                              stroke-linejoin="round"
                              stroke-miterlimit="10"
                      ></polyline>
                      <polyline
                              fill="none"
                              points="9.9 3.8 14 3.8 14.5 10.2 11.9 10.2"
                              stroke-linejoin="round"
                              stroke-miterlimit="10"
                      ></polyline>
                    </g>
                  </svg>
                  Giao hàng thành công
                </span>
          </a>
        </div>
        <div class="flex basis-full items-center gap-x-5">
          <div class="w-[82px] h-[82px] flex-0">
            <img
                    src="https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-ljhy12voht6q4c.webp"
                    alt=""
                    class="w-full h-full object-cover"
            />
          </div>
          <div class="flex-1">
            <a href="#">
              <h4
                      class="overflow-hidden text-[16px] leading-[22px] mt-[0] mx-[0] mb-[5px] max-h-[48px] text-justify"
                      style="
                      display: -webkit-box;
                      -webkit-line-clamp: 2;
                      -webkit-box-orient: vertical;
                      text-overflow: ellipsis;
                      word-break: break-word;
                      overflow: hidden;
                    "
              >
                Lorem ipsum dolor sit amet consectetur adipisicing elit. In
                hic cumque officiis odio temporibus qui explicabo, voluptate
                nostrum, vero assumenda dolor autem eligendi perferendis
                fugit esse consequatur tempore dolore. Voluptate.
              </h4>
            </a>
            <p class="text-[rgba(0,0,0,.54)]">Phân loại:</p>
            <p>Số lượng: <span>x3</span></p>
          </div>
          <div>
                <span
                        class="text-[#000] ml-[0] mr-[4px] my-[0] opacity-[.26] overflow-hidden [text-decoration-line:line-through] overflow-ellipsis"
                >₫32.000</span
                >
            <span class="text-[18px] fond-medium text-[#26aa99]"
            >₫22.950</span
            >
          </div>
        </div>
        <div class="flex flex-col items-end w-full mt-2">
          <div>
            <h3 class="text-[16px] text-black-500 font-medium">
              Thành tiền:
              <span class="text-xl text-[#26aa99]">₫68.850</span>
            </h3>
          </div>
          <div class="mt-5">
            <button
                    class="px-4 py-2 bg-[#26aa99] rounded text-white mr-2 hover:bg-[#158d7d] transition duration-300"
            >
              Đã nhận được hàng
            </button>

            <button
                    class="px-4 py-2 rounded text-black border-1 border-solid border-gray-200 hover:bg-gray-100 transition duration-300"
                    onclick="window.location.href='return-order';"
            >
              Yêu cầu trả/Hoàn tiền
            </button>
          </div>
        </div>
      </div>
      <div
              data-tab="cancelled"
              class="flex flex-wrap mb-5 p-2 bg-white rounded fade-in"
      >
        <div
                class="flex-1 items-center border-b-[1px] mb-5 border-solid border-[rgba(0,0,0,0.12)] flex ml-[0] my-[0] text-right basis-full justify-end px-4 py-2"
        >
          <a href="order-detail" class="items-center inline-flex m-0">
                <span class="text-[#ee4d2d] no-underline align-middle">
                  Đã hủy
                </span>
          </a>
        </div>
        <div class="flex basis-full items-center gap-x-5">
          <div class="w-[82px] h-[82px] flex-0">
            <img
                    src="https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-ljhy12voht6q4c.webp"
                    alt=""
                    class="w-full h-full object-cover"
            />
          </div>
          <div class="flex-1">
            <a href="#">
              <h4
                      class="overflow-hidden text-[16px] leading-[22px] mt-[0] mx-[0] mb-[5px] max-h-[48px] text-justify"
                      style="
                      display: -webkit-box;
                      -webkit-line-clamp: 2;
                      -webkit-box-orient: vertical;
                      text-overflow: ellipsis;
                      word-break: break-word;
                      overflow: hidden;
                    "
              >
                Lorem ipsum dolor sit amet consectetur adipisicing elit. In
                hic cumque officiis odio temporibus qui explicabo, voluptate
                nostrum, vero assumenda dolor autem eligendi perferendis
                fugit esse consequatur tempore dolore. Voluptate.
              </h4>
            </a>
            <p class="text-[rgba(0,0,0,.54)]">Phân loại:</p>
            <p>Số lượng: <span>x3</span></p>
          </div>
          <div>
                <span
                        class="text-[#000] ml-[0] mr-[4px] my-[0] opacity-[.26] overflow-hidden [text-decoration-line:line-through] overflow-ellipsis"
                >₫32.000</span
                >
            <span class="text-[18px] fond-medium text-[#26aa99]"
            >₫22.950</span
            >
          </div>
        </div>
        <div class="flex flex-col items-end w-full mt-2">
          <div>
            <h3 class="text-[16px] text-black-500 font-medium">
              Thành tiền:
              <span class="text-xl text-[#26aa99]">₫68.850</span>
            </h3>
          </div>
          <div class="mt-5">
            <button
                    class="px-4 py-2 bg-[#26aa99] rounded text-white mr-2 hover:bg-[#158d7d] transition duration-300"
            >
              Mua lại
            </button>
            <button
                    class="px-4 py-2 rounded text-black border-1 border-solid border-gray-200 hover:bg-gray-100 transition duration-300"
            >
              Liên hệ người bán
            </button>
          </div>
        </div>
      </div>
      <div
              data-tab="confirming"
              class="flex flex-wrap mb-5 p-2 bg-white rounded fade-in"
      >
        <div
                class="flex-1 items-center border-b-[1px] mb-5 border-solid border-[rgba(0,0,0,0.12)] flex ml-[0] my-[0] text-right basis-full justify-end px-4 py-2"
        >
          <a href="order-detail" class="items-center inline-flex m-0">
                <span class="text-[#ee4d2d] no-underline align-middle">
                  Chờ xác nhận
                </span>
          </a>
        </div>
        <div class="flex basis-full items-center gap-x-5">
          <div class="w-[82px] h-[82px] flex-0">
            <img
                    src="https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-ljhy12voht6q4c.webp"
                    alt=""
                    class="w-full h-full object-cover"
            />
          </div>
          <div class="flex-1">
            <a href="#">
              <h4
                      class="overflow-hidden text-[16px] leading-[22px] mt-[0] mx-[0] mb-[5px] max-h-[48px] text-justify"
                      style="
                      display: -webkit-box;
                      -webkit-line-clamp: 2;
                      -webkit-box-orient: vertical;
                      text-overflow: ellipsis;
                      word-break: break-word;
                      overflow: hidden;
                    "
              >
                Lorem ipsum dolor sit amet consectetur adipisicing elit. In
                hic cumque officiis odio temporibus qui explicabo, voluptate
                nostrum, vero assumenda dolor autem eligendi perferendis
                fugit esse consequatur tempore dolore. Voluptate.
              </h4>
            </a>
            <p class="text-[rgba(0,0,0,.54)]">Phân loại:</p>
            <p>Số lượng: <span>x3</span></p>
          </div>
          <div>
                <span
                        class="text-[#000] ml-[0] mr-[4px] my-[0] opacity-[.26] overflow-hidden [text-decoration-line:line-through] overflow-ellipsis"
                >₫32.000</span
                >
            <span class="text-[18px] fond-medium text-[#26aa99]"
            >₫22.950</span
            >
          </div>
        </div>
        <div class="flex flex-col items-end w-full mt-2">
          <div>
            <h3 class="text-[16px] text-black-500 font-medium">
              Thành tiền:
              <span class="text-xl text-[#26aa99]">₫68.850</span>
            </h3>
          </div>
          <div class="mt-5">
            <button
                    class="px-4 py-2 bg-[#26aa99] rounded text-white mr-2 hover:bg-[#158d7d] transition duration-300 select-none pointer-events-none opacity-50"
            >
              Hủy
            </button>
            <button
                    class="px-4 py-2 rounded text-black border-1 border-solid border-gray-200 hover:bg-gray-100 transition duration-300"
            >
              Liên hệ người bán
            </button>
          </div>
        </div>
      </div>
      <div
              data-tab="returning"
              class="flex flex-wrap mb-5 p-2 bg-white rounded fade-in"
      >
        <div
                class="flex-1 items-center border-b-[1px] mb-5 border-solid border-[rgba(0,0,0,0.12)] flex ml-[0] my-[0] text-right basis-full justify-end px-4 py-2"
        >
          <a href="order-detail" class="items-center inline-flex m-0">
                <span class="text-[#ee4d2d] no-underline align-middle">
                  Hoàn trả
                </span>
          </a>
        </div>
        <div class="flex basis-full items-center gap-x-5">
          <div class="w-[82px] h-[82px] flex-0">
            <img
                    src="https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-ljhy12voht6q4c.webp"
                    alt=""
                    class="w-full h-full object-cover"
            />
          </div>
          <div class="flex-1">
            <a href="#">
              <h4
                      class="overflow-hidden text-[16px] leading-[22px] mt-[0] mx-[0] mb-[5px] max-h-[48px] text-justify"
                      style="
                      display: -webkit-box;
                      -webkit-line-clamp: 2;
                      -webkit-box-orient: vertical;
                      text-overflow: ellipsis;
                      word-break: break-word;
                      overflow: hidden;
                    "
              >
                Lorem ipsum dolor sit amet consectetur adipisicing elit. In
                hic cumque officiis odio temporibus qui explicabo, voluptate
                nostrum, vero assumenda dolor autem eligendi perferendis
                fugit esse consequatur tempore dolore. Voluptate.
              </h4>
            </a>
            <p class="text-[rgba(0,0,0,.54)]">Phân loại:</p>
            <p>Số lượng: <span>x3</span></p>
          </div>
          <div>
                <span
                        class="text-[#000] ml-[0] mr-[4px] my-[0] opacity-[.26] overflow-hidden [text-decoration-line:line-through] overflow-ellipsis"
                >₫32.000</span
                >
            <span class="text-[18px] fond-medium text-[#26aa99]"
            >₫22.950</span
            >
          </div>
        </div>
        <div class="flex flex-col items-end w-full mt-2">
          <div>
            <h3 class="text-[16px] text-black-500 font-medium">
              Thành tiền:
              <span class="text-xl text-[#26aa99]">₫68.850</span>
            </h3>
          </div>
          <div class="mt-5">
            <button
                    class="px-4 py-2 bg-[#26aa99] rounded text-white mr-2 hover:bg-[#158d7d] transition duration-300 select-none pointer-events-none opacity-50"
            >
              Đang hoàn trả
            </button>
            <button
                    class="px-4 py-2 rounded text-black border-1 border-solid border-gray-200 hover:bg-gray-100 transition duration-300"
            >
              Liên hệ người bán
            </button>
          </div>
        </div>
      </div>
      <div
              data-tab="delivering"
              class="flex flex-wrap mb-5 p-2 bg-white rounded fade-in"
      >
        <div
                class="flex-1 items-center border-b-[1px] mb-5 border-solid border-[rgba(0,0,0,0.12)] flex ml-[0] my-[0] text-right basis-full justify-end px-4 py-2"
        >
          <a href="order-detail" class="items-center inline-flex m-0">
                <span class="text-[#ee4d2d] no-underline align-middle">
                  Đang vận chuyển
                </span>
          </a>
        </div>
        <div class="flex basis-full items-center gap-x-5">
          <div class="w-[82px] h-[82px] flex-0">
            <img
                    src="https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-ljhy12voht6q4c.webp"
                    alt=""
                    class="w-full h-full object-cover"
            />
          </div>
          <div class="flex-1">
            <a href="#">
              <h4
                      class="overflow-hidden text-[16px] leading-[22px] mt-[0] mx-[0] mb-[5px] max-h-[48px] text-justify"
                      style="
                      display: -webkit-box;
                      -webkit-line-clamp: 2;
                      -webkit-box-orient: vertical;
                      text-overflow: ellipsis;
                      word-break: break-word;
                      overflow: hidden;
                    "
              >
                Lorem ipsum dolor sit amet consectetur adipisicing elit. In
                hic cumque officiis odio temporibus qui explicabo, voluptate
                nostrum, vero assumenda dolor autem eligendi perferendis
                fugit esse consequatur tempore dolore. Voluptate.
              </h4>
            </a>
            <p class="text-[rgba(0,0,0,.54)]">Phân loại:</p>
            <p>Số lượng: <span>x3</span></p>
          </div>
          <div>
                <span
                        class="text-[#000] ml-[0] mr-[4px] my-[0] opacity-[.26] overflow-hidden [text-decoration-line:line-through] overflow-ellipsis"
                >₫32.000</span
                >
            <span class="text-[18px] fond-medium text-[#26aa99]"
            >₫22.950</span
            >
          </div>
        </div>
        <div class="flex flex-col items-end w-full mt-2">
          <div>
            <h3 class="text-[16px] text-black-500 font-medium">
              Thành tiền:
              <span class="text-xl text-[#26aa99]">₫68.850</span>
            </h3>
          </div>
          <div class="mt-5">
            <button
                    class="px-4 py-2 bg-[#26aa99] rounded text-white mr-2 hover:bg-[#158d7d] transition duration-300 select-none pointer-events-none opacity-50"
            >
              Đang giao
            </button>
            <button
                    class="px-4 py-2 rounded text-black border-1 border-solid border-gray-200 hover:bg-gray-100 transition duration-300"
            >
              Liên hệ người bán
            </button>
          </div>
        </div>
      </div>
    </div>

    <div class="flex justify-center">
      <nav aria-label="Page navigation example">
        <ul class="pagination">
          <li class="page-item">
            <a class="page-link text-black" href="#" aria-label="Previous">
              <span aria-hidden="true">&lt;</span>
            </a>
          </li>
          <li class="page-item">
            <a class="page-link text-black" href="#">1</a>
          </li>
          <li class="page-item">
            <a class="page-link text-black" href="#">2</a>
          </li>
          <li class="page-item">
            <a class="page-link text-black" href="#">3</a>
          </li>
          <li class="page-item">
            <a class="page-link text-black" href="#" aria-label="Next">
              <span aria-hidden="true">&gt;</span>
            </a>
          </li>
        </ul>
      </nav>
    </div>
  </div>
</div>
