<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <div class="page-title">
                    <h5>Thêm sản phẩm</h5>
                </div>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/owner/ecommerce"><b>Biblio</b></a></li>
                    <li><a href="${pageContext.request.contextPath}/owner/product/list"><b>Sản phẩm</b></a></li>
                    <li><b>Thêm sản phẩm</b></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card card-default card-3d-deep">
                    <div class="cr-card-content">
                        <div class="row cr-product-uploads">
                            <div class="col-lg-4 mb-991">
                                <div class="cr-vendor-img-upload">
                                    <div class="cr-vendor-main-img">
                                        <div class="avatar-upload">
                                            <div class="avatar-edit">
                                                <input type='file' id="product_main" class="cr-image-upload"
                                                       accept=".png, .jpg, .jpeg">
                                                <label><i class="ri-pencil-line"></i></label>
                                            </div>
                                            <div class="avatar-preview cr-preview">
                                                <div class="imagePreview cr-div-preview">
                                                    <img class="cr-image-preview"
                                                         src="${pageContext.request.contextPath}/assets/owner/img/product/preview.jpg"
                                                         alt="edit">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="thumb-upload-set colo-md-12">
                                            <div class="thumb-upload">
                                                <div class="thumb-edit">
                                                    <input type='file' id="thumbUpload01"
                                                           class="cr-image-upload"
                                                           accept=".png, .jpg, .jpeg">
                                                    <label><i class="ri-pencil-line"></i></label>
                                                </div>
                                                <div class="thumb-preview cr-preview">
                                                    <div class="image-thumb-preview">
                                                        <img class="image-thumb-preview cr-image-preview"
                                                             src="${pageContext.request.contextPath}/assets/owner/img/product/preview-2.jpg"
                                                             alt="edit">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="thumb-upload">
                                                <div class="thumb-edit">
                                                    <input type='file' id="thumbUpload02"
                                                           class="cr-image-upload"
                                                           accept=".png, .jpg, .jpeg">
                                                    <label><i class="ri-pencil-line"></i></label>
                                                </div>
                                                <div class="thumb-preview cr-preview">
                                                    <div class="image-thumb-preview">
                                                        <img class="image-thumb-preview cr-image-preview"
                                                             src="${pageContext.request.contextPath}/assets/owner/img/product/preview-2.jpg"
                                                             alt="edit">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="thumb-upload">
                                                <div class="thumb-edit">
                                                    <input type='file' id="thumbUpload03"
                                                           class="cr-image-upload"
                                                           accept=".png, .jpg, .jpeg">
                                                    <label><i class="ri-pencil-line"></i></label>
                                                </div>
                                                <div class="thumb-preview cr-preview">
                                                    <div class="image-thumb-preview">
                                                        <img class="image-thumb-preview cr-image-preview"
                                                             src="${pageContext.request.contextPath}/assets/owner/img/product/preview-2.jpg"
                                                             alt="edit">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="thumb-upload">
                                                <div class="thumb-edit">
                                                    <input type='file' id="thumbUpload04"
                                                           class="cr-image-upload"
                                                           accept=".png, .jpg, .jpeg">
                                                    <label><i class="ri-pencil-line"></i></label>
                                                </div>
                                                <div class="thumb-preview cr-preview">
                                                    <div class="image-thumb-preview">
                                                        <img class="image-thumb-preview cr-image-preview"
                                                             src="${pageContext.request.contextPath}/assets/owner/img/product/preview-2.jpg"
                                                             alt="edit">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="thumb-upload">
                                                <div class="thumb-edit">
                                                    <input type='file' id="thumbUpload05"
                                                           class="cr-image-upload"
                                                           accept=".png, .jpg, .jpeg">
                                                    <label><i class="ri-pencil-line"></i></label>
                                                </div>
                                                <div class="thumb-preview cr-preview">
                                                    <div class="image-thumb-preview">
                                                        <img class="image-thumb-preview cr-image-preview"
                                                             src="${pageContext.request.contextPath}/assets/owner/img/product/preview-2.jpg"
                                                             alt="edit">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="thumb-upload">
                                                <div class="thumb-edit">
                                                    <input type='file' id="thumbUpload06"
                                                           class="cr-image-upload"
                                                           accept=".png, .jpg, .jpeg">
                                                    <label><i class="ri-pencil-line"></i></label>
                                                </div>
                                                <div class="thumb-preview cr-preview">
                                                    <div class="image-thumb-preview">
                                                        <img class="image-thumb-preview cr-image-preview"
                                                             src="${pageContext.request.contextPath}/assets/owner/img/product/preview-2.jpg"
                                                             alt="edit">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="cr-vendor-upload-detail">
                                    <form class="row g-3">
                                        <div class="col-md-12">
                                            <label for="book-title" class="form-label">Tên sản phẩm</label>
                                            <input type="text" class="form-control slug-title" id="book-title">
                                        </div>
                                        <div class="col-md-4">
                                            <label for="selling-price" class="form-label">Giá bán</label>
                                            <input type="text" class="form-control slug-title" id="selling-price"
                                                   placeholder="Đơn vị: VNĐ">
                                        </div>
                                        <div class="col-md-2">
                                            <label class="form-label">Số lượng</label>
                                            <input type="number" class="form-control" id="quantity1">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Tác giả</label>
                                            <select class="form-control form-select">
                                                <option value="a">Nguyễn Nhật Ánh</option>
                                                <option value="b">B</option>
                                                <option value="c">C</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Thể loại</label>
                                            <select class="form-control form-select">
                                                <optgroup label="Truyện ngắn">
                                                    <option value="t-shirt">Tự truyện</option>
                                                    <option value="dress">B</option>
                                                </optgroup>
                                                <optgroup label="Tiểu thuyết">
                                                    <option value="table">A</option>
                                                    <option value="sofa">B</option>
                                                </optgroup>
                                                <optgroup label="Khoa học">
                                                    <option value="phone">A</option>
                                                    <option value="laptop">B</option>
                                                </optgroup>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Dịch giả</label>
                                            <select class="form-control form-select">
                                                <option value="a">Thái Phạm</option>
                                                <option value="b">B</option>
                                                <option value="c">C</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Tình trạng</label>
                                            <select class="form-control form-select">
                                                <option value="a">Còn mới</option>
                                                <option value="b">Đã qua sử dụng</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Nhà xuất bản</label>
                                            <select class="form-control form-select">
                                                <option value="a">NXB Phương Đông</option>
                                                <option value="b">B</option>
                                                <option value="c">C</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Định dạng</label>
                                            <select class="form-control form-select">
                                                <option value="a">Bìa cứng</option>
                                                <option value="b">Bìa mềm</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label>Ngày xuất bản</label>
                                            <div class="input-group date" id="datepicker">
                                                <input type="text" class="form-control" id="date"
                                                       placeholder="DD/MM/YYYY"/>
                                                <span class="input-group-text bg-light d-block"
                                                      style="cursor: pointer;">
														  <i class="ri-calendar-2-line"></i>
													  </span>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Ngôn ngữ</label>
                                            <select class="form-control form-select">
                                                <option value="a">Tiếng Việt</option>
                                                <option value="b">Tiếng Anh</option>
                                                <option value="c">Song ngữ</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="selling-price" class="form-label">Độ tuổi khuyến nghị</label>
                                            <select class="form-control form-select">
                                                <option value="a">Từ 3 - 5 tuổi</option>
                                                <option value="b">Tiếng Anh</option>
                                                <option value="c">Song ngữ</option>
                                            </select>
                                        </div>
                                        <div class="col-md-3">
                                            <label for="selling-price" class="form-label">ISBN10</label>
                                            <input type="text" class="form-control slug-title">
                                        </div>
                                        <div class="col-md-3">
                                            <label for="selling-price" class="form-label">ISBN13</label>
                                            <input type="text" class="form-control slug-title" >
                                        </div>
                                        <div class="col-md-3">
                                            <label for="selling-price" class="form-label">Tái bản</label>
                                            <input type="text" class="form-control slug-title"
                                                   placeholder="Lần thứ 3">
                                        </div>
                                        <div class="col-md-3">
                                            <label for="selling-price" class="form-label">Số trang</label>
                                            <input type="text" class="form-control slug-title" id="handcover"
                                                   placeholder="125">
                                        </div>
                                        <div class="col-md-3">
                                            <label for="selling-price" class="form-label">Chiều dài</label>
                                            <input type="text" class="form-control slug-title"
                                                   placeholder="Đơn vị: mm">
                                        </div>
                                        <div class="col-md-3">
                                            <label for="selling-price" class="form-label">Chiều rộng</label>
                                            <input type="text" class="form-control slug-title"
                                                   placeholder="Đơn vị: mm">
                                        </div>
                                        <div class="col-md-3">
                                            <label for="selling-price" class="form-label">Chiều cao</label>
                                            <input type="text" class="form-control slug-title"
                                                   placeholder="Đơn vị: mm">
                                        </div>
                                        <div class="col-md-3">
                                            <label for="selling-price" class="form-label">Khối lượng</label>
                                            <input type="text" class="form-control slug-title"
                                                   placeholder="Đơn vị: gam">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Ngày mở bán</label>
                                            <div class="input-group date">
                                                <input type="text" class="form-control"
                                                       placeholder="DD/MM/YYYY"/>
                                                <span class="input-group-text bg-light d-block"
                                                      style="cursor: pointer;">
														  <i class="ri-calendar-2-line"></i>
													  </span>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="col-md-12">
                                            <label class="form-label">
                                                <h6><b>Mô tả sách</b></h6>
                                            </label>
                                            <textarea class="form-control" rows="10"></textarea>
                                        </div>
                                        <div class="col-md-12">
                                            <label class="form-label">Nhãn sách</label>
                                            <input type="text" class="form-control"
                                                   name="group_tag" value="" placeholder=""
                                                   data-role="tagsinput">
                                        </div>
                                        <div class="col-md-12">
                                            <label class="form-label">Khuyến mãi sách</label>
                                            <input type="text" class="form-control"
                                                   name="group_tag" value="" placeholder=""
                                                   data-role="tagsinput">
                                        </div>
                                        <div class="col-md-12">
                                            <button type="submit" class="btn cr-btn-primary">Thêm sách</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    .page-title {
        margin-right: 20px;
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
    .author-name {
        font-family: 'Nunito', sans-serif;
        font-size: 90%;
        font-weight: bold;
        color: #2b3647;
    }
    div .edit-introduction p{
        width: 100%;
        margin: 0;
        text-align: justify;
        box-sizing: border-box;
        font-size: 110%;
    }
    h5 {
        font-weight: bold;
        color: #2b3647;
    }
    div.review-introduction p {
        width: 100%;
        margin: 0;
        padding-left: 10px;
        padding-right: 10px;
        text-align: justify;
        box-sizing: border-box;
        font-size: 90%;
        color: slategray;
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