<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 15.
  Time: 오후 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setAttribute("name", "이순신");
    request.setAttribute("address", "서울시 강북구");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    RequestDispatcher dispatcher = request.getRequestDispatcher("request2.jsp");
    dispatcher.forward(request, response);
%>
</body>
</html>
