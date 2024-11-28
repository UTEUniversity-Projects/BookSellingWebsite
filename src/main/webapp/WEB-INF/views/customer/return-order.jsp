<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script defer src="${pageContext.request.contextPath}/assets/customer/js/return-book.js"></script>

<!-- Return Order Form -->
<section class="section-return py-5 bg-light">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">

                <!-- Form Sản phẩm -->
                <div class="product-return-form p-4 bg-white shadow rounded mb-4">
                    <div class="form-logo text-center mb-4">
                        <img src="${pageContext.request.contextPath}/assets/img/logo/mebook-2.png" alt="logo" class="img-fluid" style="max-width: 150px;" />
                    </div>

                    <div id="product-list" class="return-product-box p-4 rounded-lg shadow-sm bg-white">
                        <!-- Hiển thị danh sách sản phẩm -->
                        <div class="form-group mb-4">
                            <label class="d-flex align-items-center">
                                <input type="checkbox" id="select-all" class="me-2" />
                                Chọn tất cả (<c:out value="${fn:length(orderDetail.products)}" />)
                            </label>
                        </div>
                        <hr style="border-top: 3px solid #004437; width: 100%; margin: 10px 0;" />

                        <c:forEach var="product" items="${orderDetail.products}">
                            <div class="product-item d-flex justify-content-between align-items-center border-bottom py-3">
                                <div class="d-flex align-items-center">
                                    <input type="checkbox" class="product-checkbox me-3" />
                                    <div class="product-image me-3">
                                        <img src="${pageContext.request.contextPath}/${product.imagePath}" alt="${product.title}" class="img-fluid" style="width: 150px;" />
                                    </div>
                                    <div>
                                        <h4 style="margin-bottom: 20px; font-size: 24px;">${product.title}</h4>
                                        <p>${product.publisherName}</p>
                                    </div>
                                </div>
                                <div class="product-price text-end d-flex flex-column">
                                    <span class="quantity text-muted">x${product.quantity}</span>
                                    <span class="new-price text-success fw-bold">${product.sellingPrice}₫</span>
                                    <!-- Thêm nút số lượng hoàn trả -->
                                    <div class="mt-10 d-flex align-items-center">
                                        <label for="return-quantity-${orderDetail.id}" class="form-label text-muted me-2">
                                            Số lượng hoàn trả:
                                        </label>
                                        <input
                                                type="number"
                                                id="return-quantity-${orderDetail.id}"
                                                class="form-control return-quantity"
                                                name="returnQuantity[${orderDetail.id}]"
                                                value="1"
                                                min="1"
                                                max="5"
                                                style="width: 60px;" />
                                    </div>

                                </div>
                            </div>
                        </c:forEach>
                    </div>

                </div>
                <!-- Form Lý do hoàn trả -->
                <div class="return-reason-form p-4 bg-white shadow rounded" >

                    <form class="cr-content-form mb-4 " action="${pageContext.request.contextPath}/return-order" method="POST" enctype="multipart/form-data">
                        <!-- Return Form Details -->
                        <div class="form-group mt-4">
                            <label for="reason" class="form-label">Lý do hoàn trả:</label>
                            <select id="reason" name="reason" class="form-control rounded">
                                <option value="">Chọn lý do</option>
                                <c:forEach var="reason" items="${EReasonReturn}">
                                    <option value="${reason.name()}">
                                            ${reason.value}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group mt-4">
                            <label for="description" class="form-label">Mô tả chi tiết:</label>
                            <textarea id="description" name="description" rows="4" class="form-control rounded" placeholder="Mô tả chi tiết lý do hoàn trả..."></textarea>
                        </div>

                        <!-- Upload Image Section -->
                        <div class="form-group mt-4">
                            <label for="uploadImage" class="form-label">Thêm hình ảnh (tối đa 5):</label>
                            <input type="file" id="uploadImage" class="form-control" accept="image/*" multiple>
                        </div>

                        <!-- Upload Video Section -->
                        <div class="form-group mt-4">
                            <label for="uploadVideo" class="form-label">Thêm video (tùy chọn):</label>
                            <input type="file" id="uploadVideo" class="form-control" accept="video/*">
                        </div>

                        <!-- Submit Button -->
                        <div class="row">
                            <div class="col-12 col-sm-6">
                                <form class="form-group mx-auto w-100">
                                    <button
                                            type="button"
                                            class="px-4 py-2 rounded text-black border-1 border-solid border-gray-200 hover:bg-gray-100 transition duration-300 w-100"
                                            onclick="window.location.href='order.html';"
                                    >
                                        Quay lại
                                    </button>
                                </form>
                            </div>
                            <div class="col-12 col-sm-6">
                                <button type="submit" class="cr-button w-100">
                                    Yêu cầu hoàn trả
                                </button>
                            </div>

                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
