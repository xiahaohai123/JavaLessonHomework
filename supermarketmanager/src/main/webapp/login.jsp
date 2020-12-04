<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/3
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head lang="en">
    <%--    <meta charset="UTF-8">--%>
    <title>系统登录 - 超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"
            charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js" charset="UTF-8"></script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>超市账单管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" onsubmit="return false">
            <div class="inputbox">
                <label for="username">用户名：</label>
                <input id="username" type="text" name="username" placeholder="请输入用户名" required/>
            </div>
            <div class="inputbox">
                <label for="password">密码：</label>
                <input id="password" type="password" name="password" placeholder="请输入密码" required/>
            </div>
            <div class="subBtn">
                <input id="login" type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </div>

        </form>
    </section>
</section>

</body>
</html>
