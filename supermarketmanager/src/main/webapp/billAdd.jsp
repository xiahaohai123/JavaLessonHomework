<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/7
  Time: 13:52
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
        $(function () {
            $("#goodsName").blur(function () {
                getGoodsAndSupplier($(this).val())
            });

            $("#count").bind("input propertychange", function () {
                $("#total").val($(this).val() * $("#goodsPrice").val())
            })
        });

        function isOrderIdExists(orderId) {

        }

        function getGoodsAndSupplier(goodsName) {
            $.get("/goods/getGoodsAndSupplier", {"goodsName": goodsName}, function (data) {
                var resultData = data.data;
                $("#goodsPrice").val(resultData.goodsPrice);
                $("#unit").val(resultData.unit);
                var supplierNameSelect = $("#supplierNameSelector");
                supplierNameSelect.empty();
                supplierNameSelect.append(
                    '<option value="' + resultData.supplierName + '">' + resultData.supplierName + '</option>'
                )
            })
        }

        function onAddOrder() {
            var data = {
                "orderId": $("#orderId").val(),
                "goodsName": $("#goodsName").val(),
                "count": $("#count").val(),
                "total": $("#total").val(),
                "pay": $("input[name='zhifu']:checked").val()
            };
            addOrder(data);
        }

        function addOrder(data) {
            $.post("/order/addOrder", data, function (returnData) {
                if (returnData.insertState === true) {
                    alert("添加成功！")
                    $(location).attr('href', '/billList.jsp');
                } else if (returnData.insertState === false) {
                    alert("添加失败！")
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
                <li><a href="${pageContext.request.contextPath}/productList.jsp">商品管理</a></li>
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
                    <input type="text" name="orderId" id="orderId" required/>
                    <span>*请输入订单编码</span>
                </div>
                <div>
                    <label for="goodsName">商品名称：</label>
                    <input type="text" name="goodsName" id="goodsName" required/>
                    <span>*请输入商品名称</span>
                </div>
                <div>
                    <label for="goodsPrice">商品单价：</label>
                    <input type="text" name="goodsPrice" id="goodsPrice" required readonly="readonly"/>
                    <span>*请输入商品单价</span>

                </div>
                <div>
                    <label for="unit">商品单位：</label>
                    <input type="text" name="unit" id="unit" required readonly="readonly"/>
                    <span>*请输入商品单位</span>

                </div>
                <div>
                    <label for="count">商品数量：</label>
                    <input type="text" name="count" id="count" required/>
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>
                <div>
                    <label for="total">总金额：</label>
                    <input type="text" name="total" id="total" required readonly="readonly"/>
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>
                <div>
                    <label>供应商：</label>
                    <select name="supplier" id="supplierNameSelector">
                        <option value="">--请选择相应的提供商--</option>
                        <option value="">北京市粮油总公司</option>
                        <option value="">邯郸市五得利面粉厂</option>

                    </select>
                    <span>*请选择供应商</span>
                </div>
                <div>
                    <label>是否付款：</label>
                    <input type="radio" name="zhifu" checked value="false"/>未付款
                    <input type="radio" name="zhifu" value="true"/>已付款
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.jsp">返回</a>-->
                    <input type="button" value="保存" onclick="onAddOrder()"/>
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