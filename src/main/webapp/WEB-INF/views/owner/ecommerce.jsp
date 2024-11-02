<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title">
            <div class="cr-breadcrumb">
                <h5>Báo cáo bán hàng</h5>
                <ul>
                    <li><a href="index.html">Biblio</a></li>
                    <li>Báo cáo bán hàng</li>
                </ul>
            </div>
            <div class="cr-tools">
                <div class="daterange">
                    <i class="fa fa-calendar"></i>&nbsp;
                    <span></span>
                    <i class="fa fa-caret-down"></i>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-12">
                <div class="row">
                    <div class="col-xl-3 col-md-6">
                        <div class="cr-card">
                            <div class="cr-card-content label-card">
                                <div class="title">
												<span class="icon icon-1"
                                                ><i class="ri-shield-user-line"></i
                                                ></span>
                                    <div class="growth-numbers">
                                        <h4>Khách Hàng</h4>
                                        <h5>40</h5>
                                    </div>
                                </div>
                                <p class="card-groth up">
                                    <i class="ri-arrow-up-line"></i>
                                    32%
                                    <span>Tháng Trước</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6">
                        <div class="cr-card">
                            <div class="cr-card-content label-card">
                                <div class="title">
												<span class="icon icon-2"
                                                ><i class="ri-shopping-bag-3-line"></i
                                                ></span>
                                    <div class="growth-numbers">
                                        <h4>Đơn Hàng</h4>
                                        <h5>369</h5>
                                    </div>
                                </div>
                                <p class="card-groth down">
                                    <i class="ri-arrow-down-line"></i>
                                    1.7%
                                    <span>Tháng trước</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6">
                        <div class="cr-card">
                            <div class="cr-card-content label-card">
                                <div class="title">
												<span class="icon icon-3"
                                                ><i class="ri-money-dollar-circle-line"></i
                                                ></span>
                                    <div class="growth-numbers">
                                        <h4>Doanh Thu</h4>
                                        <h5>113.535.362 vnđ</h5>
                                    </div>
                                </div>
                                <p class="card-groth down">
                                    <i class="ri-arrow-down-line"></i>
                                    3.8%
                                    <span>Tháng trước</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6">
                        <div class="cr-card">
                            <div class="cr-card-content label-card">
                                <div class="title">
												<span class="icon icon-4"
                                                ><i class="ri-exchange-dollar-line"></i
                                                ></span>
                                    <div class="growth-numbers">
                                        <h4>Chi Phí</h4>
                                        <h5>88.287.691 vnđ</h5>
                                    </div>
                                </div>
                                <p class="card-groth up">
                                    <i class="ri-arrow-up-line"></i>
                                    8%
                                    <span>Last Month</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xxl-12 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575">
                        <h4 class="cr-card-title">Thống kê doanh thu</h4>
                        <div class="header-tools" style="font-size: 24px">
                            <a class="a-chart" id="barChartRevenueIcon">
                                <i class="ri-bar-chart-line"></i>
                            </a>
                            <a class="a-chart" id="lineChartRevenueIcon">
                                <i class="ri-line-chart-line"></i>
                            </a>
                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            >
                                <i class="ri-fullscreen-line"></i>
                            </a>
                            <div class="cr-tools">
                                <div class="daterange">
                                    <i class="fa fa-calendar"></i>&nbsp;
                                    <span></span>
                                    <i class="fa fa-caret-down"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="revenueBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xxl-12 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575" style="font-size: 24px">
                        <h4 class="cr-card-title">
                            Thống kê doanh thu theo từng mục sách
                        </h4>
                        <div class="header-tools">
                            <div class="select-category" style="margin-bottom: 6px">
                                <select class="select-item">
                                    <option selected disabled>Danh mục</option>
                                    <option value="1">Truyện cổ tích</option>
                                    <option value="2">Kỹ năng sống</option>
                                    <option value="3">Kinh tế</option>
                                    <option value="4">Công nghệ thông tin</option>
                                    <option value="1">Truyện cổ tích</option>
                                    <option value="2">Kỹ năng sống</option>
                                    <option value="3">Kinh tế</option>
                                    <option value="4">Công nghệ thông tin</option>
                                    <option value="1">Truyện cổ tích</option>
                                    <option value="2">Kỹ năng sống</option>
                                    <option value="3">Kinh tế</option>
                                    <option value="4">Công nghệ thông tin là môn gì</option>
                                </select>
                            </div>
                            <a class="a-chart"><i class="ri-bar-chart-line"></i></a>
                            <a class="a-chart"><i class="ri-line-chart-line"></i></a>
                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            ><i class="ri-fullscreen-line"></i
                            ></a>
                            <div class="cr-tools">
                                <div class="daterange">
                                    <i class="fa fa-calendar"></i>&nbsp;
                                    <span></span>
                                    <i class="fa fa-caret-down"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="revenueOfCategoryBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xxl-12 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575">
                        <h4 class="cr-card-title">Thống kê đơn hàng</h4>
                        <div class="header-tools" style="font-size: 24px">
                            <a class="a-chart"><i class="ri-bar-chart-line"></i></a>
                            <a class="a-chart"><i class="ri-line-chart-line"></i></a>
                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            ><i class="ri-fullscreen-line"></i
                            ></a>
                            <div class="cr-tools">
                                <div class="daterange">
                                    <i class="fa fa-calendar"></i>&nbsp;
                                    <span></span>
                                    <i class="fa fa-caret-down"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="orderBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xxl-12 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575">
                        <h4 class="cr-card-title">
                            Thống kê đơn hàng theo từng mục sách
                        </h4>
                        <div class="header-tools" style="font-size: 24px">
                            <div class="select-category" style="margin-bottom: 3px">
                                <select class="select-item">
                                    <option selected disabled>Danh mục</option>
                                    <option value="1">Truyện cổ tích</option>
                                    <option value="2">Kỹ năng sống</option>
                                    <option value="3">Kinh tế</option>
                                    <option value="4">Công nghệ thông tin</option>
                                    <option value="1">Truyện cổ tích</option>
                                    <option value="2">Kỹ năng sống</option>
                                    <option value="3">Kinh tế</option>
                                    <option value="4">Công nghệ thông tin</option>
                                    <option value="1">Truyện cổ tích</option>
                                    <option value="2">Kỹ năng sống</option>
                                    <option value="3">Kinh tế</option>
                                    <option value="4">Công nghệ thông tin là môn gì</option>
                                </select>
                            </div>
                            <a class="a-chart"><i class="ri-bar-chart-line"></i></a>
                            <a class="a-chart"><i class="ri-line-chart-line"></i></a>

                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            ><i class="ri-fullscreen-line"></i
                            ></a>
                            <div class="cr-tools">
                                <div class="daterange">
                                    <i class="fa fa-calendar"></i>&nbsp;
                                    <span></span>
                                    <i class="fa fa-caret-down"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="categoryOderBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xxl-12 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575">
                        <h4 class="cr-card-title">Top sách bán chạy</h4>
                        <div class="header-tools" style="font-size: 24px">
                            <div class="select-category" style="margin-bottom: 6px">
                                <select class="select-item">
                                    <option selected disabled>- Top -</option>
                                    <option value="1">10</option>
                                    <option value="2">20</option>
                                    <option value="3">30</option>
                                </select>
                            </div>
                            <a class="a-chart"><i class="ri-bar-chart-line"></i></a>
                            <a class="a-chart"><i class="ri-pie-chart-fill"></i></a>
                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            ><i class="ri-fullscreen-line"></i
                            ></a>
                            <div class="cr-date-range date">
                                <span></span>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="topTenBookSellingBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xxl-12 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575">
                        <h4 class="cr-card-title">Thống kê khách hàng mới</h4>
                        <div class="header-tools" style="font-size: 24px">
                            <a class="a-chart"><i class="ri-bar-chart-line"></i></a>
                            <a class="a-chart"><i class="ri-line-chart-line"></i></a>
                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            ><i class="ri-fullscreen-line"></i
                            ></a>
                            <div class="cr-date-range date">
                                <span></span>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="newCustomerBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xxl-12 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575">
                        <h4 class="cr-card-title">Tỉ lệ đơn bị hoàn trả</h4>
                        <div class="header-tools" style="font-size: 24px">
                            <a class="a-chart"><i class="ri-bar-chart-line"></i></a>
                            <a class="a-chart"
                            ><i class="ri-bar-chart-horizontal-line"></i
                            ></a>
                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            ><i class="ri-fullscreen-line"></i
                            ></a>
                            <div class="cr-tools">
                                <div class="daterange">
                                    <i class="fa fa-calendar"></i>&nbsp;
                                    <span></span>
                                    <i class="fa fa-caret-down"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="refundOderBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xxl-12 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575">
                        <h4 class="cr-card-title">Tỉ lệ đơn bị hủy</h4>
                        <div class="header-tools">
                            <a class="a-chart"><i class="ri-bar-chart-line"></i></a>
                            <a class="a-chart"
                            ><i class="ri-bar-chart-horizontal-line"></i
                            ></a>
                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            ><i class="ri-fullscreen-line"></i
                            ></a>
                            <div class="cr-tools">
                                <div class="daterange">
                                    <i class="fa fa-calendar"></i>&nbsp;
                                    <span></span>
                                    <i class="fa fa-caret-down"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="cancelOderBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xxl-6 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575">
                        <h4 class="cr-card-title">Lý do đơn bị hoàn trả</h4>
                        <div class="header-tools" style="font-size: 24px">
                            <a class="a-chart"><i class="ri-bar-chart-line"></i></a>
                            <a class="a-chart"><i class="ri-pie-chart-line"></i></a>
                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            ><i class="ri-fullscreen-line"></i
                            ></a>
                            <div class="cr-tools">
                                <div class="daterange">
                                    <i class="fa fa-calendar"></i>&nbsp;
                                    <span></span>
                                    <i class="fa fa-caret-down"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="reasonRefundOderBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xxl-6 col-xl-12">
                <div class="cr-card revenue-overview">
                    <div class="cr-card-header header-575">
                        <h4 class="cr-card-title">Lý do đơn bị hủy</h4>
                        <div class="header-tools" style="font-size: 24px">
                            <a class="a-chart"><i class="ri-bar-chart-line"></i></a>
                            <a class="a-chart"><i class="ri-pie-chart-line"></i></a>
                            <a
                                    href="javascript:void(0)"
                                    class="m-r-10 cr-full-card"
                                    title="Full Screen"
                            ><i class="ri-fullscreen-line"></i
                            ></a>
                            <div class="cr-tools">
                                <div class="daterange">
                                    <i class="fa fa-calendar"></i>&nbsp;
                                    <span></span>
                                    <i class="fa fa-caret-down"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cr-card-content">
                        <div class="cr-chart-content">
                            <div id="reasonCancelOderBarChart" class="mb-m-24"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>