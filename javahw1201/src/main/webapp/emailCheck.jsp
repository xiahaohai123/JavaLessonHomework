<%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/12/1
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/emailCheck.js"></script>
</head>
<body>
<table>
    <tr>
        <td> 邮 箱：</td>
        <td><input type="text" name="name" id="email"/>&nbsp;<span style="color:crimson">*</span></td>
        <td>
            <div id="emailDiv" style="display: inline"></div>
        </td>
    </tr>
    <tr>
        <td> 用 户 名：</td>
        <td><input type="text"/>&nbsp;<span style="color:crimson">*</span></td>
        <td>
            <div style="display: inline"></div>
        </td>
    </tr>
    <tr>
        <td> 密 码 ：</td>
        <td><input type="text"/>&nbsp;<span style="color:crimson">*</span></td>
        <td>
            <div style="display: inline"></div>
        </td>
    </tr>
</table>
</body>
</html>
