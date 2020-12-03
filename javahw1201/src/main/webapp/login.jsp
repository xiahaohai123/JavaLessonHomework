<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/1
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<table>
    <tr>
        <td> 用 户 名：</td>
        <td><input type="text" id="username"/>&nbsp;<span style="color:crimson">*</span></td>
        <td>
            <div id="usernameDiv" style="display: inline"></div>
        </td>
    </tr>
    <tr>
        <td> 密 码 ：</td>
        <td><input type="text" id="password"/>&nbsp;<span style="color:crimson">*</span></td>
        <td>
            <div id="passwordDiv" style="display: inline"></div>
        </td>
    </tr>
    <tr>
        <td>
            <input type="button" id="loginButton" value="登录">
        </td>
    </tr>
</table>
</body>
</html>
