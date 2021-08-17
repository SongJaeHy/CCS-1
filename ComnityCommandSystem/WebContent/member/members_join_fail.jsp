<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입에 실패했습니다</h1>
	비밀번호를 다시 일치시켜주세요
	<a href="members_join_form.jsp">회원가입</a>
</body>
</html>