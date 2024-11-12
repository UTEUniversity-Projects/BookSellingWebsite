<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="cr-main-content">
    <div class="container-fluid">
        <div class="cr-page-title">
            <h4 class="cr-card-title">Phản hồi yêu cầu khách hàng</h4>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="cr-card">
                    <div class="cr-card-header">
                        <h4 class="cr-card-title">Chi tiết yêu cầu khách hàng</h4>
                    </div>
                    <div class="cr-card-content">
                        <form id="responseForm" action="${pageContext.request.contextPath}/staff/support-customer-dashboard" method="POST">
                            <input type="hidden" name="action" value="respond">
                            <input type="hidden" name="id" value="${supportRequest.id}">

                            <div class="mb-3">
                                <label for="customerName" class="form-label">Tên khách hàng</label>
                                <input type="text" class="form-control" id="customerName" value="${supportRequest.customer.fullName}" readonly>
                            </div>

                            <div class="mb-3">
                                <label for="requestDate" class="form-label">Ngày gửi yêu cầu</label>
                                <input type="text" class="form-control" id="requestDate" value="${supportRequest.createdAt}" readonly>
                            </div>

                            <div class="mb-3">
                                <label for="requestDetails" class="form-label">Yêu cầu</label>
                                <textarea class="form-control" id="requestDetails" rows="3" readonly>${supportRequest.requestContent}</textarea>
                            </div>

                            <div class="mb-3">
                                <label for="supportContent" class="form-label">Nội dung phản hồi</label>
                                <textarea class="form-control" id="supportContent" rows="3" readonly>${supportRequest.feedbackContent}</textarea>
                            </div>

                            <c:choose>
                                <c:when test="${not empty supportRequest.feedbackContent}">
                                    <div class="mb-3">
                                        <label for="responseText" class="form-label">Phản hồi</label>
                                        <textarea class="form-control" id="responseText" name="feedbackContent" rows="5" readonly>${supportRequest.feedbackContent}</textarea>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="mb-3">
                                        <label for="responseText" class="form-label">Phản hồi</label>
                                        <textarea class="form-control" id="responseText" name="feedbackContent" rows="5"></textarea>
                                    </div>
                                    <div class="mb-3">
                                        <button type="submit" class="btn btn-success">Gửi phản hồi</button>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>