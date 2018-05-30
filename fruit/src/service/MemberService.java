package service;

import java.util.*;

import vo.*;
import dao.*;

public class MemberService {
	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();
	
	private MemberService(){
		
	}
	public static MemberService getInstance() {
		return service;
	}
	public void memberRegister(FruitBuyer member, int user_class) {
		dao.memberRegister(member, user_class);
	}
	public void buyerRegister(FruitBuyer member) {
		dao.buyerRegister(member);
	}
	public void memberRegister(FruitSeller member, int user_class) {
		dao.memberRegister(member, user_class);
	}
	public void sellerRegister(FruitSeller member) {
		dao.sellerRegister(member);
	}
	public Member membersearch(String id) {
		return dao.memberSearch(id);
	}
}
