$(function () {
    $("#registerButton").click(function () {
        var userId = $("#userId");
        var userIdDiv = $("#userIdDiv");
        var registerUsername = $("#registerUsername");
        var usernameDiv = $("#registerUsernameDiv");
        var userPassword = $("#userPassword");
        var userPasswordDiv = $("#userPasswordDiv");
        var userRemi = $("#userRemi");
        var userRemiDiv = $("#userRemiDiv");
        var birthday = $("#birthday");
        var birthdayDiv = $("#birthdayDiv");
        var userPhone = $("#userPhone");
        var userPhoneDiv = $("#userPhoneDiv");

        var sex = $("input[name='sex']:checked").val();
        var userType = $("input[name='userType']:checked").val();
        var userAddress = $("#userAddress");


        console.log({
            "userId": userId.val(),
            "username": registerUsername.val(),
            "password": userPassword.val(),
            "sex": sex,
            "birthday": birthday.val(),
            "userPhone": userPhone.val(),
            "userAddress": userAddress.val(),
            "userType": userType
        });

        if (userId.val() == null || userId.val() === "") {
            userIdDiv.css("color", "red");
            return;
        } else {
            userIdDiv.css("color", "green");
        }

        if (registerUsername.val() == null || registerUsername.val() === "") {
            usernameDiv.css("color", "red");
            return;
        } else {
            usernameDiv.css("color", "green");
        }

        if (userPassword.val() == null || userPassword.val() === "") {
            userPasswordDiv.css("color", "red");
            return;
        } else {
            userPasswordDiv.css("color", "green");
        }

        if (userRemi.val() == null || userRemi.val() === "") {
            userRemiDiv.css("color", "red");
            return;
        } else {
            userRemiDiv.css("color", "green");
        }

        if (userRemi.val() !== userPassword.val()) {
            alert("密码重复不一致！");
            return;
        }

        if (birthday.val() == null || birthday.val() === "") {
            birthdayDiv.css("color", "red");
            return;
        } else {
            birthdayDiv.css("color", "green");
        }

        if (userPhone.val() == null || userPhone.val() === "") {
            userPhoneDiv.css("color", "red");
            return;
        } else {
            userPhoneDiv.css("color", "green");
        }

        $.post("/userInfo/registerUserInfo", {
            "userId": userId.val(),
            "username": registerUsername.val(),
            "password": userPassword.val(),
            "sex": sex,
            "birthday": birthday.val(),
            "userPhone": userPhone.val(),
            "userAddress": userAddress.val(),
            "userType": userType
        }, function (data) {
            if (data.insertState === true) {
                alert("注册成功！")
            } else if (data.insertState === false) {
                alert("注册失败！")
            } else {
                alert("未知错误！")
            }
        })
    });

    $("#userId").blur(function () {
        var userIdDiv = $("#userIdDiv");
        if ($(this).val() === "") {
            userIdDiv.html("*请输入用户编码，且不能重复").css("color", "red");
            return;
        }
        $.get("/userInfo/isUserIdExistent", {"userId": $(this).val()}, function (data) {
            if (data.isExistent === 0) {
                userIdDiv.html("用户编码可以使用！").css("color", "green")
            } else if (data.isExistent === 1) {
                userIdDiv.html("用户编码已存在！").css("color", "red");
            } else {
                alert("未知错误！")
            }
        })
    })
});