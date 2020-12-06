<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/3
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/register.js"></script>
    <script src="${pageContext.request.contextPath}/js/exitSys.js"></script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b">${sessionScope.username}</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/login.jsp" id="exitSysOnTopRight">退出</a>
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
                <li><a href="productList.jsp">商品管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/userList.jsp">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp" id="exitSys">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="userId">用户编码：</label>
                    <input type="text" name="userId" id="userId"/>
                    <span id="userIdDiv">*请输入用户编码，且不能重复</span>
                </div>
                <div>
                    <label for="registerUsername">用户名称：</label>
                    <input type="text" id="registerUsername" name="registerUsername"/>
                    <span id="registerUsernameDiv">*请输入用户名称</span>

                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="text" name="userPassword" id="userPassword"/>
                    <span id="userPasswordDiv">*密码长度必须大于6位小于20位</span>

                </div>
                <div>
                    <label for="userRemi">确认密码：</label>
                    <input type="text" name="userRemi" id="userRemi"/>
                    <span id="userRemiDiv">*请输入确认密码</span>
                </div>
                <div>
                    <label>用户性别：</label>


                    <input name="sex" type="radio" checked value="男">男
                    <input name="sex" type="radio" value="女">女
                    <span></span>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <INPUT class="sang_Calender" class=test id="birthday" type=text name="houseDate">
                    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datetime.js"></script>
                    <span id="birthdayDiv">*请输入出生日期</span>
                </div>
                <div>
                    <label for="userPhone">用户电话：</label>
                    <input type="text" name="userPhone" id="userPhone"/>
                    <span id="userPhoneDiv">*请输入用户电话</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress"/>
                </div>
                <div>
                    <label>用户类别：</label>
                    <input type="radio" name="userType" value="主管"/>主管
                    <input type="radio" name="userType" value="经理"/>经理
                    <input type="radio" checked name="userType" value="职员"/>职员

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="/userList.jsp">返回</a>-->
                    <input type="button" value="保存" id="registerButton"/>
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

</body>
</html>
