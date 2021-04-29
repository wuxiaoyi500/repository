<%--
  Created by IntelliJ IDEA.
  User: ew
  Date: 2021/3/22
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <%
      System.out.println("hello jsp");
      int i = 1;
      String cp = request.getContextPath();
      out.print(cp);
    %>
    <h1>hi jsp</h1>
    <%!int i=3;%>
    <%= "handsome"%>
    <%response.getWriter().write("response*-*-*-*-*-*-*-*");%>
  </body>
</html>
