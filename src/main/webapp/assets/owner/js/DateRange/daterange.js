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

    // Initialize daterangepicker with callback
    $(".daterange").daterangepicker(
        {
            startDate: start,
            endDate: end,
            ranges: {
                "Hôm nay": [moment(), moment()],
                "Hôm qua": [moment().subtract(1, "days"), moment().subtract(1, "days")],
                "7 ngày trước": [moment().subtract(6, "days"), moment()],
                "30 ngày trước": [moment().subtract(29, "days"), moment()],
                "Tháng này": [moment().startOf("month"), moment().endOf("month")],
            },
        },
        function (start, end) {
            cb(start, end, $(".daterange"));
        }
    );

    // Load data immediately when the page loads
    cb(start, end, $(".daterange"));
    updateCounts(start, end); // Load counts immediately
});

