<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/scss/style.css">
<script defer src="${pageContext.request.contextPath}/assets/customer/js/order-list.js"></script>

<section class="section-return py-5 bg-light">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div style="display: flex; justify-content: space-between; align-items: center; padding: 10px 20px; background-color: white; border-bottom: 1px solid rgba(0, 0, 0, 0.1);">
                    <a href="javascript:history.back()" style="text-decoration: none;">&lt; TRỞ LẠI</a>
                    <a class="text-sm font-bold cursor-pointer
                          ${orderDetail.status == 'COMPLETE_DELIVERY' ? 'text-green-500' :
                           orderDetail.status == 'CANCELED' ? 'text-red-500' : 'text-yellow-500'}">
                        ${orderDetail.status != null ? orderDetail.status.getDescription() : 'Trạng thái không xác định'}
                    </a>
                </div>



                <div class="mt-[50px] px-[40px] py-[24px]">
                    <div class="flex justify-between items-start relative flex-nowrap">
                        <div
                                class="cursor-default text-center select-none w-[140px] z-[1]"
                                aria-label="Đơn hàng đã đặt, , 22:22 24-09-2024"
                                tabindex="0"
                        >
                            <div
                                    class="flex flex-col items-center justify-center bg-white border-solid border-[4px] border-[#2dc258] rounded-full box-border text-[#2dc258] text-3xl h-[60px] w-[60px] m-auto relative"
                            >
                                <svg
                                        enable-background="new 0 0 32 32"
                                        viewBox="0 0 32 32"
                                        x="0"
                                        y="0"
                                        class="stroke-current inline-block h-[1em] w-[1em] fill-current relative"
                                >
                                    <g>
                                        <path
                                                d="m5 3.4v23.7c0 .4.3.7.7.7.2 0 .3 0 .3-.2.5-.4 1-.5 1.7-.5.9 0 1.7.4 2.2 1.1.2.2.3.4.5.4s.3-.2.5-.4c.5-.7 1.4-1.1 2.2-1.1s1.7.4 2.2 1.1c.2.2.3.4.5.4s.3-.2.5-.4c.5-.7 1.4-1.1 2.2-1.1.9 0 1.7.4 2.2 1.1.2.2.3.4.5.4s.3-.2.5-.4c.5-.7 1.4-1.1 2.2-1.1.7 0 1.2.2 1.7.5.2.2.3.2.3.2.3 0 .7-.4.7-.7v-23.7z"
                                                fill="none"
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></path>
                                        <g>
                                            <line
                                                    fill="none"
                                                    stroke-linecap="round"
                                                    stroke-miterlimit="10"
                                                    stroke-width="3"
                                                    x1="10"
                                                    x2="22"
                                                    y1="11.5"
                                                    y2="11.5"
                                            ></line>
                                            <line
                                                    fill="none"
                                                    stroke-linecap="round"
                                                    stroke-miterlimit="10"
                                                    stroke-width="3"
                                                    x1="10"
                                                    x2="22"
                                                    y1="18.5"
                                                    y2="18.5"
                                            ></line>
                                        </g>
                                    </g>
                                </svg>
                            </div>
                            <div
                                    class="text-[rgba(0,0,0,0.8)] text-sm leading-5 capitalize mt-5 mb-1 mx-0"
                            >
                                Đơn hàng đã đặt
                            </div>
                            <div class="text-[rgba(0,0,0,0.26)] text-xs h-3.5">
                                22:22 24-09-2024
                            </div>
                        </div>
                        <div
                                class="cursor-default text-center select-none w-[140px] z-[1]"
                                aria-label="Đơn hàng đã thanh toán (₫69.000), , 22:22 24-09-2024"
                                tabindex="0"
                        >
                            <div
                                    class="flex flex-col items-center justify-center bg-white border-solid border-[4px] border-[#2dc258] rounded-full box-border text-[#2dc258] text-3xl h-[60px] w-[60px] m-auto relative"
                            >
                                <svg
                                        enable-background="new 0 0 32 32"
                                        viewBox="0 0 32 32"
                                        x="0"
                                        y="0"
                                        class="stroke-current inline-block h-[1em] w-[1em] fill-current relative"
                                >
                                    <g>
                                        <path
                                                clip-rule="evenodd"
                                                d="m24 22h-21c-.5 0-1-.5-1-1v-15c0-.6.5-1 1-1h21c .5 0 1 .4 1 1v15c0 .5-.5 1-1 1z"
                                                fill="none"
                                                fill-rule="evenodd"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></path>
                                        <path
                                                clip-rule="evenodd"
                                                d="m24.8 10h4.2c.5 0 1 .4 1 1v15c0 .5-.5 1-1 1h-21c-.6 0-1-.4-1-1v-4"
                                                fill="none"
                                                fill-rule="evenodd"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></path>
                                        <path
                                                d="m12.9 17.2c-.7-.1-1.5-.4-2.1-.9l.8-1.2c.6.5 1.1.7 1.7.7.7 0 1-.3 1-.8 0-1.2-3.2-1.2-3.2-3.4 0-1.2.7-2 1.8-2.2v-1.3h1.2v1.2c.8.1 1.3.5 1.8 1l-.9 1c-.4-.4-.8-.6-1.3-.6-.6 0-.9.2-.9.8 0 1.1 3.2 1 3.2 3.3 0 1.2-.6 2-1.9 2.3v1.2h-1.2z"
                                                stroke="none"
                                        ></path>
                                    </g>
                                </svg>
                            </div>
                            <div
                                    class="text-[rgba(0,0,0,0.8)] text-sm leading-5 capitalize mt-5 mb-1 mx-0"
                            >
                                Đơn hàng đã thanh toán (₫69.000)
                            </div>
                            <div
                                    class="text-[rgba(0,0,0,0.26)] text-xs h-3.5"
                            >
                                22:22 24-09-2024
                            </div>
                        </div>
                        <div
                                class="cursor-default text-center select-none w-[140px] z-[1]"
                                aria-label="Đã giao cho ĐVVC, , 08:48 25-09-2024"
                                tabindex="0"
                        >
                            <div
                                    class="flex flex-col items-center justify-center bg-white border-solid border-[4px] border-[#2dc258] rounded-full box-border text-[#2dc258] text-3xl h-[60px] w-[60px] m-auto relative"
                            >
                                <svg
                                        enable-background="new 0 0 32 32"
                                        viewBox="0 0 32 32"
                                        x="0"
                                        y="0"
                                        class="stroke-current inline-block h-[1em] w-[1em] fill-current relative"
                                >
                                    <g>
                                        <line
                                                fill="none"
                                                stroke-linejoin="round"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                                x1="18.1"
                                                x2="9.6"
                                                y1="20.5"
                                                y2="20.5"
                                        ></line>
                                        <circle
                                                cx="7.5"
                                                cy="23.5"
                                                fill="none"
                                                r="4"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></circle>
                                        <circle
                                                cx="20.5"
                                                cy="23.5"
                                                fill="none"
                                                r="4"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></circle>
                                        <line
                                                fill="none"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                                x1="19.7"
                                                x2="30"
                                                y1="15.5"
                                                y2="15.5"
                                        ></line>
                                        <polyline
                                                fill="none"
                                                points="4.6 20.5 1.5 20.5 1.5 4.5 20.5 4.5 20.5 18.4"
                                                stroke-linejoin="round"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></polyline>
                                        <polyline
                                                fill="none"
                                                points="20.5 9 29.5 9 30.5 22 24.7 22"
                                                stroke-linejoin="round"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></polyline>
                                    </g>
                                </svg>
                            </div>
                            <div
                                    class="text-[rgba(0,0,0,0.8)] text-sm leading-5 capitalize mt-5 mb-1 mx-0"
                            >
                                Đã giao cho ĐVVC
                            </div>
                            <div
                                    class="text-[rgba(0,0,0,0.26)] text-xs h-3.5"
                            >
                                08:48 25-09-2024
                            </div>
                        </div>
                        <div
                                class="cursor-default text-center select-none w-[140px] z-[1]"
                                aria-label="Đã nhận được hàng, , 18:57 26-09-2024"
                                tabindex="0"
                        >
                            <div
                                    class="flex flex-col items-center justify-center bg-white border-solid border-[4px] border-[#2dc258] rounded-full box-border text-[#2dc258] text-3xl h-[60px] w-[60px] m-auto relative"
                            >
                                <svg
                                        enable-background="new 0 0 32 32"
                                        viewBox="0 0 32 32"
                                        x="0"
                                        y="0"
                                        class="stroke-current inline-block h-[1em] w-[1em] fill-current relative"
                                >
                                    <g>
                                        <polygon
                                                fill="none"
                                                points="2 28 2 19.2 10.6 19.2 11.7 21.5 19.8 21.5 20.9 19.2 30 19.1 30 28"
                                                stroke-linejoin="round"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></polygon>
                                        <polyline
                                                fill="none"
                                                points="21 8 27 8 30 19.1"
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></polyline>
                                        <polyline
                                                fill="none"
                                                points="2 19.2 5 8 11 8"
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                        ></polyline>
                                        <line
                                                fill="none"
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                                stroke-miterlimit="10"
                                                stroke-width="3"
                                                x1="16"
                                                x2="16"
                                                y1="4"
                                                y2="14"
                                        ></line>
                                        <path
                                                d="m20.1 13.4-3.6 3.6c-.3.3-.7.3-.9 0l-3.6-3.6c-.4-.4-.1-1.1.5-1.1h7.2c.5 0 .8.7.4 1.1z"
                                                stroke="none"
                                        ></path>
                                    </g>
                                </svg>
                            </div>
                            <div
                                    class="text-[rgba(0,0,0,0.8)] text-sm leading-5 capitalize mt-5 mb-1 mx-0"
                            >
                                Đã nhận được hàng
                            </div>
                            <div
                                    class="text-[rgba(0,0,0,0.26)] text-xs h-3.5"
                            >
                                18:57 26-09-2024
                            </div>
                        </div>
                        <div
                                class="cursor-default text-center select-none w-[140px] z-[1]"
                                aria-label="đánh giá: "
                                tabindex="0"
                        >
                            <div class="bg-[#2dc258] fill-[#2dc258] border-[#2dc258] items-center box-border text-[#e0e0e0] flex flex-col text-3xl h-[60px] justify-center relative w-[60px] m-auto rounded-[50%] border-[4px] border-solid">
                                <svg
                                        enable-background="new 0 0 32 32"
                                        viewBox="0 0 32 32"
                                        x="0"
                                        y="0"
                                        class="stroke-current inline-block h-[1em] w-[1em] fill-current relative"
                                >
                                    <polygon
                                            fill="none"
                                            points="16 3.2 20.2 11.9 29.5 13 22.2 19 24.3 28.8 16 23.8 7.7 28.8 9.8 19 2.5 13 11.8 11.9"
                                            stroke-linecap="round"
                                            stroke-linejoin="round"
                                            stroke-miterlimit="10"
                                            stroke-width="3"
                                    ></polygon>
                                </svg>
                            </div>
                            <div class="text-[rgba(0,0,0,0.8)] text-sm leading-5 capitalize mt-5 mb-1 mx-0">đánh giá</div>
                            <div class="stepper__step-date"></div>
                        </div>
                        <div class="h-1 absolute w-full top-[29px]">
                            <div
                                    class="box-border h-full absolute w-[calc(100%_-_140px)] mx-[70px] my-0"
                                    style="background: rgb(45, 194, 88)"
                            ></div>
                            <div
                                    class="box-border h-full absolute w-[calc(100%_-_140px)] mx-[70px] my-0"
                                    style="width: calc(100% - 140px); background: rgb(45, 194, 88)"
                            ></div>

                        </div>

                    </div>

                </div>
                <!-- Phần địa chỉ vận chuyển -->
                <div class="address-container mt-5 px-4 py-3" style="background-color: white; border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 8px;">
                    <div class="d-flex justify-content-between">
                        <h5 style="margin-bottom: 10px;">Địa chỉ vận chuyển</h5>
                    </div>
                    <p class="top-container" style="margin: 0; margin-bottom: 10px;">${orderDetail.shipping.shippingUnit}</p>
                    <p style="margin: 0;">${orderDetail.shipping.address}</p>
                </div>

            </div>
        </div>

    </div>

</section>


<section class="section-return py-5 bg-light">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">

                <!-- Form Sản phẩm -->
                <div class="product-return-form p-4 bg-white shadow rounded mb-4">

                    <c:forEach var="orderProduct" items="${orderDetail.products}" varStatus="loopStatus">
                        <div class="${loopStatus.index > 0 ? 'my-hidden' : ''} flex items-center mb-3">
                            <div class="flex items-center book-item w-full">
                                <!-- Hình ảnh sản phẩm -->
                                <div class="flex-shrink-0">
                                    <img src="${pageContext.request.contextPath}/${orderProduct.imagePath}" alt="${orderProduct.title}" style="width: 120px; height: auto;">
                                </div>

                                <!-- Thông tin sản phẩm -->
                                <div class="book-info flex justify-between items-center w-full pl-4">
                                    <!-- Tên sản phẩm -->
                                    <div>
                                        <h4 style="margin-bottom: 20px; font-size: 24px;">${orderProduct.title}</h4>
                                        <p>${orderDetail.publisherName}</p>
                                    </div>

                                    <!-- Thông tin giá bán và số lượng nằm bên phải -->
                                    <div class="text-right">
                                        <p>₫${orderProduct.sellingPrice}</p>
                                        <p>x${orderProduct.quantity}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <!-- Nút Xem thêm/Thu gọn -->
                    <c:if test="${fn:length(orderDetail.products) > 1}">
                        <div class="status-container flex justify-start w-full cursor-pointer text-[#26aa99]" onclick="toggleItems('${order.id}')">
                            <span id="toggle-text-${orderDetail.id}">Xem thêm ▼</span>
                        </div>
                    </c:if>

                    <!-- Tổng tiền -->
                    <div class="order-summary top-container">
                        <div class="summary-item">
                            <div class="label">Tổng tiền hàng:</div>
                            <div class="amount">${orderDetail.totalPrice}₫</div>
                        </div>
                        <div class="summary-item">
                            <div class="label">Phí vận chuyển:</div>
                            <div class="amount">${orderDetail.shipping.shippingFee}₫</div>
                        </div>
                        <div class="summary-item">
                            <div class="label">Giảm giá:</div>
                            <div class="amount">-${orderDetail.totalDiscount}₫</div>
                        </div>
                        <div class="summary-item top-container "style="margin-left: 500px;">
                            <div class="label" style="font-size: 20px; font-weight: bold;">Thành tiền:</div>
                            <div class="amount" style="font-size: 20px; font-weight: bold;">${orderDetail.finalPrice}₫</div>
                        </div>
                    </div>




                </div>



            </div>

        </div>
    </div>
    </div>
</section>
