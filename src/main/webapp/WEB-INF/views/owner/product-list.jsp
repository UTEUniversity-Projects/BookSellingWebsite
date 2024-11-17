<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Danh sách sản phẩm</h5>
                <ul>
                    <li><a href="#">Biblio</a></li>
                    <li>Danh sách sản phẩm</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card card-default product-list">
                    <div class="cr-card-content ">
                        <div class="table-responsive">
                            <table id="product_list" class="table" style="width:100%">
                                <thead>
                                <tr>
                                    <th>Ảnh</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Giá bán</th>
                                    <th>Khuyến mãi</th>
                                    <th>Đã bán</th>
                                    <th>Tồn kho</th>
                                    <th>Trạng thái</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="book" items="${books}">
                                    <tr class="product-row" data-href="/owner/product-details?id=${book.id}">
                                        <td>
                                            <img
                                                    class="tbl-thumb"
                                                    src="${pageContext.request.contextPath}${book.imageUrl}"
                                                    alt="Product Image"
                                            />
                                        </td>
                                        <td>${book.title}</td>
                                        <td class="price-value">${book.price}</td>
                                        <td>${book.quantity}</td>
                                        <td>${book.soldCount}</td>
                                        <td>${book.publicationDate}</td>
                                        <td data-status="ON_SALE">
                                            <span class="status status__on_sale">Đang mở bán</span>
                                        </td>
                                        <td>
                                            <div class="d-flex justify-content-center">
                                                <button type="button"
                                                        class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                        data-bs-toggle="dropdown" aria-haspopup="true"
                                                        aria-expanded="false" data-display="static">
                                                        <span class="sr-only">
                                                            <i class="ri-settings-3-line"></i>
                                                        </span>
                                                </button>
                                                <div class="dropdown-menu">
                                                    <a class="dropdown-item" href="#">Xem chi tiết</a>
                                                    <a class="dropdown-item" href="#">Chỉnh sửa</a>
                                                    <a class="dropdown-item" href="#">Xóa sản phẩm</a>
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
