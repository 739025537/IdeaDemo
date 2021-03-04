
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登陆</title>
</head>
<body>
<h1> 用户登陆</h1>
<!-- <%-- 很多同学忘记写  name="sbqUname"/ 这一个url一定是能访问了再复制过来，这个url都不能访问复制过来没用--%>-->
<form action="${pageContext.request.contextPath}/login.do" method="post">

    用户名：<input type="text"  name="sbqUname" /> <br />
    密码： <input type="password" name="pwd"  /> <br />
    兴趣爱好:<input type="checkbox" value="1"  name="likes"/> 钓鱼
    <input type="checkbox" value="2"  name="likes"/> 煮鱼
    <input type="checkbox" value="3"  name="likes"/> 吃鱼  <br />
    <input type="submit" value="提交" />

</form>
</body>
</html>
