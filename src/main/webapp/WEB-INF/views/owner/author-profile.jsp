<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href='https://fonts.googleapis.com/css?family=Nunito' rel='stylesheet'>
<style>
    .card-3d-deep {
        background: #fff;
        border-radius: 10px;
        padding: 20px;
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
</style>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5><b>Thông tin tác giả</b></h5>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/owner/ecommerce"><b>Biblio</b></a></li>
                    <li><a href="${pageContext.request.contextPath}/owner/author-list"><b>Tác giả</b></a></li>
                    <li><b>Thông tin tác giả</b></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-xxl-3 col-xl-4 col-md-12">
                <div class="vendor-sticky-bar">
                    <div class="col-xl-12">
                        <div class="cr-card card-3d-deep">
                            <div class="cr-vendor-block-detail">
                                <div class="avatar-preview cr-preview">
                                    <div class="imagePreview cr-div-preview">
                                        <img class="cr-image-preview image-shadow rounded-3"
                                             src="${pageContext.request.contextPath}${author.avatar}"
                                             alt="edit">
                                    </div>
                                </div>
                                <br>
                                <div class="cr-settings">
                                    <a href="#" onclick="authorAction(${author.id}, 'update'); return false;" class="cr-btn-primary m-r-10 rounded">Cập nhật</a>
                                </div>
                            </div>
                            <div class="cr-vendor-info">
                                <ul>
                                    <li><span class="label">Họ và tên :</span>&nbsp; <b>${author.name}</b></li></li>
                                    <li><span class="label">Ngày tham gia :</span>&nbsp; <b>${author.joinAt}</b></li>
                                    <li><span class="label">Cùng tác giả :</span>&nbsp; <b>9999</b> tác phẩm</li>
                                </ul>
                            </div>
                        </div>
                        <div class="cr-card card-3d-deep">
                            <div class="cr-card-content label-card">
                                <div class="title">
                                    <span class="icon icon-3"><i class="ri-product-hunt-line"></i></span>
                                    <div class="growth-numbers">
                                        <h4>Sách đã bán (cuốn)</h4>
                                        <h5>999999999</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xxl-9 col-xl-8 col-md-12">
                <div class="cr-card vendor-profile card-3d-deep">
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
