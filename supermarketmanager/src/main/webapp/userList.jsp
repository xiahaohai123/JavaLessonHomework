<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/3
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/exitSys.js"></script>
    <script type="text/javascript">
        $(function () {
            getUserInfoData(null)
        });

        function getUserInfoData(data) {
            $.get("/userInfo/getUserInfoList", {"username": data === "" ? null : data}, function (resData) {
                // json字符串转json对象
                var json = eval('(' + resData + ')');
                console.log(json);
                var tbody = $("#userInfoTable tbody");
                tbody.empty();
                $.each(json, function (index, mapObj) {
                    tbody.append('<tr>' +
                        '<td>' + mapObj.userId + '</td>' +
                        '<td>' + mapObj.username + '</td>' +
                        '<td>' + mapObj.sex + '</td>' +
                        '<td>' + mapObj.age + '</td>' +
                        '<td>' + mapObj.userTel + '</td>' +
                        '<td>' + mapObj.typeName + '</td>' +
                        '<td>' +
                        '<a href="/userInfo/getUserInfoById?userId=' + mapObj.userId + '"><img src="/img/read.png" alt="查看" title="查看"/></a>' +
                        '<a href="/userUpdate.jsp?userId=' + mapObj.userId +
                        '&username=' + mapObj.username +
                        '&sex=' + mapObj.sex +
                        '&bornDate=' + mapObj.bornDate +
                        '&userTel=' + mapObj.userTel +
                        '&userAddress=' + mapObj.userAddress +
                        '&typeName=' + mapObj.typeName + '"><img src="/img/xiugai.png" alt="修改" title="修改"/></a>' +
                        '<a href="javascript:void(0)" class="removeUser" onclick="funDel(this)" userId="' + mapObj.userId + '"><img src="/img/schu.png" alt="删除" title="删除"/></a>' +
                        '</td>' +
                        '</tr>')
                })
            })
        }

        $(function () {
            $("#queryButton").click(function () {

                getUserInfoData($("#searchUsername").val());
            })
        });

        function funDel(body) {
            if (window.confirm("****您确定要删除吗?")) {
                delUser($(body).attr("userId"));
                // document.location.href = "/userInfo/deleteUserInfoById?userId=" + ();
            }
        }

        function delUser(userId) {
            $.get("/userInfo/deleteUserInfoById", {
                "userId": userId
            }, function (data) {
                if (data.deleteState === true) {
                    alert("删除成功！");
                    window.location.reload();
                } else if (data.deleteState === true) {
                    alert("删除失败！")
                } else {
                    alert("未知错误！")
                }
            })
        }
    </script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b">${sessionScope.username}</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/login.jsp" id="exitSysOnTopRight">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath}/billList.html">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/providerList.jsp">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/productList.jsp">商品管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/userList.jsp">用户管理</a></li>

                <li><a href="${pageContext.request.contextPath}/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp" id="exitSys">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <span>用户名：</span>
            <input type="text" placeholder="请输入用户名" id="searchUsername"/>
            <input type="button" value="查询" id="queryButton"/>
            <a href="${pageContext.request.contextPath}/userAdd.jsp">添加用户</a>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0" id="userInfoTable">
            <thead>
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="20%">用户名称</th>
                <th width="10%">性别</th>
                <th width="10%">年龄</th>
                <th width="10%">电话</th>
                <th width="10%">用户类型</th>
                <th width="30%">操作</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
    summersea
</footer>

<%--<script src="js/jquery.js"></script>--%>
<script src="${pageContext.request.contextPath}/js/js.js"></script>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>
