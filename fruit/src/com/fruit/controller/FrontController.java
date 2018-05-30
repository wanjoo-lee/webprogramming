package com.fruit.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruit.controller.Controller;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> list = null;
	public void init(ServletConfig sc) throws ServletException
	{
		//
		list = new HashMap<String, Controller>();	// 이 부분 추가
		list.put("/seller/FruitSellerLogin.do", new FruitSellerLoginController());
		//			ㄴ-> 이부분 /seller 를 추가해 주세요
	}

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		
		Controller controller = list.get(path);
		controller.execute(request, response);
	}
}








