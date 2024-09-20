<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오전 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    request.setAttribute("id", "hong");
    request.setAttribute("pwd", "1234");
    session.setAttribute("name", "홍길동");
    application.setAttribute("email", "hong@test.com");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="member1.jsp"/>
</body>
</html>
