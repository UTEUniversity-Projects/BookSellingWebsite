<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Return Order Form -->
<section class="section-return py-5 bg-light">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">

                <!-- Form Sản phẩm -->
                <div class="product-return-form p-4 bg-white shadow rounded mb-4">
                    <div class="form-logo text-center mb-4">
                        <img src="${pageContext.request.contextPath}/assets/customer/img/logo/biblio.png" alt="logo" class="img-fluid" style="max-width: 150px;" />
                    </div>
                    <form class="cr-content-form">
                        <div class="return-product-box p-4 rounded-lg shadow-sm bg-white">

                            <!-- Select All Option -->
                            <div class="form-group mb-4">
                                <label class="d-flex align-items-center">
                                    <input type="checkbox" id="select-all" class="me-2" /> Chọn tất cả (2)
                                </label>
                            </div>

                            <!-- Separator for better visibility -->
                            <hr style="border-top: 3px solid #004437; margin: 20px 100;" />

                            <!-- Product Item 1 -->
                            <div class="product-item d-flex justify-content-between align-items-center border-bottom py-3">
                                <div class="d-flex align-items-center">
                                    <input type="checkbox" class="product-checkbox me-3" />
                                    <div class="product-image me-3">
                                        <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lwxpv4ydgxjt57.webp" alt="Tên sách" class="img-fluid" style="width: 200px;" />
                                    </div>
                                    <div>
                                        <div class="product-name fw-bold">Tên sách</div>
                                    </div>
                                </div>
                                <div class="product-price text-end d-flex flex-column">
                                    <span class="quantity text-muted">x1</span>
                                    <span class="new-price text-success fw-bold">₫140.000</span>
                                </div>
                            </div>

                            <!-- Product Item 2 -->
                            <div class="product-item d-flex justify-content-between align-items-center py-3">
                                <div class="d-flex align-items-center">
                                    <input type="checkbox" class="product-checkbox me-3" />
                                    <div class="product-image me-3">
                                        <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lwxpv4ydgxjt57.webp" alt="Tên sách" class="img-fluid" style="width: 200px;" />
                                    </div>
                                    <div>
                                        <div class="product-name fw-bold">Tên sách 2</div>
                                    </div>
                                </div>
                                <div class="product-price text-end d-flex flex-column">
                                    <span class="quantity text-muted">x3</span>
                                    <span class="new-price text-success fw-bold">₫124.000</span>
                                </div>
                            </div>

                        </div>
                    </form>

                </div>

                <!-- Form Lý do hoàn trả -->
                <div class="return-reason-form p-4 bg-white shadow rounded">

                    <form class="cr-content-form mb-4">
                        <!-- Return Form Details -->
                        <div class="form-group mt-4">
                            <label for="reason" class="form-label">Lý do hoàn trả:</label>
                            <select id="reason" class="form-control rounded">
                                <option value="">Chọn lý do</option>
                                <option value="damaged">Sản phẩm bị hư hỏng</option>
                                <option value="not-as-described">Sản phẩm không như mô tả</option>
                                <option value="wrong-item">Giao sai sản phẩm</option>
                            </select>
                        </div>

                        <div class="form-group mt-4">
                            <label for="description" class="form-label">Mô tả chi tiết:</label>
                            <textarea id="description" rows="4" class="form-control rounded" placeholder="Mô tả chi tiết lý do hoàn trả..."></textarea>
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
                        <div class="row mt-5">
                            <div class="col-12 col-sm-6">
                                <form class="form-group mx-auto w-100">
                                    <button
                                            type="button"
                                            class="px-4 py-2 rounded text-black border-1 border-solid border-gray-200 hover:bg-gray-100 transition duration-300 w-100"
                                            onclick="window.location.href='order';"
                                    >
                                        Quay lại
                                    </button>
                                </form>
                            </div>
                            <div class="col-12 col-sm-6">
                                <form class="form-group mx-auto w-100" method="post" action="#">
                                    <button type="submit" class="cr-button w-100">
                                        Yêu cầu hoàn trả
                                    </button>
                                </form>
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>
</section>





<script>
    // JavaScript cho checkbox "Chọn tất cả"
    document.getElementById('select-all').addEventListener('change', function () {
        const checkboxes = document.querySelectorAll('.product-checkbox');
        checkboxes.forEach(checkbox => {
            checkbox.checked = this.checked;
        });
    });

    // Đồng bộ trạng thái của checkbox "Chọn tất cả" với các checkbox sản phẩm
    const checkboxes = document.querySelectorAll('.product-checkbox');
    productCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function () {
            const allChecked = Array.from(productCheckboxes).every(checkbox => checkbox.checked);
            document.getElementById('select-all').checked = allChecked;
        });
    });
</script>


<script>
    // JavaScript cho checkbox "Chọn tất cả"
    document.getElementById('select-all').addEventListener('change', function () {
        const checkboxes = document.querySelectorAll('.product-checkbox');
        checkboxes.forEach(checkbox => {
            checkbox.checked = this.checked;
        });
    });

    // Đồng bộ trạng thái của checkbox "Chọn tất cả" với các checkbox sản phẩm
    const productCheckboxes = document.querySelectorAll('.product-checkbox');
    productCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function () {
            const allChecked = Array.from(productCheckboxes).every(checkbox => checkbox.checked);
            document.getElementById('select-all').checked = allChecked;
        });
    });
</script>