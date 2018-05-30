package controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import vo.*;
import service.*;

public class BuyerBuyController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = request.getParameter("path");
		boolean chk_query=true;
		HttpSession session = request.getSession();
		
		if(session.isNew()||session.getAttribute("id")==null) {
			System.out.println("로그인 안됨");
			response.sendRedirect("/Fruit/member/login.jsp");
		}else {
			if(path==null) {
				String usr_id = (String)session.getAttribute("id");
				MemberService mservice = MemberService.getInstance();
				FruitService fservice = FruitService.getInstance();	
				ArrayList<FruitSellerInfo> list = fservice.searchSellerInfo();
				
				request.setAttribute("sellerList", list);
				DispatcherUtil.forward(request, response, "/menu/buyer/fruitBuyerBuyFruit.jsp");
			}else if(path.equals("buy_proc")) {
				String buyer_id = (String)session.getAttribute("id");
				String seller_id = request.getParameter("seller_id");
				int buy_apple_cnt = Integer.parseInt(request.getParameter("buy_apple_cnt"));
				
				MemberService mservice = MemberService.getInstance();
				FruitService fservice = FruitService.getInstance();	
				
				ArrayList<FruitSeller> seller_list = fservice.searchSellerInfo(seller_id);
				chk_query=FruitDAO.chkQuery();
				
				if(chk_query) {
					FruitSeller seller_info = null;
					for(int i=0;i<seller_list.size();i++) {
						seller_info = new FruitSeller();
						seller_info = seller_list.get(i);
					}
					ArrayList<FruitBuyer> buyer_list = fservice.searchBuyerInfo(buyer_id);
					FruitBuyer buyer_info = null;
					for(int i=0;i<buyer_list.size();i++) {
						buyer_info = new FruitBuyer();
						buyer_info = buyer_list.get(i);
					}
					System.out.println(seller_info.getUsrid()+"/"+seller_info.getApplecnt()+"/"+seller_info.getApplePrice()+"/"+seller_info.getMoney());
					System.out.println(buyer_info.getUsrid()+"/"+buyer_info.getAppleCnt()+"/"+buyer_info.getMoney());
					if(buy_apple_cnt>seller_info.getApplecnt()) {
						System.out.println("구매하려는 양이 남은 수량보다 많아 구매 불가능 합니다.");
						response.sendRedirect("/Fruit/buyFruit.FProc");
					}else {
						if((buy_apple_cnt*seller_info.getApplePrice())>buyer_info.getMoney()) {
							System.out.println("구매하려는 금액이 소지 금액보다 많아 구매 불가능 합니다..");
							response.sendRedirect("/Fruit/buyFruit.FProc");
						}else {
							int total_charge = buy_apple_cnt*seller_info.getApplePrice();
							System.out.println(total_charge);
							buyer_info.buyFruit(seller_info, total_charge);
							System.out.println(seller_info.getUsrid()+"/"+seller_info.getApplecnt()+"/"+seller_info.getApplePrice()+"/"+seller_info.getMoney());
							System.out.println(buyer_info.getUsrid()+"/"+buyer_info.getAppleCnt()+"/"+buyer_info.getMoney());
							
							fservice.updateSellerdata(seller_info);
							fservice.updateBuyerdata(buyer_info);
							
							response.sendRedirect("/Fruit/menu/buyer/result/fruitBuyerBuyFruitOutput.jsp");
						}
					}
				}else {
					System.out.println("구매하려는 구매자의 ID를 잘못 입력 하셨습니다.");
					response.sendRedirect("/Fruit/buyFruit.FProc");
				}
			}
		}
	}
}
