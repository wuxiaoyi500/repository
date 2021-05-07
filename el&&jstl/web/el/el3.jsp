<%@ page import="cn.zyq.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());
        request.setAttribute("u",user);

    %>
<h1>获取域对象中的值</h1>
${requestScope.u}<br>
<%--    § 通过对象的属性来获取
        setter或getter方法，去掉set或get，再将剩余部分变小写
        setName --> Name --> name--%>
${requestScope.u.name}<br>
    ${requestScope.u.age}<br>
    ${requestScope.u.birthday}<br>
    ${requestScope.u.birthday.year}<br>
    ${requestScope.u.birthday.month}<br>
    ${requestScope.u.birStr}<br>


<%
    List list =new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list",list);
%>
<h1>获取List集合</h1>
${requestScope.list}<br>
    ${requestScope.list[0]}<br>
    ${requestScope.list[1]}<br>
    ${requestScope.list[99]}<br>
    ${requestScope.list[2]}<br>
    ${requestScope.list[2].birStr}<br>

<h1>获取map集合</h1>
<%
    Map map = new HashMap();
    map.put("s","b");
    map.put("name","fyp");
    request.setAttribute("map",map);
%>
${requestScope.map.s}
    ${requestScope.map.name}<br>
<%--另外一种写法--%>
    ${requestScope.map["name"]}
    ${requestScope.map["s"]}

</body>
</html>
