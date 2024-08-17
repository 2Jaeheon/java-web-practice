<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 17.
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty name="m" property="id" value="<%=request.getParameter("id")%>"/>
<jsp:setProperty name="m" property="pwd" value="<%=request.getParameter("pwd")%>"/>
<jsp:setProperty name="m" property="name" value="<%=request.getParameter("name")%>"/>
<jsp:setProperty name="m" property="email" value="<%=request.getParameter("email")%>"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
