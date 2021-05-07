<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="haha" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>
<%--
    完成数字编号对应星期几案例
        1.域中存储一数字
        2.使用choose取出数字，相当于switch声明
        3.使用when标签做数字判断，相当于case
        4.otherwise标签做其他情况的声明，相当于default
--%>

<%
    Random random = new Random();
    int i = random.nextInt();
    request.setAttribute("number",i);
%>
<haha:choose>
    <haha:when test="${requestScope.number%7==0}">星期一</haha:when>
    <haha:when test="${requestScope.number%7==1}">星期二</haha:when>
    <haha:when test="${requestScope.number%7==2}">星期三</haha:when>
    <haha:when test="${requestScope.number%7==3}">星期四</haha:when>
    <haha:when test="${requestScope.number%7==4}">星期五</haha:when>
    <haha:when test="${requestScope.number%7==5}">星期六</haha:when>
    <haha:when test="${requestScope.number%7==6}">星期七</haha:when>
    <haha:otherwise>没有日期，世界毁灭</haha:otherwise>
</haha:choose>
</body>
</html>
