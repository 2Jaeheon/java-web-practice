<%--
  Created by IntelliJ IDEA.
  User: jaeheon
  Date: 24. 8. 17.
  Time: 오후 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입창</title>
</head>
<body>
<form method="post" action="member7.jsp">
    <h1 style="text-align:center">회원가입창</h1>
    <table align="center">
        <tr>
            <td width="200">
                <p align="right">아이디</p>
            </td>
            <td width="400"><input type="text" name="id"></td>
        </tr>
        <tr>
            <td width="200">
                <p align="right">비밀번호</p>
            </td>
            <td width="400"><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td width="200">
                <p align="right">이름</p>
            </td>
            <td width="400">
                <p><input type="text" name="name"></p>
            </td>
        </tr>
        <tr>
            <td width="200">
                <p align="right">이메일</p>
            </td>
            <td width="400">
                <p><input type="text" name="email"></p>
            </td>
        </tr>
        <tr>
            <td width="200">
                <p>&nbsp</p>
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
