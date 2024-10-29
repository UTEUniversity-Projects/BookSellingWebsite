<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Danh sách nhân viên</h5>
                <ul>
                    <li><a href="index.html">Carrot</a></li>
                    <li>Danh sách nhân viên</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card card-default product-list">
                    <div class="cr-card-content ">
                        <div class="table-responsive">
                            <table id="product_list" class="table" style="width:100%">
                                <thead>
                                <tr>
                                    <th>Mã</th>
                                    <th>Họ và Tên</th>
                                    <th>Email</th>
                                    <th>Số điện thoại</th>
                                    <th>Bắt đầu làm việc</th>
                                    <th>Trạng thái</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td>#012</td>
                                    <td>Nguyễn Văn An</td>
                                    <td>nvan@gmail.com</td>
                                    <td>0702546327</td>
                                    <td>05/11/2022</td>
                                    <td>
                                        <span class="active">Đang hoạt động</span>
                                    </td>
                                    <td>
                                        <div class="d-flex justify-content-start">
                                            <button type="button"
                                                    class="btn btn-outline-success dropdown-toggle dropdown-toggle-split"
                                                    data-bs-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="false" data-display="static">
															<span class="sr-only"><i
                                                                    class="ri-settings-3-line"></i></span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Cập nhật thông tin</a>
                                                <a class="dropdown-item" href="#">Vô hiệu hóa tài khoản</a>
                                                <a class="dropdown-item" href="#">Mở khóa tài khoản</a>
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