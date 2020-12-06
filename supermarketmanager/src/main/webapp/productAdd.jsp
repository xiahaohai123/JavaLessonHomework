<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/6
  Time: 19:24
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
        function isGoodsIdExistent(goodsId) {
            var goodIdDiv = $("#goodsIdDiv");
            if (goodsId === "") {
                goodIdDiv.html("*请输商品编号").css("color", "red");
                return true;
            }

            $.get("/goods/isGoodsIdExistent", {"goodsId": goodsId}, function (data) {
                if (data.isExistent === true) {
                    goodIdDiv.html("*商品编号已存在").css("color", "red");
                    return true;
                } else if (data.isExistent === false) {
                    goodIdDiv.html("*商品编号可使用").css("color", "green");
                    return false;
                } else {
                    alert("出错啦！");
                    return true;
                }
            })
        }

        function isSupplierIdExistent(supplierId, returnFunction) {
            var supplierIdDiv = $("#supplierIdDiv");
            if (supplierId === "") {
                supplierIdDiv.html("*请输供应商编号").css("color", "red");
                returnFunction(false);
            }
            $.get("/supplier/isSupplierIdExistent", {"supplierId": supplierId}, function (data) {
                if (data.isExistent === true) {
                    supplierIdDiv.html("*供应商编码存在").css("color", "green");
                    returnFunction(true);
                } else if (data.isExistent === false) {
                    supplierIdDiv.html("*供应商编码不存在").css("color", "red");
                    returnFunction(false);
                } else {
                    alert("出错啦！");
                    returnFunction(false);
                }
            });
        }

        function hasGoodsIdInput(goodsId) {
            var goodsIdDiv = $("#goodsIdDiv");
            if (goodsId === "") {
                goodsIdDiv.html("*请输商品编号").css("color", "red");
                return false;
            } else {
                goodsIdDiv.html("*请输商品编号").css("color", "green");
                return true;
            }
        }

        function hasGoodsNameInput(goodsName) {
            var goodsNameDiv = $("#goodsNameDiv");
            if (goodsName === "") {
                goodsNameDiv.css("color", "red");
                return false;
            } else {
                goodsNameDiv.css("color", "green");
                return true;
            }
        }

        function hasGoodsPriceInput(goodsPrice) {
            var goodsPriceDiv = $("#goodsPriceDiv");
            if (goodsPrice === "") {
                goodsPriceDiv.css("color", "red");
                return false;
            } else {
                goodsPriceDiv.css("color", "green");
                return true;
            }
        }

        function hasUnitInput(unit) {
            var unitDiv = $("#unitDiv");
            if (unit === "") {
                unitDiv.css("color", "red");
                return false;
            } else {
                unitDiv.css("color", "green");
                return true;
            }
        }

        function hasStockInput(stock) {
            var stockDiv = $("#stockDiv");
            if (stock === "") {
                stockDiv.css("color", "red");
                return false;
            } else {
                stockDiv.css("color", "green");
                return true;
            }
        }

        $(function () {
            var goodsId = $("#goodsId");
            goodsId.blur(function () {
                isGoodsIdExistent($(this).val());
            });
            $("#supplierId").blur(function () {
                isSupplierIdExistent($(this).val(), function () {
                });
            });

            goodsId.bind("input propertychange", function () {
                hasGoodsIdInput($(this).val());
            });
            $("#goodsName").bind("input propertychange", function () {
                hasGoodsNameInput($(this).val());
            });

            $("#goodsPrice").bind("input propertychange", function () {
                hasGoodsPriceInput($(this).val());
            });

            $("#unit").bind("input propertychange", function () {
                hasUnitInput($(this).val());
            });
            $("#stock").bind("input propertychange", function () {
                hasStockInput($(this).val());
            });

        });

        function onRegister() {
            var goodsId = $("#goodsId");
            if (!hasGoodsIdInput(goodsId.val())) {
                alert("请输入商品编号！");
                return;
            }
            if (isGoodsIdExistent(goodsId.val())) {
                alert("请输入有效商品编号！");
                return;
            }
            if (!hasGoodsNameInput($("#goodsName").val())) {
                alert("请输入商品名！");
                return;
            }
            if (!hasGoodsPriceInput($("#goodsPrice").val())) {
                alert("请输入商品单价！");
                return;
            }
            if (!hasUnitInput($("#unit").val())) {
                alert("请输入商品单位！");
                return;
            }

            if (!hasStockInput($("#stock").val())) {
                alert("请输入商品库存！");
                return;
            }

            // 用回调函数
            isSupplierIdExistent($("#supplierId").val(), function (isExistent) {
                if (!isExistent) {
                    alert("请输入有效供应商编号！");
                } else {
                    addGoods({
                        "goodsId": $("#goodsId").val(),
                        "goodsName": $("#goodsName").val(),
                        "goodsPrice": $("#goodsPrice").val(),
                        "unit": $("#unit").val(),
                        "stock": $("#stock").val(),
                        "supplierId": $("#supplierId").val()
                    })
                }
            });
        }

        function addGoods(goods) {
            console.log(goods);
            $.post("/goods/addGoods", goods, function (data) {
                if (data.insertState === true) {
                    alert("添加成功！");
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
            <span>商品管理页面 >商品添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="goodsId">商品编号：</label>
                    <input type="text" name="goodsId" id="goodsId"/>
                    <span id="goodsIdDiv">*请输商品编号</span>
                </div>
                <div>
                    <label for="goodsName">商品名称：</label>
                    <input type="text" name="goodsName" id="goodsName"/>
                    <span id="goodsNameDiv">*请输入商品名称</span>
                </div>
                <div>
                    <label for="goodsPrice">单价：</label>
                    <input type="text" name="goodsPrice" id="goodsPrice"/>
                    <span id="goodsPriceDiv">*请输单价</span>
                </div>
                <div>
                    <label for="unit">单位：</label>
                    <input type="text" name="unit" id="unit"/>
                    <span id="unitDiv">*请输入联系电话</span>
                </div>
                <div>
                    <label for="supplierId">供应商编号：</label>
                    <input type="text" name="supplierId" id="supplierId"/>
                    <span id="supplierIdDiv">*</span>
                </div>
                <div>
                    <label for="stock">库存：</label>
                    <input type="text" name="stock" id="stock"/>
                    <span id="stockDiv">*</span>
                </div>

                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="/providerList.jsp">返回</a>-->
                    <input type="button" value="保存" onclick="onRegister()"/>
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
