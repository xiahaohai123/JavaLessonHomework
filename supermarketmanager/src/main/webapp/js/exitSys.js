$(function () {
    $("#exitSys").click(function () {
        $.get("/userInfo/exist", null)
    });

    $("#exitSysOnTopRight").click(function () {
        $.get("/userInfo/exist", null)
    })
});