<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 24.
  Time: 오후 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>fmt number태그를 이용한 숫자 포매팅 예제.</h2>
<c:set var="price" value="100000000"/>
<fmt:formatNumber value="${price}" type="number" var="priceNumber"/>
통화로 표현 시:
<fmt:formatNumber type="currency" currencySymbol="원" value="${price}" groupingUsed="true"/><br>

퍼센트로 표현 시:
<fmt:formatNumber value="${price}" type="percent" groupingUsed="false"/><br>

일반 숫자로 표현 시: ${priceNumber}<br>
<h2>formatDate 예제</h2>
<c:set var="now" value="<%=new Date()%>"/>
<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
<fmt:formatDate value="${now}" type="time"/><br>
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
<fmt:formatDate value="${now}" pattern="YYYY-MM-dd :hh:mm:ss"/><br>

<br><br>
한국 현재 시간:
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br><br>
<fmt:timeZone value="America/New York">
    뉴욕 현재 시간:
    <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
</fmt:timeZone>

</body>
</html>
