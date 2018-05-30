package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import vo.*;
import service.*;

public class LoginController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String log_usr_id = request.getParameter("rog_id");
		String log_usr_pw = request.getParameter("rog_pw");
		boolean chk_query = false;
		HttpSession session = request.getSession();
		
		MemberService service = MemberService.getInstance();
		Member member = service.membersearch(log_usr_id);
//		System.out.println(member.getUsrid()+"/"+member.getUsrpw()+"/"+member.getUsrClass());
		chk_query = MemberDAO.chkQuery();
		System.out.println(member);
		
		if(member==null){
			System.out.println("아이디 존재 x");
			DispatcherUtil.forward(request, response, "/member/login.jsp");
		}else {
			if(log_usr_pw.equals(member.getUsrpw())){
				if((member.getUsrClass())==3) {
					System.out.println("일반 회원");
					if(session.isNew()||session.getAttribute("id")==null) {
						session.setAttribute("id", log_usr_id);
						System.out.println("세션 생성");
						response.sendRedirect("/Fruit/menu/fruitBuyerMenu.jsp");
					}
				}else if((member.getUsrClass())==2) {
					System.out.println("판매 회원");
					if(session.isNew()||session.getAttribute("id")==null) {
						session.setAttribute("id", log_usr_id);
						System.out.println("세션 생성");
						response.sendRedirect("/Fruit/menu/fruitSellerMenu.jsp");
					}
				}
			}else {
				System.out.println("비밀번호 다름");
				DispatcherUtil.forward(request, response, "/member/login.jsp");
			}
		}
	}
}
