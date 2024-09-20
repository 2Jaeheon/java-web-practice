<%@ page import="sec02.ex01.MemberVO" %>
<%@ page import="sec02.ex01.MemberDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
Created by IntelliJ IDEA.
User: jaeheon
Date: 24. 8. 16.
Time: 오후 2:30
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
  h1 {
    text-align: center;
  }
</style>
<head>
    <title>회원정보 조회</title>
</head>
<body>
<h1>회원 정보 출력</h1>
<%
    request.setCharacterEncoding("utf-8");
    String _name = request.getParameter("name");
    MemberVO memberVO = new MemberVO();
    memberVO.setName(_name);
    MemberDAO dao = new MemberDAO();
    List membersList = dao.listMembers(memberVO);
%>
<table border=1 width=800 align=center>
    <tr align="center" bgcolor="#FFFF66">
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이름</td>
        <td>이메일</td>
        <td>가입일자</td>
    </tr>

    <%
        for (int i = 0; i < membersList.size(); i++) {
            MemberVO vo = (MemberVO) membersList.get(i);
            String id = vo.getId();
            String pwd = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();
            Date joinDate = vo.getJoinDate();

    %>

    <tr align="center">
        <td><%= id %>
        </td>
        <td><%= pwd %>
        </td>
        <td><%= name %>
        </td>
        <td><%= email %>
        </td>
        <td><%= joinDate %>
        </td>
    </tr>

    <%
        }
    %>
</table>
</body>
</html>
