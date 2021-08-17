<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원 탈퇴를 진행합니다.</h2>
	<form action="member_delete_ok.jsp" method="post">
	비밀번호를 한 번 더 입력하세요.<br/>
	삭제 진행 후에는 되돌릴 수 없으니 주의하세요.<br/>
		<input type="password" name="mpw" placeholder="삭제할 사원 비밀번호"><br/>
		<input type="submit" value="제출">
	
	</form>
</body>
</html>