<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <ul>
                    <li><a href="index.html">Carrot</a></li>
                    <li>Trung tâm hỗ trợ khách hàng</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card product-list" id="ordertbl">
                    <div class="cr-card-header">
                        <h4 class="cr-card-title">Trung tâm hỗ trợ khách hàng</h4>
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
                                            data-value="NOT_RESPONDED"
                                    >
                                        Chưa phản hồi
                                    </a>
                                    <a
                                            class="dropdown-item"
                                            href="#"
                                            data-value="RESPONDED"
                                    >
                                        Đã phản hồi
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content card-default">
                        <div class="table-responsive">
                            <table id="support-cus-list" class="table">
                                <thead>
                                <tr>
                                    <th>Khách hàng</th>
                                    <th>Yêu cầu</th>
                                    <th>Ngày gửi</th>
                                    <th>Trạng thái</th>
                                    <th width="11%">Hành động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Nguyễn Văn A</td>
                                    <td>Hoàn trả</td>
                                    <td>07/10/2024</td>
                                    <td data-status="NOT_RESPONDED">
														<span class="status status__pending">
															Chưa phản hồi
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
                                                    <i class="ri-feedback-line"></i>
                                                    Phản hồi
                                                </a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Nguyễn Văn B</td>
                                    <td>Hoàn trả</td>
                                    <td>07/10/2024</td>
                                    <td data-status="RESPONDED">
														<span class="status status__completed">
															Đã phản hồi
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
                                                    <i class="ri-feedback-line"></i>
                                                    Phản hồi
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
