<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오후 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty param.userID}">
    <c:if test="${param.userID == 'admin'}">
        <h1>관리자로 로그인했습니다.</h1>
        <form>
            <input type="button" value="회원정보 삭제하기">
            <input type="button" value="회원정보 수정하기">
        </form>
    </c:if>

    <c:if test="${param.userID != 'admin'}">
        <h1>환영합니다. <c:out value="${param.userID}"/> 님!! </h1>
    </c:if>
</c:if>
</body>
</html>
