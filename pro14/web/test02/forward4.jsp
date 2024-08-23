<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오후 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    request.setAttribute("id", "hong");
    request.setAttribute("pwd", "1234");
    session.setAttribute("name", "홍길동");
    application.setAttribute("email", "hong@test.com");
    //request.setAttribute("address", "서울시 강남구");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="member4.jsp"/>
</body>
</html>
