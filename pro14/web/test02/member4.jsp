<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    session.setAttribute("address", "수원시 팔달구");
%>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center">
    <tr align="center" bgcolor="#99ccff">
        <td width="7%"><b>아이디</b></td>
        <td width="7%"><b>비밀번호</b></td>
        <td width="5%"><b>이름</b></td>
        <td width="5%"><b>이메일</b></td>
        <td width="5%"><b>주소</b></td>
    </tr>
    <tr align="center">
        <td>${id}</td>
        <td>${pwd}</td>
        <td>${name}</td>
        <td>${email}</td>
        <td>${address}</td>
    </tr>
</table>
</body>
</html>
