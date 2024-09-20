<%@ page import="sec01.ex01.MemberBean" %><%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오전 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    MemberBean member = new MemberBean("lee", "1234", "이순신", "lee@test.com");
    request.setAttribute("member", member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>
