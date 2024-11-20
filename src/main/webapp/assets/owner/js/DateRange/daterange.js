$(function () {
    var start = moment().subtract(29, "days");
    var end = moment();

    function animateNumber(element, startValue, endValue, duration) {

        $({ count: startValue }).animate(
            { count: endValue },
            {
                duration: duration,
                easing: "swing",
                step: function (now) {
                    $(element).text(Math.floor(now)); // Cập nhật số nguyên
                },
                complete: function () {
                    $(element).text(endValue); // Đảm bảo hiển thị đúng giá trị cuối cùng
                },
            }
        );
    }

    function updateCounts(start, end) {
        // AJAX call to load data
        $.ajax({
            url: "/owner/ecommerce/summary-report",
            type: "GET",
            data: {
                startTime: start.format("YYYY-MM-DDTHH:mm:ss"),
                endTime: end.format("YYYY-MM-DDTHH:mm:ss"),
            },
            success: function (response) {
                // Animate numbers for each metric
                animateNumber("#customer-count", parseInt($("#customer-count").text()), response.customerCount || 0, 1000);
                animateNumber("#order-count", parseInt($("#order-count").text()), response.orderCount || 0, 1000);
                animateNumber("#revenue-count", parseFloat($("#revenue-count").text().replace(/\D/g, "")), response.venueOrder || 0, 1000);
                animateNumber("#expense-count", parseInt($("#expense-count").text().replace(/\D/g, "")), response.expense || 0, 1000);
            },
            error: function (xhr, status, error) {
                console.error("Error loading data:", error);
            },
        });
    }


    function cb(start, end, element) {
        $(element).find("span").html(start.format("MMM D, YYYY") + " - " + end.format("MMM D, YYYY"));
        updateCounts(start, end); // Trigger data update
    }

    $("#date-summary-report").daterangepicker(
        {
            startDate: start,
            endDate: end,
            ranges: {
                "Hôm nay": [moment(), moment()],
                "Hôm qua": [moment().subtract(1, "days"), moment().subtract(1, "days")],
                "7 ngày trước": [moment().subtract(6, "days"), moment()],
                "30 ngày trước": [moment().subtract(29, "days"), moment()],
            },
        },
        function (start, end) {
            cb(start, end, $("#date-summary-report"));
        }
    );

    // Load data immediately when the page loads
    cb(start, end, $("#date-summary-report"));
    updateCounts(start, end); // Load counts immediately
});




function fetchRevenueData(startDate, endDate) {
    $.ajax({
        url: "/owner/ecommerce/list-revenue", // Đường dẫn API
        type: "GET",
        data: {
            startTime: start.format("YYYY-MM-DDTHH:mm:ss"),
            endTime: end.format("YYYY-MM-DDTHH:mm:ss"),
        },
        success: function (response) {
            // response là dữ liệu từ API
            if (response && response.data) {
                const categories = response.data.map(item => item.date); // Ngày
                const revenues = response.data.map(item => item.revenue); // Doanh thu

                updateRevenueBarChart(categories, revenues);
            } else {
                alert("Không có dữ liệu!");
            }
        },
        error: function () {
            alert("Không thể tải dữ liệu doanh thu!");
        }
    });
}

function updateRevenueBarChart(categories, revenues) {
    const options = {
        chart: {
            type: "bar",
            height: 300,
            stacked: !0,
            dropShadow: {
                enabled: true,
                top: 5,
                left: 5,
                blur: 3,
                color: '#000',
                opacity: 0.1
            },
            toolbar: {
                show: !1
            }
        },
        stroke: {
            width: 0
        },
        dataLabels: {
            enabled: !1
        },
        series: [{
            name: "Doanh thu",
            data: revenues
        }],
        plotOptions: {
            bar: {
                horizontal: !1,
                columnWidth: 25,
                borderRadius: 0
            }
        },
        xaxis: {
            categories: categories,
            axisBorder: {
                show: !0
            },
            axisTicks: {
                show: !0
            },
            labels: {
                show: !0
            }
        },
        yaxis: {
            labels: {
                formatter: function (e) {
                    return e + " vnđ"
                },
                show: !0
            }
        },
        colors: ["#333", "rgba(255, 79, 126, 0.5)"],
    };

    const revenueBarChart = new ApexCharts(document.querySelector("#revenueLineChart"), options);
    revenueBarChart.render();
}

$("#date-list-revenue").daterangepicker(
    {
        startDate: moment().subtract(6, "days"), // Mặc định 7 ngày trước
        endDate: moment(), // Đến hôm nay
        ranges: {
            "Hôm nay": [moment(), moment()],
            "Hôm qua": [moment().subtract(1, "days"), moment().subtract(1, "days")],
            "7 ngày trước": [moment().subtract(6, "days"), moment()],
            "30 ngày trước": [moment().subtract(29, "days"), moment()],
        },
    },
    function (start, end) {
        // Gọi hàm fetchRevenueData khi người dùng chọn khoảng ngày
        fetchRevenueData(start, end);
    }
);

// Gọi lần đầu khi load trang
fetchRevenueData(moment().subtract(6, "days"), moment());


