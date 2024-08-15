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
    session.setAttribute("address", "서울시 강북구");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
이름은 <%=name%>입니다.
<a href="session2.jsp">두 번째 페이지로 이동 </a>
</body>
</html>
