<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 28.
  Time: 오후 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>회원정보 출력</title>
</head>
<style>
  .cls1 {
    font-size: 40px;
    text-align: center;
  }

  .cls2 {
    font-size: 20px;
    text-align: center;
  }
</style>
<body>
<p class="cls1">회원정보</p>
<table align="center" border="1">
    <tr align="center" bgcolor="#add8e6">
        <td width="7%"><b>아이디</b></td>
        <td width="7%">비밀번호</td>
        <td width="7%">이름</td>
        <td width="7%">이메일</td>
        <td width="7%">생성일</td>
        <td width="7%">수정</td>
        <td width="7%">삭제</td>
    </tr>

    <c:choose>
        <c:when test="${empty membersList}">
            <tr>
                <td colspan=7>
                    <b>등록된 회원이 없습니다.</b>
                </td>
            </tr>
        </c:when>

        <c:when test="${not empty membersList}">
            <c:forEach var="mem" items="${membersList}">
                <tr align="center">
                    <td>${mem.id}</td>
                    <td>${mem.pwd}</td>
                    <td>${mem.name}</td>
                    <td>${mem.email}</td>
                    <td>${mem.joinDate}</td>
                    <td><a href="${contextPath}/customer/modifyMemberForm.do?id=${mem.id}">수정</a>
                    </td>
                    <td><a href="${contextPath}/customer/delMember.do?id=${mem.id}">삭제</a></td>
                </tr>
            </c:forEach>
        </c:when>
    </c:choose>

</table>
<a href="${contextPath}/customer/memberForm.do"><p class="cls2">회원가입하기</p></a>
</body>
</html>
