<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/6
  Time: 21:33
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
            var goodsId = $("#goodsId");
            var goodsName = $("#goodsName");
            var goodsPrice = $("#goodsPrice");
            var unit = $("#unit");
            var supplierId = $("#supplierId");
            var stock = $("#stock");
            update({
                "goodsId": goodsId.val(),
                "goodsName": goodsName.val() === "" ? goodsName.attr("placeholder") : goodsName.val(),
                "goodsPrice": goodsPrice.val() === "" ? goodsPrice.attr("placeholder") : goodsPrice.val(),
                "unit": unit.val() === "" ? unit.attr("placeholder") : unit.val(),
                "supplierId": supplierId.val() === "" ? supplierId.attr("placeholder") : supplierId.val(),
                "stock": stock.val() === "" ? stock.attr("placeholder") : stock.val()
            })
        }

        function update(data) {
            $.post("/goods/updateGoods", data, function (data) {
                if (data.updateState === true) {
                    alert("更新成功！");
                    $(location).attr('href', '/productList.jsp');
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
                <li><a href="billList.jsp">账单管理</a></li>
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
            <span>商品管理页面 >商品修改页</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="goodsId">商品编号：</label>
                    <input type="text" name="goodsId" id="goodsId" value="${param.goodsId}"
                           readonly="readonly"/>
                </div>
                <div>
                    <label for="goodsName">商品名称：</label>
                    <input type="text" name="goodsName" id="goodsName" placeholder="${param.goodsName}"/>
                    <span>*请输入商品名称</span>
                </div>
                <div>
                    <label for="goodsPrice">单价：</label>
                    <input type="text" name="goodsPrice" id="goodsPrice" placeholder="${param.goodsPrice}"/>
                    <span>*请输单价</span>

                </div>
                <div>
                    <label for="unit">单位：</label>
                    <input type="text" name="unit" id="unit" placeholder="${param.unit}"/>
                    <span>*请输入联系电话</span>
                </div>
                <div>
                    <label for="supplierId">供应商编号：</label>
                    <input type="text" name="supplierId" id="supplierId" placeholder="${param.supplierId}"/>
                    <span></span>
                </div>
                <div>
                    <label for="stock">库存：</label>
                    <input type="text" name="stock" id="stock" placeholder="${param.stock}"/>
                    <span></span>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="/providerList.jsp">返回</a>-->
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
