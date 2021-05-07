<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<%--
    foreach:相当于java中的for循环语句
        1.完成重复操作
            属性：
                begin：开始值
                end：结束值
                var：临时遍历
                step：步长
                varStatus:
                    index:容器中元素索引，从0开始
                    count:表示循环次数
        2.遍历容器
            * 属性：
                items：容器对象
                var:表示容器中元素的临时变量

--%>
<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
${i}${s.index}${s.count}<br>
</c:forEach>
<%
    List list=new ArrayList();
    list.add("add");
    list.add("bbb");
    request.setAttribute("list",list);
%>
<c:forEach items="list" var="str" varStatus="s">
    ${s.index}${s.count}${str}<br>
</c:forEach>
</body>
</html>
