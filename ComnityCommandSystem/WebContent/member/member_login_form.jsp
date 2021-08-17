<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인 창입니다.</h1>
	<form action="#" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mid" placeholder="Id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mpw" maxlength=12 placeholder="Pw"></td>
		</tr>
		<tr>
			<td>
			<input type="submit" value="로그인">
			<a href="members_join_form.jsp">
			<input type="button" value="회원가입"></a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>