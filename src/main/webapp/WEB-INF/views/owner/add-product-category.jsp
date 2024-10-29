<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Phân loại</h5>
                <ul>
                    <li><a href="index.html">Biblio</a></li>
                    <li>Phân loại</li>
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
                                    <h3>Thêm phân loại mới</h3>

                                    <form>

                                        <div class="form-group">
                                            <label>Tên loại</label>
                                            <div class="col-12">
                                                <input id="text" name="text"
                                                       class="form-control here slug-title" type="text">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label>Mô tả ngắn</label>
                                            <div class="col-12">
														<textarea id="sortdescription" name="sortdescription" cols="40"
                                                                  rows="2" class="form-control"></textarea>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label>Mô tả đầy đủ</label>
                                            <div class="col-12">
														<textarea id="fulldescription" name="fulldescription" cols="40"
                                                                  rows="4" class="form-control"></textarea>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-12 d-flex">
                                                <button type="submit" class="cr-btn-primary">Xác nhận</button>
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
                                    <th>Tên</th>
                                    <th>Các loại con</th>
                                    <th>Số sản phẩm</th>
                                    <th>Trạng thái</th>
                                    <th>Xu hướng</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td>Bags</td>
                                    <td>
													<span class="cr-sub-cat-list">
														<span class="cr-sub-cat-count"
                                                              title="Total Sub Categories">4</span>
														<span class="cr-sub-cat-tag">shopping bag</span>
														<span class="cr-sub-cat-tag">Gym backpack</span>
														<span class="cr-sub-cat-tag">purse </span>
														<span class="cr-sub-cat-tag">wallet </span>
													</span>
                                    </td>
                                    <td>18</td>
                                    <td class="active">ACTIVE</td>
                                    <td><span class="badge badge-success">Top</span></td>
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
                                <tr>
                                    <td>Computers</td>
                                    <td>
													<span class="cr-sub-cat-list">
														<span class="cr-sub-cat-count"
                                                              title="Total Sub Categories">5</span>
														<span class="cr-sub-cat-tag">Dell</span>
														<span class="cr-sub-cat-tag">sony</span>
														<span class="cr-sub-cat-tag">lenovo</span>
														<span class="cr-sub-cat-tag">Samsung</span>
														<span class="cr-sub-cat-tag">lg</span>
													</span>
                                    </td>
                                    <td>65</td>
                                    <td class="active">ACTIVE</td>
                                    <td><span class="badge bg-primary">Medium</span></td>
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
                                <tr>
                                    <td>Cosmetics</td>
                                    <td>
													<span class="cr-sub-cat-list">
														<span class="cr-sub-cat-count"
                                                              title="Total Sub Categories">10</span>
														<span class="cr-sub-cat-tag">Makeup kit</span>
														<span class="cr-sub-cat-tag">Hair gel</span>
														<span class="cr-sub-cat-tag">sunscreen</span>
														<span class="cr-sub-cat-tag">facewash</span>
														<span class="cr-sub-cat-tag">Body shop</span>
														<span class="cr-sub-cat-tag">Lipstick</span>
														<span class="cr-sub-cat-tag">eye liner</span>
														<span class="cr-sub-cat-tag">Hair Shampoo</span>
														<span class="cr-sub-cat-tag">Beauty Cream</span>
														<span class="cr-sub-cat-tag">Skin Serum</span>
													</span>
                                    </td>
                                    <td>18</td>
                                    <td class="disable">INACTIVE</td>
                                    <td><span class="badge bg-danger">Low</span></td>
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
