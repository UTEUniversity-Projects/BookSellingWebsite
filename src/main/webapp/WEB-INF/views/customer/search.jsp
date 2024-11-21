<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Shop -->
<section class="section-shop padding-tb-100">
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
                        <h2>Danh mục</h2>
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
            <div
                    class="col-lg-3 col-12 md-30"
                    data-aos="fade-up"
                    data-aos-duration="2000"
                    data-aos-delay="400"
            >
                <div class="cr-shop-sideview">
                    <div class="cr-shop-categories">
                        <h4 class="cr-shop-sub-title">Danh mục</h4>
                        <div class="cr-checkbox">
                            <div class="checkbox-group">
                                <input type="checkbox" id="all-categories"/>
                                <label for="all-categories">Tất cả</label>
                                <span>[20]</span>
                            </div>
                            <c:forEach var="category" items="${categories}">
                                <div class="checkbox-group">
                                    <input type="checkbox" id="${category.id}"/>
                                    <label for="${category.id}">${category.name}</label>
                                    <span>[20]</span>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="cr-shop-price">
                        <h4 class="cr-shop-sub-title">Khoảng giá</h4>
                        <div class="price-range-slider">
                            <div id="slider-range" class="range-bar"></div>
                            <p class="range-value">
                                <label>Giá :</label>
                                <input type="text" id="amount" placeholder="'" readonly/>
                            </p>
                            <button type="button" class="cr-button">Lọc</button>
                        </div>
                    </div>
                    <div class="cr-shop-color">
                        <h4 class="cr-shop-sub-title">Hạng mục</h4>
                        <div class="cr-checkbox">
                            <div class="checkbox-group">
                                <input type="checkbox" id="blue"/>
                                <label for="blue">Best-Seller</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="yellow"/>
                                <label for="yellow">Top 50</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="red"/>
                                <label for="red">Combo sách</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="red"/>
                                <label for="red">Sách đang khuyến mãi</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="red"/>
                                <label for="red">Sách mới xuất bản</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="red"/>
                                <label for="red">Sách trong nước</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="red"/>
                                <label for="red">Sách nước ngoài</label>
                            </div>
                        </div>
                    </div>
                    <div class="cr-shop-condition">
                        <h4 class="cr-shop-sub-title">Tình trạng</h4>
                        <div class="cr-checkbox">
                            <div class="checkbox-group">
                                <input type="checkbox" id="all-condition"/>
                                <label for="all-condition">Tất cả</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="new"/>
                                <label for="new">Mới</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="old"/>
                                <label for="old">Cũ</label>
                            </div>
                        </div>
                    </div>
                    <div class="cr-shop-binding">
                        <h4 class="cr-shop-sub-title">Định dạng</h4>
                        <div class="cr-checkbox">
                            <div class="checkbox-group">
                                <input type="checkbox" id="all-binding"/>
                                <label for="all-binding">Tất cả</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="hard"/>
                                <label for="hard">Bìa cứng</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="soft"/>
                                <label for="soft">Bìa mềm</label>
                            </div>
                        </div>
                    </div>
                    <div class="cr-shop-rating">
                        <h4 class="cr-shop-sub-title">Đánh giá</h4>
                        <div class="cr-checkbox">
                            <div class="checkbox-group">
                                <input type="checkbox" id="all-star"/>
                                <label for="all-star">Tất cả</label>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="2-star"/>
                                <label for="2-star">2+ sao</label>
                                <span
                                ><div class="cr-star">
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-line"></i>
                        <i class="ri-star-line"></i>
                        <i class="ri-star-line"></i></div
                                ></span>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="3-star"/>
                                <label for="3-star">3+ sao</label>
                                <span>
                      <div class="cr-star">
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-line"></i>
                        <i class="ri-star-line"></i>
                      </div>
                    </span>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="4-star"/>
                                <label for="4-star">4+ sao</label>
                                <span>
                      <div class="cr-star">
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-line"></i>
                      </div>
                    </span>
                            </div>
                            <div class="checkbox-group">
                                <input type="checkbox" id="5-star"/>
                                <label for="5-star">5 sao</label>
                                <span>
                      <div class="cr-star">
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                        <i class="ri-star-fill"></i>
                      </div>
                    </span>
                            </div>
                        </div>
                    </div>
                    <div class="cr-shop-tags">
                        <h4 class="cr-shop-sub-title">Thẻ</h4>
                        <div class="cr-shop-tags-inner">
                            <ul class="cr-tags">
                                <li><a href="javascript:void(0)">Thiếu nhi</a></li>
                                <li><a href="javascript:void(0)">Kỹ năng sống</a></li>
                                <li><a href="javascript:void(0)">Kinh tế</a></li>
                                <li><a href="javascript:void(0)">Giáo trình</a></li>
                                <li><a href="javascript:void(0)">Từ điển</a></li>
                                <li><a href="javascript:void(0)">Tâm lý</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div
                    class="col-lg-9 col-12 md-30"
                    data-aos="fade-up"
                    data-aos-duration="2000"
                    data-aos-delay="600"
            >
                <div class="row">
                    <div class="col-12">
                        <div class="cr-shop-bredekamp">
                            <div class="cr-toggle">
                                <a href="javascript:void(0)" class="gridCol active-grid">
                                    <i class="ri-grid-line"></i>
                                </a>
                                <a href="javascript:void(0)" class="gridRow">
                                    <i class="ri-list-check-2"></i>
                                </a>
                            </div>
                            <div class="flex items-center justify-between flex-1">
                                <p class='font-bold'>
                                    Kết quả tìm kiếm:
                                    <span class="font-medium text-[#004838]"
                                    >đắc nhân tâm (20 kết quả)</span
                                    >
                                </p>
                            </div>
                            <div class="cr-select">
                                <label>Sắp xếp theo :</label>
                                <select
                                        class="form-select"
                                        aria-label="Default select example"
                                >
                                    <option selected>Bán chạy</option>
                                    <option value="1">Nổi bật</option>
                                    <option value="2">Khuyến mãi</option>
                                    <option value="3">Giá tăng dần</option>
                                    <option value="4">Giá giảm dần</option>
                                    <option value="5">Mới nhất</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="book-list row col-100 mb-minus-24">
                    <c:forEach var="book" items="${books}">
                        <div class="mix ${book.categoryName} col-xxl-3 col-xl-4 col-6 cr-product-box mb-24"
                        >
                            <div class="cr-product-card">
                                <div class="cr-product-image">
                                    <div class="cr-image-inner zoom-image-hover">
                                        <img src="${pageContext.request.contextPath}${book.imageUrl}"
                                             alt="${book.title}"/>
                                    </div>
                                    <div class="cr-side-view">
                                        <a
                                                class="model-oraganic-product"
                                                data-bs-toggle="modal"
                                                href="#quickview-${book.id}"
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
                                        <p>${book.categoryName}</p>
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
                                            <p>(${book.reviewRate})</p>
                                        </div>
                                    </div>
                                    <a href="${pageContext.request.contextPath}/book?id=${book.id}"
                                       class="title">${book.title}</a>
                                    <p class="cr-price">
                                        <span class="new-price price-value">${book.sellingPrice}</span>
                                        <span class="old-price price-value">${book.sellingPrice}</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <nav aria-label="..." class="cr-pagination">
                    <ul class="pagination">
                        <li class="page-item disabled">
                            <span class="page-link">Trang trước</span>
                        </li>
                        <li class="page-item active" aria-current="page">
                            <span class="page-link">1</span>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">Trang sau</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</section>
