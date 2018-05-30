package vo;

public class Member {
	private String usr_id, usr_pw;
	private int usr_class;
	
	public Member() {}
	public Member(String usr_id, String usr_pw) {
		setUsrid(usr_id);
		setUsrpw(usr_pw);
	}
	public String getUsrid() {
		return usr_id;
	}
	public void setUsrid(String usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsrpw() {
		return usr_pw;
	}
	public void setUsrpw(String usr_pw) {
		this.usr_pw = usr_pw;
	}
	public int getUsrClass() {
		return usr_class;
	}
	public void setUsrClass(int usr_class) {
		this.usr_class = usr_class;
	}
	
}
