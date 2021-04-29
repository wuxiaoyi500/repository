package zyq.loginProject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkcode_session =(String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if(checkcode_session!=null && checkcode_session.equalsIgnoreCase(checkCode)){
            //忽略大小写比较
            //验证码正确，则判断用户名和密码
            UserData userData = new UserData();
            userData.setUsername(username);
            userData.setPassword(password);
            UserData logindata = new UserSQLOperator().login(userData);

            if (logindata!=null){
                //登录成功
                //储存用户信息
                session.setAttribute("username",logindata.getUsername());
                response.sendRedirect("success.jsp");
            }else{
                request.setAttribute("user_password_error","用户名或密码错误");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else{
            //验证码错误，把错误信息存储到request
            request.setAttribute("checkCode_error","验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
