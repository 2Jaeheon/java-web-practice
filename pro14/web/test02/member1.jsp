<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String id = (String) request.getAttribute("id");
    String pwd = (String) request.getAttribute("pwd");
    String name = (String) session.getAttribute("name");
    String email = (String) application.getAttribute("email");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <table border="1" align="center">
        <tr align="center" bgcolor="#99ccff">
            <td width="20%"><b>아이디</b></td>
            <td width="20%"><b>비밀번호</b></td>
            <td width="20%"><b>이름</b></td>
            <td width="20%"><b>이메일</b></td>
        </tr>
        <tr align="center">
            <td><%=id%>
            </td>
            <td><%=pwd%>
            </td>
            <td><%=name%>
            </td>
            <td><%=email%>
            </td>
        </tr>
        <tr align="center">
            <td>${id}</td>
            <td>${pwd}</td>
            <td>${name}</td>
            <td>${email}</td>
        </tr>
    </table>
</table>
</body>
</html>
