<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href='https://fonts.googleapis.com/css?family=Nunito' rel='stylesheet'>
<style>
    table.rounded-table {
        border-radius: 1.5%;
        overflow: hidden;
    }
    table td span.row-book-sold {
        background-color: #d3f4e5;
        color: #30cb83;
        font-weight: bold;
        border-radius: 10px;
        padding: 5px;
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
        z-index: 1050; /* Cao hơn các phần tử khác */
        display: none; /* Ẩn mặc định */
        transform: translate3d(0, 0, 0); /* Giữ vị trí chính xác */
        background-color: #fff;
        box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Đổ bóng cho rõ */
    }

    .dropdown-menu.show {
        display: block; /* Hiển thị khi có class 'show' */
    }

</style>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5><b>Danh sách tác giả</b></h5>
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
                            <table id="customer-data-table" class="author-data-table table table-hover rounded-table responsive-table">
                                <thead class="table-secondary">
                                    <tr>
                                        <th style="width: 7%">#</th>
                                        <th style="width: 20%;">Họ và tên</th>
                                        <th style="width: 8%;">Tác phẩm</th>
                                        <th style="width: 12%;">Sách đã bán</th>
                                        <th style="width: 43%;">Giới thiệu</th>
                                        <th style="width: 10%;">Thao tác</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="author" items="${authors}">
                                        <tr class="author-row" data-id="${author.id}">
                                            <td>
                                                <img
                                                        class="tbl-thumb image-shadow rounded-3"
                                                        src="${pageContext.request.contextPath}${author.avatar}"
                                                        alt="Author Image"
                                                />
                                            </td>
                                            <td>
                                                <div>
                                                    <span class="row-highlight">${author.name}</span><br>
                                                    <span class="row-sub-content">Tham gia: ${author.joinAt}</span>
                                                </div>
                                            </td>
                                            <td><span class="badge bg-primary">999</span></td>
                                            <td><span class="row-book-sold">10.000.000</span></td>
                                            <td class="row-introduction" data-max-length="150">${author.introduction}</td>
                                            <td>
                                                <div class="d-flex justify-content-center">
                                                    <button type="button"
                                                            class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                            data-bs-toggle="dropdown" aria-haspopup="true"
                                                            aria-expanded="false" data-display="static">
                                                        <span class="sr-only"><i class="ri-settings-3-line"></i></span>
                                                    </button>
                                                    <div class="dropdown-menu">
                                                        <a class="dropdown-item" href="#" onclick="authorAction(${author.id}, 'view'); return false;" data-value="view">Chi tiết</a>
                                                        <a class="dropdown-item" href="#" onclick="authorAction(${author.id}, 'update'); return false;" data-value="update">Chỉnh sửa</a>
                                                        <a class="dropdown-item" href="#" onclick="authorAction(${author.id}, 'delete'); return false;" data-value="delete">Xóa</a>
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
<script>const contextPath = "<%=request.getContextPath() %>";</script>
<script src="${pageContext.request.contextPath}/assets/owner/js/table-event.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/format-data.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/manage-author.js" defer></script>
