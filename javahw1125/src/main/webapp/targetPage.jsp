<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  entity.User: xiaha
  Date: 2020/11/25
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%
    // 判断进入该页面是否有cookie
    boolean nameFlag = false;
    boolean pwdFlag = false;
    for (Cookie cookie : request.getCookies()) {
        if ("name".equals(cookie.getName())) {
            nameFlag = true;
        } else if ("pwd".equals(cookie.getName())) {
            pwdFlag = true;
        }
    }

    if (!nameFlag || !pwdFlag) {
        String name = URLEncoder.encode(request.getParameter("name"), "UTF-8");
        String pwd = URLEncoder.encode(request.getParameter("pwd"), "UTF-8");
        Cookie cookie = new Cookie("name", name);
        Cookie pwdCookie = new Cookie("pwd", pwd);

        cookie.setMaxAge(60);
        pwdCookie.setMaxAge(60);

        response.addCookie(cookie);
        response.addCookie(pwdCookie);
    }

%>

<html>
<head>
    <title>Here is target page</title>
</head>
<body>
<h2>Here is target page</h2>
<h3>cookie</h3>

<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie1 : cookies) {
            out.println(cookie1.getName() + " : " + URLDecoder.decode(cookie1.getValue(), "UTF-8"));
            out.print("<br />");
        }
    } else {
        out.print("无cookie");
    }
%>

<%
    // 计数器 使用ServletContext类的实例
    Object counterObject = application.getAttribute("counter");
    if (counterObject == null) {
        application.setAttribute("counter", "1");
        counterObject = "1";
    } else {
        counterObject = String.valueOf(Integer.valueOf(counterObject.toString()) + 1);
        application.setAttribute("counter", counterObject.toString());
    }
    out.print("您是第" + counterObject + "个访问该网页的用户");
%>
</body>
</html>
