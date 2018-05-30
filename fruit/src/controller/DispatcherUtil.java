package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DispatcherUtil {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}catch(Exception e){
			System.out.println("forward 오류" + e);
		}
		
	}
}
