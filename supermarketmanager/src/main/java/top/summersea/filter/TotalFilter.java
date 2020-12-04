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

        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);

//        System.out.println("RequestURI:" + httpServletRequest.getRequestURI());
//        System.out.println("RequestURL:" + httpServletRequest.getRequestURL());
//        System.out.println("PathInfo:" + httpServletRequest.getPathInfo());
//        System.out.println("ServletPath:" + httpServletRequest.getServletPath());
//        System.out.println("ContextPath:" + httpServletRequest.getContextPath());
        System.out.println();

        String requestURI = httpServletRequest.getRequestURI();
        // 样式资源放开
        // js资源放开
        if (isIgnore(requestURI)) {
            chain.doFilter(request, response);
            return;
        }

//        chain.doFilter(request, response);
//        return;
//
        // 设置浏览器解析字符编码
        // 不能在上方代码设置，css，js，图片等有自己的ContentType
        //
        response.setContentType("text/html;charset=utf-8");
        // 主动略过不需要Session的页面
        if (isVisitIgnoreSession(requestURI)) {
            chain.doFilter(request, response);
        } else {
            // session过滤
            HttpSession session = httpServletRequest.getSession();
            if (session == null || session.getAttribute("userId") == null) {
                ((HttpServletResponse) response).sendRedirect("/login.jsp");
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

    private boolean isIgnore(String uri) {
        return uri.indexOf("/webjars") == 0
                || uri.indexOf("/css") == 0
                || uri.indexOf("/js") == 0
                || uri.indexOf("/img") == 0
                || uri.indexOf("/favicon.ico") == 0;
    }

    private boolean isVisitIgnoreSession(String uri) {
        return uri.equals("/") || uri.equals("/userInfo/login") || uri.equals("/login.jsp") || uri.equals("/login.html");
    }
}
