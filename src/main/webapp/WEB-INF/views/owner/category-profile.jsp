<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- main content -->
<div class="cr-main-content">
  <div class="container-fluid">
    <!-- Page title & breadcrumb -->
    <div class="cr-page-title cr-page-title-2">
      <div class="cr-breadcrumb">
        <h5><b>Thông tin danh mục</b></h5>
        <ul>
          <li><a href="${pageContext.request.contextPath}/owner/ecommerce"><b>Biblio</b></a></li>
          <li><a href="${pageContext.request.contextPath}/owner/category/list"><b>Danh mục</b></a></li>
          <li><b>Thông tin danh mục</b></li>
        </ul>
      </div>
    </div>
    <div class="row">
      <div class="col-xxl-3 col-xl-4 col-md-12">
        <div class="vendor-sticky-bar">
          <div class="col-xl-12">
            <div class="cr-card card-3d-deep">
              <div class="cr-vendor-block-detail">
                <div class="avatar-preview cr-preview">
                  <div class="imagePreview cr-div-preview">
                    <img class="cr-image-preview image-shadow rounded-3"
                         src="${pageContext.request.contextPath}${category.avatar}"
                         alt="edit">
                  </div>
                </div>
                <br>
                <div class="cr-settings">
                  <a onclick="rowAction(${category.id}, 'update'); return false;" class="cr-btn-primary m-r-10 rounded">Cập nhật</a>
                </div>
              </div>
              <div class="cr-vendor-info">
                <ul>
                  <li><span class="label">Danh mục :</span>&nbsp; <b>${category.name}</b></li></li>
                  <li><span class="label">Cùng danh mục :</span>&nbsp; <b>${category.works}</b> sản phẩm</li>
                  <li><span class="label">Mô tả ngắn :</span>&nbsp; <b>${category.shortScript}</b></li>
                </ul>
              </div>
            </div>
            <div class="cr-card card-3d-deep">
              <div class="cr-card-content label-card">
                <div class="title">
                  <span class="icon icon-5"><i class="ri-star-smile-line"></i></span>
                  <div class="growth-numbers">
                    <h4>Trung bình đánh giá</h4>
                    <div class="d-flex align-items-center">
                      <h5>${category.avgRate}</h5>
                      <i class="ri-star-fill ps-2 start-rate"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-xxl-9 col-xl-8 col-md-12">
        <div class="row">
          <div class="col-xl-4 col-md-12">
            <div class="cr-card">
              <div class="cr-card-content label-card">
                <div class="title">
                  <span class="icon icon-2"><i class="ri-shopping-bag-3-line"></i></span>
                  <div class="growth-numbers">
                    <h4>Tổng lượt bán (theo đơn)</h4>
                    <h5>${category.sales}</h5>
                  </div>
                </div>
                <c:choose>
                  <c:when test="${category.perSales == 0}">
                    <p class="card-groth up">
                      <i class="ri-arrow-up-line non-growth"></i>
                      <span class="non-growth m-0">${category.perSales}%</span>
                      <span>tháng trước</span>
                    </p>
                  </c:when>
                  <c:when test="${category.perSales > 0}">
                    <p class="card-groth up">
                      <i class="ri-arrow-up-line"></i>
                        ${category.perSales}%
                      <span>tháng trước</span>
                    </p>
                  </c:when>
                  <c:otherwise>
                    <p class="card-groth down">
                      <i class="ri-arrow-down-line"></i>
                        ${-category.perSales}%
                      <span>tháng trước</span>
                    </p>
                  </c:otherwise>
                </c:choose>
              </div>
            </div>
          </div>
          <div class="col-xl-4 col-md-12">
            <div class="cr-card">
              <div class="cr-card-content label-card">
                <div class="title">
                  <span class="icon icon-3"><i class="ri-product-hunt-line"></i></span>
                  <div class="growth-numbers">
                    <h4>Số sách đã bán (quyển)</h4>
                    <h5>${category.booksSold}</h5>
                  </div>
                </div>
                <c:choose>
                  <c:when test="${category.perBooksSold == 0}">
                    <p class="card-groth up">
                      <i class="ri-arrow-up-line non-growth"></i>
                      <span class="non-growth m-0">${category.perBooksSold}%</span>
                      <span>tháng trước</span>
                    </p>
                  </c:when>
                  <c:when test="${category.perBooksSold > 0}">
                    <p class="card-groth up">
                      <i class="ri-arrow-up-line"></i>
                        ${category.perBooksSold}%
                      <span>tháng trước</span>
                    </p>
                  </c:when>
                  <c:otherwise>
                    <p class="card-groth down">
                      <i class="ri-arrow-down-line"></i>
                        ${-category.perBooksSold}%
                      <span>tháng trước</span>
                    </p>
                  </c:otherwise>
                </c:choose>
              </div>
            </div>
          </div>
          <div class="col-xl-4 col-md-12">
            <div class="cr-card">
              <div class="cr-card-content label-card">
                <div class="title">
                  <span class="icon icon-4"><i class="ri-exchange-dollar-line"></i></span>
                  <div class="growth-numbers">
                    <h4>Giá trị sách đã bán (VNĐ)</h4>
                    <h5>${category.valueBooksSold}₫</h5>
                  </div>
                </div>
                <c:choose>
                  <c:when test="${category.perValueBooksSold == 0}">
                    <p class="card-groth up">
                      <i class="ri-arrow-up-line non-growth"></i>
                      <span class="non-growth m-0">${category.perValueBooksSold}%</span>
                      <span>tháng trước</span>
                    </p>
                  </c:when>
                  <c:when test="${category.perValueBooksSold > 0}">
                    <p class="card-groth up">
                      <i class="ri-arrow-up-line"></i>
                        ${category.perValueBooksSold}%
                      <span>tháng trước</span>
                    </p>
                  </c:when>
                  <c:otherwise>
                    <p class="card-groth down">
                      <i class="ri-arrow-down-line"></i>
                        ${-category.perValueBooksSold}%
                      <span>tháng trước</span>
                    </p>
                  </c:otherwise>
                </c:choose>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4 ps-md-0 pe-md-0">
            <div class="cr-card vendor-profile card-3d-deep">
              <div class="cr-card-content">
                <h3><b>Thể loại chính</b></h3>
                <span class="cr-sub-cat-list">
                                    <c:forEach var="subCategory" items="${category.topSubCategory}" varStatus="status">
                                        <div class="d-flex align-items-center">
                                            <c:choose>
                                              <c:when test="${status.index == 0}">
                                                <p class="me-2"><b class="color-secondary">1</b></p>
                                                <div class="top-category">
                                                    ${subCategory}
                                                </div>
                                              </c:when>
                                              <c:when test="${status.index == 1}">
                                                <p class="me-2"><b class="color-warning">2</b></p>
                                                <div class="top-category">
                                                    ${subCategory}
                                                </div>
                                              </c:when>
                                              <c:when test="${status.index == 2}">
                                                <p class="me-2"><b class="color-primary">3</b></p>
                                                <div class="top-category">
                                                    ${subCategory}
                                                </div>
                                              </c:when>

                                              <c:otherwise>
                                              </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </c:forEach>
                                </span>
                <br>
                <h3><b>Tình trạng sách</b></h3>
                <div class="cr-vendor-info">
                  <ul>
                    <li><span class="label">Đã bán :</span>&nbsp;
                      <b>${category.booksSold}</b> quyển
                    </li>
                    <li><span class="label">Tồn kho :</span>&nbsp;
                      <b>${category.booksInStock}</b> quyển
                    </li>
                    <li><span class="label">Bị hủy đơn :</span>&nbsp;
                      <b>${category.booksCancelled}</b> quyển
                    </li>
                    <li><span class="label">Bị hoàn trả :</span>&nbsp;
                      <b>${category.booksReturned}</b> quyển
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-8 pe-md-0">
            <div class="cr-card vendor-profile card-3d-deep">
              <div class="cr-card-content">
                <h3><b>Thống kê tháng này</b></h3>
                <div class="cr-vendor-info">
                  <ul>
                    <div class="d-flex align-items-center">
                      <li>
                        <i class="ri-shopping-basket-line color-primary ps-1 pe-1 icon-large"></i>
                        <span class="label">Lượt bán (theo đơn) :</span>&nbsp;
                        <b>${category.salesThisMonth}</b> lượt
                      </li>
                    </div>
                    <div class="d-flex align-items-center">
                      <li>
                        <i class="ri-book-mark-line color-success ps-1 pe-1 icon-large"></i>
                        <span class="label">Đã bán :</span>&nbsp;
                        <b>${category.booksThisMonth}</b> quyển
                      </li>
                    </div>
                    <div class="d-flex align-items-center">
                      <li>
                        <i class="ri-money-dollar-circle-line color-warning ps-1 pe-1 icon-large"></i>
                        <span class="label">Doanh thu :</span>&nbsp;
                        <b class="value-books-sold-this-month">${category.revenueThisMonth} VNĐ</b>
                      </li>
                    </div>
                  </ul>
                </div>
                <br>
                <h3><b>Thống kê theo đơn</b></h3>
                <div class="cr-vendor-info">
                  <ul class="custom-char-list">
                    <li><span class="label">Đã hoàn tất :</span>&nbsp;
                      <b>${category.ordersCompleted}</b> đơn, giá trị sách <b class="value-books-sold">${category.valueOrdersCompleted}₫</b>
                    </li>
                    <li><span class="label">Đang chờ duyệt :</span>&nbsp;
                      <b>${category.ordersWaiting}</b> đơn, giá trị sách <b>${category.valueOrdersWaiting} VNĐ</b>
                    </li>
                    <li><span class="label">Đang gói hàng :</span>&nbsp;
                      <b>${category.orderPacking}</b> đơn, giá trị sách <b>${category.valueOrderPacking}₫</b>
                    </li>
                    <li><span class="label">Đang vận chuyển :</span>&nbsp;
                      <b>${category.orderShipping}</b> đơn, giá trị sách <b>${category.valueOrderShipping}₫</b>
                    </li>
                    <li><span class="label">Bị hủy :</span>&nbsp;
                      <b>${category.ordersCancelled}</b> đơn, giá trị sách <b>${category.valueOrdersCancelled}₫</b>
                    </li>
                    <li><span class="label">Yêu cầu hoàn trả :</span>&nbsp;
                      <b>${category.ordersRequestRefund}</b> đơn, giá trị sách <b>${category.valueOrdersRequestRefund}₫</b>
                    </li>
                    <li><span class="label">Đã hoàn trả :</span>&nbsp;
                      <b>${category.ordersRefunded}</b> đơn, giá trị sách <b>${category.valueOrdersRefunded}₫</b>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="cr-card card-3d-deep">
            <div class="cr-card-content mb-10">
              <div class="row title-fullScript">
                Giới thiệu danh mục
              </div>
              <div class="row">
                <div class="fullScript">
                  ${category.fullScript}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script>const contextPath = "<%=request.getContextPath() %>";</script>
<script src="${pageContext.request.contextPath}/assets/owner/js/manage/manage-category.js" defer></script>

<style>
  .top-category {
    background-color: rgba(72, 85, 104, 0.08);
    color: #485568;
    font-size: 80%;
    border-radius: 10px;
    padding: 5px;
    margin: 5px 0 5px 0;
  }
  .non-growth {
    color: slategray;
  }
  .start-rate {
    color: #FFD43B;
    font-size: 20px;
  }
  .icon-large {
    font-size: 20px;
  }
  .value-books-sold-this-month {
    background-color: #ffedde;
    color: #ffa04f;
    font-weight: bold;
    border-radius: 7px;
    padding: 2px;
  }
  .value-books-sold {
    background-color: #dcfcee;
    color: #30cb83;
    font-weight: bold;
    border-radius: 7px;
    padding: 2px;
  }
  .title-fullScript {
    font-size: 18px;
    padding-bottom: 20px;
    font-family: 'Be Vietnam Pro', sans-serif;
    font-weight: 800;
    color: #484d54;
  }
  div.fullScript, div.fullScript p {
    width: 100%;
    padding: 10px;
    font-size: 15px;
    color: slategray;
    text-align: justify;
    box-sizing: border-box;
  }
  .custom-char-list {
    list-style: none;
    margin-left: 10px;
  }
  .custom-char-list li::before {
    content: "●";
    color: slategray;
    font-size: 16px;
    margin-right: 10px;
  }
  .card-3d-deep {
    background: #fff;
    border-radius: 10px;
    padding: 20px;
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
</style>