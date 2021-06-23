package cn.zyq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp")  //具体资源路径拦截
//@WebFilter("/user/*") //目录拦截
//@WebFilter("*.jsp") //后缀名拦截
public class FilterDemo04 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo04...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
