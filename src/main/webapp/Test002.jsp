<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/21
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP内置对象</title>
</head>
<body>
<%
    /*这些没有new对象就可以使用的，称之为jsp内置对象  9大内置对象*/
    out.print("1111");/*输出*/
    /*request  代表请求对象*/

        /*PrintWriter out= resp.getWriter();
        out.println("把结果响映给浏览器");*/
    /*response 代表是响应对象 */
    /*  application  全局servlet上下文对象*/
    /* page  代表 当前jsp*/
    /* pageContext jsp上下文*/
    /* session 代表一次会话*/

%>

通过page存值<% pageContext.setAttribute("pagekey","page的值");%><br>
通过request存值<% request.setAttribute("requestkey","request的值");%><br>
通过session存值<% session.setAttribute("sessionkey","session的值");%><br>
通过application存值<% application.setAttribute("applicationkey","application的值");%><br>

获取page的值<%=pageContext.getAttribute("pagekey")%><br>
获取request的值<%=request.getAttribute("requestkey")%><br>
获取session的值<%=session.getAttribute("sessionkey")%><br>
获取application的值<%=application.getAttribute("applicationkey")%><br>
</body>
</html>
