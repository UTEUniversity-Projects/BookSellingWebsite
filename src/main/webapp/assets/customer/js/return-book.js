document.addEventListener("DOMContentLoaded", () => {
    const selectAllCheckbox = document.getElementById("select-all");
    const productCheckboxes = document.querySelectorAll(".product-checkbox");

    // Xử lý chọn tất cả
    selectAllCheckbox.addEventListener("change", function () {
        productCheckboxes.forEach(checkbox => {
            checkbox.checked = this.checked;
        });
    });

    // Đồng bộ trạng thái checkbox "Chọn tất cả"
    productCheckboxes.forEach(checkbox => {
        checkbox.addEventListener("change", function () {
            const allChecked = Array.from(productCheckboxes).every(cb => cb.checked);
            selectAllCheckbox.checked = allChecked;
        });
    });
});
