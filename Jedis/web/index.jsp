<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2021/7/19
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>选择省份</title>
  <script src="WEB-INF/js/jquery-3.6.0.min.js"></script>
  <script>
    $(function () {
      $.get("provinceServlet",{},function (data) {
        var province = $("#province")
        $(data).each(function () {
          var option = "<option name = '" + this.id + "'>" + this.name + "</option>"
          province.append(option)
        })
      })
    })
  </script>
</head>
<body>
<select id="province">
  <option>--请选择省份--</option>
</select>
</body>
</html>
