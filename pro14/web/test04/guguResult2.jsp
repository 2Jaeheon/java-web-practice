<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 24.
  Time: 오전 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="dan" value="${param.dan}"/>
<table border="1" align="center" width="800">
    <tr align="center" bgcolor="lightgreen">
        <td colspan="2">
            <c:out value="${dan}"/> 단 출력
        </td>

        <c:forEach var="i" begin="1" end="9" step="1">
        <c:if test="${i % 2 == 0}">
    <tr align="center" bgcolor="#CCFF66">
        </c:if>
        <c:if test="${i % 2 != 0}">
    <tr align="center" bgcolor="#CCCCFF">
        </c:if>

        <td width="400">
            <c:out value="${dan}"/> * <c:out value="${i}"/>
        </td>
        <td width="400">
            <c:out value="${i * dan}"/>
        </td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
