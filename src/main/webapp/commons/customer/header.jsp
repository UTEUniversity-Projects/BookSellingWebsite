<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="container-xl">
        <div class="row">
            <div class="col-lg-12">
                <div class="top-header">
                    <a href="home" class="cr-logo">
                        <img src="${pageContext.request.contextPath}/assets/customer/img/logo/biblio.png" alt="logo"
                             class="logo"/>
                    </a>
                    <form class="cr-search" action="search" method="GET" id="search-book">
                        <input
                                class="search-input"
                                type="text"
                                placeholder="Tìm kiếm sách..."
                                name="title"
                                value="${title}"
                        />
                        <button class="btn-search search-btn" type="submit">
                            <i class="ri-search-line"></i>
                        </button>
                        <span class="form-message text-[16px] text-red-500"></span>
                    </form>
                    <div class="cr-right-bar">
                        <ul class="my-0">
                            <li class="relative account">
                                <a
                                        class="nav-link dropdown-toggle cr-right-bar-item"
                                        href="javascript:void(0)"
                                >
                                    <i class="ri-user-3-line"></i>
                                    <span>Tài khoản</span>
                                </a>
                                <ul
                                        class="account-list transition-all duration-300 z-[9] absolute top-[35px] right-[20px] bg-white shadow-[rgba(149,_157,_165,_0.5)_0px_-3px_24px] rounded w-[200px]"
                                >
                                    <li
                                            class="hover:bg-gray-100 hover:text-black transition-all duration-200"
                                    >
                                        <a class="block px-5 py-2" href="register"
                                        >Đăng ký</a
                                        >
                                    </li>
                                    <li
                                            class="hover:bg-gray-100 hover:text-black transition-all duration-200"
                                    >
                                        <a class="block px-5 py-2" href="login"
                                        >Đăng nhập</a
                                        >
                                    </li>
                                    <li
                                            class="hover:bg-gray-100 hover:text-black transition-all duration-200"
                                    >
                                        <a class="block px-5 py-2" href="user-information"
                                        >Thông tin cá nhân</a
                                        >
                                    </li>
                                    <li
                                            class="hover:bg-gray-100 hover:text-black transition-all duration-200"
                                    >
                                        <a class="block px-5 py-2" href="order">
                                            <span>Đơn hàng của tôi</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <div class="notification">
                            <a href="notification" class="cr-right-bar-item relative">
                                <i class="ri-notification-3-line"></i>
                                <span>Thông báo</span>
                                <p class="notification-count absolute top-[-10px] left-[10px] rounded-full bg-black text-white inline-block w-4 h-4 text-[10px] text-center">
                                    0</p>
                            </a>
                            <div class="notification-content transition-all duration-300">
                                <div class="text-right px-4 py-2">
                                    <h3 class="notification-header text-gray-500">
                                        Thông báo mới nhận
                                    </h3>
                                </div>
                                <ul class="notification-body">
                                    <li class="px-4 py-2">
                                        <a href="notification-detail">
                                            <div class="flex gap-2 items-center">
                                                <div class="h-20 basis-1/5 aspect-square">
                                                    <img
                                                            class="w-full h-full aspect-square"
                                                            src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lwxpv4ydgxjt57.webp"
                                                            alt=""
                                                    />
                                                </div>
                                                <div class="flex-1">
                                                    <h4 class="w-full mb-1 font-medium">
                                                        Đơn hàng đang giao đến bạn
                                                    </h4>
                                                    <p
                                                            class="text-left leading-normal"
                                                            style="
                                          display: -webkit-box;
                                          -webkit-line-clamp: 3;
                                          -webkit-box-orient: vertical;
                                          text-overflow: ellipsis;
                                          word-break: break-word;
                                          overflow: hidden;
                                          "
                                                    >
                                                        Trận bán kết thứ 2 giữa T1 và Gen.G ở kỳ Chung Kết Thế Giới
                                                        (CKTG) 2024 đã kết thúc với chiến thắng 3-1 cho đương kim vô
                                                        địch T1. Không chỉ giành được chiếc vé đến với trận chung kết,
                                                        Faker và đồng đội đã chấm dứt mạch thua 11 trận đối đầu trước
                                                        Gen.G
                                                    </p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="px-4 py-2">
                                        <a href="notification-detail">
                                            <div class="flex gap-2 items-center">
                                                <div class="h-20 basis-1/5 aspect-square">
                                                    <img
                                                            class="w-full h-full aspect-square"
                                                            src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lwxpv4ydgxjt57.webp"
                                                            alt=""
                                                    />
                                                </div>
                                                <div class="flex-1">
                                                    <h4 class="w-full mb-1 font-medium">
                                                        Đơn hàng đang giao đến bạn
                                                    </h4>
                                                    <p
                                                            class="text-left leading-normal"
                                                            style="
                                          display: -webkit-box;
                                          -webkit-line-clamp: 3;
                                          -webkit-box-orient: vertical;
                                          text-overflow: ellipsis;
                                          word-break: break-word;
                                          overflow: hidden;
                                          "
                                                    >
                                                        Trận bán kết thứ 2 giữa T1 và Gen.G ở kỳ Chung Kết Thế Giới
                                                        (CKTG) 2024 đã kết thúc với chiến thắng 3-1 cho đương kim vô
                                                        địch T1. Không chỉ giành được chiếc vé đến với trận chung kết,
                                                        Faker và đồng đội đã chấm dứt mạch thua 11 trận đối đầu trước
                                                        Gen.G
                                                    </p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="px-4 py-2">
                                        <a href="notification-detail">
                                            <div class="flex gap-2 items-center">
                                                <div class="h-20 basis-1/5 aspect-square">
                                                    <img
                                                            class="w-full h-full aspect-square"
                                                            src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lwxpv4ydgxjt57.webp"
                                                            alt=""
                                                    />
                                                </div>
                                                <div class="flex-1">
                                                    <h4 class="w-full mb-1 font-medium">
                                                        Đơn hàng đang giao đến bạn
                                                    </h4>
                                                    <p
                                                            class="text-left leading-normal"
                                                            style="
                                          display: -webkit-box;
                                          -webkit-line-clamp: 3;
                                          -webkit-box-orient: vertical;
                                          text-overflow: ellipsis;
                                          word-break: break-word;
                                          overflow: hidden;
                                          "
                                                    >
                                                        Trận bán kết thứ 2 giữa T1 và Gen.G ở kỳ Chung Kết Thế Giới
                                                        (CKTG) 2024 đã kết thúc với chiến thắng 3-1 cho đương kim vô
                                                        địch T1. Không chỉ giành được chiếc vé đến với trận chung kết,
                                                        Faker và đồng đội đã chấm dứt mạch thua 11 trận đối đầu trước
                                                        Gen.G
                                                    </p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                                <a
                                        class="notification-view-all inline-block py-2"
                                        href="notifications"
                                >Xem tất cả</a
                                >
                            </div>
                        </div>
                        <a
                                href="javascript:void(0)"
                                class="cr-right-bar-item Shopping-toggle"
                        >
                            <i class="ri-shopping-cart-line"></i>
                            <span>Xem giỏ hàng</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
        integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="${pageContext.request.contextPath}/assets/customer/js/search-book.js" type="module"></script>
<script src="${pageContext.request.contextPath}/assets/customer/js/notifications.js" type="module"></script>