<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Danh sách tác giả</h5>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/owner/ecommerce">Biblio</a></li>
                    <li>Danh sách tác giả</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card card-default product-list">
                    <div class="cr-card-content">
                        <div class="table-responsive">
                            <table id="author-data-table" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Mã #</th>
                                    <th>Họ và tên</th>
                                    <th>Giới thiệu</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="author" items="${authors}">
                                    <tr class="author-row" data-href="/owner/author-profile?id=${author.id}">
                                        <td>${author.id}</td>
                                        <td>${author.name}</td>
                                        <td>${author.introduction}</td>
                                        <td>
                                            <div class="d-flex justify-content-start">
                                                <button type="button"
                                                        class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                        data-bs-toggle="dropdown" aria-haspopup="true"
                                                        aria-expanded="false" data-display="static">
                                                    <span class="sr-only"><i class="ri-settings-3-line"></i></span>
                                                </button>
                                                <div class="dropdown-menu">
                                                    <a class="dropdown-item pop-positioned-timeout" href="#">Chỉnh sửa</a>
                                                    <a class="dropdown-item pop-positioned-timeout" href="#">Xóa</a>
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
