var address = "http://192.168.100.132:8080/chart_leave/";

function setCookie(name, value, days) {
    var d = new Date;
    d.setTime(d.getTime() + 24*60*60*1000*days);
    window.document.cookie = name + "=" + value + ";path=/;expires=" + d.toGMTString();
}

function getCookie(name) {
    var v = window.document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return v ? v[2] : null;
}

function getUserName(userId) {
    var user = {};
    user.userId = userId;
    var response;
    $.ajax({
        async : false,
        type : 'POST',
        url : address+"getUser",
        data : user,
        dataType : 'json',
        success : function(result) {
            response = result;
        },
        error : function(result) {
            alert('出现错误');
        }
    });
    if(response.status == "0"){
        var user = response.content;
        user = JSON.parse(user);
        return user.userName;
    }
    else{
        alert(response.content);
    }
}