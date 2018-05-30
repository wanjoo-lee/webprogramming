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
		FruitSellerInfo info = (FruitSellerInfo)request.getAttribute("info");
		id = info.getUserid();
		cnt = info.getApplecnt();
		price = info.getApplePrice();
		money = info.getMoney();
	%>
	<body>
		<span style="clear: both;">
			<div style="clear: both; width: 100px; float: left; text-align: left;">AppleCount : </div>
			<div style="width: 10px; float: left; text-align: right;"><%=cnt %></div>
		</span><br>
		<span style="clear: both;">
			<div style="clear: both; width: 100px; float: left; text-align: left;">ApplePrice : </div>
			<div style="width: 10px; float: left; text-align: right;"><%=price %></div>
		</span><br>
		<span style="clear: both;">
			<div style="clear: both; width: 100px; float: left; text-align: left;">Money : </div>
			<div style="width: 10px; float: left; text-align: right;"><%=money %></div>
		</span><br>
		<%@ include file="sellerHome.jsp" %>
	</body>
</html>