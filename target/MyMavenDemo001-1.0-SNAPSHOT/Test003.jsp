<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/22
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
获取page的值<%=pageContext.getAttribute("pagekey")%><br>
获取request的值<%=request.getAttribute("requestkey")%><br>
获取session的值<%=session.getAttribute("sessionkey")%><br>
获取application的值<%=application.getAttribute("applicationkey")%><br>
</body>
</html>
