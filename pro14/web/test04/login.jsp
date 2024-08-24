<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오후 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form action="result2.jsp" method="post">
    아이디: <input type="text" name="userID"><br>
    비밀번호: <input type="password" name="userPw"><br>
    <input type="submit" value="로그인">
    <input type="reset" value="다시입력">
</form>
</body>
</html>
