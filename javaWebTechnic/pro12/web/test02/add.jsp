<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 15.
  Time: 오후 5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         errorPage="addException.jsp" %>

<%
    int num = Integer.parseInt(request.getParameter("num"));
    int sum = 0;
    for (int i = 1; i <= num; i++) {
        sum += i;
    }
%>
<html>
<head>
    <title>합계 구하기</title>
</head>
<body>
<h2>합계 구하기</h2>
<h1>1부터 <%=num%>까지의 합은 <%=sum%>입니다!! </h1>
</body>
</html>
