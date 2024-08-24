<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오후 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="score" value="${param.score}"/>
<h1>시험 점수
    <c:out value="${score}"/>
</h1><br>
<c:choose>
    <c:when test="${score >= 0 && score <= 100}">
        <c:choose>
            <c:when test="${score>=90 && score <= 100}">
                <h1>A 학점입니다</h1>
            </c:when>
            <c:when test="${score >= 80 && score < 90}">
                <h1>B 학점입니다.</h1>
            </c:when>
            <c:when test="${score >= 70 && score < 80}">
                <h1>C 학점입니다.</h1>
            </c:when>
            <c:when test="${score >= 60 && score < 70}">
                <h1>D 학점입니다.</h1>
            </c:when>
            <c:otherwise>
                <h1>F 학점입니다.</h1>
            </c:otherwise>
        </c:choose>
    </c:when>

    <c:otherwise>
        <h1>점수를 잘못 입력하셨습니다. 다시 입력하세요</h1>
        <a href="scoreTest.jsp">점수 입력 창으로 이동</a>
    </c:otherwise>
</c:choose>
</body>
</html>
