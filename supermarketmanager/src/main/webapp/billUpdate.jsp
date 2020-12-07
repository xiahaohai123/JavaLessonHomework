<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/7
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function onUpdate() {
            update({
                "orderId": $("#orderId").val(),
                "pay": $("input[name='zhifu']:checked").val()
            })
        }

        function update(data) {
            $.post("/order/updateOrder", data, function (data) {
                if (data.updateState === true) {
                    alert("更新成功！");
                    $(location).attr('href', '/billList.jsp');
                } else if (data.updateState === false) {
                    alert("更新失败！")
                } else {
                    alert("出错啦！")
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
                <li id="active"><a href="${pageContext.request.contextPath}/billList.jsp">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/providerList.jsp">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/userList.jsp">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="orderId">订单编码：</label>
                    <input type="text" name="orderId" id="orderId" value="${param.orderId}" readonly="readonly"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="goodsName">商品名称：</label>
                    <input type="text" name="goodsName" id="goodsName" value="${param.goodsName}" readonly="readonly"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="unit">商品单位：</label>
                    <input type="text" name="unit" id="unit" value="${param.unit}" readonly="readonly"/>
                    <span>*</span>

                </div>
                <div>
                    <label for="count">商品数量：</label>
                    <input type="text" name="count" id="count" value="${param.count}" readonly="readonly"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="total">总金额：</label>
                    <input type="text" name="total" id="total" value="${param.total}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="supplierName">供应商：</label>
                    <input type="text" name="supplierName" id="supplierName" value="${param.supplierName}"/>
                    <span>*</span>
                </div>
                <div>
                    <label>是否付款：</label>
                    <% boolean pay = Boolean.valueOf(request.getParameter("pay")); %>
                    <input type="radio" name="zhifu" <%=!pay ? "checked" : ""%> value="false"/>未付款
                    <input type="radio" name="zhifu" <%=pay ? "checked" : ""%> value="true"/>已付款
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.jsp">返回</a>-->
                    <input type="button" value="保存" onclick="onUpdate()"/>
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
