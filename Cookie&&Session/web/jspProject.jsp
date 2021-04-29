<%@ page import="cn.zyq.timeUtiles.timeUtil" %><%--
  Created by IntelliJ IDEA.
  User: ew
  Date: 2021/3/23
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示登陆时间</title>
</head>
<body>
<%
    //由于响应消息为中文数据，因此需要设置编码格式
    response.setContentType("text/html;charset=utf-8");
    //1.获取所有的cookie
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length>0){
        //2.遍历cookie数组
        for (Cookie cookie : cookies){
            String name = cookie.getName();
            if (name.equals("LastTime")){
                //LastTime存在，代表并非初次访问
                //响应数据
                String value = cookie.getValue();
                %>
                <h1>您好，欢迎继续访问，您上次的访问时间为：<%=value%></h1>
<%
                //写入cookie
                String time = timeUtil.getTime();
                cookie.setValue(time);
                cookie.setMaxAge(60 * 60 * 24 * 30);
//                    cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
    }else if (cookies == null || cookies.length==0){
        //说明是初次访问

        String time = timeUtil.getTime();
        Cookie cookie = new Cookie("Last",time);
        cookie.setMaxAge(60 * 60 * 24 * 30);
//            cookie.setMaxAge(0);
        response.addCookie(cookie);
        %>
        <h1>欢迎新用户，点击登录可领取价值888元新手大礼包！！</h1>
<%    }
        %>
</body>
</html>
