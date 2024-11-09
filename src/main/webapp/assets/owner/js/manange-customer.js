function changeStatus(customerId, action) {
    const url = `/owner/customer-list?action=${action}&id=${customerId}`;

    fetch(url, {
        method: 'GET'
    })
        .then(response => response.text())
        .then(data => {
            if (data === 'success') {
                alert(action === 'deactivate' ? 'Tài khoản đã bị vô hiệu hóa' : 'Tài khoản đã được mở khóa');

                // Cập nhật trạng thái hiển thị
                const statusElement = document.getElementById(`status-${customerId}`);
                if (statusElement) {
                    statusElement.innerText = (action === 'deactivate') ? 'INACTIVE' : 'ACTIVE';
                }
            } else {
                alert('Có lỗi xảy ra khi thay đổi trạng thái tài khoản');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Có lỗi xảy ra khi kết nối tới server');
        });
}
