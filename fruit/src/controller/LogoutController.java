package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import vo.*;
import service.*;

public class LogoutController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		if(session!=null&&session.getAttribute("id")!=null) {
			session.invalidate();
			System.out.println("로그아웃 완료");
			response.sendRedirect("/Fruit/member/login.jsp");
		}
	}
}
