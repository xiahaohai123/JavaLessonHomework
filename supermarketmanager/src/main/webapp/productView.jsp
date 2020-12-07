<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/6
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
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
                <li><a href="${pageContext.request.contextPath}/billList.jsp">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/providerList.jsp">供应商管理</a></li>
                <li id="active"><a href="productList.jsp">商品管理</a></li>
                <li><a href="${pageContext.request.contextPath}/userList.jsp">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>商品管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>商品编号：</strong><span>${param.goodsId}</span></p>
            <p><strong>商品名称：</strong><span>${param.goodsName}</span></p>
            <p><strong>单价：</strong><span>${param.goodsPrice}</span></p>
            <p><strong>单位：</strong><span>${param.unit}</span></p>
            <p><strong>供应商编号：</strong><span>${param.supplierId}</span></p>
            <p><strong>库存：</strong><span>${param.stock}</span></p>
            <a href="${pageContext.request.contextPath}/productList.jsp">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
    summersea
</footer>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>
