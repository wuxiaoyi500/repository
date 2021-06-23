package cn.zyq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//浏览器直接请求index.jsp资源时，过滤器会被执行，转发则不会
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//转发访问才被执行，直接访问过滤器不被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)
//转发和直接访问都拦截
//@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo05 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilterDemo05");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
