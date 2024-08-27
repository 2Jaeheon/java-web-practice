<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 27.
  Time: 오후 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${contextPath}/member/addMember.do">
    <h1 style="text-align:center">회원 가입창</h1>
    <table align="center">
        <tr>
            <td width="200"><p align="right">아이디</p></td>
            <td width="400"><input type="text" name="id"></td>
        </tr>

        <tr>
            <td width="200"><p align="right">비밀번호</p></td>
            <td width="400"><input type="password" name="pwd"></td>
        </tr>

        <tr>
            <td width="200"><p align="right">이름</p></td>
            <td widht="200"><input type="text" name="name"></td>
        </tr>

        <tr>
            <td width="400"><p align="right">이메일</p></td>
            <td widht="400"><input type="text" name="email"></td>
        </tr>

        <tr>
            <td width="200">
                <p>&nbsp;</p>
            </td>
            <td width="400">
                <input type="submit" value="가입하기">
                <input type="reset" value="다시입력">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
