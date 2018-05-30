<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>판매자 회원 가입</h1>
		<form action="/Fruit/register.MProc" method="POST">
			<input type="hidden" name="regi_path" id="regi_path" value="seller">
			<span>
				<label for="regi_id">아이디</label><br>
				<input type="text" name="regi_id" id="regi_id"><br>
			</span>
			<span>
				<label for="regi_pw">비밀번호</label><br>
				<input type="password" name="regi_pw" id="regi_pw"><br>
			</span>
			<input type="submit" value="가입" name="">
		</form>
	</body>
</html>