<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<style>
    .error-message {
        color: red;
        font-size: 0.7em;
    }
    .ip-padding {
        padding-bottom: 20px;
    }
</style>
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
                                    <form action="/owner/promotion-details" method="POST" class="promotionForm">
                                        <input type="hidden" name="formType" value="editVoucher"/>

                                        <!-- Mã -->
                                        <div class="form-group ip-padding">
                                            <label>Mã</label>
                                            <div class="col-12">
                                                <input name="code" value="${promotion.code}" class="form-control here slug-title" style="background-color: #f5f5f5;" readonly type="text" onblur="validateInput(this)" />
                                                <span class="error-message codeError"></span>
                                            </div>
                                        </div>

                                        <!-- Tiêu đề -->
                                        <div class="form-group ip-padding">
                                            <label>Tiêu đề</label>
                                            <div class="col-12">
                                                <input name="title" value="${promotion.title}" class="form-control here slug-title" disabled type="text" onblur="validateInput(this)" />
                                                <span class="error-message titleError"></span>
                                            </div>
                                        </div>

                                        <!-- Số tiền giảm -->
                                        <div class="form-group ip-padding">
                                            <label>Số tiền giảm</label>
                                            <div class="col-12">
                                                <input name="discountLimit" value="${promotion.discountLimit}" class="form-control here slug-title" disabled type="number" onblur="validateInput(this)" />
                                                <span class="error-message discountLimitError"></span>
                                            </div>
                                        </div>

                                        <!-- Số tiền yêu cầu trên hóa đơn -->
                                        <div class="form-group ip-padding">
                                            <label>Số tiền yêu cầu trên hóa đơn</label>
                                            <div class="col-12">
                                                <input name="minValueApplied" value="${promotion.minValueToApplied}" class="form-control here slug-title" disabled type="number" onblur="validateInput(this)" />
                                                <span class="error-message minValueAppliedError"></span>
                                            </div>
                                        </div>

                                        <!-- Số lượng khuyến mãi -->
                                        <div class="form-group ip-padding">
                                            <label>Số lượng khuyến mãi</label>
                                            <div class="col-12">
                                                <input
                                                        name="quantity"
                                                        class="form-control here slug-title"
                                                        type="number"
                                                        <c:if test="${promotion.quantity == -1}">value="" disabled</c:if>
                                                        <c:if test="${promotion.quantity != -1}">value="${promotion.quantity}" disabled</c:if>
                                                        onblur="validateInput(this)" />
                                                <label>
                                                    <input
                                                            type="checkbox"
                                                            name="unlimited"
                                                            value="true"
                                                            style="margin-top: 5px"
                                                            disabled
                                                            <c:if test="${promotion.quantity == -1}">checked</c:if> />
                                                    Không giới hạn
                                                </label>

                                                <span class="error-message quantityError"></span>
                                            </div>

                                        </div>

                                        <!-- Mô tả -->
                                        <div class="form-group ip-padding">
                                            <label>Mô tả</label>
                                            <div class="col-12">
                                                <textarea name="description" class="form-control" rows="4" disabled onblur="validateInput(this)">${promotion.description}</textarea>
                                                <span class="error-message descriptionError"></span>
                                            </div>
                                        </div>

                                        <!-- Thời gian áp dụng -->
                                        <div class="form-group row ip-padding">
                                            <label>Thời gian áp dụng</label>
                                            <div class="col-12">
                                                <input type="text" name="dateeffective" disabled style="width: 100%;" onblur="validateInput(this)" />
                                                <span class="error-message dateeffectiveError"></span>
                                            </div>
                                        </div>

                                        <div class="row ip-padding">
                                            <div class="col-12 d-flex">
                                                <button type="submit" class="btn-voucher cr-btn-primary" data-editing="false">Chỉnh sửa</button>
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
                                        <form action="/owner/promotion-details" method="POST" class="promotionForm">
                                            <input type="hidden" name="formType" value="editFreeShip" />
                                            <div class="form-group ip-padding">
                                                <label>Mã</label>
                                                <div class="col-12">
                                                    <input name="code" class="form-control here slug-title" type="text" value="${promotion.code}" style="background-color: #f5f5f5;" readonly onblur="validateInput(this)" />
                                                    <span class="error-message codeError"></span>
                                                </div>
                                            </div>
                                            <div class="form-group ip-padding">
                                                <label>Tiêu đề</label>
                                                <div class="col-12">
                                                    <input name="title" class="form-control here slug-title" type="text" value="${promotion.title}" disabled onblur="validateInput(this)" />
                                                    <span class="error-message titleError"></span>
                                                </div>
                                            </div>
                                            <div class="form-group ip-padding">
                                                <label>Số tiền giảm</label>
                                                <div class="col-12">
                                                    <input name="discountLimit" class="form-control here slug-title" type="number" value="${promotion.discountLimit}" disabled onblur="validateInput(this)" />
                                                    <span class="error-message discountLimitError"></span>
                                                </div>
                                            </div>
                                            <div class="form-group ip-padding">
                                                <label>Số lượng khuyến mãi</label>
                                                <div class="col-12">
                                                    <input
                                                            name="quantity"
                                                            class="form-control here slug-title"
                                                            type="number"
                                                            <c:if test="${promotion.quantity == -1}">value="" disabled</c:if>
                                                            <c:if test="${promotion.quantity != -1}">value="${promotion.quantity}" disabled</c:if>
                                                            onblur="validateInput(this)" />
                                                    <label>
                                                        <input
                                                                type="checkbox"
                                                                name="unlimited"
                                                                value="true"
                                                                style="margin-top: 5px"
                                                                disabled
                                                                <c:if test="${promotion.quantity == -1}">checked</c:if> />
                                                        Không giới hạn
                                                    </label>

                                                    <span class="error-message quantityError"></span>
                                            </div>
                                                <div class="form-group ip-padding">
                                                    <label>Mô tả</label>
                                                    <div class="col-12">
                                                        <textarea name="description" class="form-control" rows="4" disabled onblur="validateInput(this)">${promotion.description}</textarea>
                                                        <span class="error-message descriptionError"></span>
                                                    </div>
                                                </div>
                                            <div class="form-group row ip-padding">
                                                <label>Thời gian áp dụng</label>
                                                <div class="col-12">
                                                    <input type="text" name="dateeffective" disabled style="width: 100%;" onblur="validateInput(this)" />
                                                    <span class="error-message dateeffectiveError"></span>
                                                </div>
                                            </div>

                                            <div class="row ip-padding" >
                                                <div class="col-12 d-flex">
                                                    <button type="submit" class="btn-voucher cr-btn-primary" data-editing="false">Chỉnh sửa</button>
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

<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<script>
    $(function() {
        const fixedStartDate = moment().subtract(7, 'days').startOf('day'); // Ngày bắt đầu cố định
        const promotionStatus = '${promotion.status}'; // Trạng thái từ server (EFFECTIVE hoặc COMING_SOON)

        // Giá trị từ server
        const effectiveDate = moment('${promotion.effectiveDate}', 'YYYY-MM-DDTHH:mm:ss'); // Format kiểu ISO nếu cần
        const expirationDate = moment('${promotion.expirationDate}', 'YYYY-MM-DDTHH:mm:ss'); // Format kiểu ISO nếu cần

        if (promotionStatus === 'COMING_SOON') {
            // Nếu trạng thái là COMING_SOON: Cho chỉnh cả ngày bắt đầu và ngày kết thúc
            $('input[name="dateeffective"]').daterangepicker({
                timePicker: true,
                singleDatePicker: false,
                startDate: effectiveDate.isValid() ? effectiveDate : fixedStartDate, // Giá trị bắt đầu từ server
                endDate: expirationDate.isValid() ? expirationDate : moment().startOf('hour').add(32, 'hour'), // Giá trị kết thúc từ server
                minDate: moment(), // Ngày nhỏ nhất là hôm nay
                autoUpdateInput: true,
                locale: {
                    format: 'M/DD/YYYY hh:mm A' // Hiển thị cả năm
                }
            });
        } else if (promotionStatus === 'EFFECTIVE' || promotionStatus === 'USED_OUT') {
            // Nếu trạng thái là EFFECTIVE: Chỉ chỉnh ngày kết thúc
            $('input[name="dateeffective"]').daterangepicker({
                singleDatePicker: true, // Chỉ chọn một ngày
                timePicker: true, // Hiển thị bộ chọn giờ
                startDate: expirationDate.isValid() ? expirationDate : moment(), // Mặc định ngày kết thúc
                minDate: moment(), // Ngày nhỏ nhất là hôm nay
                locale: {
                    format: 'M/DD/YYYY hh:mm A' // Hiển thị cả năm
                }
            });
        }
    });
</script>

<script>const contextPath = "<%= request.getContextPath()%>";</script>
<script src="${pageContext.request.contextPath}/assets/owner/js/validator-promotion-details.js" defer></script>

<script src="${pageContext.request.contextPath}/assets/owner/js/add-promotion.js" defer></script>



