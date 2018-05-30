package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import vo.*;
import service.*;

public class FruitRegisterController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int apple_cnt = Integer.parseInt(request.getParameter("apple_cnt"));
		int apple_price = Integer.parseInt(request.getParameter("apple_price"));
		boolean chk_query = false;
		HttpSession session = request.getSession();
		
		if(session.isNew()||session.getAttribute("id")==null) {
			System.out.println("로그인 안됨");
			response.sendRedirect("/Fruit/member/login.jsp");
		}else {
			String usr_id = (String)session.getAttribute("id");
			FruitService service = FruitService.getInstance();
			service.updateFruit(usr_id, apple_cnt, apple_price);
			chk_query = FruitDAO.chkQuery();
			if(chk_query) {
				response.sendRedirect("/Fruit/menu/seller/result/fruitSellerRegisterOutput.jsp");
			}else {
				request.setAttribute("FruitRegiError", "저장하는데 문제가 발생하였습니다. 다시 입력해 주십시오.");
				DispatcherUtil.forward(request, response, "/Fruit/menu/seller/fruitSellerRegister.jsp");
			}
		}
	}
}
