<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>隐式对象</title>
</head>
<body>
<h1>获取其他对象</h1>
${pageContext.request}
<h1>获取虚拟目录</h1>
${pageContext.request.contextPath}
</body>
</html>
