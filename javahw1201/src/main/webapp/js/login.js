$(function () {
    $("#loginButton").click(function () {
        var usernameDiv = $("#usernameDiv");
        var passwordDiv = $("#passwordDiv");
        // 清空
        usernameDiv.html("");
        passwordDiv.html("");
        var username = $("#username").val();
        var password = $("#password").val();

        // 判空
        if (username === "" || username == null) {
            usernameDiv.html("用户名不能为空！").css("color", "red");
            return;
        }
        if (password === "" || password == null) {
            passwordDiv.html("密码不能为空！").css("color", "red");
        }

        $.post("userComplete/login", {"username": username, "password": password}, function (data) {
            if (data == 1) {
                alert("登陆成功！")
            } else if (data == 0) {
                alert("登录失败！")
            } else {
                alert("出错了！")
            }
        })

    })
});