<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/22
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>修改用户</h1>
<form action="${pageContext.request.contextPath}/updateUser.do" method="post">
    <%--最重要的一点，必需有id 必需再加一个input --%>

    <input type="hidden" name="id" value="${user.id}" >
    用户名：<input type="text" name="userName" value="${user.name}"><br>
    密码:<input type="password" name="pwd" value="${user.pwd}"><br>

    <input type="submit" value="提交">
</form>
</body>
</html>
