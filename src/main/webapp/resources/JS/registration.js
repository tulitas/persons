$(".name").focus(function(){
    $(".name-help").slideDown(500);
}).blur(function(){
    $(".name-help").slideUp(500);
});

$(".email").focus(function(){
    $(".email-help").slideDown(500);
}).blur(function(){
    $(".email-help").slideUp(500);
});

function zero_first_format(value) {
    if (value < 10) {
        value = '0' + value;
    }
    return value;
}

function date_time() {
    var current_datetime = new Date();
    var day = zero_first_format(current_datetime.getDate());
    var month = zero_first_format(current_datetime.getMonth() + 1);
    var year = current_datetime.getFullYear();
    var hours = zero_first_format(current_datetime.getHours());
    var minutes = zero_first_format(current_datetime.getMinutes());
    var seconds = zero_first_format(current_datetime.getSeconds());


    document.getElementById('current_date_time_block').innerHTML =
        day + "." + month + "." + year + " " + hours + ":" + minutes + ":" + seconds;
}

setInterval(date_time, 0);