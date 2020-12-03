<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xiaha
  Date: 2020/11/30
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>课间小憩网</title>
    <style type="text/css">
        <!--
        .style1 {
            color: #000066;
            font-weight: bold;
        }

        .style2 {
            color: #FF0000
        }

        -->
    </style>
</head>

<body bgcolor="#CCCCFF">
<table width="490" border="0" align="center">
    <tr>
        <td align="center"><img src="/image/header.gif" width="468" height="60"></td>
    </tr>
    <tr>
        <td align="center"> 【<a href="listUsers.html">用户管理</a>】【<a href="listNews.html">新闻管理</a>】【商铺管理】【论坛管理】【<a
                href="welcome.html">网站首页</a>】
        </td>
    </tr>
</table>
<br>
<table width="350" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="54" align="center"><span class="style1"><font size="7"><b><font face="华文彩云" size="6"
                                                                                    color="#666699">用户列表显示：</font></b></font></span>
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%" border="1" align="center" bordercolor="#660033" bgcolor="#99CCCC" cellspacing="1">
                <tr align="center">
                    <td width="25%">编号</td>
                    <td width="40%">用户名</td>
                    <td>用户密码</td>
                </tr>
                <%
                    List<User> userList = (List<User>) request.getAttribute("userList");
                    for (User user : userList) {
                %>
                <tr align="center">
                    <td width="25%"><a href="/userId.jsp?id=<%=user.getId()%>&username=<%=user.getUsername()%>&password=<%=user.getPassword()%>"><%=user.getId()%></a></td>
                    <td width="40%"><%=user.getUsername()%></td>
                    <td><%=user.getPassword()%></td>
                </tr>
                <% } %>
            </table>
        </td>
    </tr>
    <tr>
        <td align="right"><a href="listUsers.html">首页</a>||<a href="listUsers.html">上页</a>||<a
                href="listUsers.html">下页</a>||<a href="listUsers.html">末页</a></td>
    </tr>
    <tr>
        <td align="center" height="40"><span class="style2">权利保留！！！</span></td>
    </tr>
</table>
</body>
</html>


