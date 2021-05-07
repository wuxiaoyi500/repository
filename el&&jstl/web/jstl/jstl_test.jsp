<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.zyq.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl案例</title>
</head>
<body>
<%--
    练习：
        *需求：
            在request域中存有一个User对象的list集合
            需要用jstl和el将该集合展示到页面的table表格中
--%>
<%
    List list=new ArrayList();
    list.add(new User("张三",18,new Date()));
    list.add(new User("曾宇",19,new Date()));
    list.add(new User("陈玮",22,new Date()));
    list.add(new User("李四",25,new Date()));
    request.setAttribute("list",list);
%>
<table border="2" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <cc:forEach var="user" items="${list}" varStatus="vs">
        <cc:if test="${vs.count%2==0}">
            <tr bgcolor="#ffb6c1">
                <td>${vs.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </cc:if>
        <cc:if test="${vs.count%2!=0}">
            <tr bgcolor="green">
                <td>${vs.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </cc:if>

    </cc:forEach>
</table>
</body>
</html>
