<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Cart -->
<section class="section-cart padding-t-100">
    <div class="container">
        <div class="row d-none">
            <div class="col-lg-12">
                <div
                        class="mb-30"
                        data-aos="fade-up"
                        data-aos-duration="2000"
                        data-aos-delay="400"
                >
                    <div class="cr-banner">
                        <h2>Giỏ hàng</h2>
                    </div>
                    <div class="cr-banner-sub-title">
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                            do eiusmod tempor incididunt ut labore lacus vel facilisis.
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div
                        class="cr-cart-content"
                        data-aos="fade-up"
                        data-aos-duration="2000"
                        data-aos-delay="400"
                >
                    <div class="row">
                        <form action="#">
                            <div class="cr-table-content">
                                <table>
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>Sách</th>
                                        <th>Giá</th>
                                        <th class="text-center">Số lượng</th>
                                        <th>Tổng</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td class="cr-cart-checkbox">
                                            <input type="checkbox" class="product-checkbox" />
                                        </td>
                                        <td class="cr-cart-name">
                                            <a href="javascript:void(0)">
                                                <img
                                                        src="${pageContext.request.contextPath}/customer/img/product/1.jpg"
                                                        alt="product-1"
                                                        class="cr-cart-img"
                                                />
                                                Organic Lemon
                                            </a>
                                        </td>
                                        <td class="cr-cart-price">
                                            <span class="amount" data-price="56">$56.00</span>
                                        </td>
                                        <td class="cr-cart-qty">
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
                                        </td>
                                        <td class="cr-cart-subtotal">$56.00</td>
                                        <td class="cr-cart-remove">
                                            <a href="javascript:void(0)" class="remove-item">
                                                <i class="ri-delete-bin-line"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="cr-cart-checkbox">
                                            <input type="checkbox" class="product-checkbox" />
                                        </td>
                                        <td class="cr-cart-name">
                                            <a href="javascript:void(0)">
                                                <img
                                                        src="${pageContext.request.contextPath}/customer/img/product/2.jpg"
                                                        alt="product-1"
                                                        class="cr-cart-img"
                                                />
                                                Apple Juice
                                            </a>
                                        </td>
                                        <td class="cr-cart-price">
                                            <span class="amount" data-price="75">$75.00</span>
                                        </td>
                                        <td class="cr-cart-qty">
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
                                        </td>
                                        <td class="cr-cart-subtotal">$75.00</td>
                                        <td class="cr-cart-remove">
                                            <a href="javascript:void(0)" class="remove-item">
                                                <i class="ri-delete-bin-line"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="cr-cart-checkbox">
                                            <input type="checkbox" class="product-checkbox" />
                                        </td>
                                        <td class="cr-cart-name">
                                            <a href="javascript:void(0)">
                                                <img
                                                        src="${pageContext.request.contextPath}/customer/img/product/3.jpg"
                                                        alt="product-1"
                                                        class="cr-cart-img"
                                                />
                                                Watermelon 5kg Pack
                                            </a>
                                        </td>
                                        <td class="cr-cart-price">
                                            <span class="amount" data-price="48">$48.00</span>
                                        </td>
                                        <td class="cr-cart-qty">
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
                                        </td>
                                        <td class="cr-cart-subtotal">$48.00</td>
                                        <td class="cr-cart-remove">
                                            <a href="javascript:void(0)" class="remove-item">
                                                <i class="ri-delete-bin-line"></i>
                                            </a>
                                        </td>
                                    </tr>

                                    </tbody>
                                </table>
                            </div>
                            <div class="cr-cart-summary">
                                <div class="summary-sub-total">
                                    <table class="table summary-table">
                                        <tbody>
                                        <tr>
                                            <td>Tiền sách :</td>
                                            <td>$300.00</td>
                                        </tr>
                                        <tr>
                                            <td>Thuế (20%) :</td>
                                            <td>$60.00</td>
                                        </tr>
                                        <tr>
                                            <td>Thành tiền :</td>
                                            <td>$360.00</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="cr-cart-update-bottom">
                                        <a href="home" class="cr-btn-secondary">Tiếp tục mua sách</a>

                                        <a href="checkout" class="cr-button">Thanh toán</a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Popular products -->
<section
        class="section-popular-products padding-tb-100"
        data-aos="fade-up"
        data-aos-duration="2000"
        data-aos-delay="400"
>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="mb-30">
                    <div class="cr-banner">
                        <h2>Các cuốn sách nổi tiếng</h2>
                    </div>
                    <div class="cr-banner-sub-title">
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                            do eiusmod tempor incididunt ut labore et viverra maecenas
                            accumsan lacus vel facilisis.
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="cr-popular-product">
                    <div class="slick-slide">
                        <div class="cr-product-card">
                            <div class="cr-product-image">
                                <div class="cr-image-inner zoom-image-hover">
                                    <img src="${pageContext.request.contextPath}/customer/img/product/9.jpg" alt="product-1" />
                                </div>
                                <div class="cr-side-view">
                                    <a href="javascript:void(0)" class="wishlist">
                                        <i class="ri-heart-line"></i>
                                    </a>
                                    <a
                                            class="model-oraganic-product"
                                            data-bs-toggle="modal"
                                            href="#quickview"
                                            role="button"
                                    >
                                        <i class="ri-eye-line"></i>
                                    </a>
                                </div>
                                <a class="cr-shopping-bag" href="javascript:void(0)">
                                    <i class="ri-shopping-bag-line"></i>
                                </a>
                            </div>
                            <div class="cr-product-details">
                                <div class="cr-brand">
                                    <a href="shop-left-sidebar.html">Snacks</a>
                                    <div class="cr-star">
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-line"></i>
                                        <p>(4.5)</p>
                                    </div>
                                </div>
                                <a href="product" class="title"
                                >Best snakes with hazel nut mix pack 200gm</a
                                >
                                <p class="cr-price">
                                    <span class="new-price">$120.25</span>
                                    <span class="old-price">$123.25</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="slick-slide">
                        <div class="cr-product-card">
                            <div class="cr-product-image">
                                <div class="cr-image-inner zoom-image-hover">
                                    <img src="${pageContext.request.contextPath}/customer/img/product/10.jpg" alt="product-1" />
                                </div>
                                <div class="cr-side-view">
                                    <a href="javascript:void(0)" class="wishlist">
                                        <i class="ri-heart-line"></i>
                                    </a>
                                    <a
                                            class="model-oraganic-product"
                                            data-bs-toggle="modal"
                                            href="#quickview"
                                            role="button"
                                    >
                                        <i class="ri-eye-line"></i>
                                    </a>
                                </div>
                                <a class="cr-shopping-bag" href="javascript:void(0)">
                                    <i class="ri-shopping-bag-line"></i>
                                </a>
                            </div>
                            <div class="cr-product-details">
                                <div class="cr-brand">
                                    <a href="shop-left-sidebar.html">Snacks</a>
                                    <div class="cr-star">
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <p>(5.0)</p>
                                    </div>
                                </div>
                                <a href="product" class="title"
                                >Sweet snakes crunchy nut mix 250gm pack</a
                                >
                                <p class="cr-price">
                                    <span class="new-price">$100.00</span>
                                    <span class="old-price">$110.00</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="slick-slide">
                        <div class="cr-product-card">
                            <div class="cr-product-image">
                                <div class="cr-image-inner zoom-image-hover">
                                    <img src="${pageContext.request.contextPath}/customer/img/product/1.jpg" alt="product-1" />
                                </div>
                                <div class="cr-side-view">
                                    <a href="javascript:void(0)" class="wishlist">
                                        <i class="ri-heart-line"></i>
                                    </a>
                                    <a
                                            class="model-oraganic-product"
                                            data-bs-toggle="modal"
                                            href="#quickview"
                                            role="button"
                                    >
                                        <i class="ri-eye-line"></i>
                                    </a>
                                </div>
                                <a class="cr-shopping-bag" href="javascript:void(0)">
                                    <i class="ri-shopping-bag-line"></i>
                                </a>
                            </div>
                            <div class="cr-product-details">
                                <div class="cr-brand">
                                    <a href="shop-left-sidebar.html">Snacks</a>
                                    <div class="cr-star">
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-line"></i>
                                        <p>(4.5)</p>
                                    </div>
                                </div>
                                <a href="product" class="title"
                                >Best snakes with hazel nut mix pack 200gm</a
                                >
                                <p class="cr-price">
                                    <span class="new-price">$120.25</span>
                                    <span class="old-price">$123.25</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="slick-slide">
                        <div class="cr-product-card">
                            <div class="cr-product-image">
                                <div class="cr-image-inner zoom-image-hover">
                                    <img src="${pageContext.request.contextPath}/customer/img/product/2.jpg" alt="product-1" />
                                </div>
                                <div class="cr-side-view">
                                    <a href="javascript:void(0)" class="wishlist">
                                        <i class="ri-heart-line"></i>
                                    </a>
                                    <a
                                            class="model-oraganic-product"
                                            data-bs-toggle="modal"
                                            href="#quickview"
                                            role="button"
                                    >
                                        <i class="ri-eye-line"></i>
                                    </a>
                                </div>
                                <a class="cr-shopping-bag" href="javascript:void(0)">
                                    <i class="ri-shopping-bag-line"></i>
                                </a>
                            </div>
                            <div class="cr-product-details">
                                <div class="cr-brand">
                                    <a href="shop-left-sidebar.html">Snacks</a>
                                    <div class="cr-star">
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <p>(5.0)</p>
                                    </div>
                                </div>
                                <a href="product" class="title"
                                >Sweet snakes crunchy nut mix 250gm pack</a
                                >
                                <p class="cr-price">
                                    <span class="new-price">$100.00</span>
                                    <span class="old-price">$110.00</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="slick-slide">
                        <div class="cr-product-card">
                            <div class="cr-product-image">
                                <div class="cr-image-inner zoom-image-hover">
                                    <img src="${pageContext.request.contextPath}/customer/img/product/3.jpg" alt="product-1" />
                                </div>
                                <div class="cr-side-view">
                                    <a href="javascript:void(0)" class="wishlist">
                                        <i class="ri-heart-line"></i>
                                    </a>
                                    <a
                                            class="model-oraganic-product"
                                            data-bs-toggle="modal"
                                            href="#quickview"
                                            role="button"
                                    >
                                        <i class="ri-eye-line"></i>
                                    </a>
                                </div>
                                <a class="cr-shopping-bag" href="javascript:void(0)">
                                    <i class="ri-shopping-bag-line"></i>
                                </a>
                            </div>
                            <div class="cr-product-details">
                                <div class="cr-brand">
                                    <a href="shop-left-sidebar.html">Snacks</a>
                                    <div class="cr-star">
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <i class="ri-star-fill"></i>
                                        <p>(5.0)</p>
                                    </div>
                                </div>
                                <a href="product" class="title"
                                >Sweet snakes crunchy nut mix 250gm pack</a
                                >
                                <p class="cr-price">
                                    <span class="new-price">$100.00</span>
                                    <span class="old-price">$110.00</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>