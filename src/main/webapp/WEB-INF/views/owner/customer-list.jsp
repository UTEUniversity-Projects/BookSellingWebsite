<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Danh sách khách hàng</h5>
                <ul>
                    <li><a href="index.html">Biblio</a></li>
                    <li>Danh sách khách hàng</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card card-default product-list">
                    <div class="cr-card-content">
                        <div class="table-responsive">
                            <table id="customer-data-table" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên</th>
                                    <th>Email</th>
                                    <th>Số đơn hàng</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr class="customer-row" data-href="/owner/customer-profile">
                                    <td>#012</td>
                                    <td>name</td>
                                    <td>name@gmail.com</td>
                                    <td>78</td>
                                    <td class="cod">Tài khoản bị khóa</td>
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