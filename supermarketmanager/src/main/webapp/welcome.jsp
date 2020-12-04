<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/2
  Time: 21:46
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
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <%--    <h1><></h1>--%>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span
                style="color: #fff21b">${sessionScope.username}</span> ,
            欢迎你！</p>
        <a href="/login.jsp" id="exitSysOnTopRight">退出</a>
    </div>
</header>
<!--时间-->
<% long date = new Date().getTime();
    request.setAttribute("date", date);%>
<section class="publicTime">
    <%--    <span id="time">2015年1月1日 11:11  星期一</span>--%>
    <span id="time">${date}</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath}/billList.html">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/supplier/toSupplierManagerPage">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/productList.html">商品管理</a></li>
                <li><a href="${pageContext.request.contextPath}/userList.jsp">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp" id="exitSys">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath}/img/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${sessionScope.username}</h2>
            <p>欢迎来到超市账单管理系统!</p>
        </div>
    </div>
</section>
<footer class="footer">
    summersea
</footer>
<script src="${pageContext.request.contextPath}/js/time.js"></script>
</body>
</html>
