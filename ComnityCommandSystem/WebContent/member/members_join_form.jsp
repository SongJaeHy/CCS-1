<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입 창</h1>
	<form action="member_login_form.jsp"method="post">
	아이디:<input type="text" name="mid" placeholder="Id" size="13" required>
	<input type="button" value="중복확인" onclick="openIdChk()"><br/>
	비밀번호:<input type="password" name="mpw" placeholder="Pw" min=6 maxlength=12><br/>
	비밀번호 확인:<input type="password" name="repw" placeholder="한번 더 입력해주세요"><br/>
	이름:<input type="text" name="mname" placeholder="이름"><br/>
	사원번호:<input type="text" name="mno" placeholder="사번" maxlength=8 required><br/>
	부서명:<input type="text" name="mdeptno" placeholder="부서명" maxlength=6><br/>
	핸드폰번호:<input type="tel" name="mphone" value="000-0000-0000" maxlength=13><br/>
	이메일:<input type="email" name="memail" placeholder="이메일"><br/>
	
	<input type="submit" value="가입">
	<a href="members_join_fail.jsp">회원가입 실패</a>
	
	</form>
</body>
</html>