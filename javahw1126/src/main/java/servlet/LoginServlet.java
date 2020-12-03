package servlet;

import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @PackageName: servlet
 * @ClassName: LoginServlet
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/26 18:42
 */
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);

        resp.setContentType("text/html;charset=utf-8");
        if (userService.login(user)) {
            resp.getWriter().println("<h1>登录成功</h1>");
        } else {
            resp.getWriter().println("<h1>登录失败</h1>");
        }

    }
}
