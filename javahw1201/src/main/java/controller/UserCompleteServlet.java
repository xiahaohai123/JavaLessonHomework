package controller;

import entity.UserComplete;
import service.UserCompleteService;
import service.UserCompleteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "UserCompleteServlet", urlPatterns = "/userComplete/*")
public class UserCompleteServlet extends HttpServlet {
    private UserCompleteService userCompleteService;

    @Override
    public void init() throws ServletException {
        super.init();
        userCompleteService = new UserCompleteServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=utf-8");

        // 获取方法路径
        String methodPath = req.getPathInfo();
        String methodName = methodPath.substring(1);
        try {
            // 找到对应方法
            Method declaredMethod = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            resp.setStatus(404);
            resp.sendError(404, "找不到对应方法");
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void emailCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        response.getWriter().print(userCompleteService.isEmailExist(email) ? 1 : 0);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserComplete userComplete = new UserComplete();
        userComplete.setUsername(username);
        userComplete.setPassword(password);
        boolean login = userCompleteService.login(userComplete);
        response.getWriter().print(login ? 1 : 0);
    }
}
