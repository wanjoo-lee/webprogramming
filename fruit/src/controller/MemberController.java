package controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MemberController extends HttpServlet{
	HashMap<String, Controller> list = null;
	public void init(ServletConfig sc) throws ServletException{
		list = new HashMap<String,Controller>();
		list.put("/login.MProc", new LoginController());
		list.put("/register.MProc", new RegisterController());
		list.put("/logout.MProc", new LogoutController());
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());

		Controller subController = list.get(path);
		subController.execute(request, response);
	}
}
