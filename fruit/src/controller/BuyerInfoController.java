package controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import vo.*;
import service.*;

public class BuyerInfoController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		if(session.isNew()||session.getAttribute("id")==null) {
			System.out.println("로그인 안됨");
			response.sendRedirect("/Fruit/member/login.jsp");
		}else {
			String buyer_id = (String)session.getAttribute("id");
			FruitService service = FruitService.getInstance();
			ArrayList<FruitBuyer> list = service.searchBuyerInfo(buyer_id);
			FruitBuyer info = null;
			for(int i=0;i<list.size();i++) {
				info = new FruitBuyer();
				info = list.get(i);
//				System.out.println(info.getUserid()+"/"+info.getApplecnt()+"/"+info.getApplePrice()+"/"+info.getMoney());
			}
			request.setAttribute("info", info);
			DispatcherUtil.forward(request, response, "/menu/buyer/result/fruitBuyerInformation.jsp");
		}
	}
}
