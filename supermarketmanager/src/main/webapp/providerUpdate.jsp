<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/5
  Time: 22:32
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
            var supplierName = $("#supplierName");
            var linkMan = $("#linkMan");
            var linkTel = $("#linkTel");
            var linkAddress = $("#linkAddress");
            var fax = $("#fax");
            var describe = $("#describe");
            update({
                "supplierId": $("#providerId").val(),
                "supplierName": supplierName.val() === "" ? supplierName.attr("placeholder") : supplierName.val(),
                "linkMan": linkMan.val() === "" ? linkMan.attr("placeholder") : linkMan.val(),
                "linkTel": linkTel.val() === "" ? linkTel.attr("placeholder") : linkTel.val(),
                "linkAddress": linkAddress.val() === "" ? linkAddress.attr("placeholder") : linkAddress.val(),
                "fax": fax.val() === "" ? fax.attr("placeholder") : fax.val(),
                "describe": describe.val() === "" ? describe.attr("placeholder") : describe.val()
            })
        }

        function update(data) {
            $.post("/supplier/updateSupplier", data, function (data) {
                if (data.updateState === true) {
                    alert("更新成功！")
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
                <li><a href="billList.html">账单管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/providerList.jsp">供应商管理</a></li>
                <li><a href="productList.jsp">商品管理</a></li>
                <li><a href="${pageContext.request.contextPath}/userList.jsp">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商修改页</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="providerId">供应商编码：</label>
                    <input type="text" name="providerId" id="providerId" value="${param.supplierId}"
                           readonly="readonly"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="supplierName">供应商名称：</label>
                    <input type="text" name="providerName" id="supplierName" placeholder="${param.supplierName}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="linkMan">联系人：</label>
                    <input type="text" name="linkMan" id="linkMan" placeholder="${param.linkMan}"/>
                    <span>*</span>

                </div>
                <div>
                    <label for="linkTel">联系电话：</label>
                    <input type="text" name="linkTel" id="linkTel" placeholder="${param.linkTel}"/>
                    <span></span>
                </div>
                <div>
                    <label for="linkAddress">联系地址：</label>
                    <input type="text" name="linkAddress" id="linkAddress" placeholder="${param.linkAddress}"/>
                    <span></span>

                </div>
                <div>
                    <label for="fax">传真：</label>
                    <input type="text" name="fax" id="fax" placeholder="${param.fax}"/>
                    <span></span>

                </div>
                <div>
                    <label for="describe">描述：</label>
                    <input type="text" name="describe" id="describe" placeholder="${param.describe}"/>
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
<script src="js/time.js"></script>

</body>
</html>
