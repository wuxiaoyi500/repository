package zyq.cookieProject;

import cn.zyq.timeUtiles.timeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*   			§ 2.在服务器中的Servlet判断，是否有一个名为lasttime的cookie
				□ 1.有：不是初次访问
					® 1.响应数据
						◊ 欢迎回来，您上次的访问时间为：显示字符串
						◊ 写回cookie，更新时间
				□ 2.没有：是初次访问
					® 1.响应数据：
						◊ 您好，欢迎首次访问
					® 2.写回cookie：lastTime=2021年3月22日22:50:04
* */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //由于响应消息为中文数据，因此需要设置编码格式
        resp.setContentType("text/html;charset=utf-8");
        //1.获取所有的cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length>0){
            //2.遍历cookie数组
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                if (name.equals("LastTime")){
                    //LastTime存在，代表并非初次访问
                    //响应数据
                    String value = cookie.getValue();
                    resp.getWriter().write("<h1>您好，欢迎继续访问，您上次的访问时间为："+value+"</h1>");
                    //写入cookie
                    String time = timeUtil.getTime();
                    cookie.setValue(time);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
//                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    break;
                }
            }
        }else if (cookies == null || cookies.length==0){
            //说明是初次访问
            resp.getWriter().write("<h1>欢迎新用户，点击登录可领取价值888元新手大礼包！！</h1>");
            String time = timeUtil.getTime();
            Cookie cookie = new Cookie("Last",time);
            cookie.setMaxAge(60 * 60 * 24 * 30);
//            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
