<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 22.
  Time: 오후 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>

<html>
<head>
    <meta charset="utf-8">
    <title>표현 언어에서 사용되는 데이터들</title>
</head>
<body>
<h1>표현 언어로 여러가지 데이터 출력하기</h1>
<h1>
    \${100}: ${100}<br>
    \${"안녕하세요"}: ${"안녕하세요"}<br>
    \${10+1}: ${10 + 1}<br>
    \${"10" + 1}: ${"10" + 1}<br>
    <%-- \${null+10}: ${null + 10}<br> --%>
</h1>
</body>
</html>
