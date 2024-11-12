<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <ul>
                    <li><a href="/staff/product-dashboard">Biblio</a></li>
                    <li><a href="${pageContext.request.contextPath}/staff/order-dashboard">Danh sách đơn hàng</a></li>
                    <li>Chi tiết đơn hàng</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card">
                    <div class="cr-card-header">
                        <div class="cr-card-info">
                            <p class="cr-card-id">Mã đơn hàng #${order.id}</p>
                            <p class="cr-card-customer">
                                <i class="ri-account-pin-box-line"></i>
                                ${order.customerName}
                            </p>
                            <p class="cr-card-phone-number">
                                <i class="ri-phone-line"></i>
                                ${order.phoneNumber}
                            </p>
                            <p class="cr-card-location">
                                <i class="ri-map-pin-line"></i>
                                ${order.address}
                            </p>
                            <p class="cr-card-date">
                                <i class="ri-calendar-2-line"></i>
                                ${order.orderDate}
                            </p>
                            <p class="cr-card-note">
                                <i class="ri-sticky-note-line"></i>
                                ${order.note}
                            </p>
                        </div>
                        <div>
                            <p class="cr-card-status cr-card-status--${order.statusStyle}">
                                ${order.statusDisplay}
                            </p>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-card-content-header">
                            <p class="heading">Danh sách sản phẩm</p>
                        </div>
                        <div class="cr-card-content-body">
                            <div class="table-responsive">
                                <table
                                        id="order-product-data-table"
                                        class="table table-hover"
                                >
                                    <thead>
                                    <tr>
                                        <th width="5%"></th>
                                        <th>Sản phẩm</th>
                                        <th>Trạng thái</th>
                                        <th>Số lượng</th>
                                        <th>Giá</th>
                                        <th>Tổng tiền</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="product" items="${order.products}">
                                        <tr>
                                            <td>
                                                <img
                                                    class="tbl-thumb"
                                                    src="${pageContext.request.contextPath}${product.imagePath}"
                                                    alt="${product.title}"
                                                />
                                            </td>
                                            <td>${product.title}</td>
                                            <td>
                                                <span class="status status__pending">
                                                    Đang đóng gói
                                                </span>
                                            </td>
                                            <td>${product.quantity}</td>
                                            <td class="price-value">${product.sellingPrice}</td>
                                            <td class="price-value">${product.totalPrice}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="price-summary">
                            <div class="summary-row">
                                <div class="summary-label">Tổng tiền hàng</div>
                                <div class="summary-value price-value">${order.totalPrice}</div>
                            </div>
                            <div class="summary-row">
                                <div class="summary-label">Phí vận chuyển</div>
                                <div class="summary-value price-value">42500</div>
                            </div>
                            <div class="summary-row">
                                <div class="summary-label">Giảm giá phí vận chuyển</div>
                                <div class="summary-value price-value minus-value">42500</div>
                            </div>
                            <div class="summary-row">
                                <div class="summary-label">Voucher từ Shop</div>
                                <div class="summary-value price-value minus-value">42500</div>
                            </div>
                            <div class="summary-row total-row">
                                <div class="summary-label">Thành tiền</div>
                                <div class="summary-value price-value total-value">42500</div>
                            </div>
                            <div class="summary-row">
                                <div class="summary-label">Phương thức thanh toán</div>
                                <div class="summary-value">Momo</div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content d-grid gap-3 d-md-flex justify-content-md-end">
                        <button class="btn btn-success" onclick="showSuccessToast();">Xác nhận</button>
                        <button class="btn btn-outline-danger" onclick="showErrorToast();">Từ chối</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/assets/staff/js/order-details.js" defer></script>
