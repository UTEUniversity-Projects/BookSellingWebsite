<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Nhà xuất bản</h5>
                <ul>
                    <li><a href="index.html">Biblio</a></li>
                    <li>Nhà xuất bản</li>
                </ul>
            </div>
        </div>
        <div class="row cr-category">
            <div class="col-xl-4 col-lg-12">
                <div class="team-sticky-bar">
                    <div class="col-md-12">
                        <div class="cr-cat-list cr-card card-default mb-24px">
                            <div class="cr-card-content">
                                <div class="cr-cat-form">
                                    <h3>Thêm nhà xuất bản</h3>

                                    <form>
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
                                                                         src="/assets/owner/img/product/preview.jpg"
                                                                         alt="edit">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <br>

                                        <div class="form-group">
                                            <label>Tên nhà xuất bản</label>
                                            <div class="col-12">
                                                <input id="text" name="text"
                                                       class="form-control here slug-title" type="text">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label>Giới thiệu</label>
                                            <div class="col-12">
														<textarea id="fulldescription" name="fulldescription" cols="40"
                                                                  rows="8" class="form-control"></textarea>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-12 d-flex">
                                                <button type="submit" class="cr-btn-primary">Thêm mới</button>
                                            </div>
                                        </div>

                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-8 col-lg-12">
                <div class="cr-cat-list cr-card card-default">
                    <div class="cr-card-content ">
                        <div class="table-responsive tbl-800">
                            <table id="cat_data_table" class="table">
                                <thead>
                                <tr>
                                    <th>Mã #</th>
                                    <th>Nhà xuất bản</th>
                                    <th>Giới thiệu</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td>#PHBH9762</td>
                                    <td>NXB Phương Đông</td>
                                    <td>Một trong những nhà xuất bản hàng đầu về sách nghiên cứu tổng hợp.</td>
                                    <td>
                                        <div>
                                            <button type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="false" data-display="static">
															<span class="sr-only"><i
                                                                    class="ri-settings-3-line"></i></span>
                                            </button>

                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Chỉnh sửa</a>
                                                <a class="dropdown-item" href="#">Xóa</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>