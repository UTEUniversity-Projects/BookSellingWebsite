<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Cập nhật thông tin tác giả</h5>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/owner/ecommerce">Biblio</a></li>
                    <li><a href="${pageContext.request.contextPath}/owner/author-list">Tác giả</a></li>
                    <li>Cập nhật thông tin tác giả</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <form class="d-flex">
                <div class="col-xxl-3 col-xl-4 col-md-12">
                    <div class="vendor-sticky-bar">
                        <div class="col-xl-12">
                            <div class="cr-card">
                                <div class="cr-card-content">
                                    <div class="cr-cat-form">
                                        <div class="row cr-product-uploads">
                                            <div class="col-lg-12 mb-991">
                                                <div class="cr-vendor-img-upload">
                                                    <div class="cr-vendor-main-img">
                                                        <div class="avatar-upload">
                                                            <div class="avatar-edit">
                                                                <input type='file' id="avatar"
                                                                       class="cr-image-upload"
                                                                       accept=".png, .jpg, .jpeg">
                                                                <label><i class="ri-pencil-line"></i></label>
                                                            </div>
                                                            <div class="avatar-preview cr-preview">
                                                                <div class="imagePreview cr-div-preview">
                                                                    <img class="cr-image-preview"
                                                                         src="${author.avatar}"
                                                                         alt="edit">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="form-group col-12">
                                            <label for="name">Họ và tên</label>
                                            <input id="name" name="name" class="form-control here slug-title" type="text"
                                                   value="${author.name}" />
                                        </div>
                                        <br>
                                        <div class="cr-settings d-flex justify-content-center">
                                            <button type="submit" class="cr-btn-primary">Cập nhật</button>
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
                                </div>
                                <div class="col-12">
                                    <label for="introduction"></label>
                                    <textarea id="introduction" name="introduction" class="form-control here slug-title" type="text" rows="3">
                                        ${fn:trim(author.introduction)}
                                    </textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
