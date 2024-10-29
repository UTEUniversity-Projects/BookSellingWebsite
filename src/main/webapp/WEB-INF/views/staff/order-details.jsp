<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <ul>
                    <li><a href="#">Biblio</a></li>
                    <li><a href="/staff/order-dashboard">Danh sách đơn hàng</a></li>
                    <li>Chi tiết đơn hàng</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card">
                    <div class="cr-card-header">
                        <div class="cr-card-info">
                            <p class="cr-card-id">Mã đơn hàng #123</p>
                            <p class="cr-card-date">
                                <i class="ri-calendar-2-line"></i>
                                Aug 17, 2020, 5:48 (ET)
                            </p>
                        </div>
                        <div>
                            <p class="cr-card-status cr-card-status--completed">
                                Đã hoàn thành
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
                                    <tr>
                                        <td>
                                            <img
                                                class="tbl-thumb"
                                                src="/assets/staff/img/product/1.jpg"
                                                alt="Product Image"
                                            />
                                        </td>
                                        <td>Avira Venusio</td>
                                        <td>
                                            <span class="status status__pending">
                                                Đang đóng gói
                                            </span>
                                        </td>
                                        <td>3</td>
                                        <td>100.000VND</td>
                                        <td>300.300VND</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img
                                                class="tbl-thumb"
                                                src="/assets/staff/img/product/1.jpg"
                                                alt="Product Image"
                                            />
                                        </td>
                                        <td>Avira Venusio</td>
                                        <td>
                                            <span class="status status__completed">
                                                Sẳn sàng
                                            </span>
                                        </td>
                                        <td>3</td>
                                        <td>100.000VND</td>
                                        <td>300.300VND</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img
                                                class="tbl-thumb"
                                                src="/assets/staff/img/product/1.jpg"
                                                alt="Product Image"
                                            />
                                        </td>
                                        <td>Avira Venusio</td>
                                        <td>
                                            <span class="status status__pending">
                                                Đang đóng gói
                                            </span>
                                        </td>
                                        <td>3</td>
                                        <td>100.000VND</td>
                                        <td>300.300VND</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <img
                                                class="tbl-thumb"
                                                src="/assets/staff/img/product/1.jpg"
                                                alt="Product Image"
                                            />
                                        </td>
                                        <td>Avira Venusio</td>
                                        <td>
                                            <span class="status status__completed">
                                                Sẳn sàng
                                            </span>
                                        </td>
                                        <td>3</td>
                                        <td>100.000VND</td>
                                        <td>300.300VND</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="row align-items-start">
                            <div class="col-md-6">
                                <dl class="row">
                                    <dt class="col-sm-6">Subtotal:</dt>
                                    <dd class="col-sm-6">$65.00</dd>
                                    <dt class="col-sm-6">Shipping fee:</dt>
                                    <dd class="col-sm-6">$0.00</dd>
                                    <dt class="col-sm-6">Tax:</dt>
                                    <dd class="col-sm-6">$7.00</dd>
                                    <dt class="col-sm-6">Total:</dt>
                                    <dd class="col-sm-6">$65.00</dd>
                                    <dt class="col-sm-6">Amount paid:</dt>
                                    <dd class="col-sm-6">$65.00</dd>
                                </dl>
                            </div>
                            <div class="col-md-6 text-end">
                                <button class="btn btn-success">Xác nhận</button>
                                <button class="btn btn-danger">Từ chối</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>