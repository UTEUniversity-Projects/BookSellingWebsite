<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<style>
    .error-message {
        color: red;
        font-size: 0.7em;
    }
</style>
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Thêm Promotion</h5>
                <ul>
                    <li><a href="index.html">Biblio</a></li>
                    <li>Thêm Voucher</li>
                </ul>
            </div>
        </div>
        <div class="tab-promotion">
            <div class="tab-list-promotion">
                <div class="tab-item-promotion active" data-tab="1">Discount</div>
                <div class="tab-item-promotion" data-tab="2">Voucher</div>
                <div class="tab-item-promotion" data-tab="3">Freeship</div>
            </div>
        </div>
        <div class="content-promotion">
            <div class="row cr-promotion" data-tab="1">
                <div class="col-xl-4 col-lg-12">
                    <div class="team-sticky-bar">
                        <div class="col-md-12">
                            <div class="cr-cat-list cr-card card-default mb-24px">
                                <div class="cr-card-content">
                                    <div class="cr-cat-form">
                                        <img
                                                class="img-promotion"
                                                src="assets/img/product/1.jpg"
                                        />
                                        <h3>Thêm Discount</h3>
                                        <form>
                                            <div class="form-group">
                                                <label>Mã</label>
                                                <div class="col-12">
                                                    <input
                                                            name="text"
                                                            class="form-control here slug-title"
                                                            type="text"
                                                            value="#20-10"
                                                    />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Tiêu đề</label>
                                                <div class="col-12">
                                                    <input
                                                            name="text"
                                                            class="form-control here slug-title"
                                                            type="text"
                                                            value="20 - 10"
                                                    />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Phần trăm giảm (%)</label>
                                                <div class="col-12">
                                                    <input
                                                            name="text"
                                                            class="form-control here slug-title"
                                                            type="text"
                                                            value="50%"
                                                    />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Đối tượng áp dụng</label>
                                                <div class="select-oject-use-voucher">
                                                    <select
                                                            class="select-item"
                                                            id="select-object-discount"
                                                    >
                                                        <option selected disabled>- Chọn -</option>
                                                        <option value="1">Sản phẩm cụ thể</option>
                                                        <option value="2">Giảm theo Category</option>
                                                        <option value="3">
                                                            Giảm theo Sub Category
                                                        </option>
                                                        <option value="4">Toàn bộ sản phẩm</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Số lượng khuyến mãi</label>
                                                <div class="col-12">
                                                    <input
                                                            name="text"
                                                            class="form-control here slug-title"
                                                            type="text"
                                                    />
                                                    <label
                                                    ><input
                                                            type="checkbox"
                                                            value="Không giới hạn"
                                                            style="margin-top: 5px"
                                                    />
                                                        Không giới hạn</label
                                                    >
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Mô tả</label>
                                                <div class="col-12">
																<textarea
                                                                        class="form-control"
                                                                        rows="4"
                                                                ></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label>Thời gian áp dụng</label>
                                                <div class="col-12">
                                                    <input
                                                            type="text"
                                                            name="dateeffective"
                                                            style="width: 100%"
                                                    />
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-12 d-flex">
                                                    <button type="submit" class="cr-btn-primary">
                                                        Thêm
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div
                        class="col-xl-8 col-lg-12"
                        id="list-product-category-subcategory-discount"
                >
                    <div class="cr-cat-list cr-card card-default">
                        <div class="cr-card-content">
                            <div class="table-responsive tbl-800">
                                <table id="discount_table" class="table">
                                    <div class="select-parent-add-promotion">
                                        <label>Lọc theo:</label>
                                        <div class="select-add-promotion">
                                            <select
                                                    class="select-item"
                                                    id="category-select-discount"
                                            >
                                                <option selected disabled>- Categories -</option>
                                                <option value="1">Sách giáo khoa</option>
                                                <option value="2">Tiểu thuyết</option>
                                                <option value="3">Kỹ năng</option>
                                                <option value="4">Kinh tế</option>
                                            </select>
                                        </div>
                                        <div class="select-add-promotion">
                                            <select
                                                    class="select-item"
                                                    id="subcategory-select-discount"
                                            >
                                                <option selected disabled>
                                                    - Sub Categories -
                                                </option>
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
                                            <input
                                                    type="checkbox"
                                                    id="select-all"
                                                    style="margin-left: -3px"
                                            />
                                            Chọn tất cả
                                        </th>
                                        <th>Mã</th>
                                        <th>Tên</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr class="selectable-row">
                                        <td>
                                            <input type="checkbox" class="row-checkbox" />
                                        </td>
                                        <td>#1321</td>
                                        <td>Đắc nhân tâm</td>
                                    </tr>
                                    <tr class="selectable-row">
                                        <td>
                                            <input type="checkbox" class="row-checkbox" />
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
            <div class="row cr-promotion" data-tab="2">
                <div class="col-xl-12 col-lg-12">
                    <div class="team-sticky-bar">
                        <div class="col-md-12">
                            <div class="cr-cat-list cr-card card-default mb-24px">
                                <div class="cr-card-content">
                                    <div class="cr-cat-form">
                                        <img
                                                class="img-promotion"
                                                src="assets/img/product/1.jpg"
                                        />
                                        <h3>Thêm Voucher action="/owner/add-promotion" method="POST" </h3>

                                            <form class="promotionForm">
                                                <input type="hidden" name="formType" value="addVoucher"/>

                                                <!-- Mã -->
                                                <div class="form-group">
                                                    <label>Mã</label>
                                                    <div class="col-12">
                                                        <input name="code" class="form-control here slug-title" type="text" onblur="validateInput(this)" />
                                                        <span class="error-message codeError"></span>
                                                    </div>
                                                </div>

                                                <!-- Tiêu đề -->
                                                <div class="form-group">
                                                    <label>Tiêu đề</label>
                                                    <div class="col-12">
                                                        <input name="title" class="form-control here slug-title" type="text" onblur="validateInput(this)" />
                                                        <span class="error-message titleError"></span>
                                                    </div>
                                                </div>

                                                <!-- Số tiền giảm -->
                                                <div class="form-group">
                                                    <label>Số tiền giảm</label>
                                                    <div class="col-12">
                                                        <input name="discountLimit" class="form-control here slug-title" type="number" onblur="validateInput(this)" />
                                                        <span class="error-message discountLimitError"></span>
                                                    </div>
                                                </div>

                                                <!-- Số tiền yêu cầu trên hóa đơn -->
                                                <div class="form-group">
                                                    <label>Số tiền yêu cầu trên hóa đơn</label>
                                                    <div class="col-12">
                                                        <input name="minValueApplied" class="form-control here slug-title" type="number" onblur="validateInput(this)" />
                                                        <span class="error-message minValueAppliedError"></span>
                                                    </div>
                                                </div>

                                                <!-- Số lượng khuyến mãi -->
                                                <div class="form-group">
                                                    <label>Số lượng khuyến mãi</label>
                                                    <div class="col-12">
                                                        <input name="quantity" class="form-control here slug-title" type="number" onblur="validateInput(this)" />
                                                        <label><input type="checkbox" name="unlimited" value="true" style="margin-top: 5px" /> Không giới hạn</label>
                                                        <span class="error-message quantityError"></span>
                                                    </div>
                                                </div>

                                                <!-- Mô tả -->
                                                <div class="form-group">
                                                    <label>Mô tả</label>
                                                    <div class="col-12">
                                                        <textarea name="description" class="form-control" rows="4" onblur="validateInput(this)"></textarea>
                                                        <span class="error-message descriptionError"></span>
                                                    </div>
                                                </div>

                                                <!-- Thời gian áp dụng -->
                                                <div class="form-group row">
                                                    <label>Thời gian áp dụng</label>
                                                    <div class="col-12">
                                                        <input type="text" name="dateeffective" style="width: 100%;" onblur="validateInput(this)" />
                                                        <span class="error-message dateeffectiveError"></span>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-12 d-flex">
                                                        <button type="submit" class="btn-voucher cr-btn-primary"  onclick="return validateForm()">Thêm</button>
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
            <div class="row cr-promotion" data-tab="3">
                <div class="col-xl-12 col-lg-12">
                    <div class="team-sticky-bar">
                        <div class="col-md-12">
                            <div class="cr-cat-list cr-card card-default mb-24px">
                                <div class="cr-card-content">
                                    <div class="cr-cat-form">
                                        <img
                                                class="img-promotion"
                                                src="assets/img/product/1.jpg"
                                        />
                                        <h3>Thêm Freeship</h3>
                                        <form action="/owner/add-promotion" method="POST" class="promotionForm">
                                            <input type="hidden" name="formType" value="addFreeShip" />
                                            <div class="form-group">
                                                <label>Mã</label>
                                                <div class="col-12">
                                                    <input name="code" class="form-control here slug-title" type="text" onblur="validateInput(this)" />
                                                    <span class="error-message codeError"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Tiêu đề</label>
                                                <div class="col-12">
                                                    <input name="title" class="form-control here slug-title" type="text" onblur="validateInput(this)" />
                                                    <span class="error-message titleError"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Số tiền giảm</label>
                                                <div class="col-12">
                                                    <input name="discountLimit" class="form-control here slug-title" type="number" onblur="validateInput(this)" />
                                                    <span class="error-message discountLimitError"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Số lượng khuyến mãi</label>
                                                <div class="col-12">
                                                    <input name="quantity" class="form-control here slug-title" type="number" onblur="validateInput(this)" />
                                                    <label><input type="checkbox" name="unlimited" value="true" style="margin-top: 5px" /> Không giới hạn</label>
                                                    <span class="error-message quantityError"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Mô tả</label>
                                                <div class="col-12">
                                                    <textarea name="description" class="form-control" rows="4" onblur="validateInput(this)"></textarea>
                                                    <span class="error-message descriptionError"></span>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label>Thời gian áp dụng</label>
                                                <div class="col-12">
                                                    <input type="text" name="dateeffective" style="width: 100%;" onblur="validateInput(this)" />
                                                    <span class="error-message dateeffectiveError"></span>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-12 d-flex">
                                                    <button type="submit" class="cr-btn-primary" onclick="return validateForm()">Thêm</button>
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
        </div>
    </div>
</div>


<script>const contextPath = "<%= request.getContextPath()%>";</script>
<script src="${pageContext.request.contextPath}/assets/owner/js/add-promotion.js" defer></script>
<script src="${pageContext.request.contextPath}/assets/owner/js/validator.js" defer></script>
