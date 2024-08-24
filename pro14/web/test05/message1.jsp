<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 24.
  Time: 오후 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fmt:setLocale value="en_US"/>
<fmt:setLocale value="ko_KR"/>
<h1>
    회원정보 <br><br>
    <fmt:bundle basename="resource.member">
        이름:<fmt:message key="mem.name"/><br>
        주소:<fmt:message key="mem.address"/><br>
        직업:<fmt:message key="mem.job"/>
    </fmt:bundle>
</h1>
</body>
</html>
