function showSuccessToast() {
    toast({
        title: "Thành công!",
        message: "Bạn đã xác nhận đơn hàng thành công.",
        type: "success",
        duration: 1000,
    });
    console.log("CLick")
}

function showErrorToast() {
    toast({
        title: "Thất bại!",
        message: "Có lỗi xảy ra, vui lòng liên hệ quản trị viên.",
        type: "error",
        duration: 1000,
    });
}