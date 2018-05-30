package controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import vo.*;
import service.*;

public class FruitSellerInfoController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		if(session.isNew()||session.getAttribute("id")==null) {
			System.out.println("로그인 안됨");
			response.sendRedirect("/Fruit/member/login.jsp");
		}else {
			String seller_id = (String)session.getAttribute("id");
			FruitService service = FruitService.getInstance();
			ArrayList<FruitSeller> list = service.searchSellerInfo(seller_id);
			FruitSeller info = null;
			for(int i=0;i<list.size();i++) {
				info = new FruitSeller();
				info = list.get(i);
//				System.out.println(info.getUserid()+"/"+info.getApplecnt()+"/"+info.getApplePrice()+"/"+info.getMoney());
			}
			request.setAttribute("info", info);
			DispatcherUtil.forward(request, response, "/menu/seller/result/fruitSellerInformation.jsp");
		}
	}
}
