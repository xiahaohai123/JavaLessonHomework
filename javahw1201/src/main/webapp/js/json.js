$(function () {
    var data = [
        {"id": 1, "username": "admin", "email": "admin@qq.com"},
        {"id": 2, "username": "admin1", "email": "admin1@qq.com"},
        {"id": 3, "username": "admin2", "email": "admin2@qq.com"},
        {"id": 4, "username": "admin3", "email": "admin3@qq.com"},
        {"id": 5, "username": "admin4", "email": "admin4@qq.com"}
    ];
    var tbody = $("#table1 tbody");
    var select = $("#select");
    $.each(data, function (index, data) {
        tbody.append('<tr>' +
            '<td>' + data.id + '</td>' +
            '<td>' + data.username + '</td>' +
            '<td>' + data.email + '</td>' +
            '</tr>');

        select.append("<option value=" + data.id + ">" + data.username +"&nbsp;"+data.email+ "</option>")
    })

});