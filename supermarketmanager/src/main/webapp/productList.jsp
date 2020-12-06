<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/6
  Time: 17:05
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
            getGoodsList(null);
        });

        function getGoodsList(goodsName) {
            $.get("/goods/getGoodsList", {"goodsName": goodsName}, function (data) {
                console.log(data.data);
                var tbody = $("#goodsTable tbody");
                tbody.empty();
                $.each(data.data, function (index, mapObj) {
                    tbody.append(
                        '<tr>' +
                        '<td>' + mapObj.goodsId + '</td>' +
                        '<td>' + mapObj.goodsName + '</td>' +
                        '<td>' + mapObj.goodsPrice + '</td>' +
                        '<td>' + mapObj.linkTel + '</td>' +
                        '<td>' + mapObj.unit + '</td>' +
                        '<td>' +
                        '<a href="/productView.jsp?' +
                        'goodsId=' + mapObj.goodsId +
                        '&goodsName=' + mapObj.goodsName +
                        '&goodsPrice=' + mapObj.goodsPrice +
                        '&unit=' + mapObj.unit +
                        '&supplierId=' + mapObj.supplierId +
                        '&stock=' + mapObj.stock +
                        '"><img src="/img/read.png" alt="查看" title="查看"/></a>' +
                        '<a href="/productUpdate.html"><img src="/img/xiugai.png" alt="修改" title="修改"/></a>' +
                        '<a href="javascript:void(0)" class="removeProvider"><img src="/img/schu.png" alt="删除" title="删除"/></a>' +
                        '</td>' +
                        '</tr>'
                    )
                })
            })
        }

        $(function () {
            $("#goodsQueryButton").click(function () {
                getGoodsList($("#goodsQueryName").val())
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
                <li><a href="${pageContext.request.contextPath}/billList.html">账单管理</a></li>
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
            <span>商品管理页面</span>
        </div>
        <div class="search">
            <span>商品名称：</span>
            <input type="text" placeholder="请输商品的名称" id="goodsQueryName"/>
            <input type="button" value="查询" id="goodsQueryButton"/>
            <a href="${pageContext.request.contextPath}/productAdd.jsp">添加商品</a>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0" id="goodsTable">
            <thead>
            <tr class="firstTr">
                <th width="10%">商品编号</th>
                <th width="20%">商品名称</th>
                <th width="10%">商品价格</th>
                <th width="10%">联系电话</th>
                <th width="10%">商品单位</th>
                <th width="30%">操作</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删该除商品吗？</p>
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
