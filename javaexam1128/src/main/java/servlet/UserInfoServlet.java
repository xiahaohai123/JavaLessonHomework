package servlet;

import entity.UserInfo;
import service.UserInfoService;
import service.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @PackageName: servlet
 * @ClassName: UserInfoServlet
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/28 9:29
 */
@WebServlet(urlPatterns = "/userinfo/*")
public class UserInfoServlet extends HttpServlet {
    private UserInfoService userInfoService;

    @Override
    public void init() throws ServletException {
        super.init();
        userInfoService = new UserInfoServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的下级路径
        String pathInfo = req.getPathInfo();
        String methodName;
        // 防止没有下级路径
        if (pathInfo == null) {
            methodName = "";
        } else {
            methodName = pathInfo.substring(1);
        }
        try {
            Method declaredMethod = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            resp.setStatus(404);
            resp.sendError(404, "找不到方法");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");
        String email = request.getParameter("email");
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setEmail(email);
        if (userInfoService.register(userInfo)) {
            try {
                response.sendRedirect("/success.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.setContentType("text/html:charset=utf-8");
                response.getWriter().println("注册失败，请检查信息");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        if (userInfoService.login(userInfo)) {
            try {
                response.sendRedirect("/book.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("登录失败，请检查信息");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
