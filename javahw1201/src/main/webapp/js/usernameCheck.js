$(function () {
    // 变量，预存XMLHttpRequest对象
    var xmlhttp;

    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }


    // 失去焦点事件，当id=name的对象失去焦点后触发
    $("#name").blur(function () {
        // 获得值
        var name = $(this).val();
        // 判断
        if (name === "" || name == null) {
            $("#nameDiv").html("用户名不能为空").css("color", "red");
            return;
        }
        // 回调函数绑定
        xmlhttp.onreadystatechange = handle;

        // 通过XMLHttpRequest对象设置请求信息
        // async=true 启用异步
        xmlhttp.open("GET", "/user/checkUsername?name=" + name, true);

        // 发送请求
        // 不带请求体
        xmlhttp.send(null)
    }).focus(function () {
        // 改变就清空
        $("#nameDiv").html("");
    });

    // 回调函数处理
    function handle() {
        // readystate变化有多种状态，选取我们需要的
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            if (xmlhttp.responseText === "false") {
                $("#nameDiv").html("用户名可以使用！").css("color", "blue");
            } else {
                $("#nameDiv").html("用户名已存在！").css("color", "red");
            }
        }
    }
})