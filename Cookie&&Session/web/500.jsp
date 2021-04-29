<%--
  Created by IntelliJ IDEA.
  User: ew
  Date: 2021/3/30
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙...<h1>
        <%
            String message = exception.getMessage();
            out.print(message);
        %>
</body>
</html>
