<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 24.
  Time: 오후 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*, sec02.ex01.*"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
    <jsp:useBean id="m" class="sec02.ex01.MemberBean"/>
    <jsp:setProperty name="m" property="*"/>

    <%
        MemberDAO memDAO = new MemberDAO();
        memDAO.addMember(m);
        List membersList = memDAO.listMembers();
        request.setAttribute("membersList", membersList);
    %>
</head>
<body>
<jsp:forward page="membersList.jsp"/>
</body>
</html>
