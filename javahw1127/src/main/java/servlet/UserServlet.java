package servlet;

import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: servlet.UserServlet
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/27 10:24
 */
@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        // 获取方法路径
        String methodPath = req.getPathInfo();
        String methodName = methodPath.substring(1);
        try {
            // 找到对应方法
            Method declaredMethod = UserServlet.class.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            resp.setStatus(404);
            resp.sendError(404, "找不到对应方法");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("userName");
        String password = request.getParameter("userPass");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userService.login(user)) {
            try {
//                request.setCharacterEncoding("utf-8");
                // 转发问题
                // 需要改页面编码为GB2312
                // 图片会因为路径问题加载不出来
//                request.getRequestDispatcher("/welcome.html").forward(request, response);
                response.sendRedirect("/welcome.html");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().println("登录失败，请重试");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("textfield");
        String password = request.getParameter("textfield2");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userService.register(user)) {
            try {
                response.sendRedirect("/index.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().println("注册失败，请重试");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = userService.listAllUser();
        request.setAttribute("userList", list);

        try {
            // 转发使用绝对路径
            request.getRequestDispatcher("/listUser.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新或删除
     *
     * @param request
     * @param response
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestType = request.getParameter("Submit");
        Integer id = Integer.valueOf(request.getParameter("id"));
        if ("修改".equals(requestType)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);

            if (!userService.updateUserInfo(user)) {
                response.getWriter().println("<h1>更新失败，请检查信息</h1>");
            } else {
                // 重定向到list界面
                response.sendRedirect("/user/listUser");
            }
        } else {
            if (!userService.deleteUser(id)) {
                response.getWriter().println("<h1>删除失败，请检查id</h1>");
            } else {
                // 重定向到list界面
                response.sendRedirect("/user/listUser");
            }
        }


    }
}
