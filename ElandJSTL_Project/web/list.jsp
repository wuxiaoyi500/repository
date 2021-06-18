<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function  deleteUser(id) {
            //给出安全提示
            if(confirm("您确定要删除吗"))
                location.href="${pageContext.request.contextPath}/deleteUserServlet?id="+id;
                /*$ {user.id}在这里不能获取，要在循环遍历中获取，所以采用传递参数的形式*/
        }
        window.onload = function () {
            // 给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {
                    //定义标记
                    var flag = false;
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0;i<cbs.length;i++){
                        if (cbs[i].checked){
                            flag = true;
                            break;
                        }
                    }
                    //判断是否有选中条目
                    if (flag){
                        //安全提示信息
                        if(confirm("您确定要删除选中条目吗")){
                            // 表单提交
                            document.getElementById("uidform").submit();
                        }
                    }else{
                        alert("未选中任何信息")
                    }


            }
            //全选功能
            document.getElementById("firstbox").onclick = function (){
                //获取下边列表中所有的cb
                var cbs = document.getElementsByName("uid");
                //遍历
                for (var i = 0;i<cbs.length;i++){
                //设置这些cbs[i]的状态 = firstbox
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left">
        <form class="form-inline">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" id="username" >
            </div>
            <div class="form-group">
                <label for="homeland">籍贯</label>
                <input type="text" class="form-control" id="homeland" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2" >
            </div>
            <button type="submit" class="btn btn-default">查询表单</button>
        </form>
    </div>
    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>
    <form id="uidform" action="${pageContext.request.contextPath}/delSelectedServlet">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstbox"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <cc:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a></td>
                </tr>
            </cc:forEach>

        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
<%--                向前翻页--%>
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != 1}">
                    <li>
                </c:if>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage - 1}&rows=5" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <!--页码标签选中状态-->
                    <c:if test="${pb.currentPage == i}">
                        <li class="active">
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li>
                    </c:if>
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5">
                                    ${i}
                            </a>
                        </li>
                </c:forEach>


                <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                </c:if>
                <c:if test="${pb.currentPage != pb.totalPage}">
                    <li>
                </c:if>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=5" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                <span style="font-size: 20px;margin-left: 15px">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
