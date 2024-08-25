<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 25.
  Time: 오전 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="result.jsp">
    <input type="hidden" name="param1" value="Duke.png"/><br>
    <input type="hidden" name="param2" value="Duke2.png"/><br>
    <input type="submit" value="이미지 다운로드">
</form>
</body>
</html>
