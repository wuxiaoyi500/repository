package cn.zyq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("/*")
public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo01执行了");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行了");
    }

    @Override
    public void destroy() {

    }
}
