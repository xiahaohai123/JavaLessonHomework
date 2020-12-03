package top.summersea.controller;

import com.alibaba.fastjson.JSONArray;
import top.summersea.entity.UserInfo;
import top.summersea.service.UserInfoService;
import top.summersea.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "UserInfoServlet", urlPatterns = "/userInfo/*")
public class UserInfoServlet extends HttpServlet {
    private UserInfoService userInfoService;

    @Override
    public void init() throws ServletException {
        super.init();
        userInfoService = new UserInfoServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取方法路径
        String methodPath = request.getPathInfo();
        String methodName = methodPath.substring(1);
        try {
            // 找到对应方法
            Method declaredMethod = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, request, response);
        } catch (NoSuchMethodException e) {
            response.setStatus(404);
            response.sendError(404, "找不到对应方法");
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        UserInfo resUserInfo = userInfoService.login(userInfo);
        HttpSession session = request.getSession(true);
        // !=null短路后方判断防止NullPointerException
        if (resUserInfo != null && resUserInfo.getUserId() != null && !"".equals(resUserInfo.getUserId())) {
            // 使用session跟踪操作

            // 过期时间设置10分钟
            session.setMaxInactiveInterval(10 * 60);
            // 跟踪内容为username
            session.setAttribute("username", username);
            session.setAttribute("userId", resUserInfo.getUserId());
            response.getWriter().print(1);
//            response.sendRedirect("/welcome.html");
        } else {
            // 登录失败让session失效
            session.invalidate();
            response.getWriter().print(0);
        }
    }

    private void updatePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        String username = session.getAttribute("username").toString();
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUsername(username);
        userInfo.setPassword(oldPassword);

        if (userInfoService.updatePassword(userInfo, newPassword)) {
            response.getWriter().print(1);
        } else {
            response.getWriter().print(0);
        }

    }

    private void getUserInfoList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        List<Object> userInfoList;
        if (username != null && !"".equals(username)) {
            userInfoList = userInfoService.getUserInfoList("%" + username + "%");
        } else {
            userInfoList = userInfoService.getUserInfoList();
        }

        JSONArray jsonArray = new JSONArray(userInfoList);
        response.getWriter().print(jsonArray.toJSONString());
    }
}
