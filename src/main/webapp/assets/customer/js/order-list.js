let currentStatus = "all";  // Lọc trạng thái mặc định là tất cả các đơn hàng

// Hàm để render danh sách đơn hàng
const renderOrders = (orders) => {
    const orderList = document.getElementById("order-list");
    orderList.innerHTML = "";  // Xóa danh sách đơn hàng hiện tại

    // Lặp qua danh sách đơn hàng để hiển thị từng đơn
    orders.forEach(order => {
        if (currentStatus === "all" || order.status === currentStatus) {
            let orderHTML = `
                <div data-tab="${order.status}" class="flex flex-wrap mb-5 p-2 bg-white rounded fade-in">
                    <div class="flex-1 items-center border-b-[1px] mb-5 border-solid border-[rgba(0,0,0,0.12)] flex ml-[0] my-[0] text-right basis-full justify-end px-4 py-2">
                        <a href="order-detail.html" class="items-center inline-flex m-0">
                            <span class="text-[#26aa99] no-underline align-middle">${order.status === "completed" ? "Giao hàng thành công" : order.status === "cancelled" ? "Đã hủy" : "Chờ xác nhận"}</span>
                        </a>
                    </div>
                    <div class="flex basis-full items-start gap-x-5 flex-col">
            `;

            // Render sản phẩm đầu tiên
            orderHTML += `
                <div class="flex items-center w-full mb-3">
                    <div class="w-[82px] h-[82px] flex-0">
                        <img src="${order.items[0].imageUrl}" alt="${order.items[0].title}" class="w-full h-full object-cover" />
                    </div>
                    <div class="flex-1 ml-3">
                        <a href="#">
                            <h4 class="overflow-hidden text-[16px] leading-[22px] mt-[0] mx-[0] mb-[5px] max-h-[48px] text-justify" style="display: -webkit-box; -webkit-line-clamp: 2; -webkit-box-orient: vertical; text-overflow: ellipsis; word-break: break-word; overflow: hidden;">
                                ${order.items[0].title}
                            </h4>
                        </a>
                        <p class="text-[rgba(0,0,0,.54)]">Phân loại:</p>
                        <p>Số lượng: <span>x${order.items[0].quantity}</span></p>
                        <span class="text-[#000] ml-[0] mr-[4px] my-[0] opacity-[.26] overflow-hidden [text-decoration-line:line-through] overflow-ellipsis">₫${order.items[0].originalPrice.toLocaleString()}</span>
                        <span class="text-[18px] font-medium text-[#26aa99]">₫${order.items[0].currentPrice.toLocaleString()}</span>
                    </div>
                </div>
            `;

            // Render các sản phẩm còn lại (nếu có)
            if (order.items.length > 1) {
                order.items.slice(1).forEach((item, i) => {
                    orderHTML += `
                        <div class="flex items-center w-full mb-3 hidden" id="item-${order.status}-${i}">
                            <div class="w-[82px] h-[82px] flex-0">
                                <img src="${item.imageUrl}" alt="${item.title}" class="w-full h-full object-cover" />
                            </div>
                            <div class="flex-1 ml-3">
                                <a href="#">
                                    <h4 class="overflow-hidden text-[16px] leading-[22px] mt-[0] mx-[0] mb-[5px] max-h-[48px] text-justify" style="display: -webkit-box; -webkit-line-clamp: 2; -webkit-box-orient: vertical; text-overflow: ellipsis; word-break: break-word; overflow: hidden;">
                                        ${item.title}
                                    </h4>
                                </a>
                                <p class="text-[rgba(0,0,0,.54)]">Phân loại:</p>
                                <p>Số lượng: <span>x${item.quantity}</span></p>
                                <span class="text-[#000] ml-[0] mr-[4px] my-[0] opacity-[.26] overflow-hidden [text-decoration-line:line-through] overflow-ellipsis">₫${item.originalPrice.toLocaleString()}</span>
                                <span class="text-[18px] font-medium text-[#26aa99]">₫${item.currentPrice.toLocaleString()}</span>
                            </div>
                        </div>
                    `;
                });

                // Nút "Xem thêm"
                orderHTML += `
                    <div class="flex justify-start w-full cursor-pointer text-[#26aa99]" onclick="toggleItems('${order.status}')">
                        <span id="toggle-text-${order.status}">Xem thêm ▼</span>
                    </div>
                `;
            }

            orderHTML += `
                <div class="flex flex-col items-end w-full mt-2">
                    <h3 class="text-[16px] text-black-500 font-medium">
                        Thành tiền:
                        <span class="text-xl text-[#26aa99]">₫${order.items.reduce((total, item) => total + item.totalPrice, 0).toLocaleString()}</span>
                    </h3>
                    <div class="mt-5">
                        ${order.status === "completed" ? `
                            <button class="px-4 py-2 bg-[#26aa99] rounded text-white mr-2 hover:bg-[#158d7d] transition duration-300">Đặt lại đơn hàng</button>
                            <button class="px-4 py-2 bg-[#ff9800] rounded text-white mr-2 hover:bg-[#e58900] transition duration-300" onclick="location.href='return-order.html'">Hoàn trả</button>
                            <button class="px-4 py-2 bg-[#ffc107] rounded text-white mr-2 hover:bg-[#e6ac00] transition duration-300">Đánh giá</button>
                        ` : ''}
                        ${order.status === "confirming" ? `
                            <button class="px-4 py-2 bg-[#e91e4c] rounded text-white mr-2 hover:bg-[#d0173f] transition duration-300">Hủy đơn hàng</button>
                        ` : ''}
                        ${order.status === "cancelled" ? `
                            <button class="px-4 py-2 bg-[#26aa99] rounded text-white mr-2 hover:bg-[#158d7d] transition duration-300">Mua lại đơn hàng</button>
                        ` : ''}
                        <button class="px-4 py-2 rounded text-black border-1 border-solid border-gray-200 hover:bg-gray-100 transition duration-300">Liên hệ người bán</button>
                    </div>
                </div>
            </div>
        </div>`;
            orderList.innerHTML += orderHTML;
        }
    })

// Hàm để toggle (mở rộng) các mục sản phẩm
    const toggleItems = (status) => {
        const toggleText = document.getElementById(`toggle-text-${status}`);
        const items = document.querySelectorAll(`#order-list .fade-in[data-tab="${status}"] .hidden, #order-list .fade-in[data-tab="${status}"] .toggled`);
        const isHidden = Array.from(items).every(item => item.classList.contains('hidden'));

        items.forEach(item => {
            item.classList.toggle('hidden', !isHidden);
            item.classList.toggle('toggled', isHidden);
        });

        toggleText.textContent = isHidden ? "Thu gọn ▲" : "Xem thêm ▼";
    };

// Lấy dữ liệu từ backend (Ví dụ: API hoặc qua server-side rendering)
    const fetchOrders = async () => {
        // Nếu đang sử dụng API để lấy đơn hàng
        const response = await fetch('/api/orders');  // Thay '/api/orders' bằng URL thực tế
        const orders = await response.json();
        renderOrders(orders);  // Gọi hàm renderOrders với dữ liệu nhận được
    };

// Hàm khởi tạo, gọi khi trang tải xong
    const init = () => {
        fetchOrders();  // Lấy và render dữ liệu đơn hàng
        const tags = document.querySelectorAll('.tag');
        tags.forEach(tag => {
            tag.addEventListener('click', (e) => {
                currentStatus = e.target.dataset.status;
                tags.forEach(t => t.style.color = '#a0a0a0'); // Reset màu sắc
                e.target.style.color = '#26aa99'; // Nổi bật tag được chọn
                fetchOrders();  // Lấy lại dữ liệu và render lại
            });
        });
    };

    document.addEventListener("DOMContentLoaded", init);}
