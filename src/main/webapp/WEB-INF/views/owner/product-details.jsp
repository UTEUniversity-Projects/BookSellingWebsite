<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Product -->
<div class="cr-main-content mb-3">
    <div class="container-fluid">
        <!-- region Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <div class="page-title">
                    <h5>Chi tiết sản phẩm</h5>
                </div>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/owner/ecommerce"><b>Biblio</b></a></li>
                    <li><a href="${pageContext.request.contextPath}/owner/product-list"><b>Danh sách sản phẩm</b></a></li>
                    <li><b>Chi tiết sản phẩm</b></li>
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
                            <c:forEach var="imageUrl" items="${book.imageUrls}">
                                <div class="slider-banner-image">
                                    <div class="zoom-image-hover">
                                        <img
                                                src="${pageContext.request.contextPath}${imageUrl}"
                                                alt="product-image"
                                                class="product-image"
                                        />
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="slider slider-nav thumb-image">
                            <c:forEach var="imageUrl" items="${book.imageUrls}">
                                <div class="thumbnail-image" style="margin: 10px 5px 20px 0px">
                                    <div class="thumbImg">
                                        <img src="${pageContext.request.contextPath}${imageUrl}" class="mini-image-shadow" alt="product-thumbnail"/>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xxl-8 col-xl-7 col-md-6 col-12 mb-24">
                <h2 class="product-title">
                    ${book.title}
                </h2>
                <div style="font-size: 80%">
                    <p>
                        <c:forEach var="author" items="${book.authors}" varStatus="status">
                            <span class="name author-name-inline">${author.name}</span>
                            <i>(tác giả)</i>
                            <c:if test="${status.last}">
                                <c:if test="${not empty book.translators}">
                                    ,
                                </c:if>
                            </c:if>
                            <c:if test="${!status.last}">
                                ,
                            </c:if>
                        </c:forEach>
                        <c:forEach var="translator" items="${book.translators}" varStatus="status">
                            <span class="name">${translator.name}</span>
                            <i>(dịch giả)</i>
                            <c:if test="${!status.last}">
                                ,
                            </c:if>
                        </c:forEach>
                    </p>
                </div>
                <div class="d-flex align-items-center">
                    <p class="book-avg-rate">${book.avgRating}</p>
                    <div class="cr-star book-review-star">
                        <c:forEach var="i" begin="1" end="5" step="1">
                            <c:choose>
                                <c:when test="${book.avgRating >= i}">
                                    <i class="ri-star-fill" style="color: #FFD43B"></i>
                                </c:when>
                                <c:when test="${book.avgRating > i - 1 && book.avgRating < i}">
                                    <i class="ri-star-half-line" style="color: #FFD43B"></i>
                                </c:when>
                                <c:otherwise>
                                    <i class="ri-star-line" style="color: slategray"></i>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                    <p>(${book.reviewCount})</p>
                    <p class="ms-2 me-2">|</p>
                    <p class="book-sold-count">10 lượt bán</p>
                </div>
                <div class="cr-size-and-weight">
                    <div class="cr-product-price" style="padding-top: 0">
                        <span class="new-price price-value">${book.sellingPrice} VNĐ</span>
                        <span class="old-price price-value">${book.sellingPrice} VNĐ</span>
                    </div>
                    <div class="d-flex align-items-center">
                        <i class="ri-community-line me-1" style="font-size: 20px"></i>
                        <p>Nhà xuất bản Văn hóa và Nghệ thuật</p>
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
                <hr class="my-4">
                <div class="slider slider-nav thumb-image">
                    <div>
                        <div class="slider-info-title text-center">
                            Số trang
                        </div>
                        <div class="slider-icon text-center">
                            <i class="ri-file-copy-2-line"></i>
                        </div>
                        <div class="slider-info-value text-center">
                            ${book.hardcover} trang
                        </div>
                    </div>
                    <div>
                        <div class="slider-info-title text-center">
                            Ngôn ngữ
                        </div>
                        <div class="slider-icon text-center">
                            <i class="ri-file-copy-2-line"></i>
                        </div>
                        <div class="slider-info-value text-center">
                            ${book.languages}
                        </div>
                    </div>
                    <div>
                        <div class="slider-info-title text-center">
                            Nhà xuất bản
                        </div>
                        <div class="slider-icon text-center">
                            <i class="ri-file-copy-2-line"></i>
                        </div>
                        <div class="slider-info-value text-center">
                            ${book.publisher}
                        </div>
                    </div>
                    <div>
                        <div class="slider-info-title text-center">
                            Ngày xuất bản
                        </div>
                        <div class="slider-icon text-center">
                            <i class="ri-file-copy-2-line"></i>
                        </div>
                        <div class="slider-info-value text-center">
                            ${book.publicationDate}
                        </div>
                    </div>
                    <div>
                        <div class="slider-info-title text-center">
                            Kích thước
                        </div>
                        <div class="slider-icon text-center">
                            <i class="ri-file-copy-2-line"></i>
                        </div>
                        <div class="slider-info-value text-center">
                            ${book.size}
                        </div>
                    </div>
                    <div>
                        <div class="slider-info-title text-center">
                            ISBN-10
                        </div>
                        <div class="slider-icon text-center">
                            <i class="ri-file-copy-2-line"></i>
                        </div>
                        <div class="slider-info-value text-center">
                            ${book.codeISBN10}
                        </div>
                    </div>
                    <div>
                        <div class="slider-info-title text-center">
                            ISBN-13
                        </div>
                        <div class="slider-icon text-center">
                            <i class="ri-file-copy-2-line"></i>
                        </div>
                        <div class="slider-info-value text-center">
                            ${book.codeISBN10}
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
                <div class="cr-paking-delivery card-3d-deep">
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
                                    <p>
                                        ${book.description}
                                    </p>
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
                                            ${book.category}
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
                                            ${book.recommendedAge}
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
                                    <c:forEach var="author" items="${book.authors}">
                                        <div class="row d-flex author-item">
                                            <div class="col-3">
                                                <div class="col-xl-12">
                                                    <div class="cr-vendor-block-detail">
                                                        <div class="avatar-preview cr-preview">
                                                            <div class="imagePreview cr-div-preview">
                                                                <img class="cr-image-preview image-shadow rounded-3"
                                                                     src="${pageContext.request.contextPath}${author.avatar}"
                                                                     alt="edit">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-8">
                                                <span class="name">${author.name} (Tác giả)</span>
                                                <p>${author.introduction}</p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <c:forEach var="translator" items="${book.translators}">
                                        <div class="row d-flex author-item">
                                            <div class="col-3">
                                                <div class="col-xl-12">
                                                    <div class="cr-vendor-block-detail">
                                                        <div class="avatar-preview cr-preview">
                                                            <div class="imagePreview cr-div-preview">
                                                                <img class="cr-image-preview image-shadow rounded-3"
                                                                     src="${pageContext.request.contextPath}${translator.avatar}"
                                                                     alt="edit">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-8">
                                                <span class="name">${translator.name} (Dịch giả)</span>
                                                <p>${translator.introduction}</p>
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
</div>

<!-- region VENDOR JS -->
<script src="${pageContext.request.contextPath}/assets/owner/js/vendor/jquery.zoom.min.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/vendor/mixitup.min.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/vendor/range-slider.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/vendor/aos.min.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/vendor/swiper-bundle.min.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/vendor/slick.min.js" defer></script>
<!-- endregion -->

<script src="${pageContext.request.contextPath}/assets/owner/js/product-details.js" defer></script>

<style>
    .product-title {
        font-family:  'Nunito Sans', sans-serif;
        font-weight: bold;
        font-size: 200%;
        color: #2b3647;
    }
    .page-title {
        margin-right: 20px;
    }
    .book-avg-rate {
        margin-right: 5px;
        font-size: 130%;
        font-weight: bold;
        color: #2b3647;
        font-family: Nunito, sans-serif
    }
    .book-review-star {
        margin-right: 10px;
    }
    .book-sold-count {
        background-color: #dcfcee;
        color: #30cb83;
        font-weight: bold;
        border-radius: 10px;
        padding: 3px 5px 3px 5px;
        font-family: Nunito, sans-serif;
    }
    .slider-info-title {
        font-size: 12px;
    }
    .slider-info-value {
        font-size: 12px;
        font-weight: bold;
    }
    .slider-icon {
        font-size: 20px;
        margin-top: 10px;
        margin-bottom: 10px;
    }
    .new-price {
        font-family: "Be Vietnam Pro", sans-serif;
        font-size: 110%;
        font-weight: 600;
        color: #64b496;
    }
    .card-3d-deep {
        background: #fff;
        border-radius: 10px;
        padding: 20px;
        position: relative;
        overflow: visible;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1),
        0 8px 10px rgba(0, 0, 0, 0.1),
        0 16px 24px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }
    .card-3d-deep:hover {
        box-shadow: 0 6px 8px rgba(0, 0, 0, 0.1),
        0 12px 20px rgba(0, 0, 0, 0.15),
        0 24px 32px rgba(0, 0, 0, 0.2);
    }
    .mini-card-3d-deep {
        background: #fff;
        border-radius: 10px;
        padding: 20px;
        position: relative;
        overflow: visible;
        box-shadow: 0 2px 3px rgba(0, 0, 0, 0.1),
        0 4px 5px rgba(0, 0, 0, 0.1),
        0 8px 12px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }
    .mini-card-3d-deep:hover {
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1),
        0 6px 10px rgba(0, 0, 0, 0.15),
        0 12px 16px rgba(0, 0, 0, 0.2);
    }
    .image-shadow {
        transition: transform 0.3s ease, box-shadow 0.3s ease;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        object-fit: cover;
    }
    .image-shadow:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
        object-fit: cover;
    }
    .mini-image-shadow {
        transition: transform 0.3s ease, box-shadow 0.3s ease;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
        object-fit: cover;
    }
    .mini-image-shadow:hover {
        transform: translateY(-5px);
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        object-fit: cover;
    }
</style>
