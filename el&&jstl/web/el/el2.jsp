<%--
  Created by IntelliJ IDEA.
  User: ew
  Date: 2021/3/31
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%request.setAttribute("name","张三");%>
    <%session.setAttribute("age",18);%>
    <h1>获取值</h1>
    ${requestScope.name}
    ${sessionScope.age}
<%--    el如果没有获取到值，会显示空字符串，不会显示null--%>
    ${pageContext.page}
</body>
</html>
