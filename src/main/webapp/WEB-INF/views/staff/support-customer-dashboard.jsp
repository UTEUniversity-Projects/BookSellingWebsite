<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                                            data-value="NOT_RESPONDED"
                                    >
                                        Chưa phản hồi
                                    </a>
                                    <a
                                            class="dropdown-item"
                                            href="#"
                                            data-value="RESPONDED"
                                    >
                                        Đã phản hồi
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="cr-card-content card-default">
                        <div class="table-responsive">
                            <table id="support-cus-list" class="table">
                                <thead>
                                <tr>
                                    <th>Khách hàng</th>
                                    <th>Yêu cầu</th>
                                    <th>Ngày gửi</th>
                                    <th>Trạng thái</th>
                                    <th width="11%">Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${supportRequests}" var="request">
                                    <tr>
                                        <td>${request.customer.fullName}</td>
                                        <td>${request.title}</td>
                                        <td>${request.createdAt}</td>
                                        <td data-status="${request.status}">
                                            <span class="status ${request.status == 'RESPONDED' ? 'status__completed' : 'status__pending'}">
                                                    ${request.status == 'RESPONDED' ? 'Đã phản hồi' : 'Chưa phản hồi'}
                                            </span>
                                        </td>
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
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
