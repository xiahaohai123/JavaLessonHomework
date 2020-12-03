$(function () {
    $("#email").blur(function () {
        $("#emailDiv").html("");
        var email = $(this).val();

        if (email == null || email === "") {
            $("#emailDiv").html("邮箱不能为空").css("color", "red");
        } else {
            $.post("/userComplete/emailCheck", {"email": email}, function (data) {
                if (data == 0) {
                    $("#emailDiv").html("邮箱可以使用!").css("color", "blue");
                } else if(data ==1){
                    $("#emailDiv").html("邮箱已存在！").css("color", "red");
                }else{
                    $("#emailDiv").html("奇怪的问题！").css("color", "red");
                }
            })
        }
    })
});