<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="/Fruit/login.MProc" method="POST">
			<span>
				<label for="rog_id">아이디</label><br>
				<input type="text" name="rog_id" id="rog_id"><br>
			</span>
			<span>
				<label for="rog_pw">비밀번호</label><br>
				<input type="text" name="rog_pw" id="rog_pw"><br>
			</span>
			<input type="submit" name="" value="로그인">
			<input type="button" name="" value="회원가입" onclick="location.href='/Fruit/member/regiSelect.jsp'">
		</form>
	</body>
</html>