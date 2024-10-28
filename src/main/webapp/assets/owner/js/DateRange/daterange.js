$(function() {

    var start = moment().subtract(29, 'days');
    var end = moment();

    function cb(start, end, element) {
        $(element).find('span').html(start.format('MMM D, YYYY') + ' - ' + end.format('MMM D, YYYY'));
    }

    $('.daterange').each(function() {
        var $this = $(this);
        $this.daterangepicker({
            startDate: start,
            endDate: end,
            ranges: {
                'Hôm nay': [moment(), moment()],
                'Hôm qua': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                '7 ngày trước': [moment().subtract(6, 'days'), moment()],
                '30 ngày trước': [moment().subtract(29, 'days'), moment()],
                'Tháng này': [moment().startOf('month'), moment().endOf('month')],
                'Quý này': [moment().startOf('quarter'), moment().endOf('quarter')]
            }
        }, function(start, end) {
            cb(start, end, $this);
        });

        cb(start, end, $this);
    });
});
