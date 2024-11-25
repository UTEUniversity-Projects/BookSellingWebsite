<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Include stylesheet -->
<link href="https://cdn.jsdelivr.net/npm/quill@2.0.2/dist/quill.snow.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Nunito' rel='stylesheet'>
<style>
    .author-name {
        font-family: 'Nunito', sans-serif;
        font-size: 90%;
        font-weight: bold;
        color: #2b3647;
    }

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
    #review-content {
        white-space: pre-wrap;
        word-wrap: break-word;
    }
</style>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5><b>Cập nhật thông tin tác giả</b></h5>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/owner/ecommerce"><b>Biblio</b></a></li>
                    <li><a href="${pageContext.request.contextPath}/owner/author-list"><b>Tác giả</b></a></li>
                    <li><b>Cập nhật thông tin tác giả</b></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <form class="d-flex">
                <div class="col-xxl-3 col-xl-4 col-md-12">
                    <div class="vendor-sticky-bar">
                        <div class="col-xl-12">
                            <div class="cr-card card-3d-deep">
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
                                                                    <img class="cr-image-preview image-shadow rounded-3"
                                                                         src="${pageContext.request.contextPath}${author.avatar}"
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
                                            <input id="name" name="name" class="form-control here slug-title author-name" type="text"
                                                   value="${author.name}" />
                                        </div>
                                        <br>
                                        <div class="cr-settings d-flex justify-content-center">
                                            <button type="submit" class="cr-btn-primary rounded">Cập nhật</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xxl-9 col-xl-8 col-md-12" style="padding-left: 10px">
                    <div class="cr-card vendor-profile card-3d-deep">
                        <div class="cr-card-content vendor-details mb-m-30">
                            <div class="row">
                                <div class="d-flex col-sm-12" style="justify-content: space-between; align-items: center; margin-bottom: 30px">
                                    <h3>Soạn thảo giới thiệu</h3>
                                    <button id="review-btn" style="border-radius: 8px">Xem trước</button>
                                </div>
                                <!-- Create the editor container -->
                                <div id="editor">
                                    ${fn:trim(author.introduction)}
                                </div>
                                <div style="margin-top: 30px; margin-bottom: 20px">
                                    <div id="review-container" style="display: none;">
                                        <h3>Giới thiệu tác giả</h3>
                                        <div id="review-content"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/quill@2.0.2/dist/quill.js"></script>
<script>const contextPath = "<%=request.getContextPath() %>";</script>
<script src="${pageContext.request.contextPath}/assets/owner/js/quill-editor.js" defer></script>
