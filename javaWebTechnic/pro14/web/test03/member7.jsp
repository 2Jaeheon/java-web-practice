<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="sec01.ex01.MemberBean" %><%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오후 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
    List membersList = new ArrayList();
    MemberBean m1 = new MemberBean("son", "1234", "손흥민", "son@test.com");
    MemberBean m2 = new MemberBean("ki", "4321", "기성용", "ki@test.com");
    MemberBean m3 = new MemberBean("park", "1212", "박지성", "park@test.com");
    membersList.add(m1);
    membersList.add(m2);
    membersList.add(m3);
%>
<c:set var="membersList" value="<%= membersList%>"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center">
    <tr align="center" bgcolor="lightgreen">
        <td width="7%"><b>아이디</b></td>
        <td width="7%"><b>비밀번호</b></td>
        <td width="5%"><b>이름</b></td>
        <td width="5%"><b>이메일</b></td>
    </tr>
    <c:forEach var="i" begin="0" end="2" step="1">
        <tr align="center">
            <td>${membersList[i].id}</td>
            <td>${membersList[i].pwd}</td>
            <td>${membersList[i].name}</td>
            <td>${membersList[i].email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
