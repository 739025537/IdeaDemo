<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/15
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>测试EL表达式和JStl</title>
</head>
<body>
<c:set var="age" value="18"></c:set>
<c:if test="${age>=18}">
    小王的年龄为：${age}<br>
    已经成年了
</c:if>
<c:if test="${age<18}">
    小王的年龄为：${age}<br>
    还未成年
</c:if>

需求：小王<br>
0-22   好好学习<br>
22-30 可以结婚生娃<br>
30-50  一边工作，一边浪<br>
50-70 安乐死<br>
70:   房产过期，睡大马路<br>
<c:set var="age" value="20"></c:set>
<c:choose>
    <c:when test="${age>=0 && age<22}">好好学习</c:when>
    <c:when test="${age>=22 && age<30}">可以结婚生娃</c:when>
    <c:when test="${age>=30 && age<50}">一边工作，一边浪</c:when>
    <c:when test="${age>=50 && age<70}">安乐死</c:when>
    <c:otherwise>房产过期，睡大马路</c:otherwise>
</c:choose>
<br>
</body>
</html>
