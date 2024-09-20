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
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String msg = request.getParameter("msg");
    if (msg != null) {
%>
<h1><%=msg %>
</h1>
<%
    }
%>
<form action="result2.jsp" method="post">
    아이디: <input type="text" name="userID"><br>
    비밀번호: <input type="password" name="userPW"><br>
    <input type="submit" value="로그인">
    <input type="reset" value="다시입력">
</form>

</body>
</html>
