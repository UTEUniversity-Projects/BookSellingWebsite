<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <ul>
                    <li><a href="index.html">Biblio</a></li>
                    <li>Danh sách sản phẩm</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card product-list" id="ordertbl">
                    <div class="cr-card-header">
                        <h4 class="cr-card-title">Danh sách sản phẩm</h4>
                        <div class="header-tools">
                            <a href="javascript:void(0)" class="m-r-10 cr-full-card">
                                <i class="ri-fullscreen-line"></i>
                            </a>
                            <div class="cr-date-range dots m-r-10">
                                <span></span>
                            </div>
                            <div>
                                <button
                                        type="button"
                                        class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                        data-bs-toggle="dropdown"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                        data-display="static"
                                >
                                    <span id="selected-text">Tất cả</span>
                                    <span class="sr-only">
													<i class="ri-arrow-down-s-line"></i>
												</span>
                                </button>
                                <div class="dropdown-menu dropdown-menu__status">
                                    <a class="dropdown-item" href="#" data-value="ALL">
                                        Tất cả
                                    </a>
                                    <a
                                            class="dropdown-item"
                                            href="#"
                                            data-value="COMING_SOON"
                                    >
                                        Sắp mở bán
                                    </a>
                                    <a class="dropdown-item" href="#" data-value="ON_SALE">
                                        Đang bán
                                    </a>
                                    <a
                                            class="dropdown-item"
                                            href="#"
                                            data-value="OUT_OF_STOCK"
                                    >
                                        Hết hàng
                                    </a>
                                    <a
                                            class="dropdown-item"
                                            href="#"
                                            data-value="STOP_SELLING"
                                    >
                                        Ngừng kinh doanh
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content card-default">
                        <div class="table-responsive">
                            <table id="product-data-table" class="table table-hover">
                                <thead>
                                <tr>
                                    <th width="5%"></th>
                                    <th width="20%">Tiêu đề</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Đã bán</th>
                                    <th>Ngày mở bán</th>
                                    <th>
                                        <span>Trạng thái</span>
                                    </th>
                                    <th width="11%">Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                        <img
                                                class="tbl-thumb"
                                                src="/assets/staff/img/product/1.jpg"
                                                alt="Product Image"
                                        />
                                    </td>
                                    <td>Mens t-shirt</td>
                                    <td>10.000.000VND</td>
                                    <td>100</td>
                                    <td>61</td>
                                    <td>05/11/2023</td>
                                    <td data-status="ON_SALE">
														<span class="status status__on_sale"
                                                        >Đang mở bán</span
                                                        >
                                    </td>
                                    <td>
                                        <div class="d-flex justify-content-start">
                                            <button
                                                    type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown"
                                                    aria-haspopup="true"
                                                    aria-expanded="false"
                                                    data-display="static"
                                            >
																<span class="sr-only">
																	<i class="ri-settings-3-line"></i>
																</span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-eye-line"></i>
                                                    Xem trước
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-pencil-line"></i>
                                                    Chỉnh sửa
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-delete-bin-line"></i>
                                                    Xóa
                                                </a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img
                                                class="tbl-thumb"
                                                src="/assets/staff/img/product/1.jpg"
                                                alt="Product Image"
                                        />
                                    </td>
                                    <td>Mens t-shirt</td>
                                    <td>10.000.000VND</td>
                                    <td>100</td>
                                    <td>61</td>
                                    <td>05/11/2023</td>
                                    <td data-status="OUT_OF_STOCK">
														<span class="status status__out_of_stock"
                                                        >Hết hàng</span
                                                        >
                                    </td>
                                    <td>
                                        <div class="d-flex justify-content-start">
                                            <button
                                                    type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown"
                                                    aria-haspopup="true"
                                                    aria-expanded="false"
                                                    data-display="static"
                                            >
                                                    <span class="sr-only">
                                                        <i class="ri-settings-3-line"></i>
                                                    </span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-eye-line"></i>
                                                    Xem trước
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-pencil-line"></i>
                                                    Chỉnh sửa
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-delete-bin-line"></i>
                                                    Xóa
                                                </a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img
                                                class="tbl-thumb"
                                                src="/assets/staff/img/product/1.jpg"
                                                alt="Product Image"
                                        />
                                    </td>
                                    <td>Mens t-shirt</td>
                                    <td>10.000.000VND</td>
                                    <td>100</td>
                                    <td>61</td>
                                    <td>05/11/2023</td>
                                    <td data-status="COMING_SOON">
														<span class="status status__coming_soon"
                                                        >Sắp mở bán</span
                                                        >
                                    </td>
                                    <td>
                                        <div class="d-flex justify-content-start">
                                            <button
                                                    type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown"
                                                    aria-haspopup="true"
                                                    aria-expanded="false"
                                                    data-display="static"
                                            >
																<span class="sr-only">
																	<i class="ri-settings-3-line"></i>
																</span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-eye-line"></i>
                                                    Xem trước
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-pencil-line"></i>
                                                    Chỉnh sửa
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-delete-bin-line"></i>
                                                    Xóa
                                                </a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img
                                            class="tbl-thumb"
                                            src="/assets/staff/img/product/1.jpg"
                                            alt="Product Image"
                                        />
                                    </td>
                                    <td>Mens t-shirt</td>
                                    <td>10.000.000VND</td>
                                    <td>100</td>
                                    <td>61</td>
                                    <td>05/11/2023</td>
                                    <td data-status="STOP_SELLING">
														<span class="status status__stop_selling">
															Ngừng kinh doanh
														</span>
                                    </td>
                                    <td>
                                        <div class="d-flex justify-content-start">
                                            <button
                                                    type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown"
                                                    aria-haspopup="true"
                                                    aria-expanded="false"
                                                    data-display="static"
                                            >
																<span class="sr-only">
																	<i class="ri-settings-3-line"></i>
																</span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-eye-line"></i>
                                                    Xem trước
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-pencil-line"></i>
                                                    Chỉnh sửa
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="ri-delete-bin-line"></i>
                                                    Xóa
                                                </a>
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