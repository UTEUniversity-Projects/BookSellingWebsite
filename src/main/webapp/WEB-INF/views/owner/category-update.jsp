<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5><b>Cập nhật thông tin danh mục</b></h5>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/owner/ecommerce"><b>Biblio</b></a></li>
                    <li><a href="${pageContext.request.contextPath}/owner/category/list"><b>Danh mục</b></a></li>
                    <li><b>Cập nhật thông tin danh mục</b></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <form id="categoryUpdateForm" class="d-flex">
                <div class="col-xxl-3 col-xl-4 col-md-12">
                    <div class="vendor-sticky-bar">
                        <div class="col-xl-12">
                            <div class="cr-card card-3d-deep">
                                <div class="avatar-preview cr-preview">
                                    <div class="imagePreview cr-div-preview">
                                        <img class="cr-image-preview image-shadow rounded-3"
                                             src="${pageContext.request.contextPath}${category.avatar}"
                                             alt="edit">
                                    </div>
                                </div>
                                <br>
                                <div class="col-12">
                                    <label for="name">Danh mục<sup class="color-secondary" style="font-size: 100%">*</sup></label>
                                    <input id="name" name="name" class="form-control here slug-title category-name" type="text"
                                           value="${category.name}" />
                                </div>
                                <div class="col-12">
                                    <label for="shortScript">Mô tả ngắn<sup class="color-secondary" style="font-size: 100%">*</sup></label>
                                    <textarea id="shortScript" name="shortScript" class="form-control here slug-title category-name" type="text"
                                              rows="5">${category.shortScript}</textarea>
                                </div>
                                <br>
                                <input id="id" name="id" value="${category.id}" class="form-control" type="hidden" />
                                <input id="originAvatar" name="originAvatar" value="${category.avatar}" class="form-control" type="hidden" />
                                <div class="cr-settings d-flex justify-content-center">
                                    <button id="updateButton" type="button" class="cr-btn-primary rounded">Cập nhật</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xxl-9 col-xl-8 col-md-12 ps-3">
                    <div class="cr-card card-3d-deep">
                        <div class="cr-card-content">
                            <div class="row">
                                <div class="d-flex col-sm-12 editor-area">
                                    <h5>Soạn thảo giới thiệu</h5>
                                    <button id="review-btn" class="cr-btn default-btn color-primary">Xem trước</button>
                                </div>
                                <div id="editor" name="fullScript" class="edit-fullScript">
                                    ${category.fullScript}
                                </div>
                                <div class="review-area">
                                    <div id="review-container d-none">
                                        <h5 class="mb-30">Giới thiệu danh mục</h5>
                                        <div id="review-content" class="review-fullScript"></div>
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

<script>const contextPath = "<%=request.getContextPath() %>";</script>
<script src="${pageContext.request.contextPath}/assets/owner/js/manage/init-global-variables.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/extension/quill-editor.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/manage/manage-category.js" defer></script>

<style>
    h5 {
        font-weight: bold;
        color: #2b3647;
    }
    .form-control {
        border-radius: 10px;
        color: #2b3647;
    }
    .form-control:focus {
        border-color: #007bff;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        outline: none;
        color: #2b3647;
    }
    .editor-area {
        justify-content: space-between;
        align-items: center;
        margin-bottom: 30px
    }
    .review-area {
        padding-top: 30px;
        padding-bottom: 20px;
    }
    .category-name {
        font-family: 'Nunito', sans-serif;
        font-size: 90%;
        font-weight: bold;
        color: #2b3647;
    }
    div.ql-editor p {
        white-space: pre-wrap;
        word-wrap: break-word;
        color: #7a7a7a;
    }
    #review-content {
        white-space: pre-wrap;
        word-wrap: break-word;
    }
    div.edit-fullScript p{
        width: 100%;
        margin: 0;
        text-align: justify;
        box-sizing: border-box;
        font-size: 110%;
    }
    div.review-fullScript p {
        width: 100%;
        font-size: 15px;
        padding: 10px;
        color: slategray;
        text-align: justify;
        box-sizing: border-box;
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
</style>
