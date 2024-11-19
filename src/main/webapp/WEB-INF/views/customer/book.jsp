<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Product -->
<section class="section-product padding-t-100">
  <div class="container">
    <div
            class="row mb-minus-24"
            data-aos="fade-up"
            data-aos-duration="2000"
            data-aos-delay="600"
    >
      <div class="col-xxl-4 col-xl-5 col-md-6 col-12 mb-24">
        <div class="vehicle-detail-banner banner-content clearfix">
          <div class="banner-slider">
            <div class="slider slider-for">
              <c:forEach var="imageUrl" items="${book.imageUrls}" varStatus="status">
                <div class="slider-banner-image">
                  <div class="zoom-image-hover">
                    <img
                            src="${pageContext.request.contextPath}${imageUrl}"
                            alt="product-tab-${status.index}"
                            class="product-image"
                    />
                  </div>
                </div>
              </c:forEach>
            </div>
            <div class="slider slider-nav thumb-image">
              <c:forEach var="imageUrl" items="${book.imageUrls}" varStatus="status">
                <div class="thumbnail-image">
                    <div class="thumbImg">
                      <img src="${pageContext.request.contextPath}${imageUrl}" alt="product-tab-${status.index}" />
                    </div>
                </div>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
      <div class="col-xxl-8 col-xl-7 col-md-6 col-12 mb-24">
        <div class="cr-size-and-weight-contain">
          <h2 class="heading">${book.title}</h2>
        </div>
        <div class="cr-size-and-weight">
          <div class="cr-review-star">
            <div class="cr-star">
              <c:forEach var="i" begin="1" end="5" step="1">
                <c:choose>
                  <c:when test="${book.avgRating >= i}">
                    <i class="ri-star-fill"></i>
                  </c:when>
                  <c:when test="${book.avgRating > i - 1 && book.avgRating < i}">
                    <i class="ri-star-half-line"></i>
                  </c:when>
                  <c:otherwise>
                    <i class="ri-star-line"></i>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </div>
            <p>( ${book.avgRating} )</p>
          </div>
          <div class="list">
            <ul>
              <li>
                <label>Tác giả <span>:</span></label
                >${book.authors[0].name}
              </li>
              <li>
                <label>NXB <span>:</span></label
                >${book.publisher}
              </li>
              <li>
                <label>Ngày XB <span>:</span></label
                >${book.publicationDate}
              </li>
              <li>
                <label>Ngôn ngữ <span>:</span></label
                >${book.languages}
              </li>
            </ul>
          </div>
          <div class="cr-product-price">
            <span class="new-price">${book.sellingPrice} đ</span>
<%--            <span class="old-price">404.000 đ</span>--%>
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
            <!-- <div class="cr-card-icon">
                          <a href="javascript:void(0)" class="wishlist">
                              <i class="ri-heart-line"></i>
                          </a>
                          <a class="model-oraganic-product" data-bs-toggle="modal" href="#quickview" role="button">
                              <i class="ri-eye-line"></i>
                          </a>
                      </div> -->
          </div>
        </div>
      </div>
    </div>
    <div
            class="row"
            data-aos="fade-up"
            data-aos-duration="2000"
            data-aos-delay="600"
    >
      <div class="col-12">
        <div class="cr-paking-delivery">
          <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
              <button
                      class="nav-link active"
                      id="description-tab"
                      data-bs-toggle="tab"
                      data-bs-target="#description"
                      type="button"
                      role="tab"
                      aria-controls="description"
                      aria-selected="true"
              >
                Mô tả sản phẩm
              </button>
            </li>
            <li class="nav-item" role="presentation">
              <button
                      class="nav-link"
                      id="additional-tab"
                      data-bs-toggle="tab"
                      data-bs-target="#additional"
                      type="button"
                      role="tab"
                      aria-controls="additional"
                      aria-selected="false"
              >
                Chi tiết sản phẩm
              </button>
            </li>
            <li class="nav-item" role="presentation">
              <button
                      class="nav-link"
                      id="review-tab"
                      data-bs-toggle="tab"
                      data-bs-target="#review"
                      type="button"
                      role="tab"
                      aria-controls="review"
                      aria-selected="false"
              >
                Đánh giá sản phẩm
              </button>
            </li>
            <li class="nav-item" role="presentation">
              <button
                      class="nav-link"
                      id="author-tab"
                      data-bs-toggle="tab"
                      data-bs-target="#author"
                      type="button"
                      role="tab"
                      aria-controls="author"
                      aria-selected="false"
              >
                Thông tin tác giả/ dịch giả
              </button>
            </li>
          </ul>
          <div class="tab-content" id="myTabContent">
            <div
                    class="tab-pane fade show active"
                    id="description"
                    role="tabpanel"
                    aria-labelledby="description-tab"
            >
              <div class="cr-tab-content">
                <div class="cr-description">
                  <p>${book.description}</p>
                </div>
              </div>
            </div>
            <div
                    class="tab-pane fade"
                    id="additional"
                    role="tabpanel"
                    aria-labelledby="additional-tab"
            >
              <div class="cr-tab-content">
                <div class="list">
                  <ul>
                    <li>
                      <label>Danh mục <span>:</span></label
                      >${book.category}
                    </li>
                    <li>
                      <label>Kho <span>:</span></label
                      >${book.quantity}
                    </li>
                    <li>
                      <label>Tác giả <span>:</span></label
                      >${book.authors[0].name}
                    </li>
                    <li>
                      <label>NXB <span>:</span></label
                      >${book.publisher}
                    </li>
                    <li>
                      <label>Ngày XB <span>:</span></label
                      >${book.publicationDate}
                    </li>
                    <li>
                      <label>Phiên bản <span>:</span></label
                      >${book.edition}
                    </li>
                    <li>
                      <label>Ngôn ngữ <span>:</span></label
                      >${book.languages}
                    </li>
                    <li>
                      <label>Trọng lượng <span>:</span></label
                      >${book.weight} kg
                    </li>
                    <li>
                      <label>Kích thước <span>:</span></label
                      >${book.size}
                    </li>
                    <li>
                      <label>Số trang <span>:</span></label
                      >${book.hardcover} trang
                    </li>
                    <li>
                      <label>Định dạng <span>:</span></label
                      >${book.format}
                    </li>
                    <li>
                      <label>ISBN-10 <span>:</span></label
                      >${book.codeISBN10}
                    </li>
                    <li>
                      <label>ISBN-13 <span>:</span></label
                      >${book.codeISBN13}
                    </li>
                    <li>
                      <label>Độ tuổi <span>:</span></label
                      >${book.recommendedAge}
                    </li>
                  </ul>
                </div>
              </div>
            </div>
            <div
                    class="tab-pane fade"
                    id="review"
                    role="tabpanel"
                    aria-labelledby="review-tab"
            >
              <div class="cr-tab-content-from">
                <ul class="review-list">
                  <c:forEach var="review" items="${book.reviews}">
                    <li class="review-item">
                      <div class="review-item__image">
                        <img src="${pageContext.request.contextPath}${review.imageUrl}"
                             alt="review"/>
                      </div>
                      <div class="review-item__content">
                        <div class="header">
                          <div class="header__left">
                            <span>${review.customerName}</span>
                            <div class="rating">
                              <c:forEach var="i" begin="1" end="5" step="1">
                                <c:choose>
                                  <c:when test="${i <= review.rating}">
                                    <i class="ri-star-fill"></i>
                                  </c:when>
                                  <c:otherwise>
                                    <i class="ri-star-line"></i>
                                  </c:otherwise>
                                </c:choose>
                              </c:forEach>
                            </div>
                          </div>
                        </div>
                        <span class="date">${review.createdAt}</span>

                        <div class="review-content">
                          ${review.content}
                        </div>

<%--                        <div class="response-review">--%>
<%--                          <div class="response-title">Phản Hồi Của Người Bán</div>--%>
<%--                          <div class="response-text">--%>
<%--                            Dạ vâng adidas cảm ơn quý khách đã tin tưởng và ủng hộ ❤️. Sự góp ý--%>
<%--                          </div>--%>
<%--                        </div>--%>
                      </div>
                    </li>
                  </c:forEach>
                </ul>
              </div>
            </div>
            <div
                    class="tab-pane fade"
                    id="author"
                    role="tabpanel"
                    aria-labelledby="author-tab"
            >
              <div class="cr-tab-content">
                <div class="cr-description">
                  <c:forEach var="author" items="${book.authors}">
                    <div class="author-item">
                      <div class="author-item--avatar">
                        <img src="${author.avatar}" alt="">
                      </div>
                      <div class="author-item--info">
                        <span class="name">${author.name} (Tác giả)</span>
                        <p>${author.introduction}</p>
                      </div>
                    </div>
                  </c:forEach>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Related products -->
<section
        class="section-related-products padding-tb-100"
        data-aos="fade-up"
        data-aos-duration="2000"
        data-aos-delay="400"
>
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="mb-30">
          <div class="cr-banner">
            <h2>Các sản phẩm liên quan</h2>
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
                  <img src="${pageContext.request.contextPath}/assets/customer/img/product/9.jpg" alt="product-1" />
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
                >Getting Work Done (HBR 20-Minute Manager Series)</a
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
                  <img src="${pageContext.request.contextPath}/assets/customer/img/product/10.jpg" alt="product-1" />
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
                >Work Rules: Insights From Inside Google</a
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
                  <img src="${pageContext.request.contextPath}/assets/customer/img/product/1.jpg" alt="product-1" />
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
                <a href="product" class="title">
                  Essentialism - The Disciplined Pursuit Of Less</a
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
                  <img src="${pageContext.request.contextPath}/assets/customer/img/product/2.jpg" alt="product-1" />
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
                  <img src="${pageContext.request.contextPath}/assets/customer/img/product/3.jpg" alt="product-1" />
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
