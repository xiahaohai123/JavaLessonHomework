$(function () {
    $("#updatePassword").click(function () {

        var newPassword = $("#newPassword");
        var reNewPassword = $("#reNewPassword");
        var oldPassword = $("#oldPassword");

        if (oldPassword.val() == "" || oldPassword.val() == null) {
            alert("旧密码不能为空");
            return;
        }

        if (newPassword.val() == "" || newPassword.val() == null) {
            alert("新密码不能为空");
            return;
        }

        if (reNewPassword.val() == "" || reNewPassword.val() == null) {
            alert("再次新密码不能为空");
            return;
        }

        if (oldPassword.val() === newPassword.val()) {
            alert("原密码不能与新密码一致");
            return;
        }

        if (newPassword.val() === reNewPassword.val()) {
            $.post("/userInfo/updatePassword",
                {
                    "oldPassword": oldPassword.val(),
                    "newPassword": newPassword.val()
                }, function (data) {
                    if (data == 1) {
                        alert("密码更新成功！");
                    } else if (data == 0) {
                        alert("密码更新失败")
                    } else {
                        alert("未知错误")
                    }
                    // 刷新所有内容
                    oldPassword.attr("value", "");
                    newPassword.attr("value", "");
                    reNewPassword.attr("value", "")
                })
        } else {
            alert("新旧密码不一致")
        }
    })
});