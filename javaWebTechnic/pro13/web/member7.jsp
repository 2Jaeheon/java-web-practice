<%@ page import="sec01.ex01.MemberDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="sec01.ex01.MemberBean" %><%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 17.
  Time: 오후 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
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
<table align="center" width="100%">
    <tr align="center" bgcolor="#99ccff">
        <td width="7%">아이디</td>
        <td width="7%">비밀번호</td>
        <td width="5%">이름</td>
        <td width="11%">이메일</td>
        <td width="5%">가입일</td>
    </tr>
    <tr align="center">
        <td>
            <jsp:getProperty name="m" property="id"/>
        </td>
        <td>
            <jsp:getProperty name="m" property="pwd"/>
        </td>
        <td>
            <jsp:getProperty name="m" property="pwd"/>
        </td>
        <td>
            <jsp:getProperty name="m" property="email"/>
        </td>
    </tr>
</table>
</body>
</html>
