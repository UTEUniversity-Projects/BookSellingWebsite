<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Danh sách khuyến mãi</h5>
                <ul>
                    <li><a href="index.html">Biblio</a></li>
                    <li>Danh sách khuyến mãi</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="tab-promotion">
                    <div class="tab-list-promotion">
                        <div class="tab-item-promotion active" data-tab="1">Discount</div>
                        <div class="tab-item-promotion" data-tab="2">Voucher</div>
                        <div class="tab-item-promotion" data-tab="3">Coupon</div>
                        <div class="tab-item-promotion" data-tab="4">Freeship</div>
                    </div>
                </div>
                <div class="cr-card card-default ">
                    <div class="cr-card-content promotion-list" data-tab="1" style="width: 100%;">
                        <div class="table-responsive">
                            <table id="discount_list" class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Mã</th>
                                    <th>%</th>
                                    <th>Tiêu đề</th>
                                    <th>Số lượng</th>
                                    <th>Bắt đầu</th>
                                    <th>Kết thúc</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td><img class="tbl-thumb" src="/assets/owner/img/product/1.jpg"
                                             alt="Product Image"></td>
                                    <td>Dicount</td>
                                    <td>50%</td>
                                    <td>Giảm giá 20 - 10</td>
                                    <td>Không giới hạn</td>
                                    <td>20/10/2024 - 00:00 AM</td>
                                    <td>21/10/2024 - 00:00 AM</td>
                                    <td><span class="active">active</span></td>
                                    <td>
                                        <div class="d-flex justify-content-center">
                                            <button type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="false" data-display="static">
															<span class="sr-only"><i
                                                                    class="ri-settings-3-line"></i></span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Chỉnh sửa</a>
                                                <a class="dropdown-item" href="#">Ngừng khuyến mãi</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="cr-card-content promotion-list" data-tab="2" style="width: 100%;">
                        <div class="table-responsive">
                            <table id="voucher_list" class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Mã</th>
                                    <th>%</th>
                                    <th>Tiêu đề</th>
                                    <th>Số lượng</th>
                                    <th>Bắt đầu</th>
                                    <th>Kết thúc</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td><img class="tbl-thumb" src="/assets/owner/img/product/1.jpg"
                                             alt="Product Image"></td>
                                    <td>Voucher</td>
                                    <td>50%</td>
                                    <td>Giảm giá 20 - 10</td>
                                    <td>Không giới hạn</td>
                                    <td>20/10/2024 - 00:00 AM</td>
                                    <td>21/10/2024 - 00:00 AM</td>
                                    <td><span class="active">active</span></td>
                                    <td>
                                        <div class="d-flex justify-content-center">
                                            <button type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="false" data-display="static">
															<span class="sr-only"><i
                                                                    class="ri-settings-3-line"></i></span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Chỉnh sửa</a>
                                                <a class="dropdown-item" href="#">Ngừng khuyến mãi</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="cr-card-content promotion-list" data-tab="3" style="width: 100%;">
                        <div class="table-responsive">
                            <table id="coupon_list" class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Mã</th>
                                    <th>%</th>
                                    <th>Tiêu đề</th>
                                    <th>Số lượng</th>
                                    <th>Bắt đầu</th>
                                    <th>Kết thúc</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td><img class="tbl-thumb" src="/assets/owner/img/product/1.jpg"
                                             alt="Product Image"></td>
                                    <td>Coupon</td>
                                    <td>50%</td>
                                    <td>Giảm giá 20 - 10</td>
                                    <td>Không giới hạn</td>
                                    <td>20/10/2024 - 00:00 AM</td>
                                    <td>21/10/2024 - 00:00 AM</td>
                                    <td><span class="active">active</span></td>
                                    <td>
                                        <div class="d-flex justify-content-center">
                                            <button type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="false" data-display="static">
															<span class="sr-only"><i
                                                                    class="ri-settings-3-line"></i></span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Chỉnh sửa</a>
                                                <a class="dropdown-item" href="#">Ngừng khuyến mãi</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="cr-card-content promotion-list" data-tab="4" style="width: 100%;">
                        <div class="table-responsive">
                            <table id="freeship_list" class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Mã</th>
                                    <th>%</th>
                                    <th>Tiêu đề</th>
                                    <th>Số lượng</th>
                                    <th>Bắt đầu</th>
                                    <th>Kết thúc</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td><img class="tbl-thumb" src="/assets/owner/img/product/1.jpg"
                                             alt="Product Image"></td>
                                    <td>Freeship</td>
                                    <td>50%</td>
                                    <td>Giảm giá 20 - 10</td>
                                    <td>Không giới hạn</td>
                                    <td>20/10/2024 - 00:00 AM</td>
                                    <td>21/10/2024 - 00:00 AM</td>
                                    <td><span class="active">active</span></td>
                                    <td>
                                        <div class="d-flex justify-content-center">
                                            <button type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="false" data-display="static">
															<span class="sr-only"><i
                                                                    class="ri-settings-3-line"></i></span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Chỉnh sửa</a>
                                                <a class="dropdown-item" href="#">Ngừng khuyến mãi</a>
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
