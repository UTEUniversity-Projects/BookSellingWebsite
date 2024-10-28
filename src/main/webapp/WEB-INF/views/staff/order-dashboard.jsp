<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <ul>
                    <li><a href="index.html">Carrot</a></li>
                    <li>Danh sách đơn hàng</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card" id="ordertbl">
                    <div class="cr-card-header">
                        <h4 class="cr-card-title">Danh sách đơn hàng</h4>
                        <div class="header-tools">
                            <a href="javascript:void(0)" class="m-r-10 cr-full-card">
                                <i class="ri-fullscreen-line"></i>
                            </a>
                            <div class="cr-date-range dots m-r-10">
                                <span></span>
                            </div>
                            <div>
                                <button
                                    type="button"
                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                    data-bs-toggle="dropdown"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                                    data-display="static"
                                >
                                    <span id="selected-text">Tất cả</span>
                                    <span class="sr-only">
                                        <i class="ri-arrow-down-s-line"></i>
                                    </span>
                                </button>
                                <div class="dropdown-menu dropdown-menu__status">
                                    <a class="dropdown-item" href="#" data-value="ALL">
                                        Tất cả
                                    </a>
                                    <a
                                        class="dropdown-item"
                                        href="#"
                                        data-value="WAITING_CONFIRMATION"
                                    >
                                        Chờ xác nhận
                                    </a>
                                    <a class="dropdown-item" href="#" data-value="PACKING">
                                        Đang đóng gói
                                    </a>
                                    <a class="dropdown-item" href="#" data-value="SHIPPING">
                                        Đang vận chuyển
                                    </a>
                                    <a
                                        class="dropdown-item"
                                        href="#"
                                        data-value="COMPLETE_DELIVERY"
                                    >
                                        Đã hoàn thành
                                    </a>
                                    <a class="dropdown-item" href="#" data-value="CANCELED">
                                        Đã hủy
                                    </a>
                                    <a
                                        class="dropdown-item"
                                        href="#"
                                        data-value="REQUEST_REFUND"
                                    >
                                        Yêu cầu hoàn trả
                                    </a>
                                    <a class="dropdown-item" href="#" data-value="REFUNDED">
                                        Đã hoàn trả
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content card-default">
                        <div class="table-responsive">
                            <table id="order-data-table" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Khách hàng</th>
                                    <th>Ngày lập đơn</th>
                                    <th>Tổng tiền</th>
                                    <th>Thanh toán</th>
                                    <th>Trạng thái</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="order-row" data-href="/staff/order-details">
                                    <td class="token">#fx2650</td>
                                    <td>Avira Venusio</td>
                                    <td>10/14/2024</td>
                                    <td>1.000.000VND</td>
                                    <td>Momo</td>
                                    <td data-status="WAITING_CONFIRMATION">
                                        <span class="status status__pending">
                                            Chờ xác nhận
                                        </span>
                                    </td>
                                </tr>
                                <tr class="order-row" data-href="/staff/order-details">
                                    <td class="token">#fx2650</td>
                                    <td>Bvira Venusio</td>
                                    <td>10/14/2024</td>
                                    <td>2.000.000VND</td>
                                    <td>Momo</td>
                                    <td data-status="PACKING">
                                        <span class="status status__packing">
                                            Đang đóng gói
                                        </span>
                                    </td>
                                </tr>
                                <tr class="order-row" data-href="/staff/order-details">
                                    <td class="token">#fx2650</td>
                                    <td>Cvira Venusio</td>
                                    <td>10/14/2024</td>
                                    <td>5.000.000VND</td>
                                    <td>Momo</td>
                                    <td data-status="SHIPPING">
                                        <span class="status status__shipping">
                                            Đang vận chuyển
                                        </span>
                                    </td>
                                </tr>
                                <tr class="order-row" data-href="/staff/order-details">
                                    <td class="token">#fx2650</td>
                                    <td>Dvira Venusio</td>
                                    <td>10/14/2024</td>
                                    <td>3.000.000VND</td>
                                    <td>Momo</td>
                                    <td data-status="COMPLETE_DELIVERY">
                                        <span class="status status__completed">
                                            Đã hoàn thành
                                        </span>
                                    </td>
                                </tr>
                                <tr class="order-row" data-href="/staff/order-details">
                                    <td class="token">#fx2650</td>
                                    <td>Evira Venusio</td>
                                    <td>10/14/2024</td>
                                    <td>7.000.000VND</td>
                                    <td>Momo</td>
                                    <td data-status="CANCELED">
                                        <span class="status status__canceled">
                                            Đã hủy
                                        </span>
                                    </td>
                                </tr>
                                <tr class="order-row" data-href="/staff/order-details">
                                    <td class="token">#fx2650</td>
                                    <td>Avira Venusio</td>
                                    <td>10/14/2024</td>
                                    <td>500.000VND</td>
                                    <td>Momo</td>
                                    <td data-status="REQUEST_REFUND">
                                        <span class="status status__request_refund">
                                            Yêu cầu trả hàng
                                        </span>
                                    </td>
                                </tr>
                                <tr class="order-row" data-href="/staff/order-details">
                                    <td class="token">#fx2650</td>
                                    <td>Jvira Venusio</td>
                                    <td>10/14/2024</td>
                                    <td>10.000.000VND</td>
                                    <td>Momo</td>
                                    <td data-status="REFUNDED">
                                        <span class="status status__refunded">
                                            Hoàn trả
                                        </span>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
