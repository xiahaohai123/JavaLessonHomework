<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/2
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/js.js"></script>
    <script src="${pageContext.request.contextPath}/js/time.js"></script>


    <script>
        $(function () {
            getDataList(null);
        });

        $(function () {
            $("#querySupplierListButton").click(function () {
                getDataList($("#querySupplierName").val());
            })
        });

        function getDataList(supplierName) {
            $.get("/supplier/toSupplierManagerPage", {"supplierName": supplierName}, function (data) {
                console.log(data.data);
                var tbody = $("#supplierListTable tbody");
                tbody.empty();
                $.each(data.data, function (index, mapObj) {
                    tbody.append(
                        '<tr>' +
                        '<td>' + mapObj.supplierId + '</td>' +
                        '<td>' + mapObj.supplierName + '</td>' +
                        '<td>' + mapObj.linkMan + '</td>' +
                        '<td>' + mapObj.linkTel + '</td>' +
                        '<td>' + mapObj.fax + '</td>' +
                        '<td>' + mapObj.createTimeInString + '</td>' +
                        '<td>' +
                        '<a href="/providerView.jsp?' +
                        'supplierId=' + mapObj.supplierId +
                        '&supplierName=' + mapObj.supplierName +
                        '&linkMan=' + mapObj.linkMan +
                        '&linkTel=' + mapObj.linkTel +
                        '&fax=' + mapObj.fax +
                        '&describe=' + mapObj.describe +
                        '"><img src="/img/read.png" alt="查看" title="查看"/></a>' +
                        '<a href="/providerUpdate.jsp?' +
                        'supplierId=' + mapObj.supplierId +
                        '&supplierName=' + mapObj.supplierName +
                        '&linkMan=' + mapObj.linkMan +
                        '&linkTel=' + mapObj.linkTel +
                        '&linkAddress=' + mapObj.linkAddress +
                        '&fax=' + mapObj.fax +
                        '&describe=' + mapObj.describe +
                        '"><img src="/img/xiugai.png" alt="修改" title="修改"/></a>' +
                        '<a href="javascript:void(0)" class="removeProvider" onclick="onDelete(this)" supplierId = "' + mapObj.supplierId + '"><img src="/img/schu.png" alt="删除" title="删除"/></a>' +
                        '</td>' +
                        '</tr>')
                })
            })
        }

        function onDelete(body) {
            if (window.confirm("****您确定要删除吗?")) {
                deleteSupplier($(body).attr("supplierId"));
                // document.location.href = "/userInfo/deleteUserInfoById?userId=" + ();
            }
        }

        function deleteSupplier(supplierId) {
            $.get("/supplier/deleteSupplier", {"supplierId": supplierId}, function (data) {
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
    <%--    <h1></h1>--%>

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
                <li id="active"><a href="${pageContext.request.contextPath}/providerList.jsp">供应商管理</a>
                </li>
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
            <span>供应商管理页面</span>
        </div>
        <div class="search">
            <span>供应商名称：</span>
            <input type="text" placeholder="请输入供应商的名称" id="querySupplierName"/>
            <input type="button" value="查询" id="querySupplierListButton"/>
            <a href="${pageContext.request.contextPath}/providerAdd.jsp">添加供应商</a>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0" id="supplierListTable">
            <thead>
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            </thead>
            <tbody>
            <%--            <c:forEach items="${supplierList}" var="supplier">--%>
            <%--                <tr>--%>
            <%--                    <td>${supplier.supplierId}</td>--%>
            <%--                    <td>${supplier.supplierName}</td>--%>
            <%--                    <td>${supplier.linkMan}</td>--%>
            <%--                    <td>${supplier.linkTel}</td>--%>
            <%--                    <td>${supplier.linkAddress}</td>--%>
            <%--                    <td>${supplier.createTime}</td>--%>
            <%--                    <td>--%>
            <%--                        <a href="${pageContext.request.contextPath}/providerView.jsp"><img--%>
            <%--                                src="${pageContext.request.contextPath}/img/read.png" alt="查看"--%>
            <%--                                title="查看"/></a>--%>
            <%--                        <a href="${pageContext.request.contextPath}/providerUpdate.jsp"><img--%>
            <%--                                src="${pageContext.request.contextPath}/img/xiugai.png"--%>
            <%--                                alt="修改"--%>
            <%--                                title="修改"/></a>--%>
            <%--                        <a href="#" class="removeProvider"><img src="${pageContext.request.contextPath}/img/schu.png"--%>
            <%--                                                                alt="删除" title="删除"/></a>--%>
            <%--                    </td>--%>
            <%--                </tr>--%>
            <%--            </c:forEach>--%>
            </tbody>
        </table>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该供应商吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>


</body>
</html>
