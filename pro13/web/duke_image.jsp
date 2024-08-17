<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 17.
  Time: 오전 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String imgName = request.getParameter("imgName");
%>
<html>
<head>
    <title>듀크 이미지</title>
</head>
<body>
<br><br>
<h1>이름은 <%=name%> 입니다</h1>
<img src="./image/<%=imgName%>"/>
</body>
</html>
