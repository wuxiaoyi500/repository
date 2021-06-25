package cn.zyq.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ContextLoaderListner implements ServletContextListener {
    /*
     * 监听ServletContext对象创建的
     * ServletContext对象服务器启动后自动创建
     *
     * 在服务器启动后自动调用
     * */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载资源文件步骤
        //1.获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();
        //2.加载资源文件
        String parameter = servletContext.getInitParameter("contextConfigLocation");
        //3.获取真实路径
        String realPath = servletContext.getRealPath(parameter);
        //4.加载进内存
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("ServletContext对象被创建了");
    }
    /*
    * 在服务器关闭后，ServletContext对象被销毁
    * 当服务器正常关闭后自动调用
    * */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁");
    }
}
