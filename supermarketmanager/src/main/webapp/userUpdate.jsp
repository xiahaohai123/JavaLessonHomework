<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/4
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>

    <script>
        $(function () {
            $("#updateUserInfoButton").click(function () {
                var userId = getQueryVariable("userId");
                var username = $("#username");
                var userTel = $("#userTel");
                var userAddress = $("#userAddress");

                $.post("/userInfo/updateUserInfo", {
                    "userId": userId,
                    "username": username.val() === "" ? username.attr("placeholder") : username.val(),
                    "sex": $("input[name='sex']:checked").val(),
                    "bornDate": $("#bornDate").val(),
                    "userTel": userTel.val() === "" ? userTel.attr("placeholder") : userTel.val(),
                    "userAddress": userAddress.val() === "" ? userAddress.attr("placeholder") : userAddress.val(),
                    "userType": $("input[name='userType']:checked").val()
                }, function (data) {
                    if (data.updateState === true) {
                        alert("修改成功！")
                    } else if (data.updateState === false) {
                        alert("修改失败！")
                    } else {
                        alert("出错啦！ ")
                    }
                });
            });

            function getQueryVariable(variable) {
                var query = window.location.search.substring(1);
                var vars = query.split("&");
                for (var i = 0; i < vars.length; i++) {
                    var pair = vars[i].split("=");
                    if (pair[0] == variable) {
                        return pair[1];
                    }
                }
                return (false);
            }
        })
    </script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b">${sessionScope.username}</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/login.jsp">退出</a>
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
                <li><a href="${pageContext.request.contextPath}/productList.html">商品管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/userList.jsp">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="username">用户名称：</label>
                    <input type="text" name="username" id="username" placeholder="${param.username}"/>
                    <span>*</span>
                </div>

                <div>
                    <label>用户性别：</label>

                    <% String sex = request.getParameter("sex"); %>
                    <input name="sex" type="radio" <%="男".equals(sex)?"checked":""%> value="男">男
                    <input name="sex" type="radio" <%="女".equals(sex)?"checked":""%> value="女">女
                </div>
                <div>
                    <label for="bornDate">出生日期：</label>
                    <INPUT class="sang_Calender" class=test type=text name="bornDate" id="bornDate"
                           value="${param.bornDate}">
                    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datetime.js"></script>
                    <span>*</span>
                </div>
                <div>
                    <label for="userTel">用户电话：</label>
                    <input type="text" name="userTel" id="userTel" placeholder="${param.userTel}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress" placeholder="${param.userAddress}"/>
                </div>
                <div>
                    <label>用户类别：</label>
                    <% String typeName = request.getParameter("typeName"); %>
                    <input type="radio" name="userType" <%="主管".equals(typeName) ? "checked" : ""%> value="主管"/>主管
                    <input type="radio" name="userType" <%="经理".equals(typeName) ? "checked" : ""%> value="经理"/>经理
                    <input type="radio" name="userType" <%="职员".equals(typeName) ? "checked" : ""%> value="职员"/>职员

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="/userList.jsp">返回</a>-->
                    <input type="button" value="保存" id="updateUserInfoButton"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
    summersea
</footer>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>
