<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 22.
  Time: 오후 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
         isELIgnored="false"
         import="java.util.*"
%>
<jsp:useBean id="m1" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty name="m1" property="name" value="이순신"/>
<jsp:useBean id="m2" class="java.util.ArrayList" scope="page"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    \${empty m1 } : ${empty m1 } <br>
    \${not empty m1 } : ${not empty m1 } <br><br>

    \${empty m2 } : ${empty m2 } <br>
    \${not empty m2} : ${not empty m2 } <br><br>

    \${empty "hello"} : ${empty "hello" }<br>
    \${empty null} : ${empty null } <br>
    \${empty ""} : ${empty "" } <br>
</h1>
</body>
</html>
