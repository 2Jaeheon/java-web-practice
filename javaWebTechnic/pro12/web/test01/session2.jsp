<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 15.
  Time: 오후 4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String) session.getAttribute("name");
    String address = (String) session.getAttribute("address");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
이름은 <%=name%>입니다.
주소는 <%=address%>입니다.
</body>
</html>
