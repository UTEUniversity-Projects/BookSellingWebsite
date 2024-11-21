<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="cr-main-content">
    <div class="container-fluid">
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <ul>
                    <li><a href="index.html">Carrot</a></li>
                    <li>Trung tâm hỗ trợ khách hàng</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card product-list" id="ordertbl">
                    <div class="cr-card-header">
                        <h4 class="cr-card-title">Trung tâm hỗ trợ khách hàng</h4>
                        <div class="header-tools">
                            <!-- Dropdown Lọc Trạng Thái -->
                            <div>
                                <button
                                        type="button"
                                        class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                        data-bs-toggle="dropdown"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                >
                                    <span id="selected-text">Tất cả</span>
                                    <span class="sr-only">
                                        <i class="ri-arrow-down-s-line"></i>
                                    </span>
                                </button>
                            </div>
                        </div>
                    </div>

                    <div class="cr-card-content card-default">
                        <!-- Bảng Yêu Cầu -->
                        <div class="table-responsive">
                            <table id="support-cus-list" class="table">
                                <thead>
                                <tr>
                                    <th>Khách hàng</th>
                                    <th>Yêu cầu</th>
                                    <th>Ngày gửi</th>
                                    <th width="11%">Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${supportRequests}" var="request">
                                    <tr>
                                        <td><c:out value="${request.customer.fullName}" /></td>
                                        <td><c:out value="${request.title}" /></td>
                                        <td>${request.createdAt}</td>
                                        <td>
                                            <a class="btn btn-outline-success"
                                               href="${pageContext.request.contextPath}/staff/support-customer-dashboard?action=detail&id=${request.id}">
                                                Phản hồi
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- Phân Trang -->
                        <nav>
                            <ul class="pagination">
                                <li class="page-item">
                                    <a class="page-link" href="?page=1" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <!-- Render dynamic page numbers -->
                                <li class="page-item"><a class="page-link" href="?page=1">1</a></li>
                                <li class="page-item"><a class="page-link" href="?page=2">2</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="?page=3" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
