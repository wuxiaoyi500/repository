package cn.zyq.web.servlet;

import cn.zyq.domain.PageBean;
import cn.zyq.domain.User;
import cn.zyq.service.UserService;
import cn.zyq.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页查询的条数
        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "5";
        }
//        String rows = "5";
        // 2.调用service查询
        UserServiceImp service = new UserServiceImp();
        PageBean<User> pb = service.findUserByPage(currentPage, rows);
//        System.out.println(pb);
        //3.将pageBean存入request
        request.setAttribute("pb",pb);
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
