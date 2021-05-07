<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运算符</title>
</head>
<body>
<h1>empty运算符</h1>
<%
    String str = "fyp";
    request.setAttribute("name",str);
%>
${empty name}
</body>
</html>
