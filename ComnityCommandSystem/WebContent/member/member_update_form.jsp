<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 정보 수정</h1>
	
	<form action="member_update_ok.jsp" method="post">
	<input type="text" name="mid" placeholder="아이디" readonly required><br/>
	<input type="password" name="mpw" placeholder="비밀번호"><br/>
	<input type="text" name="mdepart" placeholder="부서"required><br/>
	<input type="email" name="memail" placeholder="이메일"required><br/>
	<input type="tel" name="mphone" placeholder="전화번호" 
	value="000-0000-0000" maxlength="13"required><br/>
	<input type="submit" value="사원정보 수정하기">
	
	
	</form>
</body>
</html>