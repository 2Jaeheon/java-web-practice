<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 15.
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
%>
<%!
    String name = "이순신";

    public String getName() {
        return name;
    }
%>
<%
    String age = request.getParameter("age");
%>

<html>
<head>
    <title>타이틀</title>
</head>
<body>
<h1>안녕하세요 저는 <%=name %>입니다.</h1>
<h1>나이는 <%=age%>살 입니다</h1>
</body>
</html>
