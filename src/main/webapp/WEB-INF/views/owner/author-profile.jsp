<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Thông tin tác giả</h5>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/owner/ecommerce">Biblio</a></li>
                    <li><a href="${pageContext.request.contextPath}/owner/author-list">Tác giả</a></li>
                    <li>Thông tin tác giả</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-xxl-3 col-xl-4 col-md-12">
                <div class="vendor-sticky-bar">
                    <div class="col-xl-12">
                        <div class="cr-card">
                            <div class="cr-card-content">
                                <div class="cr-vendor-block-img">
                                    <div class="cr-vendor-block-detail">
                                        <div class="profile-img">
                                            <img class="v-img" src="${author.avatar}"
                                                 alt="vendor image" style="width: 200px; height: 200px">
                                            <span class="tag-label online"></span>
                                        </div>
                                        <div class="cr-settings">
                                            <a href="#" onclick="authorAction(${author.id}, 'update'); return false;" class="cr-btn-primary m-r-10">Chỉnh sửa</a>
                                        </div>
                                    </div>
                                    <div class="cr-vendor-info">
                                        <ul>
                                            <li><span class="label">Họ và tên :</span>&nbsp;${author.name}</li>
                                            <li><span class="label">Ngày tham gia :</span>&nbsp;${author.joinAt}</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xxl-9 col-xl-8 col-md-12">
                <div class="cr-card vendor-profile">
                    <div class="cr-card-content vendor-details mb-m-30">
                        <div class="row">
                            <div class="col-sm-12">
                                <h3>Giới thiệu tác giả</h3>
                                <br>
                            </div>
                            <div class="col-12">
                                <p id="description">
                                    ${author.introduction}
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>const contextPath = "<%=request.getContextPath() %>";</script>
<script src="${pageContext.request.contextPath}/assets/owner/js/manage-author.js" defer></script>
