<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="hehe" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--
    hehe:if标签：
        1.属性：
            * test为必须属性，用来接收Boolean表达式
                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
                * 一般情况下test属性会结合EL表达式一起使用
        2.没有else：
            * 想要else可以再定义一个
--%>
<hehe:if test="true">我是真</hehe:if>
<%--示例--%>
<%
    List list = new ArrayList();
    list.add("aaa");
    request.setAttribute("list",list);
%>
<hehe:if test="${not empty requestScope.list}">
    <h1>呵呵呵呵呵</h1>
</hehe:if>
</body>
</html>
