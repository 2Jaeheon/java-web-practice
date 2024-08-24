<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오후 9:43
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
<c:if test="${empty param.userID}">
    아이디를 입력하세요<br>
    <a href="login.jsp">로그인창</a>
</c:if>
<c:if test="${not empty param.userID}">
    <h1>환영합니다. <c:out value="${param.userID}"/>님!!!</h1>
</c:if>
</body>
</html>
