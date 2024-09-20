<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 24.
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul calss="list_type">
    <li>
        <span style="margin-left:50px">이미지</span>
        <span>이미지 이름</span>
        <span>선택하기</span>
    </li>

    <c:forEach var="i" begin="1" end="9" step="1">
        <li>
            <a href="#" style="margin-left:50px">
                <img src="../imgage/duke.png" width="90" height="90" alt=""/>
            </a>
            <a href="#"><strong>이미지 이름: 듀크${i}</strong></a>
            <a href="#"><input name="chk${i}" type="checkbox"/></a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
