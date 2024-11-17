<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Product -->
<div class="cr-main-content mb-3">
    <div class="container-fluid">
        <!-- region Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/staff/product-dashboard">Biblio</a></li>
                    <li><a href="${pageContext.request.contextPath}/staff/product-dashboard">Danh sách sản phẩm</a></li>
                    <li>Chi tiết sản phẩm</li>
                </ul>
            </div>
        </div>
        <!-- endregion -->

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
                            <c:forEach var="imageUrl" items="${book.imagesUrl}">
                                <div class="slider-banner-image">
                                    <div class="zoom-image-hover">
                                        <img
                                                src="${imageUrl}"
                                                alt="product-image"
                                                class="product-image"
                                        />
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="slider slider-nav thumb-image">
                            <c:forEach var="imageUrl" items="${book.imagesUrl}">
                                <div class="thumbnail-image">
                                    <div class="thumbImg">
                                        <img src="${imageUrl}" alt="product-thumbnail"/>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xxl-8 col-xl-7 col-md-6 col-12 mb-24">
                <div class="cr-size-and-weight-contain">
                    <h2 class="heading">
                        ${book.title}
                    </h2>
                    <p>
                        ${book.description}
                    </p>
                </div>
                <div class="cr-size-and-weight">
                    <div class="cr-review-star">
                        <div class="cr-star">
                            <c:set var="rating" value="${book.totalRating}"/>
                            <c:set var="fullStars" value="${rating - (rating % 1)}"/>
                            <c:set var="halfStar" value="${(rating % 1) >= 0.5}"/>
                            <c:set var="emptyStars" value="${5 - fullStars - (halfStar ? 1 : 0)}"/>

                            <c:forEach var="i" begin="1" end="${fullStars}">
                                <i class="ri-star-fill"></i>
                            </c:forEach>

                            <c:if test="${halfStar}">
                                <i class="ri-star-half-fill"></i>
                            </c:if>

                            <c:forEach var="i" begin="1" end="${emptyStars}">
                                <i class="ri-star-line"></i>
                            </c:forEach>
                        </div>
                        <p>( ${book.reviewCount} Review )</p>
                    </div>
                    <div class="list">
                        <ul>
                            <li>
                                <label>Tác giả <span>:</span></label>
                                ${book.authors[0].name}
                            </li>
                            <li>
                                <label>NXB <span>:</span></label>
                                ${book.publisher}
                            </li>
                            <li>
                                <label>Ngày XB <span>:</span></label>
                                ${book.publicationDate}
                            </li>
                            <li>
                                <label>Ngôn ngữ <span>:</span></label>
                                ${book.languages}
                            </li>
                        </ul>
                    </div>
                    <div class="cr-product-price">
                        <span class="new-price price-value">${book.sellingPrice}</span>
                        <span class="old-price price-value">${book.sellingPrice}</span>
                    </div>
                    <div class="cr-size-weight">
                        <h5><span>Tình trạng</span> :</h5>
                        <div class="cr-kg">
                            <ul>
                                <li class="active-color">${book.condition}</li>
                            </ul>
                        </div>
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
                                Thông tin chi tiết
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
                                Thông tin tác giả
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
                                    <div class="cr-description">
                                        <p>
                                            ${book.description}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div
                                class="tab-pane"
                                id="additional"
                                role="tabpanel"
                                aria-labelledby="additional-tab"
                        >
                            <div class="cr-tab-content">
                                <div class="list">
                                    <ul>
                                        <li>
                                            <label>Danh mục <span>:</span></label>
                                            Sách kỹ năng sống
                                        </li>
                                        <li>
                                            <label>Kho <span>:</span></label>
                                            ${book.quantity}
                                        </li>
                                        <li>
                                            <label>Tác giả <span>:</span></label>
                                            ${book.authors[0].name}
                                        </li>
                                        <li>
                                            <label>NXB <span>:</span></label>
                                            ${book.publisher}
                                        </li>
                                        <li>
                                            <label>Ngày XB <span>:</span></label>
                                            ${book.publicationDate}
                                        </li>
                                        <li>
                                            <label>Ngôn ngữ <span>:</span></label>
                                            ${book.languages}
                                        </li>
                                        <li>
                                            <label>Trọng lượng <span>:</span></label>
                                            ${book.weight} gram
                                        </li>
                                        <li>
                                            <label>Kích thước <span>:</span></label>
                                            ${book.size}
                                        </li>
                                        <li>
                                            <label>Số trang <span>:</span></label>
                                            ${book.hardcover}
                                        </li>
                                        <li>
                                            <label>Định dạng <span>:</span></label>
                                            ${book.format}
                                        </li>
                                        <li>
                                            <label>ISBN-10 <span>:</span></label>
                                            ${book.codeISBN10}
                                        </li>
                                        <li>
                                            <label>ISBN-13 <span>:</span></label>
                                            ${book.codeISBN13}
                                        </li>
                                        <li>
                                            <label>Độ tuổi <span>:</span></label>
                                            ${book.ageRecommend}
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
                                        <li class="review-item" data-review-id="${review.id}">
                                            <div class="review-item__image">
                                                <img src="${pageContext.request.contextPath}${review.imageUrl}"
                                                     alt="review"/>
                                            </div>
                                            <div class="review-item__content">
                                                <div class="header">
                                                    <div class="header__left">
                                                        <span class="name">${review.customerName}</span>
                                                        <div class="rating">
                                                            <c:forEach var="i" begin="1" end="5">
                                                                <i class="<c:choose>
                                                                             <c:when test='${i <= review.rating}'>ri-star-s-fill</c:when>
                                                                             <c:otherwise>ri-star-line</c:otherwise>
                                                                         </c:choose>">
                                                                </i>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                    <div class="header__right">
                                                        <button class="action-btn action-btn__hide">
                                                            <i class="ri-eye-off-line"></i>
                                                        </button>
                                                        <c:if test="${empty review.responseContent}">
                                                            <button type="button"
                                                                    class="action-btn action-btn__response">
                                                                <i class="ri-reply-line"></i>
                                                            </button>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <span class="date">${review.createdAt}</span>

                                                <div class="review-content">
                                                        ${review.content}
                                                </div>

                                                <c:if test="${not empty review.responseContent}">
                                                    <div class="response-review">
                                                        <div class="response-title">Phản Hồi Của Người Bán</div>
                                                        <div class="response-text">${review.responseContent}</div>
                                                    </div>
                                                </c:if>
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
                                    <img src="${pageContext.request.contextPath}/assets/customer/img/product/1.jpg"
                                         alt="">
                                    <p>
                                        <b>Richard Koch</b> is the author of The 80/20 Principle,
                                        which has sold more than a million copies,
                                        and been published in approximately forty languages.
                                        He is also a successful entrepreneur and investor whose ventures have
                                        included Filofax,
                                        Plymouth Gin, Belgo restaurants and Betfair, the world’s largest betting
                                        exchange.
                                        He was formerly a partner of Bain & Company, and co-founder of LEK
                                        Consulting.
                                        He has written more than twenty acclaimed books on business and ideas.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- region Modal -->
<%--FeedbackModal--%>
<div class="modal fade" id="feedbackModal" tabindex="-1" aria-labelledby="feedbackModalLabel" aria-hidden="true">
    <input class="review-id" value="" hidden>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="feedbackModalLabel">Phản hồi của bạn</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="feedbackForm">
                    <div class="mb-3">
                        <label for="feedbackContent" class="form-label">Nội dung phản hồi</label>
                        <textarea id="feedbackContent" name="feedbackContent" class="form-control" placeholder="Nhập nội dung phản hồi..."
                                  rows="4"></textarea>
                        <p id="error-message">Vui lòng nhập nội dung!</p>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                <button type="button" class="btn btn-primary" id="submitFeedback">Gửi</button>
            </div>
        </div>
    </div>
</div>

<%--HideModal--%>
<div class="modal fade" id="hideReviewModal" tabindex="-1" aria-labelledby="hideReviewModalLabel" aria-hidden="true">
    <input class="review-id" value="" hidden>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="hideReviewModalLabel">Bạn có chắc muốn ẩn đánh giá này không?</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                <button type="button" class="btn btn-primary" id="confirmHideReview">Ẩn đánh giá</button>
            </div>
        </div>
    </div>
</div>
<!-- endregion -->

<!-- region VENDOR JS -->
<script src="${pageContext.request.contextPath}/assets/staff/js/vendor/jquery.zoom.min.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/staff/js/vendor/mixitup.min.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/staff/js/vendor/range-slider.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/staff/js/vendor/aos.min.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/staff/js/vendor/swiper-bundle.min.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/staff/js/vendor/slick.min.js" defer></script>
<!-- endregion -->

<script src="${pageContext.request.contextPath}/assets/staff/js/product-details.js" defer></script>