<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta
            name="keywords"
            content="ecommerce, market, shop, mart, cart, deal, multipurpose, marketplace"
    />
    <meta name="description" content="Biblio."/>

    <title>
        <c:choose>
            <c:when test="${breadcumb != null}">
                ${breadcumb}
            </c:when>
            <c:otherwise>
                Biblio
            </c:otherwise>
        </c:choose>
    </title>

    <!-- App favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/customer/img/logo/collapse-logo.png"/>

    <!-- Icon CSS -->
    <link
            rel="stylesheet"
            href="${pageContext.request.contextPath}/assets/customer/css/vendor/materialdesignicons.min.css"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/css/vendor/remixicon.css"/>

    <!-- Vendor -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/css/vendor/animate.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/css/vendor/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/css/vendor/aos.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/css/vendor/range-slider.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/css/vendor/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/css/vendor/jquery.slick.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/css/vendor/slick-theme.css"/>

    <!-- Main CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/customer/css/style.css?v=1"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
</head>

<body>

<div id="cr-overlay">
    <span class="loader"></span>
</div>

<div class="cr-sidebar-overlay"></div>
<div id="cr_mobile_menu" class="cr-side-cart cr-mobile-menu">
    <div class="cr-menu-title">
        <span class="menu-title">My Menu</span>
        <button type="button" class="cr-close">×</button>
    </div>
    <div class="cr-menu-inner">
        <div class="cr-menu-content">
            <ul>
                <li class="dropdown drop-list">
                    <a href="index.html">Home</a>
                </li>
                <li class="dropdown drop-list">
                    <span class="menu-toggle"></span>
                    <a href="javascript:void(0)" class="dropdown-list">Category</a>
                    <ul class="sub-menu">
                        <li><a href="shop-left-sidebar.html">Shop Left sidebar</a></li>
                        <li><a href="shop-right-sidebar.html">Shop Right sidebar</a></li>
                        <li><a href="shop-full-width.html">Full Width</a></li>
                    </ul>
                </li>
                <li class="dropdown drop-list">
                    <span class="menu-toggle"></span>
                    <a href="javascript:void(0)" class="dropdown-list">product</a>
                    <ul class="sub-menu">
                        <li><a href="product-left-sidebar.html">product Left sidebar</a></li>
                        <li><a href="product-right-sidebar.html">product Right sidebar</a></li>
                        <li><a href="product-full-width.html">Product Full Width </a></li>
                    </ul>
                </li>
                <li class="dropdown drop-list">
                    <span class="menu-toggle"></span>
                    <a href="javascript:void(0)" class="dropdown-list">Pages</a>
                    <ul class="sub-menu">
                        <li><a href="about.html">About Us</a></li>
                        <li><a href="contact-us.html">Contact Us</a></li>
                        <li><a href="cart.html">Cart</a></li>
                        <li><a href="checkout.html">Checkout</a></li>
                        <li><a href="track-order.html">Track Order</a></li>
                        <li><a href="wishlist.html">Wishlist</a></li>
                        <li><a href="faq.html">Faq</a></li>
                        <li><a href="login.html">Login</a></li>
                        <li><a href="register.html">Register</a></li>
                        <li><a href="policy.html">Policy</a></li>
                    </ul>
                </li>
                <li class="dropdown drop-list">
                    <span class="menu-toggle"></span>
                    <a href="javascript:void(0)" class="dropdown-list">Blog</a>
                    <ul class="sub-menu">
                        <li><a href="blog-left-sidebar.html">Left Sidebar</a></li>
                        <li><a href="blog-right-sidebar.html">Right Sidebar</a></li>
                        <li><a href="blog-full-width.html">Full Width</a></li>
                        <li><a href="blog-detail-left-sidebar.html">Detail Left Sidebar</a></li>
                        <li><a href="blog-detail-right-sidebar.html">Detail Right Sidebar</a></li>
                        <li><a href="blog-detail-full-width.html">Detail Full Width</a></li>
                    </ul>
                </li>
                <li class="dropdown drop-list">
                    <span class="menu-toggle"></span>
                    <a href="javascript:void(0)">Element</a>
                    <ul class="sub-menu">
                        <li><a href="elements-products.html">Products</a></li>
                        <li><a href="elements-typography.html">Typography</a></li>
                        <li><a href="elements-buttons.html">Buttons</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

<%@include file="/commons/customer/header.jsp" %>

<!-- Breadcrumb -->
<section class="section-breadcrumb">
    <div class="cr-breadcrumb-image">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cr-breadcrumb-title">
                        <span>
                            <a href="home">Trang chủ</a>
                            <c:if test="${breadcumb != null}">
                                / ${breadcumb}
                            </c:if>
                        </span>
                        <h2>${breadcumb}</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<decorator:body/>
<%@include file="/commons/customer/footer.jsp" %>

<a href="#Top" class="back-to-top result-placeholder">
    <i class="ri-arrow-up-line"></i>
    <div class="back-to-top-wrap">
        <svg viewBox="-1 -1 102 102">
            <path d="M50,1 a49,49 0 0,1 0,98 a49,49 0 0,1 0,-98"/>
        </svg>
    </div>
</a>

<!-- Model -->
<c:forEach var="book" items="${books}">
    <div
            class="modal fade quickview-modal"
            id="quickview-${book.id}"
            aria-hidden="true"
            tabindex="-1"
    >
        <div class="modal-dialog modal-dialog-centered cr-modal-dialog">
            <div class="modal-content">
                <button
                        type="button"
                        class="cr-close-model btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                ></button>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-5 col-sm-12 col-xs-12">
                            <div class="zoom-image-hover modal-border-image">
                                <img
                                        src="${pageContext.request.contextPath}${book.imageUrl}"
                                        alt="product-tab-2"
                                        class="product-image"
                                />
                            </div>
                        </div>
                        <div class="col-md-7 col-sm-12 col-xs-12">
                            <div class="cr-size-and-weight-contain">
                                <h2 class="heading">
                                    ${book.title}
                                </h2>
                            </div>
                            <div class="cr-size-and-weight">
                                <div class="cr-review-star">
                                    <div class="cr-star">
                                        <c:forEach var="i" begin="1" end="5" step="1">
                                            <c:choose>
                                                <c:when test="${book.reviewRate >= i}">
                                                    <i class="ri-star-fill"></i>
                                                </c:when>
                                                <c:when test="${book.reviewRate > i - 1 && book.reviewRate < i}">
                                                    <i class="ri-star-half-line"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="ri-star-line"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </div>
                                    <p>( ${book.numberOfReviews} Reviews)</p>
                                </div>
                                <div class="cr-product-price">
                                    <span class="new-price">${book.sellingPrice}</span>
    <%--                                <span class="old-price">$123.25</span>--%>
                                </div>
                                <div class="cr-size-weight">
                                    <h5><span>Tình trạng</span> :</h5>
                                    <div class="cr-kg">
                                        <ul>
                                            <li class="active-color">${book.condition}</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="cr-add-card">
                                    <div class="cr-qty-main">
                                        <input
                                                type="text"
                                                placeholder="."
                                                value="1"
                                                minlength="1"
                                                maxlength="20"
                                                class="quantity"
                                        />
                                        <button type="button" class="plus">+</button>
                                        <button type="button" class="minus">-</button>
                                    </div>
                                    <div class="cr-add-button">
                                        <button type="button" class="cr-button cr-btn-secondary cr-shopping-bag">
                                            Thêm vào giỏ hàng
                                        </button>
                                    </div>
                                    <div class="cr-buy-button">
                                        <button type="button" class="cr-button">
                                            Mua ngay
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<!-- Cart -->
<div class="cr-cart-overlay"></div>
<div class="cr-cart-view">
    <div class="cr-cart-inner">
        <div class="cr-cart-top">
            <div class="cr-cart-title">
                <h6>Giỏ hàng của tôi</h6>
                <button type="button" class="close-cart">×</button>
            </div>
            <ul class="crcart-pro-items">
                <c:forEach var="cartItem" items="${cart.cartItems}">
                    <li>
                        <a href="${pageContext.request.contextPath}/book?id=${cartItem.bookId}" class="crside_pro_img"
                        ><img src="${pageContext.request.contextPath}${cartItem.imageUrl}" alt="${cartItem.title}"
                        /></a>
                        <div class="cr-pro-content">
                            <a href="product-left-sidebar.html" class="cart_pro_title"
                            >${cartItem.title}</a
                            >
                            <span class="cart-price"><span class="price-value">${cartItem.sellingPrice}</span> x ${cartItem.quantity}</span>
                            <div class="cr-cart-qty">
                                <div class="cart-qty-plus-minus">
                                    <button type="button" class="minus">-</button>
                                    <input
                                            type="text"
                                            placeholder="."
                                            value="1"
                                            minlength="1"
                                            maxlength="20"
                                            class="quantity"
                                    />
                                    <button type="button" class="plus">+</button>
                                </div>
                            </div>
                            <a href="${pageContext.request.contextPath}/book?id=${cartItem.bookId}" class="remove">×</a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="cr-cart-bottom">
            <div class="cart-sub-total">
                <table class="table cart-table">
                    <tbody>
                    <tr>
                        <td class="text-left">Tiền sách:</td>
                        <td class="text-right">$300.00</td>
                    </tr>
                    <tr>
                        <td class="text-left">VAT (20%) :</td>
                        <td class="text-right">$60.00</td>
                    </tr>
                    <tr>
                        <td class="text-left">Thành tiền:</td>
                        <td class="text-right primary-color">$360.00</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="cart_btn">
                <a href="cart.html" class="cr-button">Xem giỏ hàng</a>
                <a href="checkout.html" class="cr-btn-secondary">Thanh toán</a>
            </div>
        </div>
    </div>
</div>

<div class="cr-tool-overlay"></div>
<div class="cr-tool">
    <div class="cr-tool-btn">
        <a href="javascript:void(0)" class="btn-cr-tool result-placeholder">
            <i class="ri-settings-line"></i>
        </a>
        <div class="color-variant">
            <div class="cr-bar-title">
                <h6>Tools</h6>
                <a href="javascript:void(0)" class="close-tools">
                    <i class="ri-close-line"></i>
                </a>
            </div>
            <div class="cr-tools-detail">
                <div class="heading">
                    <h2>Select Color</h2>
                </div>
                <ul class="cr-color">
                    <li class="colors c1 active-colors">
                    </li>
                    <li class="colors c2">
                    </li>
                    <li class="colors c3">
                    </li>
                    <li class="colors c4">
                    </li>
                    <li class="colors c5">
                    </li>
                    <li class="colors c6">
                    </li>
                    <li class="colors c7">
                    </li>
                    <li class="colors c8">
                    </li>
                    <li class="colors c9">
                    </li>
                    <li class="colors c10">
                    </li>
                </ul>
            </div>
            <div class="cr-tools-detail">
                <div class="heading">
                    <h2>Dark mode</h2>
                </div>
                <ul class="dark-mode">
                    <li class="dark">
                    </li>
                    <li class="white active-dark-mode">
                    </li>
                </ul>
            </div>
            <div class="cr-tools-detail">
                <div class="heading">
                    <h2>Backgrounds</h2>
                </div>
                <ul class="bg-panel">
                    <li class="bg-1">
                        <img src="${pageContext.request.contextPath}/assets/customer/img/shape/bg-shape-1.png"
                             alt="bg-shape-1">
                    </li>
                    <li class="bg-2">
                        <img src="${pageContext.request.contextPath}/assets/customer/img/shape/bg-shape-2.png"
                             alt="bg-shape-2">
                    </li>
                    <li class="bg-3">
                        <img src="${pageContext.request.contextPath}/assets/customer/img/shape/bg-shape-3.png"
                             alt="bg-shape-3">
                    </li>
                    <li class="bg-4">
                        <img src="${pageContext.request.contextPath}/assets/customer/img/shape/bg-shape-4.png"
                             alt="bg-shape-4">
                    </li>
                    <li class="bg-5">
                        <img src="${pageContext.request.contextPath}/assets/customer/img/shape/bg-shape-5.png"
                             alt="bg-shape-5">
                    </li>
                    <li class="bg-6 active-bg-panel">
                        <img src="${pageContext.request.contextPath}/assets/customer/img/shape/bg-shape-6.png"
                             alt="bg-shape-6">
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script> const contextPath = "<%=request.getContextPath() %>";</script>
<!-- Vendor Custom -->
<script src="${pageContext.request.contextPath}/assets/customer/js/vendor/jquery-3.6.4.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/customer/js/vendor/jquery.zoom.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/customer/js/vendor/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/customer/js/vendor/mixitup.min.js"></script>

<script src="${pageContext.request.contextPath}/assets/customer/js/vendor/range-slider.js"></script>
<script src="${pageContext.request.contextPath}/assets/customer/js/vendor/aos.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/customer/js/vendor/swiper-bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/customer/js/vendor/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/customer/js/vendor/tailwind.min.js"></script>

<!-- Main Custom -->
<script src="${pageContext.request.contextPath}/assets/customer/js/main.js?v=1"></script>
</body>
<div id="toast"></div>
</html>
