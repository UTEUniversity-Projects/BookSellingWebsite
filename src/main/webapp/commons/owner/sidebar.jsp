<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- sidebar -->
<div class="cr-sidebar-overlay"></div>
<div class="cr-sidebar" data-mode="light">
    <div class="cr-sb-logo">
        <a href="index.html" class="sb-full"
        ><img src="${pageContext.request.contextPath}/assets/owner/img/logo/full-logo.png" alt="logo"
        /></a>
        <a href="index.html" class="sb-collapse"
        ><img src="${pageContext.request.contextPath}/assets/owner/img/logo/collapse-logo.png" alt="logo"
        /></a>
    </div>
    <div class="cr-sb-wrapper">
        <div class="cr-sb-content">
            <ul class="cr-sb-list">
                <li class="cr-sb-item sb-drop-item"></li>
                <li class="cr-sb-title condense">Bảng điều khiển</li>
                <li class="cr-sb-item sb-drop-item">
                    <a href="javascript:void(0)" class="cr-drop-toggle">
                        <i class="ri-dashboard-3-line"></i
                        ><span class="condense"
                    >Bảng điều khiển<i
                            class="drop-arrow ri-arrow-down-s-line"
                    ></i></span
                    ></a>
                    <ul class="cr-sb-drop condense">
                        <li class="cr-sb-item sb-subdrop-item">
                            <a href="javascript:void(0)" class="cr-sub-drop-toggle">
                                <i class="ri-bar-chart-2-line"></i
                                ><span class="condense"
                            >Tài chính<i
                                    class="drop-arrow ri-arrow-down-s-line"
                            ></i></span
                            ></a>
                            <ul class="cr-sb-subdrop condense">
                                <li>
                                    <a href="/owner/ecommerce" class="cr-page-link drop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Báo cáo
                                        tài chính</a
                                    >
                                </li>
                            </ul>
                        </li>
                        <li class="cr-sb-item sb-subdrop-item">
                            <a href="javascript:void(0)" class="cr-sub-drop-toggle">
                                <i class="ri-product-hunt-line"></i
                                ><span class="condense"
                            >Sản phẩm<i
                                    class="drop-arrow ri-arrow-down-s-line"
                            ></i></span
                            ></a>
                            <ul class="cr-sb-subdrop condense">
                                <li>
                                    <a href="${pageContext.request.contextPath}/owner/product-list" class="cr-page-link drop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Danh
                                        sách sản phẩm</a
                                    >
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/owner/add-product" class="cr-page-link drop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Thêm sản
                                        phẩm</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/owner/tag-list" class="cr-page-link drop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Danh sách nhãn</a>
                                </li>
                                <li>
                                    <a
                                            href="${pageContext.request.contextPath}/owner/category-list"
                                            class="cr-page-link drop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Danh sách phân loại</a>
                                </li>
                                <li>
                                    <a
                                            href="${pageContext.request.contextPath}/owner/sub-category-list"
                                            class="cr-page-link drop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Danh sách phân loại con</a>
                                </li>
                            </ul>
                        </li>
                        <li class="cr-sb-item sb-subdrop-item">
                            <a href="javascript:void(0)" class="cr-sub-drop-toggle">
                                <i class="ri-coupon-3-line"></i
                                ><span class="condense"
                            >Khuyến mãi<i
                                    class="drop-arrow ri-arrow-down-s-line"
                            ></i></span
                            ></a>
                            <ul class="cr-sb-subdrop condense">
                                <li>
                                    <a href="/owner/promotion-list" class="cr-page-link drop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Danh
                                        sách khuyến mãi</a
                                    >
                                </li>
                                <li>
                                    <a href="/owner/add-promotion" class="cr-page-link drop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Thêm
                                        khuyến mãi</a
                                    >
                                </li>
                            </ul>
                        </li>
                        <li class="cr-sb-item sb-subdrop-item">
                            <a href="javascript:void(0)" class="cr-sub-drop-toggle">
                                <i class="ri-file-user-line"></i
                                ><span class="condense"
                            >Khách hàng<i
                                    class="drop-arrow ri-arrow-down-s-line"
                            ></i></span
                            ></a>
                            <ul class="cr-sb-subdrop condense">
                                <li>
                                    <a
                                            href="${pageContext.request.contextPath}/owner/customer-list"
                                            class="cr-page-link subdrop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Danh
                                        sách khách hàng</a
                                    >
                                </li>
                            </ul>
                        </li>
                        <li class="cr-sb-item sb-subdrop-item">
                            <a href="javascript:void(0)" class="cr-sub-drop-toggle">
                                <i class="ri-account-pin-box-line"></i>
                                <span class="condense">
                                    Nhân viên
                                    <i class="drop-arrow ri-arrow-down-s-line"></i>
                                </span>
                            </a>
                            <ul class="cr-sb-subdrop condense">
                                <li>
                                    <a href="${pageContext.request.contextPath}/owner/staff-list" class="cr-page-link subdrop">
                                        <i class="ri-checkbox-blank-circle-line"></i>
                                        Danh sách nhân viên
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="cr-sb-item sb-subdrop-item">
                            <a href="javascript:void(0)" class="cr-sub-drop-toggle">
                                <i class="ri-file-list-2-line"></i
                                ><span class="condense"
                            >Nội dung trang<i
                                    class="drop-arrow ri-arrow-down-s-line"
                            ></i></span
                            ></a>
                            <ul class="cr-sb-subdrop condense">
                                <li>
                                    <a href="${pageContext.request.contextPath}/owner/content-list" class="cr-page-link subdrop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Danh sách nội dung</a>
                                </li>
                            </ul>
                        </li>
                        <li class="cr-sb-item sb-subdrop-item">
                            <a href="javascript:void(0)" class="cr-sub-drop-toggle">
                                <i class="ri-airplay-line"></i
                                ><span class="condense"
                            >Quản lý khác<i
                                    class="drop-arrow ri-arrow-down-s-line"
                            ></i></span
                            ></a>
                            <ul class="cr-sb-subdrop condense">
                                <li>
                                    <a href="${pageContext.request.contextPath}/owner/author-list" class="cr-page-link subdrop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Tác
                                        giả</a
                                    >
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/owner/translator-list" class="cr-page-link drop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Dịch
                                        giả</a
                                    >
                                </li>
                                <li>
                                    <a
                                            href="${pageContext.request.contextPath}/owner/publisher-list"
                                            class="cr-page-link subdrop"
                                    ><i class="ri-checkbox-blank-circle-line"></i>Nhà xuất
                                        bản</a
                                    >
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
