<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/staff/product-dashboard">Biblio</a></li>
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
                            <p id="order-id" class="cr-card-id" data-order-id="${order.id}">Mã đơn hàng #${order.id}</p>
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
                            <p class="cr-card-shipping">
                                <i class="ri-truck-line"></i>
                                ${order.shippingUnit}
                            </p>
                        </div>
                        <div>
                            <p id="order-status" class="cr-card-status cr-card-status--${order.statusStyle}">
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
                                        <th>Khuyến mãi</th>
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
                                                    -20%
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
                                <div class="summary-value price-value">${order.shippingFee}</div>
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
                                <div class="summary-value">${order.paymentMethod}</div>
                            </div>
                        </div>
                    </div>

                    <c:if test="${order.status == 'REQUEST_REFUND' || order.status == 'WAITING_CONFIRMATION'}">
                        <div class="btn-container cr-card-content d-grid gap-3 d-md-flex justify-content-md-end">
                            <button id="btn-cancel" class="btn btn-outline-danger">Từ chối</button>
                            <button id="btn-confirm" class="cr-btn-primary">Xác nhận</button>
                        </div>
                    </c:if>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- region Modal -->
<%--FeedbackModal--%>
<div class="modal fade" id="cancelOrderModal" tabindex="-1" aria-labelledby="cancelOrderModalLabel" aria-hidden="true">
    <input class="order-id" value="" hidden>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="cancelOrderModalLabel">Thông báo tới khách hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="feedbackForm">
                    <div class="mb-3">
                        <label for="cancelContent" class="form-label">Lý do từ chối</label>
                        <textarea id="cancelContent" name="cancelContent" class="form-control"
                                  placeholder="Nhập lý do ..."
                                  rows="4">
                        </textarea>
                        <p id="error-message">Vui lòng nhập lý do!</p>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                <button type="button" class="btn cr-btn-primary" id="sendReason">Gửi</button>
            </div>
        </div>
    </div>
</div>

<%--ConfirmModal--%>
<div class="modal fade" id="confirmOrderModal" tabindex="-1" aria-labelledby="confirmOrderModalLabel" aria-hidden="true">
    <input class="order-id" value="" hidden>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmOrderModalLabel">Bạn có chắc muốn xác nhận đơn hàng này không?</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                <!-- Gửi giá trị action="confirm" qua nút Xác nhận -->
                <button
                        type="button"
                        class="btn cr-btn-primary"
                        id="confirmOrder"
                        data-action="confirm">Xác nhận</button>
            </div>
        </div>
    </div>
</div>

<!-- endregion -->

<script src="${pageContext.request.contextPath}/assets/staff/js/order-details.js" defer></script>
