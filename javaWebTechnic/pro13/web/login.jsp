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
<h1>아이디를 입력하지 않았습니다. 아이디를 입력해주세요</h1>
<form action="result.jsp" method="post">
    아이디: <input type="text" name="userID"><br>
    비밀번호: <input type="password" name="userPW"><br>
    <input type="submit" value="로그인">
    <input type="reset" value="다시입력">
</form>
</body>
</html>
