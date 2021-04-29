<%--
  Created by IntelliJ IDEA.
  User: ew
  Date: 2021/3/24
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script>
        window.onclick=function () {
            var image=document.getElementById(`image`);
            image.onclick = function () {
                this.src="/CookieAndSession/checkCode?time="+new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>

<body>

    <form action="/CookieAndSession/loginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"> </td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"> </td>
            </tr>
            <tr>
                <td>验证码</td>
                <td ><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="image" src="/CookieAndSession/checkCode"> </td>
            </tr>
            <tr>

                <td colspan="2"><input type="submit" name="登录"> </td>
            </tr>
        </table>
    </form>
    <div>
        <%=request.getAttribute("user_password_error")==null ? "" : request.getAttribute("user_password_error")%>
        <%=request.getAttribute("checkCode_error")==null ? "" :request.getAttribute("checkCode_error")%>
    </div>
</body>
</html>
