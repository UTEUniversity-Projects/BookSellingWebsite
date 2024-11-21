// $(document).ready(function () {
//
//     var start = moment().subtract(6, "days");
//     var end = moment();
//
//     function updateRevenueChart(start, end) {
//         console.log("Selected range:", start, end); // Debug log
//         $("#date-list-revenue span").html(
//             start.format("YYYY-MM-DD") + " - " + end.format("YYYY-MM-DD")
//         );
//
//         $.ajax({
//             url: "/owner/ecommerce/list-revenue",
//             type: "GET",
//             data: {
//                 startTime: start.format("YYYY-MM-DDTHH:mm:ss"),
//                 endTime: end.format("YYYY-MM-DDTHH:mm:ss"),
//             },
//
//             success: function (response) {
//                 console.log("API response:", response); // Debug log
//                 const revenueList = response.revenueList;
//                 console.log(revenueList.size)
//
//                 const totalDays = revenueList.length;
//                 let processedData = [];
//                 if (totalDays <= 15) {
//                     processedData = revenueList.map(item => ({
//                         date: item.date.split("T")[0],
//                         revenue: item.revenue,
//                     }));
//                 } else {
//                     const groupSize = Math.ceil(totalDays / 15);
//                     for (let i = 0; i < totalDays; i += groupSize) {
//                         const group = revenueList.slice(i, i + groupSize);
//                         const avgRevenue =
//                             group.reduce((sum, item) => sum + item.revenue, 0) /
//                             group.length;
//                         processedData.push({
//                             date: group[0].date.split("T")[0],
//                             revenue: Math.round(avgRevenue),
//                         });
//                     }
//                 }
//
//                 const categories = processedData.map(item => item.date);
//                 const revenues = processedData.map(item => item.revenue);
//
//                 console.log("Categories:", categories); // Debug log
//                 console.log("Revenues:", revenues); // Debug log
//
//                 if (window.revenueLineChart) {
//                     window.revenueLineChart.destroy();
//                 }
//                 window.revenueLineChart = new ApexCharts(
//                     document.querySelector("#revenueLineChart"),
//                     {
//                         series: [{ name: "Doanh thu", data: revenues }],
//                         chart: {
//                             height: 365,
//                             type: "line",
//                             toolbar: { show: false },
//                         },
//                         stroke: { width: [2], curve: "smooth" },
//                         colors: ["#5f6af5"],
//                         xaxis: {
//                             categories: categories,
//                             axisTicks: { show: false },
//                             axisBorder: { show: false },
//                         },
//                         yaxis: {
//                             labels: {
//                                 formatter: value =>
//                                     value.toLocaleString("vi-VN") + " vnđ",
//                             },
//                         },
//                     }
//                 );
//                 window.revenueLineChart.render();
//             },
//             error: function (xhr, status, error) {
//                 console.error("Status Code:", xhr.status); // HTTP Status Code (e.g., 404, 500, etc.)
//                 console.error("Status Text:", status); // Text status (e.g., "error", "timeout", etc.)
//                 console.error("Error Message:", error); // Error message from server
//                 console.error("Response Text:", xhr.responseText); // Full response body from server
//             },
//         });
//     }
//
//     $("#date-list-revenue").daterangepicker(
//         {
//             startDate: start,
//             endDate: end,
//             ranges: {
//                 "Hôm nay": [moment(), moment()],
//                 "Hôm qua": [
//                     moment().subtract(1, "days"),
//                     moment().subtract(1, "days"),
//                 ],
//                 "7 ngày trước": [moment().subtract(6, "days"), moment()],
//                 "30 ngày trước": [moment().subtract(29, "days"), moment()],
//             },
//         },
//         updateRevenueChart
//     );
//
//     updateRevenueChart(start, end);
// });
$(document).ready(function () {
    var start = moment().subtract(6, "days");
    var end = moment();

    function updateRevenueChart(start, end) {
        // Hiển thị khoảng thời gian được chọn
        $("#date-list-revenue span").html(
            start.format("YYYY-MM-DD") + " - " + end.format("YYYY-MM-DD")
        );

        // Tính số ngày trong khoảng thời gian
        const totalDays = end.diff(start, "days") + 1; // +1 để bao gồm cả ngày bắt đầu
        console.log("Total days:", totalDays);

        // Gửi yêu cầu AJAX để lấy dữ liệu biểu đồ
        $.ajax({
            url: "/owner/ecommerce/list-revenue",
            type: "GET",
            data: {
                startTime: start.format("YYYY-MM-DDTHH:mm:ss"),
                endTime: end.format("YYYY-MM-DDTHH:mm:ss"),
            },
            success: function (response) {
                console.log(totalDays);
                // Xử lý dữ liệu từ server
                const revenueList = response.revenueList;

                // Xử lý dữ liệu biểu đồ (giới hạn tối đa 15 điểm)
                let processedData = [];
                if (totalDays <= 15) {
                    processedData = revenueList.map(item => ({
                        date: item.date.split("T")[0],
                        revenue: item.revenue,
                    }));
                } else {
                    const groupSize = Math.ceil(totalDays / 15);
                    for (let i = 0; i < totalDays; i += groupSize) {
                        const group = revenueList.slice(i, i + groupSize);
                        const avgRevenue =
                            group.reduce((sum, item) => sum + item.revenue, 0) /
                            group.length;
                        processedData.push({
                            date: group[0].date.split("T")[0],
                            revenue: Math.round(avgRevenue),
                        });
                    }
                }

                // Tách dữ liệu để vẽ biểu đồ
                const categories = processedData.map(item => item.date);
                const revenues = processedData.map(item => item.revenue);

                // Vẽ biểu đồ
                var options = {
                    series: [
                        {
                            name: "Doanh thu",
                            data: revenues,
                        },
                    ],
                    chart: {
                        height: 365,
                        type: "line",
                        toolbar: { show: false },
                    },
                    stroke: { width: [2], curve: "smooth" },
                    colors: ["#5f6af5"],
                    xaxis: {
                        categories: categories,
                        axisTicks: { show: false },
                        axisBorder: { show: false },
                    },
                    yaxis: {
                        labels: {
                            formatter: value =>
                                value.toLocaleString("vi-VN") + " vnđ",
                        },
                    },
                };
                var revenueLineChart = new ApexCharts(
                    document.querySelector("#revenueLineChart"),
                    options
                );
                revenueLineChart.render();
            },
            error: function (xhr, status, error) {
                console.error("Error fetching revenue data:", error);
            },
        });
    }


    // Khởi tạo Daterangepicker
    $("#date-list-revenue").daterangepicker(
        {
            startDate: start,
            endDate: end,
            ranges: {
                "Hôm nay": [moment(), moment()],
                "Hôm qua": [
                    moment().subtract(1, "days"),
                    moment().subtract(1, "days"),
                ],
                "7 ngày trước": [moment().subtract(6, "days"), moment()],
                "30 ngày trước": [moment().subtract(29, "days"), moment()],
            },
        },
        updateRevenueChart // Callback khi chọn ngày
    );

    // Gọi lần đầu tiên khi trang tải
    updateRevenueChart(start, end);
});

