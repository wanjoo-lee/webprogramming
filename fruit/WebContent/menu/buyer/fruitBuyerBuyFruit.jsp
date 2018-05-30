<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		String seller_id;
		int seller_apple_cnt, seller_apple_price;
		ArrayList<FruitSellerInfo> list = (ArrayList<FruitSellerInfo>)(request.getAttribute("sellerList"));
		FruitSellerInfo sellerInfo = null;
		%>
		<table>
			<thead>
				<tr>
					<th>SellerID</th>
					<th>AppleCount</th>
					<th>ApplePrice</th>
				</tr>
			</thead>
			<tbody>
		<%
		for(int i=0;i<list.size();i++){
			sellerInfo = new FruitSellerInfo();
			sellerInfo = list.get(i);
			seller_id = sellerInfo.getUserid();
			seller_apple_cnt = sellerInfo.getApplecnt();
			seller_apple_price = sellerInfo.getApplePrice();
			%>
				<tr>
					<td><%=seller_id%></td>
					<td><%=seller_apple_cnt%></td>
					<td><%=seller_apple_price%></td>
				</tr>
			<%
		}
		%>
			</tbody>
		</table><br>
		<form action="/Fruit/buyFruit.FProc" method="POST">
			<input type="hidden" name="path" value="buy_proc">
			<span>
				<label for="">SellerID</label>
				<input type="text" name="seller_id" id="seller_id">
			</span><br>
			<span>
				<label for="">AppleCount</label>
				<input type="text" name="buy_apple_cnt" id="buy_apple_cnt">
			</span>
			<input type="submit" value="구매">
		</form>
	</body>
</html>