<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 17.
  Time: 오전 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<%!
    String message = "아이디를 입력하지 않았습니다. 아이디를 입력해주세요";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userID = request.getParameter("userID");
    if (userID.length() == 0) {
%>
<jsp:forward page="login2.jsp">
    <jsp:param name="msg" value="<%=message%>"/>
</jsp:forward>

<%
    }
%>
<h1>환영합니다. <%=userID%>님!</h1>
</body>
</html>
