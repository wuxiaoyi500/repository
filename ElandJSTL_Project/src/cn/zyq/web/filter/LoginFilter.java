package cn.zyq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//登录验证的过滤器
//@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含相关登录资源,要注意排除CSS/JS/图片/验证码等
        if(uri.contains("login.jsp") || uri.contains("loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet/")){
            //用户想登录，放行
            chain.doFilter(req, resp);
        }else{
            //不包含，验证是否已经登录
            Object user = request.getSession().getAttribute("user");
            if (user!=null){
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("login_msg","您未登录，请登录");
                request.getRequestDispatcher("login.jsp").forward(request,resp);
            }
        }
//        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
