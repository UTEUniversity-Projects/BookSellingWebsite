<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- main content -->
<div class="cr-main-content">
    <div class="container-fluid">
        <!-- Page title & breadcrumb -->
        <div class="cr-page-title cr-page-title-2">
            <div class="cr-breadcrumb">
                <h5>Nội dung trang</h5>
                <ul>
                    <li><a href="#">Biblio</a></li>
                    <li>Nội dung trang</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="cr-card card-default">
                    <div class="cr-card-content">
                        <div class="row cr-product-uploads">

                            <!-- Store Introduction Section -->
                            <div class="col-lg-12 mb-4">
                                <h5>Giới thiệu cửa hàng</h5>
                                <textarea class="form-control" id="store-introduction-text" rows="4" readonly>Giới thiệu cửa hàng.</textarea>
                                <div class="edit-buttons d-flex justify-content-end mt-2">
                                    <button type="button" class="btn cr-btn-primary" id="edit-store-introduction"
                                            onclick="startEdit('store-introduction')">
                                        <i class="ri-pencil-line"></i> Chỉnh sửa
                                    </button>
                                    <div id="save-cancel-store-introduction" class="d-none">
                                        <button type="button" class="btn cr-btn-success"
                                                onclick="saveContent('store-introduction')">
                                            <i class="ri-check-line"></i> Lưu
                                        </button>
                                        <button type="button" class="btn cr-btn-danger"
                                                onclick="cancelEdit('store-introduction')">
                                            <i class="ri-close-line"></i> Hủy
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <!-- Customer Terms Section -->
                            <div class="col-lg-12 mb-4">
                                <h5>Điều khoản khách hàng</h5>
                                <textarea class="form-control" id="customer-terms-text" rows="4" readonly>Điều khoản khách hàng.</textarea>
                                <div class="edit-buttons d-flex justify-content-end mt-2">
                                    <button type="button" class="btn cr-btn-primary" id="edit-customer-terms"
                                            onclick="startEdit('customer-terms')">
                                        <i class="ri-pencil-line"></i> Chỉnh sửa
                                    </button>
                                    <div id="save-cancel-customer-terms" class="d-none">
                                        <button type="button" class="btn cr-btn-success"
                                                onclick="saveContent('customer-terms')">
                                            <i class="ri-check-line"></i> Lưu
                                        </button>
                                        <button type="button" class="btn cr-btn-danger"
                                                onclick="cancelEdit('customer-terms')">
                                            <i class="ri-close-line"></i> Hủy
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <!-- Privacy Policy Section -->
                            <div class="col-lg-12 mb-4">
                                <h5>Chính sách bảo mật</h5>
                                <textarea class="form-control" id="privacy-policy-text" rows="4" readonly>Chính sách bảo mật.</textarea>
                                <div class="edit-buttons d-flex justify-content-end mt-2">
                                    <button type="button" class="btn cr-btn-primary" id="edit-privacy-policy"
                                            onclick="startEdit('privacy-policy')">
                                        <i class="ri-pencil-line"></i> Chỉnh sửa
                                    </button>
                                    <div id="save-cancel-privacy-policy" class="d-none">
                                        <button type="button" class="btn cr-btn-success"
                                                onclick="saveContent('privacy-policy')">
                                            <i class="ri-check-line"></i> Lưu
                                        </button>
                                        <button type="button" class="btn cr-btn-danger"
                                                onclick="cancelEdit('privacy-policy')">
                                            <i class="ri-close-line"></i> Hủy
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <!-- Shipping Policy Section -->
                            <div class="col-lg-12 mb-4">
                                <h5>Chính sách vận chuyển</h5>
                                <textarea class="form-control" id="shipping-policy-text" rows="4" readonly>Chính sách vận chuyển.</textarea>
                                <div class="edit-buttons d-flex justify-content-end mt-2">
                                    <button type="button" class="btn cr-btn-primary" id="edit-shipping-policy"
                                            onclick="startEdit('shipping-policy')">
                                        <i class="ri-pencil-line"></i> Chỉnh sửa
                                    </button>
                                    <div id="save-cancel-shipping-policy" class="d-none">
                                        <button type="button" class="btn cr-btn-success"
                                                onclick="saveContent('shipping-policy')">
                                            <i class="ri-check-line"></i> Lưu
                                        </button>
                                        <button type="button" class="btn cr-btn-danger"
                                                onclick="cancelEdit('shipping-policy')">
                                            <i class="ri-close-line"></i> Hủy
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <!-- Payment and Return Policy Section -->
                            <div class="col-lg-12 mb-4">
                                <h5>Chính sách đổi trả</h5>
                                <textarea class="form-control" id="payment-policy-text" rows="4" readonly>Chính sách đổi trả.</textarea>
                                <div class="edit-buttons d-flex justify-content-end mt-2">
                                    <button type="button" class="btn cr-btn-primary" id="edit-payment-policy"
                                            onclick="startEdit('payment-policy')">
                                        <i class="ri-pencil-line"></i> Chỉnh sửa
                                    </button>
                                    <div id="save-cancel-payment-policy" class="d-none">
                                        <button type="button" class="btn cr-btn-success"
                                                onclick="saveContent('payment-policy')">
                                            <i class="ri-check-line"></i> Lưu
                                        </button>
                                        <button type="button" class="btn cr-btn-danger"
                                                onclick="cancelEdit('payment-policy')">
                                            <i class="ri-close-line"></i> Hủy
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <!-- Promotion Policy Section -->
                            <div class="col-lg-12 mb-4">
                                <h5>Chính sách khuyến mãi</h5>
                                <textarea class="form-control" id="promotion-policy-text" rows="4" readonly>Chính sách khuyến mãi.</textarea>
                                <div class="edit-buttons d-flex justify-content-end mt-2">
                                    <button type="button" class="btn cr-btn-primary" id="edit-promotion-policy"
                                            onclick="startEdit('promotion-policy')">
                                        <i class="ri-pencil-line"></i> Chỉnh sửa
                                    </button>
                                    <div id="save-cancel-promotion-policy" class="d-none">
                                        <button type="button" class="btn cr-btn-success"
                                                onclick="saveContent('promotion-policy')">
                                            <i class="ri-check-line"></i> Lưu
                                        </button>
                                        <button type="button" class="btn cr-btn-danger"
                                                onclick="cancelEdit('promotion-policy')">
                                            <i class="ri-close-line"></i> Hủy
                                        </button>
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
