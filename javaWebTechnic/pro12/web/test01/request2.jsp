<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 15.
  Time: 오후 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String) request.getAttribute("name");
    String address = (String) request.getAttribute("address");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>이름은 <%=name%> 입니다.</h1>
<h1>주소는 <%=address%> 입니다.</h1>
</body>
</html>