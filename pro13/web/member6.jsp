<%@ page import="sec01.ex01.MemberDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 17.
  Time: 오후 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty name="m" property="*"/>
<%
    MemberDAO memberDAO = new MemberDAO();
    memberDAO.addMember(m);
    List membersList = memberDAO.listMembers();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
