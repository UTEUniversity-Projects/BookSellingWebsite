<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Thông tin khuyến mãi</h5>
                <ul>
                    <li><a href="index.html">Biblio</a></li>
                    <li>Thông tin khuyến mãi</li>
                </ul>
            </div>
        </div>
        <c:if test="${promotion.type == 'DISCOUNT'}">
            <div class="row">
                <div class="col-xl-4 col-lg-12">
                    <div class="team-sticky-bar">
                        <div class="col-md-12">
                            <div class="cr-cat-list cr-card card-default mb-24px">
                                <div class="cr-card-content">
                                    <div class="cr-cat-form">
                                        <img class="img-promotion" src="assets/img/product/1.jpg">
                                        <h3>Thêm Discount</h3>
                                        <form class="promotion-form">
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Mã</label>
                                                <div class="col-12">
                                                    <input class="form-control here slug-title" type="text" value="#20-10" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Tiêu đề</label>
                                                <div class="col-12">
                                                    <input class="form-control here slug-title" type="text" value="20 - 10" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Phần trăm giảm (%)</label>
                                                <div class="col-12">
                                                    <input class="form-control here slug-title" type="text" value="50%" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Đối tượng áp dụng</label>
                                                <div class="select-oject-use-voucher">
                                                    <select class="select-item" id="select-object-discount" disabled>
                                                        <option selected disabled> - Chọn - </option>
                                                        <option value="1">Sản phẩm cụ thể</option>
                                                        <option value="2">Giảm theo Category</option>
                                                        <option value="3">Giảm theo Sub Category</option>
                                                        <option value="4">Toàn bộ sản phẩm</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Mô tả</label>
                                                <div class="col-12">
                                                    <textarea class="form-control" rows="4" disabled></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group row" style="padding-bottom: 20px;">
                                                <label>Thời gian áp dụng</label>
                                                <div class="col-12">
                                                    <input type="text" name="dateeffective"  style="width: 100%;" disabled>
                                                </div>
                                            </div>
                                            <div class="row" style="padding-bottom: 20px;">
                                                <div class="col-12 d-flex">
                                                    <button type="button" class="cr-btn-primary" id="edit-button">Chỉnh sửa</button>
                                                    <button type="button" class="cr-btn-primary" id="save-button" style="display: none;">Lưu</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8 col-lg-12" id="list-product-category-subcategory-discount">
                    <div class="cr-cat-list cr-card card-default">
                        <div class="cr-card-content ">
                            <div class="table-responsive tbl-800">
                                <table id="discount_table" class="table">
                                    <div class="select-parent-add-promotion">
                                        <label>Lọc theo:</label>
                                        <div class="select-add-promotion">
                                            <select class="select-item" id="category-select-discount">
                                                <option selected disabled> - Categories - </option>
                                                <option value="1">Sách giáo khoa</option>
                                                <option value="2">Tiểu thuyết</option>
                                                <option value="3">Kỹ năng</option>
                                                <option value="4">Kinh tế</option>
                                            </select>
                                        </div>
                                        <div class="select-add-promotion">
                                            <select class="select-item" id="subcategory-select-discount">
                                                <option selected disabled> - Sub Categories - </option>
                                                <option value="1">Sách lớp 1</option>
                                                <option value="2">Sách lớp 1</option>
                                                <option value="3">Sách lớp 1</option>
                                                <option value="4">Sách lớp 1</option>
                                            </select>
                                        </div>
                                    </div>

                                    <thead>
                                    <tr>
                                        <th>
                                            <input type="checkbox" id="select-all" style="margin-left: -3px;" disabled>
                                            Chọn tất cả
                                        </th>
                                        <th>Mã</th>
                                        <th>Tên</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr class="selectable-row">
                                        <td>
                                            <input type="checkbox" class="row-checkbox">
                                        </td>
                                        <td>#1321</td>
                                        <td>Đắc nhân tâm</td>
                                    </tr>
                                    <tr class="selectable-row">
                                        <td>
                                            <input type="checkbox" class="row-checkbox">
                                        </td>
                                        <td>#1322</td>
                                        <td>Cuốn theo chiều gió</td>
                                    </tr>
                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${promotion.type == 'VOUCHER'}">
            <div class="row">
                <div class="col-xl-12 col-lg-12">
                    <div class="col-md-12">
                        <div class="cr-cat-list cr-card card-default mb-24px">
                            <div class="cr-card-content">
                                <div class="cr-cat-form">
                                    <img class="img-promotion" src="assets/img/product/1.jpg">
                                    <h5>Thông tin Voucher</h5>
                                    <form class="promotion-form">
                                        <div class="form-group" style="padding-bottom: 20px;">
                                            <label>Mã</label>
                                            <div class="col-12">
                                                <input class="form-control here slug-title" type="text" value="${promotion.code}" id="promotion-code" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group" style="padding-bottom: 20px;">
                                            <label>Tiêu đề</label>
                                            <div class="col-12">
                                                <input class="form-control here slug-title" type="text" value="${promotion.title}" id="promotion-title" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group" style="padding-bottom: 20px;">
                                            <label>Số tiền giảm</label>
                                            <div class="col-12">
                                                <input class="form-control here slug-title" type="text" value="${promotion.discountLimit}" id="promotion-discount-limit" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group" style="padding-bottom: 20px;">
                                            <label>Số tiền yêu cầu trên hóa đơn</label>
                                            <div class="col-12">
                                                <input class="form-control here slug-title" type="text" value="${promotion.minValueApplied}" id="promotion-min-value-to-applied" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group" style="padding-bottom: 20px;">
                                            <label>Số lượng khuyến mãi</label>
                                            <div class="col-12">
                                                <input class="form-control here slug-title" type="text" id="promotion-quantity" value="100" disabled>
                                                <label>
                                                    <input type="checkbox" id="unlimited-checkbox" style="margin-top: 5px;"> Không giới hạn
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group" style="padding-bottom: 20px;">
                                            <label>Mô tả</label>
                                            <div class="col-12">
                                                <textarea class="form-control" rows="4" id="promotion-description" disabled></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group row" style="padding-bottom: 20px;">
                                            <label>Thời gian áp dụng</label>
                                            <div class="col-12">
                                                <input type="text" name="dateeffective" style="width: 100%;" id="promotion-time-effective" disabled>
                                            </div>
                                        </div>

                                        <div class="row" style="padding-bottom: 20px;">
                                            <div class="col-12 d-flex">
                                                <button type="button" class="cr-btn-primary" id="edit-button">Chỉnh sửa</button>
                                                <button type="button" class="cr-btn-primary" id="save-button" style="display: none;">Lưu</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${promotion.type == 'COUPON'}">
            <div class="row">
                <div class="col-xl-12 col-lg-12">
                    <div class="team-sticky-bar">
                        <div class="col-md-12">
                            <div class="cr-cat-list cr-card card-default mb-24px">
                                <div class="cr-card-content">
                                    <div class="cr-cat-form">
                                        <img class="img-promotion" src="assets/img/product/1.jpg">
                                        <h3>Thông tin Coupon</h3>
                                        <form class="promotion-form">
                                            <div class="form-group">
                                                <label>Mã</label>
                                                <div class="col-12" style="padding-bottom: 20px;">
                                                    <input name="text" class="form-control here slug-title" type="text" value="#20-10" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Tiêu đề</label>
                                                <div class="col-12">
                                                    <input name="text" class="form-control here slug-title" type="text" value="20 - 10" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Phần trăm giảm (%)</label>
                                                <div class="col-12">
                                                    <input name="text" class="form-control here slug-title" type="text" value="50%" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Giảm tối da</label>
                                                <div class="col-12">
                                                    <input name="text" class="form-control here slug-title" type="text" value="50.000 vnđ" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Số lượng khuyến mãi</label>
                                                <div class="col-12">
                                                    <input class="form-control here slug-title" type="text" id="promotion-quantity" disabled>
                                                    <label>
                                                        <input type="checkbox" id="unlimited-checkbox" style="margin-top: 5px;"> Không giới hạn
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Mô tả</label>
                                                <div class="col-12">
                                                    <textarea class="form-control" rows="4" disabled></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group row" style="padding-bottom: 20px;">
                                                <label>Thời gian áp dụng</label>
                                                <div class="col-12">
                                                    <input type="text" name="dateeffective" style="width: 100%;" disabled>
                                                </div>
                                            </div>

                                            <div class="row" style="padding-bottom: 20px;">
                                                <div class="col-12 d-flex">
                                                    <button type="button" class="cr-btn-primary" id="edit-button">Chỉnh sửa</button>
                                                    <button type="button" class="cr-btn-primary" id="save-button" style="display: none;">Lưu</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${promotion.type == 'FREESHIP'}">
            <div class="row">
                <div class="col-xl-12 col-lg-12">
                    <div class="team-sticky-bar">
                        <div class="col-md-12">
                            <div class="cr-cat-list cr-card card-default mb-24px">
                                <div class="cr-card-content">
                                    <div class="cr-cat-form">
                                        <img class="img-promotion" src="assets/img/product/1.jpg">
                                        <h3>Thông tin Freeship</h3>
                                        <form class="promotion-form">
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Mã</label>
                                                <div class="col-12">
                                                    <input name="text" class="form-control here slug-title" type="text" value="#20-10" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Tiêu đề</label>
                                                <div class="col-12">
                                                    <input name="text" class="form-control here slug-title" type="text" value="20 - 10" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Phần trăm giảm (%)</label>
                                                <div class="col-12">
                                                    <input name="text" class="form-control here slug-title" type="text" value="50%" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Giảm tối da</label>
                                                <div class="col-12">
                                                    <input name="text" class="form-control here slug-title" type="text" value="50.000 vnđ" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Số lượng khuyến mãi</label>
                                                <div class="col-12">
                                                    <input class="form-control here slug-title" type="text" id="promotion-quantity" disabled>
                                                    <label>
                                                        <input type="checkbox" id="unlimited-checkbox" style="margin-top: 5px;"> Không giới hạn
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="form-group" style="padding-bottom: 20px;">
                                                <label>Mô tả</label>
                                                <div class="col-12">
                                                    <textarea class="form-control" rows="4" disabled></textarea>

                                                </div>
                                            </div>
                                            <div class="form-group row" style="padding-bottom: 20px;">
                                                <label>Thời gian áp dụng</label>
                                                <div class="col-12">
                                                    <input type="text" name="dateeffective" style="width: 100%;" disabled>
                                                </div>
                                            </div>

                                            <div class="row" style="padding-bottom: 20px;">
                                                <div class="col-12 d-flex">
                                                    <button type="button" class="cr-btn-primary" id="edit-button">Chỉnh sửa</button>
                                                    <button type="button" class="cr-btn-primary" id="save-button" style="display: none;">Lưu</button>
                                                </div>
                                            </div>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>
<script src="${pageContext.request.contextPath}/assets/owner/js/promotion-detail.js" defer></script>


