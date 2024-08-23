<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오후 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List dataList = new ArrayList();
    dataList.add("hello");
    dataList.add("world");
    dataList.add("안녕하세요!!");
%>
<c:set var="list" value="<%=dataList  %>"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
    i=  ${i}   &nbsp;&nbsp;&nbsp; 반복횟수: ${loop.count} <br>
</c:forEach>
<br>
<c:forEach var="i" begin="1" end="10" step="2">
    5 * ${i} = ${5*i}<br>
</c:forEach>
<br>
<c:forEach var="data" items="${list}">
    ${data } <br>
</c:forEach>
<br>
<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤"/>
<c:forTokens var="token" items="${fruits}" delims=",">
    ${token} <br>
</c:forTokens>
</body>
</html>
