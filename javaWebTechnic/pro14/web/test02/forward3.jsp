<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 23.
  Time: 오전 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*, sec01.ex01.*"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<%
    request.setCharacterEncoding("utf-8");
    List membersList = new ArrayList();
    MemberBean m1 = new MemberBean("lee", "1234", "이순신", "lee@test.com");
    MemberBean m2 = new MemberBean("hong", "1234", "손흥민", "son@test.com");
    membersList.add(m1);
    membersList.add(m2);
    request.setAttribute("membersList", membersList);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="member3.jsp"/>
</body>
</html>
