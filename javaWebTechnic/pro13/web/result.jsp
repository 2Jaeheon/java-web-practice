<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 17.
  Time: 오전 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userID = request.getParameter("userID");
    if (userID.length() == 0) {
        // 포워딩하지 않아도 됨
%>
<jsp:forward page="login.jsp"/>
<%
    }
%>
<h1>환영합니다 <%=userID%>님!!!</h1>
</body>
</html>
