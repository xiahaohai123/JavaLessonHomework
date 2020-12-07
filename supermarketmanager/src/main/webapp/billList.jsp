<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/6
  Time: 21:59
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
            getBillList(null);
            getSupplierNameList();
        });

        function getBillList(queryData) {
            $.get("/order/getOrderList", queryData, function (data) {
                console.log(data.data);
                var tbody = $("#orderListTable tbody");
                tbody.empty();
                $.each(data.data, function (index, mapObj) {
                    tbody.append(
                        '<tr>' +
                        '<td>' + mapObj.orderId + '</td>' +
                        '<td>' + mapObj.goodsName + '</td>' +
                        '<td>' + mapObj.supplierName + '</td>' +
                        '<td>' + mapObj.total + '</td>' +
                        '<td>' + (mapObj.pay === true ? "是" : "否") + '</td>' +
                        '<td>' + mapObj.createTime + '</td>' +
                        '<td>' +
                        '<a href="/billView.jsp?' +
                        'orderId=' + mapObj.orderId +
                        '&goodsName=' + mapObj.goodsName +
                        '&unit=' + mapObj.unit +
                        '&count=' + mapObj.count +
                        '&total=' + mapObj.total +
                        '&supplierName=' + mapObj.supplierName +
                        '&pay=' + (mapObj.pay === true ? "是" : "否") +
                        '"><img src="img/read.png" alt="查看" title="查看"/></a>' +
                        '<a href="/billUpdate.jsp?' +
                        'orderId=' + mapObj.orderId +
                        '&goodsName=' + mapObj.goodsName +
                        '&unit=' + mapObj.unit +
                        '&count=' + mapObj.count +
                        '&total=' + mapObj.total +
                        '&supplierName=' + mapObj.supplierName +
                        '&pay=' + mapObj.pay +
                        '"><img src="img/xiugai.png" alt="修改" title="修改"/></a>' +
                        '<a href="javascript:void(0)" class="removeBill" orderId="' + mapObj.orderId + '"><img src="img/schu.png" alt="删除" title="删除"/></a>' +
                        '</td>' +
                        '</tr>')
                })
            })
        }

        function getSupplierNameList() {
            $.get("/supplier/getAllSupplierName", null, function (data) {
                var selector = $("#supplierSelector");
                $.each(data.data, function (index, mapObj) {
                    selector.append("<option value=" + mapObj.supplierName + ">" + mapObj.supplierName + "</option>")
                })
            })
        }

        $(function () {
            $("#queryOrderButton").click(function () {
                var data = {
                    "goodsName": $("#queryGoodsName").val(),
                    // "supplierName": $("#supplierSelector").find('option:selected').text(),
                    "supplierName": $("#supplierSelector").val(),
                    // "hasPayed": $("#hasPayedSelector").find('option:selected').text()
                    "hasPayed": $("#hasPayedSelector").val()
                };

                // console.log(data);
                getBillList(data)
            })
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
                <li id="active"><a href="${pageContext.request.contextPath}/billList.jsp">账单管理</a></li>
                <!--                    <li><a href="/providerList.jsp">供应商管理</a></li>-->
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
            <span>账单管理页面</span>
        </div>
        <div class="search">
            <span>商品名称：</span>
            <input type="text" placeholder="请输入商品的名称" id="queryGoodsName"/>

            <span>供应商：</span>
            <select name="tigong" id="supplierSelector">
                <option value="">--请选择--</option>
                <%--                <option value="北京市粮油总公司">北京市粮油总公司</option>--%>
                <%--                <option value="邯郸市五得利面粉厂">邯郸市五得利面粉厂</option>--%>
            </select>

            <span>是否付款：</span>
            <select name="fukuan" id="hasPayedSelector">
                <option value="">--请选择--</option>
                <option value="true">已付款</option>
                <option value="false">未付款</option>
            </select>

            <input type="button" value="查询" id="queryOrderButton"/>
            <a href="${pageContext.request.contextPath}/billAdd.jsp">添加订单</a>
        </div>
        <!--账单表格 样式和供应商公用-->
        <table class="providerTable" cellpadding="0" cellspacing="0" id="orderListTable">
            <thead>
            <tr class="firstTr">
                <th width="10%">账单编码</th>
                <th width="20%">商品名称</th>
                <th width="10%">供应商</th>
                <th width="10%">账单金额</th>
                <th width="10%">是否付款</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
    summersea
</footer>

<script src="${pageContext.request.contextPath}/js/js.js"></script>
<script src="${pageContext.request.contextPath}/js/time.js"></script>

</body>
</html>
