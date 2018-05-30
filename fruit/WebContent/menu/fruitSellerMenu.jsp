<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%
		if(session.isNew()||session.getAttribute("id")==null){
			System.out.println("로그인 안됨");
			response.sendRedirect("/Fruit/member/login.jsp");
		}else{%>
			<a href="seller/fruitSellerRegister.jsp">RegisterFruit</a><br>
			<a href="/Fruit/sellerInfo.FProc">Information</a><br>
			<br>
			<input type="button" value="로그아웃" name="" onclick="location.href='/Fruit/logout.MProc'">
		<%}
	%>
	</body>
</html>