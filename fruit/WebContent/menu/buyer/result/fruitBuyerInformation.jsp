<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<%
		String id;
		int cnt, price, money;
		FruitBuyer info = (FruitBuyer)request.getAttribute("info");
		id = info.getUsrid();
		cnt = info.getAppleCnt();
		money = info.getMoney();
	%>
	<body>
		<span>
			<div>AppleCount : </div>
			<div><%=cnt%></div>
		</span><br>
		<span>
			<div>Money : </div>
			<div><%=money%></div>
		</span><br>
		<%@ include file="buyerHome.jsp" %>
	</body>
</html>