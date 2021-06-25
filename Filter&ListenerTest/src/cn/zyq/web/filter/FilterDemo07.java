package cn.zyq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo07 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Demo07执行了");
        chain.doFilter(req, resp);
        System.out.println("Demo07回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
