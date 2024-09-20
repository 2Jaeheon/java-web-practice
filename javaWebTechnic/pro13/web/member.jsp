<%@ page import="sec01.ex01.MemberBean" %>
<%@ page import="sec01.ex01.MemberDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 17.
  Time: 오후 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<%
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    MemberBean m = new MemberBean(id, pwd, name, email);
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
    <%
        if (membersList.size() == 0) {
    %>
    <tr>
        <td colspan="5">
            <p align="cneter"><b><span type="font-size:pt;">등록된 회원이 없습니다.
            </span></b></p>
        </td>
    </tr>
    <%
    } else {
        for (int i = 0; i < membersList.size(); i++) {
            MemberBean bean = (MemberBean) membersList.get(i);
    %>
    <tr align="center">
        <td>
            <%= bean.getId() %>
        </td>
        <td>
            <%= bean.getPwd() %>
        </td>
        <td>
            <%= bean.getName() %>
        </td>
        <td>
            <%= bean.getEmail() %>
        </td>
        <td>
            <%= bean.getJoinDate() %>
        </td>
    </tr>
    <%
            }//for
        }//if
    %>
    <tr height="1" bgcolor="99ccff">
        <td colspan="5"></td>
    </tr>
</table>
</body>
</html>
