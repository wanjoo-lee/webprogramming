package com.fruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruit.service.FruitService;

public class FruitSellerLoginController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		FruitService service = FruitService.getInstance();
		String dbPasswd = service.fruitSellerLogin(id);
		
		
	}

}








