package controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FruitController extends HttpServlet{
	HashMap<String, Controller> list = null;
	public void init(ServletConfig sc) throws ServletException{
		list = new HashMap<String,Controller>();
		list.put("/regiFruit.FProc", new FruitRegisterController());
		list.put("/sellerInfo.FProc", new FruitSellerInfoController());
		list.put("/regiMoney.FProc", new BuyerMoneyRegisterController());
		list.put("/buyFruit.FProc", new BuyerBuyController());
		list.put("/buyerInfo.FProc", new BuyerInfoController());
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());

		Controller subController = list.get(path);
		subController.execute(request, response);
	}

}
