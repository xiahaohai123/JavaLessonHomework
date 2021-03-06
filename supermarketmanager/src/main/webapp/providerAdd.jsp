<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/5
  Time: 21:04
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
        var isSupplierIdExistent = true;

        var isSupplierIdInput = false;
        var isProviderNameInput = false;
        var isPeopleInput = false;
        var isPhoneInput = false;

        // 检测输入function
        $(function () {
            var providerId = $("#providerId");
            providerId.blur(function () {
                var providerIdDiv = $("#providerIdDiv");
                var value = $(this).val();
                if (value === "") {
                    providerIdDiv.html("*请输入供应商编码").css("color", "red");
                    isSupplierIdExistent = true;
                    return;
                }

                $.get("/supplier/isSupplierIdExistent", {"supplierId": value}, function (data) {
                    if (data.isExistent === true) {
                        isSupplierIdExistent = true;
                        providerIdDiv.html("*供应商编码已存在").css("color", "red");
                    } else if (data.isExistent === false) {
                        isSupplierIdExistent = false;
                        providerIdDiv.html("*供应商编码可以使用").css("color", "green");
                    } else {
                        isSupplierIdExistent = true;
                        alert("出错啦！")
                    }
                })

            });

            $("#providerName").bind("input propertychange", function () {
                var providerNameDiv = $("#providerNameDiv");
                if ($(this).val() === "") {
                    isProviderNameInput = false;
                    providerNameDiv.css("color", "red");
                } else {
                    isProviderNameInput = true;
                    providerNameDiv.css("color", "green");
                }
            });

            $("#people").bind("input propertychange", function () {
                var peopleDiv = $("#peopleDiv");
                if ($(this).val() === "") {
                    isPeopleInput = false;
                    peopleDiv.css("color", "red");
                } else {
                    isPeopleInput = true;
                    peopleDiv.css("color", "green");
                }
            });

            $("#phone").bind("input propertychange", function () {
                var phoneDiv = $("#phoneDiv");
                if ($(this).val() === "") {
                    isPhoneInput = false;
                    phoneDiv.css("color", "red");
                } else {
                    isPhoneInput = true;
                    phoneDiv.css("color", "green");
                }
            });

            providerId.bind("input propertychange", function () {
                var providerIdDiv = $("#providerIdDiv");
                if ($(this).val() === "") {
                    isSupplierIdInput = false;
                    providerIdDiv.css("color", "red");
                } else {
                    isSupplierIdInput = true;
                    providerIdDiv.css("color", "green");
                }
            });
        });

        function onRegisterClick() {

            if (isSupplierIdExistent) {
                alert("请确保编码可使用！");
                return;
            }


            if (isSupplierIdInput && isProviderNameInput && isPeopleInput && isPhoneInput) {
                register({
                    "supplierId": $("#providerId").val(),
                    "supplierName": $("#providerName").val(),
                    "linkMan": $("#people").val(),
                    "linkTel": $("#phone").val(),
                    "linkAddress": $("#address").val(),
                    "fax": $("#fax").val(),
                    "describe": $("#describe").val()
                })
            } else {
                alert("请确保必输入项已输入");
            }

        }

        function register(data) {
            $.post("/supplier/registerSupplier", data, function (data) {
                if (data.insertState === true) {
                    alert("添加成功！");
                    $(location).attr('href', '/providerList.jsp');
                } else if (data.insertState === false) {
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
                <li><a href="billList.jsp">账单管理</a></li>
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
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="providerId">供应商编码：</label>
                    <input type="text" name="providerId" id="providerId"/>
                    <span id="providerIdDiv">*请输入供应商编码</span>
                </div>
                <div>
                    <label for="providerName">供应商名称：</label>
                    <input type="text" name="providerName" id="providerName"/>
                    <span id="providerNameDiv">*请输入供应商名称</span>
                </div>
                <div>
                    <label for="people">联系人：</label>
                    <input type="text" name="people" id="people"/>
                    <span id="peopleDiv">*请输入联系人</span>

                </div>
                <div>
                    <label for="phone">联系电话：</label>
                    <input type="text" name="phone" id="phone"/>
                    <span id="phoneDiv">*请输入联系电话</span>
                </div>
                <div>
                    <label for="address">联系地址：</label>
                    <input type="text" name="address" id="address"/>
                    <span></span>
                </div>
                <div>
                    <label for="fax">传真：</label>
                    <input type="text" name="fax" id="fax"/>
                    <span></span>
                </div>
                <div>
                    <label for="describe">描述：</label>
                    <input type="text" name="describe" id="describe"/>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="/providerList.jsp">返回</a>-->
                    <input type="button" value="保存" onclick="onRegisterClick()"/>
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
