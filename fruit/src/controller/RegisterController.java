package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import vo.*;
import service.*;

public class RegisterController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path_conn = request.getParameter("regi_path");
		String regi_new_id = request.getParameter("regi_id");
		String regi_new_pw = request.getParameter("regi_pw");
		int usr_classification = 0;
		boolean chk_query_member = false;
		boolean chk_query_seller = false;
		
		if(path_conn.equals("member")) {
			usr_classification = 3;
			FruitBuyer member = new FruitBuyer(regi_new_id, regi_new_pw);
			MemberService service = MemberService.getInstance();
			service.memberRegister(member, usr_classification);
			chk_query_member = MemberDAO.chkQuery();
			if(chk_query_member) {
				service.buyerRegister(member);
				response.sendRedirect("/Fruit/member/result/regiSuccess.jsp?id="+regi_new_id);
			}else {
				request.setAttribute("regi_error", "회원가입 도중 오류가 발생하였습니다. 회원가입을 다시 진행 해 주세요.");
				DispatcherUtil.forward(request, response, "/member/regiNewMember.jsp");
			}
		}else if(path_conn.equals("seller")) {
			usr_classification = 2;
			FruitSeller member = new FruitSeller(regi_new_id, regi_new_pw);
			MemberService service = MemberService.getInstance();
			service.memberRegister(member, usr_classification);
			chk_query_member = MemberDAO.chkQuery();
			if(chk_query_member) {
				service.sellerRegister(member);
				chk_query_seller = MemberDAO.chkQuery();
				response.sendRedirect("/Fruit/member/result/regiSuccess.jsp?id="+regi_new_id);
			}else {
				request.setAttribute("regi_error", "회원가입 도중 오류가 발생하였습니다. 회원가입을 다시 진행 해 주세요.");
				DispatcherUtil.forward(request, response, "/member/regiNewMember.jsp");
			}
		}	
	}
}
