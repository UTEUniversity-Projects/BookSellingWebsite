<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <div class="d-flex align-items-center">
                    <div class="page-title">
                        <h5><b>Danh sách tác giả</b></h5>
                    </div>
                    <a href="${pageContext.request.contextPath}/owner/author/create" class="cr-btn default-btn color-primary">
                        Thêm tác giả
                    </a>
                </div>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/owner/ecommerce"><b>Biblio</b></a></li>
                    <li><b>Danh sách tác giả</b></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card card-default product-list card-3d-deep">
                    <div class="cr-card-content">
                        <div class="table-responsive">
                            <table id="customer-data-table" class="item-data-table table table-hover rounded-table responsive-table">
                                <thead class="table-secondary">
                                    <tr>
                                        <th style="width: 7%">#</th>
                                        <th style="width: 20%;">Họ và tên</th>
                                        <th style="width: 8%;">Tác phẩm</th>
                                        <th style="width: 8%;">Đánh giá</th>
                                        <th style="width: 10%;">Doanh thu</th>
                                        <th style="width: 37%;">Giới thiệu</th>
                                        <th style="width: 10%;">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${authors}">
                                        <tr class="item-row" data-id="${item.id}">
                                            <td>
                                                <img
                                                        class="tbl-thumb image-shadow rounded-3"
                                                        src="${pageContext.request.contextPath}${item.avatar}"
                                                        alt="Author Image"
                                                />
                                            </td>
                                            <td>
                                                <div>
                                                    <span class="row-highlight">${item.name}</span><br>
                                                    <span class="row-sub-content">Tham gia: ${item.joinAt}</span>
                                                </div>
                                            </td>
                                            <td><span class="badge bg-primary">${item.works}</span></td>
                                            <td>
                                                <div class="d-flex align-items-center">
                                                    <h6 class="avg-rate">${item.avgRate}</h6>
                                                    <i class="ri-star-fill ps-2" style="color: #FFD43B; font-size: 20px;"></i>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="label-card d-flex align-items-center">
                                                    <c:choose>
                                                        <c:when test="${item.perValueBooksSold >= 0}">
                                                            <p class="card-groth up" style="margin-top: 0">
                                                                <i class="ri-arrow-up-line"></i>
                                                                    ${item.perValueBooksSold}%
                                                            </p>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <p class="card-groth down" style="margin-top: 0">
                                                                <i class="ri-arrow-down-line"></i>
                                                                    ${-item.perValueBooksSold}%
                                                            </p>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </td>
                                            <td class="row-introduction">${item.introduction}</td>
                                            <td>
                                                <div class="d-flex justify-content-center">
                                                    <button type="button"
                                                            class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                            data-bs-toggle="dropdown" aria-haspopup="true"
                                                            aria-expanded="false" data-display="static">
                                                        <span class="sr-only"><i class="ri-settings-3-line"></i></span>
                                                    </button>
                                                    <div class="dropdown-menu">
                                                        <a class="dropdown-item" href="#" onclick="rowAction(${item.id}, 'view'); return false;" data-value="view">Chi tiết</a>
                                                        <a class="dropdown-item" href="#" onclick="rowAction(${item.id}, 'update'); return false;" data-value="update">Chỉnh sửa</a>
                                                        <a class="dropdown-item" href="#" onclick="rowAction(${item.id}, 'delete'); return false;" data-value="delete">Xóa</a>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<link id="popup-css" href="${pageContext.request.contextPath}/assets/owner/css/popup.css" rel="stylesheet"/>
<div id="delete-popup" class="popup-overlay" style="display: none;">
    <div class="popup-content popup-danger">
        <div id="lottie-danger" class="popup-gif"></div>
        <p class="popup-message">Bạn có chắc chắn muốn xóa không?</p>
        <div class="popup-buttons">
            <button id="confirm-delete" class="cr-btn default-btn color-danger">Xác nhận</button>
            <button id="cancel-delete" class="cr-btn default-btn color-light">Hủy</button>
        </div>
    </div>
</div>
<div id="success-popup" class="popup-overlay" style="display: none;">
    <div class="popup-content popup-success">
        <div id="lottie-success" class="popup-gif"></div>
        <p class="popup-message">Xóa thành công!</p>
        <div class="popup-buttons">
            <button id="success-ok" class="cr-btn default-btn color-success">OK</button>
        </div>
    </div>
</div>
<div id="fail-popup" class="popup-overlay" style="display: none;">
    <div class="popup-content popup-fail">
        <div id="lottie-fail" class="popup-gif"></div>
        <p class="popup-message">Xóa thất bại, xin thử lại sau!</p>
        <div class="popup-buttons">
            <button id="fail-ok" class="cr-btn default-btn color-light">OK</button>
        </div>
    </div>
</div>

<script>const contextPath = "<%=request.getContextPath() %>";</script>
<script src="${pageContext.request.contextPath}/assets/owner/js/event-handler/table-event.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/makeup-data/format-data.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/manage/manage-author.js" defer></script>

<style>
    .page-title {
        margin-right: 20px;
    }
    .avg-rate {
        margin: 0;
        font-size: 110%;
        font-weight: bold;
        color: #2b3647;
        font-family: Nunito, sans-serif
    }
    table.rounded-table {
        border-radius: 1.5%;
        overflow: hidden;
    }
    table td div span.row-highlight {
        font-family: 'Nunito', sans-serif;
        font-size: 120%;
        font-weight: bold;
        color: #2b3647;
    }
    table td div span.row-sub-content {
        font-family: "Be Vietnam Pro", sans-serif;
        font-size: 90%;
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
    table thead {
        pointer-events: none;
    }
    .responsive-table {
        width: 100%;
        border-collapse: separate;
        border-spacing: 0;

        td {
            padding: 10px;
            text-align: left;
            position: relative;
            background-color: #fff;
            border: none;
        }

        tr {
            position: relative;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
    }
    .dropdown-menu {
        position: absolute;
        z-index: 1050;
        display: none;
        transform: translate3d(0, 0, 0);
        background-color: #fff;
        box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    }
    .dropdown-menu.show {
        display: block;
    }
</style>
