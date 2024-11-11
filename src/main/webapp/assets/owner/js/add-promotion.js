$(function() {
    $('input[name="dateeffective"]').daterangepicker({
        timePicker: true,
        startDate: moment().startOf('hour'),
        endDate: moment().startOf('hour').add(32, 'hour'),
        minDate: moment(), // Ngày tối thiểu là ngày hiện tại, không thể chọn quá khứ
        locale: {
            format: 'M/DD hh:mm A'
        }
    });
});
