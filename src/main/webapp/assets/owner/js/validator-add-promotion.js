function validateInput(input) {
    const errorSpan = input.closest('.col-12').querySelector('.' + input.name + 'Error');

    // Kiểm tra nếu input rỗng
    if (input.value.trim() === "") {
        errorSpan.textContent = "Mục này không được để trống.";
        return;
    } else {
        errorSpan.textContent = ""; // Xóa lỗi khi nhập hợp lệ
    }

    // Kiểm tra số nguyên dương cho các trường 'discountLimit', 'minValueApplied', và 'quantity'
    if (["discountLimit", "minValueApplied", "quantity"].includes(input.name)) {
        if (!Number.isInteger(Number(input.value)) || Number(input.value) < 0) {
            errorSpan.textContent = "Giá trị không được là số âm.";
            return;
        } else {
            errorSpan.textContent = "";
        }
    }



    // Kiểm tra 'percentDiscount' phải trong khoảng từ 0 đến 100
    if (input.name === "percentDiscount") {
        const value = Number(input.value);
        if (value < 1 || value > 100) {
            errorSpan.textContent = "Giá trị phải nằm trong khoảng từ 1% đến 100%.";
            return;
        } else {
            errorSpan.textContent = "";
        }
    }
}

// Áp dụng sự kiện 'input' cho tất cả các input để xóa lỗi khi người dùng bắt đầu nhập
document.querySelectorAll('.promotionForm .form-control').forEach(input => {
    input.addEventListener('input', () => validateInput(input));
});

// Sự kiện cho checkbox "Không giới hạn"
document.querySelectorAll('.promotionForm input[name="unlimited"]').forEach(checkbox => {
    checkbox.addEventListener('change', function () {
        const quantityError = checkbox.closest('.col-12').querySelector('.quantityError');
        if (checkbox.checked) {
            quantityError.textContent = ""; // Xóa lỗi khi chọn "Không giới hạn"
        }
    });
});

function validateForm(form) {
    let isValid = true;
    const inputs = form.querySelectorAll('.form-control');
    const codeInput = form.querySelector('input[name="code"]');
    const codeValue = codeInput ? codeInput.value.trim() : "";

    // const selectElement = form.querySelector('#select-object-discount');
    // const selectErrorSpan = form.querySelector('.selectOjectError');
    // if (selectElement && selectElement.value === "- Chọn đối tượng áp dụng -") {
    //    // selectErrorSpan.textContent = "Bạn cần chọn một đối tượng áp dụng.";
    //     isValid = false;
    // } else if (selectErrorSpan) {
    //     selectErrorSpan.textContent = "";
    // }

    inputs.forEach(input => {
        // const errorSpan = input.closest('.col-12').querySelector('.' + input.name + 'Error');
      //  const errorSpan = input.closest('.col-12').querySelector(`.${input.name}Error`);
        // Bỏ qua kiểm tra 'quantity' nếu 'unlimited' được chọn
        if (input.name === "quantity") {
            const unlimitedCheckbox = input.closest('.col-12').querySelector('input[name="unlimited"]');
            if (unlimitedCheckbox && unlimitedCheckbox.checked) {
                // errorSpan.textContent = "";
                // return;
            }
        }

        // Kiểm tra nếu input rỗng
        if (input.value.trim() === "") {
            //errorSpan.textContent = "Mục này không được để trống.";
            if (input.type === "search") return
            isValid = false;
            // return;
        }

        // Kiểm tra số nguyên dương cho các trường 'discountLimit', 'minValueApplied', và 'quantity'
        if (["discountLimit", "minValueApplied", "quantity"].includes(input.name)) {
            if (!Number.isInteger(Number(input.value)) || Number(input.value) < 0) {
                // errorSpan.textContent = "Giá trị không được là số âm.";
                isValid = false;
                // return;
            } else {
                // errorSpan.textContent = "";
            }
        }

        // Kiểm tra 'percentDiscount' phải trong khoảng từ 1 đến 100
        if (input.name === "percentDiscount") {
            const value = Number(input.value);
            if (value < 1 || value > 100) {
                // errorSpan.textContent = "Giá trị phải nằm trong khoảng từ 1% đến 100%.";
                isValid = false;
                // return;
            } else {
                // errorSpan.textContent = "";
            }
        }
    });
    return isValid;
}


function parseDateRange(input) {
    const [start, end] = input.split(" - ");

    function formatDate(dateString) {
        const [monthDay, time, period] = dateString.split(" ");
        const [month, day, year] = monthDay.split("/");
        const [hour, minute] = time.split(":");

        let hours = parseInt(hour, 10);
        if (period === "PM" && hours !== 12) hours += 12;
        if (period === "AM" && hours === 12) hours = 0;

        // Tạo đối tượng Date
        const date = new Date();
        date.setFullYear(parseInt(year, 10));
        date.setMonth(parseInt(month, 10) - 1);
        date.setDate(parseInt(day, 10));
        date.setHours(hours);
        date.setMinutes(parseInt(minute, 10));
        date.setSeconds(0);
        date.setMilliseconds(0);

        // Định dạng thành chuỗi theo yêu cầu
        const formattedDate = `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, '0')}-${String(date.getDate()).padStart(2, '0')} ${String(date.getHours()).padStart(2, '0')}:${String(date.getMinutes()).padStart(2, '0')}:00.000000`;
        return formattedDate;
    }

    const effectiveDate = formatDate(start);
    const expirationDate = formatDate(end);

    return { effectiveDate, expirationDate };
}


// document.querySelectorAll('.promotionForm').forEach(form => {
//     form.addEventListener('submit', function (event) {
//         event.preventDefault();
//
//         if (!validateForm(form)) {
//             toast({
//                 title: "Thất bại!",
//                 message: 'Vui lòng điền đầy đủ thông tin',
//                 type: "warning",
//                 duration: 3000,
//             });
//         } else {
//             const formData = new FormData(form);
//             const data = {};
//             // Lấy giá trị từ form và xử lý
//             formData.forEach((value, key) => {
//                 if (key === "datetimes") {
//                     // Gọi parseDateRange với giá trị và năm hiện tại
//                     const { effectiveDate, expirationDate } = parseDateRange(value);
//                     data["effectiveDate"] = effectiveDate;
//                     data["expirationDate"] = expirationDate;
//
//                     const effectiveDateObj = new Date(effectiveDate);
//                     const currentDate = new Date();
//                     data["status"] = effectiveDateObj > currentDate ? "COMING_SOON" : "EFFECTIVE";
//                 } else {
//                     data[key] = value.trim();
//                 }
//             });
//             // Lấy thông tin về checkbox "unlimited" và quantity
//             const unlimitedCheckbox = form.querySelector('input[name="unlimited"]');
//             let quantity = parseInt(data["quantity"], 10);
//             const isInfinite = unlimitedCheckbox.checked || isNaN(quantity) || quantity <= 0;
//             data["isInfinite"] = isInfinite;
//             if (isInfinite) quantity = 1;
//             switch (data["formType"]) {
//                 case "addVoucher":
//                     data["type"] = "VOUCHER"; // Đặt type là VOUCHER
//                     data["percentDiscount"] = 100; // Phần trăm giảm giá là 100%
//                     break;
//                 case "addFreeShip":
//                     data["type"] = "FREESHIP"; // Đặt type là FREESHIP
//                     data["percentDiscount"] = 100; // Miễn phí vận chuyển
//                     data["minValueApplied"] = 0.0; // Giá trị tối thiểu áp dụng là 0
//                     break;
//                 default:
//                     console.error("Loại form không hợp lệ"); // Xử lý lỗi khi formType không đúng
//                     return;
//             }
//
//             // Tạo danh sách promotionInsertRequests
//             const promotionInsertRequests = [];
//             for (let i = 0; i < quantity; i++) {
//                 promotionInsertRequests.push({
//                     title: data["title"] || "Default Title",
//                     description: data["description"] || "Default Description",
//                     percentDiscount: parseFloat(data["percentDiscount"]) || 0.0,
//                     discountLimit: parseFloat(data["discountLimit"]) || 0.0,
//                     minValueApplied: parseFloat(data["minValueApplied"]) || 0.0,
//                     effectiveDate: data["effectiveDate"],
//                     expirationDate: data["expirationDate"],
//                     status: "NOT_USE",
//                     promotionTargets: [
//                         {
//                             applicableObjectId: -1,
//                             type: "WHOLE"
//                         }
//                     ]
//                 });
//             }
//             const responseData = {
//                 code: data["code"],
//                 isInfinite: isInfinite,
//                 status: data["status"],
//                 type: data["type"],
//                 promotionInsertRequests: promotionInsertRequests
//             };
//
//
//
//             // Gửi request AJAX
//             $.ajax({
//                 url: '/owner/promotion/add',
//                 type: 'POST',
//                 contentType: 'application/json; charset=UTF-8',
//                 data: JSON.stringify(responseData),
//                 success: function (result) {
//                     toast({
//                         title: result.isCodeExisted ? "Thất bại!" : "Thành công!",
//                         message: result.isCodeExisted ? 'Mã khuyến mãi đã tồn tại.' : 'Khuyến mãi đã được thêm thành công!',
//                         type: result.isCodeExisted ? "warning" : "success",
//                         duration: 3000,
//                     });
//                     if (!result.isCodeExisted) {
//                         form.reset();
//                         form.querySelector('input[name="quantity"]').disabled = false;
//
//                     }
//                 },
//                 error: function (xhr, status, error) {
//                     console.error("Lỗi khi gọi API:", error);
//
//                     toast({
//                         title: "Lỗi!",
//                         message: 'Đã xảy raaaaaaaa lỗi trong quá trình thêm khuyến mãi.',
//                         type: "error",
//                         duration: 3000,
//                     });
//                 }
//             });
//         }
//     });
// });
// document.querySelectorAll('.promotionForm').forEach(form => {
//     form.addEventListener('submit', function (event) {
//
//         event.preventDefault();
//
//         if (!validateForm(form)) {
//             toast({
//                 title: "Thất bại!",
//                 message: 'Vui lòng điền đầy đủ thông tin',
//                 type: "warning",
//                 duration: 3000,
//             });
//             alert("sadasd");
//         } else {
//             const formData = new FormData(form);
//             const data = {};
//
//             formData.forEach((value, key) => {
//                 if (key === "formType") {
//                     alert(value);
//                 }
//             });
//         }
//     });
// });
document.querySelectorAll('.promotionForm').forEach(form => {
    form.addEventListener('submit', function (event) {
        event.preventDefault();
        if (!validateForm(form)) {
            toast({
                title: "Thất bại!",
                message: 'Vui lòng điền đầy đủ thông tin',
                type: "warning",
                duration: 3000,
            });
        } else {
            const formData = new FormData(form);
            const data = {};

            // Lấy giá trị từ form và xử lý
            formData.forEach((value, key) => {
                if (key === "datetimes") {
                    const { effectiveDate, expirationDate } = parseDateRange(value);
                    data["effectiveDate"] = effectiveDate;
                    data["expirationDate"] = expirationDate;

                    const effectiveDateObj = new Date(effectiveDate);
                    const currentDate = new Date();
                    data["status"] = effectiveDateObj > currentDate ? "COMING_SOON" : "EFFECTIVE";
                } else {
                    data[key] = value.trim();
                }
            });

            // Lấy thông tin checkbox và xử lý `quantity`
            const unlimitedCheckbox = form.querySelector('input[name="unlimited"]');
            let quantity = parseInt(data["quantity"], 10);
            const isInfinite = unlimitedCheckbox.checked || isNaN(quantity) || quantity <= 0;
            data["isInfinite"] = isInfinite;
            if (isInfinite) quantity = 1;

            // Tách xử lý theo formType
            const formType = data["formType"];
            if (!formType) {
                console.error("Không tìm thấy formType");
                return;
            }
            const promotionInsertRequests = [];
            switch (formType) {
                case "addDiscount":
                    document.getElementById("select-object-discount").addEventListener("change", function () {
                        const selectedValue = this.value; // Lấy giá trị được chọn
                        const selectedText = this.options[this.selectedIndex].text; // Lấy nội dung hiển thị của tùy chọn
                        alert(`Bạn đã chọn: ${selectedText} (Value: ${selectedValue})`);
                    });
                case "addVoucher":
                    handleAddVoucher(data, quantity, promotionInsertRequests);
                    break;
                case "addFreeShip":
                    handleAddFreeShip(data, quantity, promotionInsertRequests);
                    break;
                default:
                    console.error("Loại form không hợp lệ:", formType);
                    return;
            }

            const responseData = {
                code: data["code"],
                isInfinite: isInfinite,
                status: data["status"],
                type: data["type"],
                promotionInsertRequests: promotionInsertRequests
            };

            // Gửi request AJAX
            sendPromotionRequest(responseData, form);
        }
    });
});

// Hàm xử lý formType "addVoucher"
function handleAddVoucher(data, quantity, promotionInsertRequests) {
    data["type"] = "VOUCHER";
    data["percentDiscount"] = 100; // Giảm giá 100%

    for (let i = 0; i < quantity; i++) {
        promotionInsertRequests.push(createPromotionRequest(data));
    }
}

// Hàm xử lý formType "addFreeShip"
function handleAddFreeShip(data, quantity, promotionInsertRequests) {
    data["type"] = "FREESHIP";
    data["percentDiscount"] = 100; // Miễn phí vận chuyển
    data["minValueApplied"] = 0.0; // Giá trị tối thiểu áp dụng là 0

    for (let i = 0; i < quantity; i++) {
        promotionInsertRequests.push(createPromotionRequest(data));
    }
}

// Hàm tạo một request
function createPromotionRequest(data) {
    return {
        title: data["title"] || "Default Title",
        description: data["description"] || "Default Description",
        percentDiscount: parseFloat(data["percentDiscount"]) || 0.0,
        discountLimit: parseFloat(data["discountLimit"]) || 0.0,
        minValueApplied: parseFloat(data["minValueApplied"]) || 0.0,
        effectiveDate: data["effectiveDate"],
        expirationDate: data["expirationDate"],
        status: "NOT_USE",
        promotionTargets: [
            {
                applicableObjectId: -1,
                type: "WHOLE"
            }
        ]
    };
}

// Hàm gửi request AJAX
function sendPromotionRequest(responseData, form) {
    $.ajax({
        url: '/owner/promotion/add',
        type: 'POST',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(responseData),
        success: function (result) {
            toast({
                title: result.isCodeExisted ? "Thất bại!" : "Thành công!",
                message: result.isCodeExisted ? 'Mã khuyến mãi đã tồn tại.' : 'Khuyến mãi đã được thêm thành công!',
                type: result.isCodeExisted ? "warning" : "success",
                duration: 3000,
            });
            if (!result.isCodeExisted) {
                form.reset();
                form.querySelector('input[name="quantity"]').disabled = false;
            }
        },
        error: function (xhr, status, error) {
            console.error("Lỗi khi gọi API:", error);
            toast({
                title: "Lỗi!",
                message: 'Đã xảy ra lỗi trong quá trình thêm khuyến mãi.',
                type: "error",
                duration: 3000,
            });
        }
    });
}


// $(document).ready(function () {
//     const table = $(".table_item_to_discount").DataTable({
//         aLengthMenu: [[5, 10, -1], [5, 10, "All"]],
//         pageLength: 5,
//         ordering: false, // Tắt tính năng sort
//         dom: '<"row justify-content-between top-information"lf>rt<"row justify-content-between bottom-information"ip><"clear">',
//     });
//
//     function fetchData(url, params = {}, onSuccess, onError = 'Đã xảy ra lỗi khi gọi API.') {
//         $.ajax({
//             url,
//             type: 'GET',
//             data: params,
//             success: response => onSuccess?.(response),
//             error: () => alert(onError),
//         });
//     }
//
//     $('#select-object-discount').change(function () {
//         const selectedValue = $(this).val();
//         resetSelections();
//
//         if (selectedValue === "1") handleCase1();
//         else if (selectedValue === "2") handleCase2();
//         else if (selectedValue === "3") handleCase3();
//     });
//
//     function resetSelections() {
//         $('#category-select-discount, #subcategory-select-discount').empty();
//         table.clear().draw();
//     }
//
//     function handleCase1() {
//         $('#category-select-discount').off('change').on('change', function () {
//             const categoryId = $(this).val();
//             categoryId ? loadSubCategories(categoryId) : $('#subcategory-select-discount').empty();
//         });
//         loadCategories(loadSubCategories);
//     }
//
//     function handleCase2() {
//         $('#category-select-discount').off('change');
//         loadCategories(categories => populateTable(categories, 'Không có danh mục nào'));
//     }
//
//     function handleCase3() {
//         $('#category-select-discount').off('change').on('change', function () {
//             const categoryId = $(this).val();
//             categoryId ? loadSubCategoriesToTable(categoryId) : table.clear().draw();
//         });
//         loadCategories(loadSubCategoriesToTable);
//     }
//
//     function loadCategories(callback) {
//         fetchData('/owner/promotion/get-categories', {}, categories => {
//             if (categories?.length) populateCategories(categories, callback);
//             else alert('Không có danh mục nào!');
//         }, 'Không thể tải danh sách danh mục!');
//     }
//
//     function loadSubCategories(categoryId) {
//         fetchData('/owner/promotion/get-subcategories', { categoryId }, subcategories => {
//             const subCategorySelect = $('#subcategory-select-discount');
//             subCategorySelect.empty();
//
//             if (subcategories?.length) {
//                 subcategories.forEach(sub => subCategorySelect.append(`<option value="${sub.id}">${sub.name}</option>`));
//                 const firstSubCategoryId = subcategories[0]?.id;
//                 firstSubCategoryId && subCategorySelect.val(firstSubCategoryId);
//                 bindSubCategoryChange(subCategorySelect, loadBooks);
//             } else alert('Không có danh mục con nào!');
//         });
//     }
//
//     function loadSubCategoriesToTable(categoryId) {
//         fetchData('/owner/promotion/get-subcategories', { categoryId }, subcategories => {
//             populateTable(subcategories, 'Không có danh mục con nào');
//         }, `Không thể tải danh mục con cho Category ID: ${categoryId}`);
//     }
//
//     function loadBooks(subCategoryId) {
//         fetchData('/owner/promotion/get-book', { idSubcategory: subCategoryId }, books => {
//             populateTable(books, 'Không có sách trong danh mục này');
//         }, 'Không thể tải danh sách sách!');
//     }
//
//     function populateCategories(categories, callback) {
//         const categorySelect = $('#category-select-discount');
//         categorySelect.empty();
//         categories.forEach(cat => categorySelect.append(`<option value="${cat.id}">${cat.name}</option>`));
//         callback?.(categories[0]?.id);
//     }
//
//     function populateTable(data, emptyMessage) {
//         table.clear();
//         if (data?.length) {
//             data.forEach(item => table.row.add([
//                 `<input type="checkbox" class="row-checkbox" name="selectedItems_${item.id}" value="${item.id}" />`,
//                 `#${item.id}`,
//                 `${item.name || item.title}`
//             ]));
//         } else {
//             table.row.add(['', '', emptyMessage]);
//         }
//         table.draw();
//     }
//
//     function bindSubCategoryChange(subCategorySelect, callback) {
//         subCategorySelect.off('change').on('change', function () {
//             const subCategoryId = $(this).val();
//             subCategoryId && callback(subCategoryId);
//         });
//     }
// });




$(document).ready(function () {
    var table = $(".table_item_to_discount").DataTable({
        "aLengthMenu": [[5, 10, -1], [5, 10, "All"]], // Menu options for rows per page
        "pageLength": 5, // Default rows per page
        "dom": '<"row justify-content-between top-information"lf>rt<"row justify-content-between bottom-information"ip><"clear">', // Customize control layout
    });
    // Hàm gọi API chung
    function fetchData(url, params, onSuccess, onError) {
        $.ajax({
            url: url,
            type: 'GET',
            data: params,
            success: function (response) {
                console.log(`API Response [${url}]:`, response); // Debug API
                if (onSuccess) onSuccess(response);
            },
            error: function () {
                alert(onError || 'Đã xảy ra lỗi khi gọi API.');
            }
        });
    }

    // Xử lý khi thay đổi giá trị của "select-object-discount"
    $('#select-object-discount').change(function () {
        const selectedValue = $(this).val();
        $('#category-select-discount, #subcategory-select-discount').empty();
        table.clear().draw();

        if (selectedValue === "1") {
            // Xử lý khi chọn trường hợp 1
            console.log("Selected Case 1: Loading categories and subcategories.");
            $('#category-select-discount').off('change').on('change', function () {
                const selectedCategoryId = $(this).val();
                if (selectedCategoryId) {
                    loadSubCategories(selectedCategoryId); // Tải danh sách subcategories
                } else {
                    $('#subcategory-select-discount').empty();
                }
            });

            // Tải danh sách categories
            fetchData('/owner/promotion/get-categories', {}, function (categories) {
                if (categories && categories.length > 0) {
                    populateCategories(categories, function (firstCategoryId) {
                        if (firstCategoryId) {
                            loadSubCategories(firstCategoryId);
                        }
                    });
                } else {
                    alert('Không có danh mục nào!');
                }
            }, 'Không thể tải danh sách danh mục!');
        } else if (selectedValue === "2") {
            // Xử lý khi chọn trường hợp 2
            console.log("Selected Case 2: Loading categories into table.");
            $('#category-select-discount').off('change');
            fetchData('/owner/promotion/get-categories', {}, function (categories) {
                populateTable(categories, 'Không có danh mục nào');
            }, 'Không thể tải danh sách danh mục!');
        } else if (selectedValue === "3") {
            // Xử lý khi chọn trường hợp 3
            console.log("Selected Case 3: Loading subcategories into table.");
            $('#category-select-discount').off('change').on('change', function () {
                const selectedCategoryId = $(this).val();
                if (selectedCategoryId) {
                    loadSubCategoriesToTable(selectedCategoryId);
                } else {
                    table.clear().draw();
                }
            });

            // Tải danh sách categories
            fetchData('/owner/promotion/get-categories', {}, function (categories) {
                populateCategories(categories, function (firstCategoryId) {
                    if (firstCategoryId) {
                        loadSubCategoriesToTable(firstCategoryId);
                    }
                });
            }, 'Không thể tải danh sách danh mục!');
        }
    });

    // Hàm tải subcategories và cập nhật #subcategory-select-discount
    function loadSubCategories(categoryId) {
        console.log(`Loading subcategories for categoryId: ${categoryId}`);
        fetchData('/owner/promotion/get-subcategories', { categoryId }, function (subcategories) {
            const subCategorySelect = $('#subcategory-select-discount');
            subCategorySelect.empty();

            if (subcategories && subcategories.length > 0) {
                subcategories.forEach(function (subcategory) {
                    subCategorySelect.append(
                        `<option value="${subcategory.id}">${subcategory.name}</option>`
                    );
                });

                // Tải sách của subcategory đầu tiên
                const firstSubCategoryId = subcategories[0]?.id;
                if (firstSubCategoryId) {
                    subCategorySelect.val(firstSubCategoryId);
                    loadBooks(firstSubCategoryId);
                }
                subCategorySelect.off('change').on('change', function () {
                    const selectedSubCategoryId = $(this).val();
                    if (selectedSubCategoryId) {
                        loadBooks(selectedSubCategoryId);
                    }
                });
            } else {
                alert('Không có danh mục con nào!');
            }
        }, 'Không thể tải danh sách subcategories!');
    }

    // Hàm tải subcategories hiển thị trong bảng
    function loadSubCategoriesToTable(categoryId) {
        console.log(`Loading subcategories into table for categoryId: ${categoryId}`);
        fetchData('/owner/promotion/get-subcategories', { categoryId }, function (subcategories) {
            table.clear(); // Xóa dữ liệu cũ

            if (subcategories && subcategories.length > 0) {
                subcategories.forEach(function (subcategory) {
                    table.row.add([
                        `<input type="checkbox" class="row-checkbox" name="selectedItems_${subcategory.id}" value="${subcategory.id}" />`,
                        `#${subcategory.id}`,
                        `${subcategory.name}`
                    ]);
                });
                table.draw(); // Cập nhật bảng
            } else {
                table.row.add([
                    '',
                    '',
                    'Không có danh mục con nào'
                ]).draw();
            }
        }, `Không thể tải danh mục con cho Category ID: ${categoryId}`);
    }

    // Hàm tải danh sách sách
    function loadBooks(subCategoryId) {
        console.log(`Loading books for subCategoryId: ${subCategoryId}`);
        fetchData('/owner/promotion/get-book', { idSubcategory: subCategoryId }, function (books) {
            populateTable(books, 'Không có sách trong danh mục này');
        }, 'Không thể tải danh sách sách!');
    }

    // Hàm thêm danh sách vào category-select-discount
    function populateCategories(categories, callback) {
        const categorySelect = $('#category-select-discount');
        categorySelect.empty();

        categories.forEach(function (category) {
            categorySelect.append(
                `<option value="${category.id}">${category.name}</option>`
            );
        });

        const firstCategoryId = categories[0]?.id;
        if (callback && typeof callback === 'function') {
            callback(firstCategoryId);
        }
    }

    // Hàm thêm danh sách vào DataTables
    function populateTable(data, emptyMessage) {
        table.clear();

        if (data && data.length > 0) {
            data.forEach(function (item) {
                table.row.add([
                    `<input type="checkbox" class="row-checkbox" name="selectedItems_${item.id}" value="${item.id}" />`,
                    `#${item.id}`,
                    `${item.name || item.title}`
                ]);
            });
            table.draw();
        } else {
            table.row.add([
                '',
                '',
                emptyMessage
            ]).draw();
        }
    }
});


















