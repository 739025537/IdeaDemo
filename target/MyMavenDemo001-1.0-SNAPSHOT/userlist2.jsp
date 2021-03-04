
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/15
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%--isELIgnored="false" 必需加这个，支持EL表达式，后面讲--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<head>
    <title>用户查询</title>
</head>
<body>


<%--不会这样写，不会这写，只是讲思路--%>



<form>

    <table width="80%" border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>密码</td>
            <td>操作</td>
        </tr>

        <c:forEach var="li" items="${list2}">
            <tr>
                <td>${li.id}</td>
                <td>${li.name}</td>
                <td>${li.pwd}</td>
                <td>

                    <a href="addUser.jsp">添加</a>
                        <%--
                        deleteUser.do
                        如果传一个值 deleteUser.do?sbqNum=1
                        如果传两个值  deleteUser.do?sbqNum=1&sbqStr=张三
                        如果传三个值 deleteUser.do?sbqNum=1&sbqStr=张三&sbqStr2=李四

                        --%>
                    <a href="${pageContext.request.contextPath}/deleteUser.do?id=${li.id}">删除</a>

<%--                    必需先通过id查询出数据--%>
                    <a href="${pageContext.request.contextPath}/findByUserId.do?id=${li.id}">修改</a>

                </td>
            </tr>
        </c:forEach>
    </table>

    <table>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <a href="${pageContext.request.contextPath}/userPageQuery.do?curPageNo=1">首页</a>--%>
<%--                <a href="${pageContext.request.contextPath}/userPageQuery.do?curPageNo=${sbqPage.curPageNo-1}">上一页</a>--%>
<%--                <a href="${pageContext.request.contextPath}/userPageQuery.do?curPageNo=${sbqPage.curPageNo+1}">下一页</a>--%>
<%--                <a href="${pageContext.request.contextPath}/userPageQuery.do?curPageNo=${sbqPage.totalPageCount}">末页</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
        总共&nbsp;${sbqPage.totalPageCount}&nbsp; 页  当前第&nbsp;${sbqPage.curPageNo}&nbsp;页  总共&nbsp;${sbqPage.totalCount}&nbsp;条数据
        <tr>
            <td>
                <c:if test="${sbqPage.curPageNo>1}" var="flag">
                    <a href="${pageContext.request.contextPath}/userPageQuery.do?curPageNo=1">首页</a>
                    <a href="${pageContext.request.contextPath}/userPageQuery.do?curPageNo=${sbqPage.curPageNo-1}">上一页</a>
                </c:if>

                <c:if test="${!flag}">
                    <a href="#">首页</a>
                    <a href="#">上一页</a>
                </c:if>
                <%--只有当前页小于 总页数--%>
                <c:if test="${sbqPage.curPageNo<sbqPage.totalPageCount}" var="all">
                    <a href="${pageContext.request.contextPath}/userPageQuery.do?curPageNo=${sbqPage.curPageNo+1}">下一页</a>
                    <a href="${pageContext.request.contextPath}/userPageQuery.do?curPageNo=${sbqPage.totalPageCount}">末页</a>
                </c:if>
                <c:if test="${!all}">
                    <a href="#">下一页</a>
                    <a href="#">末页</a>
                </c:if>

                <input type="number"  value="${sbqPage.curPageNo}" onclick="cccc(this.value);" size="5px" max="${sbqPage.totalPageCount}" min="1">
                <script>

                    function  cccc(sbq) {
                        // alert(sbq)
                        window.location.href="${pageContext.request.contextPath}/userPageQuery.do?curPageNo="+sbq;
                    }
                </script>
            </td>
        </tr>
    </table>

</form>

</body>
</html>
