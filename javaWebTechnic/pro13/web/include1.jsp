<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 17.
  Time: 오전 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
안녕하세요 쇼핑몰 중심 JSP 시작입니다.
<br>
<jsp:include page="duke_image.jsp" flush="true">
    <jsp:param name="name" value="듀크"/>
    <jsp:param name="imgName" value="duke.png"/>
</jsp:include>
<br>
안녕하세요 쇼핑몰 중심 JSP 끝 부분입니다.
</body>
</html>
