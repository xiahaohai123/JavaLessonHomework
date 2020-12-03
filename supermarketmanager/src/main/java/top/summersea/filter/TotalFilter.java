package top.summersea.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @PackageName: filter
 * @ClassName: TotalFilter
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/2 15:24
 */

@WebFilter(filterName = "TotalFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "encoding", value = "utf-8")
})
public class TotalFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=utf-8");
        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
//        chain.doFilter(request, response);
//
        // 主动略过登录页面
        // 样式资源放开
        // js资源放开
        String servletPath = httpServletRequest.getServletPath();
        if (servletPath.contains(".ico") || servletPath.contains(".css") || servletPath.contains(".js") || servletPath.contains(".jpg") || servletPath.contains(".png")) {
            chain.doFilter(request, response);
        } else if ("/login.html".equals(servletPath) || "//login.html".equals(servletPath) || "login.html".equals(servletPath) || "/login.jsp".equals(servletPath)) {
            chain.doFilter(request, response);
        } else if ("/userInfo".equals(servletPath) && "/login".equals(httpServletRequest.getPathInfo())) {
            // 放开登录
            chain.doFilter(request, response);
        } else {

            // session过滤
            HttpSession session = httpServletRequest.getSession();
            if (session == null || session.getAttribute("userId") == null) {
                ((HttpServletResponse) response).sendRedirect("/login.html");
            } else {
//                System.out.println(session);
//                System.out.println(session.getAttribute("userId"));
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
