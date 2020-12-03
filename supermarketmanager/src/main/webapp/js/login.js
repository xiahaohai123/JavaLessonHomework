$(function () {
    $("#login").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();

        if (username == "" || username == null) {
            return;
        }

        if (password == "" || password == null) {
            return;
        }

        $.post("/userInfo/login", {"username": username, "password": password}, function (data) {
            if (data == 1) {
                $(location).attr('href', "welcome.jsp");
                // $(location).attr('href', "http://www.baidu.com");
                alert("登陆成功！");
            } else if (data == 0) {
                alert("登录失败！")
            } else {
                alert("出错了！")
            }
        })
    })
});