package cn.zyq.web.servlet;

import cn.zyq.domain.User;
import cn.zyq.service.UserService;
import cn.zyq.service.impl.UserServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
            //2.1获取用户填写的验证码
        String verifycode = request.getParameter("verifycode");
        //3.校验验证码
        HttpSession session = request.getSession();
        String checkCode = (String)session.getAttribute("checkCode");
        session.removeAttribute("checkCode");//把验证码从session中移除，确保验证码的一次性
        if (!checkCode.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误");
            //跳转登录界面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        Map<String, String[]> map = request.getParameterMap();
        //4.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //5.调用Service查询
        UserServiceImp service = new UserServiceImp();
        User loginUer = service.login(user);
        //6.判断是否登录成功
        if (loginUer != null){
            //登录成功
            //将用户存入session
            session.setAttribute("user",loginUer);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        if(loginUer == null){
            //登录失败
            request.setAttribute("login_msg","用户名或密码错误");
            //跳转登录界面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
