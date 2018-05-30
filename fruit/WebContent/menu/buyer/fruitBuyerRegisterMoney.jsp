<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="/Fruit/regiMoney.FProc" method="POST">
			<span>
				<label for="">Money : </label>
				<input type="text" name="regi_money" id="regi_money">
			</span>
			<input type="submit" value="register">
		</form>
		<a href="#" onclick="history.back(-1)">Go back</a>
	</body>
</html>