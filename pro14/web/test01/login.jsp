<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 22.
  Time: 오후 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="result.jsp">
    아이디: <input type="text" size="20"/><br>
    비밀번호: <input type="password" size="20"/><br>
    <input type="submit" value="로그인"/> <input type="reset" value="다시입력"/>
</form>
<br><br>
<a href="${pageContext.request.contextPath}/test01/memberForm.jsp">회원가입하기</a>
</body>
</html>
