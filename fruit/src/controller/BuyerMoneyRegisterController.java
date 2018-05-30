package controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import vo.*;
import service.*;

public class BuyerMoneyRegisterController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int set_money = Integer.parseInt(request.getParameter("regi_money"));
		boolean chk_query = false;
		HttpSession session = request.getSession();
		
		if(session.isNew()||session.getAttribute("id")==null) {
			System.out.println("로그인 안됨");
			response.sendRedirect("/Fruit/member/login.jsp");
		}else {
			String usr_id = (String)session.getAttribute("id");
			FruitService service = FruitService.getInstance();
			service.updateBuyerMoney(usr_id, set_money);
			chk_query = FruitDAO.chkQuery();
			if(chk_query) {
				response.sendRedirect("/Fruit/menu/buyer/result/fruitBuyerRegisterMoneyOutput.jsp");
			}else {
				request.setAttribute("FruitRegiError", "저장하는데 문제가 발생하였습니다. 다시 입력해 주십시오.");
				DispatcherUtil.forward(request, response, "/Fruit/menu/buyer/fruitBuyerRegisterMoney.jsp");
			}
		}
	}
}
