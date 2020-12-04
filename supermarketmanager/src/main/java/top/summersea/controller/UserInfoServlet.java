package top.summersea.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import top.summersea.entity.UserInfo;
import top.summersea.service.UserInfoService;
import top.summersea.service.impl.UserInfoServiceImpl;
import top.summersea.util.JSONUtil;
import top.summersea.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

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

    private void isUserIdExistent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String userId = request.getParameter("userId");
        JSONObject jsonObject = JSONUtil.createSuccessJSONObject();
        jsonObject.put("isExistent", userInfoService.isUserIdExist(userId) ? 1 : 0);

        response.getWriter().print(jsonObject.toJSONString());
    }

    private void registerUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String userId = request.getParameter("userId");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String userPhone = request.getParameter("userPhone");
        String userAddress = request.getParameter("userAddress");
        String userType = request.getParameter("userType");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setSex(sex);
        userInfo.setUserTel(userPhone);
        userInfo.setUserAddress(userAddress);
        try {
            userInfo.setBornDate(TimeUtil.dateStringToDate(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean b = userInfoService.registerUserInfo(userInfo, userType);

        JSONObject jsonObject = JSONUtil.createSuccessJSONObject();
        jsonObject.put("insertState", b);
        response.getWriter().print(jsonObject.toJSONString());

    }

    /**
     * 用户退出
     * 干掉session
     *
     * @param request  req
     * @param response resp
     */
    private void exist(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
    }

    /**
     * 根据userId获取userInfo
     *
     * @param request
     * @param response
     */
    private void getUserInfoById(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userId = request.getParameter("userId");
        Map<String, Object> resMap = userInfoService.getUserInfoByUserId(userId);
        request.setAttribute("data", resMap);

        request.getRequestDispatcher("/userView.jsp").forward(request, response);
    }

    private void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String userId = request.getParameter("userId");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String bornDate = request.getParameter("bornDate");
        String userTel = request.getParameter("userTel");
        String userAddress = request.getParameter("userAddress");
        String userType = request.getParameter("userType");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUsername(username);
        userInfo.setSex(sex);
        userInfo.setUserTel(userTel);
        userInfo.setUserAddress(userAddress);
        try {
            userInfo.setBornDate(TimeUtil.dateStringToDate(bornDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean b = userInfoService.updateUserInfo(userInfo, userType);


        JSONObject jsonObject = JSONUtil.createSuccessJSONObject();
        jsonObject.put("updateState", b);
        response.getWriter().print(jsonObject.toJSONString());
    }

    private void deleteUserInfoById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String userId = request.getParameter("userId");

        boolean b = userInfoService.deleteUserInfoByUserId(userId);
        JSONObject jsonObject = JSONUtil.createSuccessJSONObject();
        jsonObject.put("deleteState", b);
        response.getWriter().print(jsonObject.toJSONString());
    }
}
