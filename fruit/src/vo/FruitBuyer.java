package vo;

public class FruitBuyer {
	private String usr_id, usr_pw;
	private int money, appleCnt, applePrice;
	
	public FruitBuyer() {}
	public FruitBuyer(String usr_id, String usr_pw) {
		setUsrid(usr_id);
		setUsrpw(usr_pw);
		appleCnt = 0;
		applePrice = 0;
	}
	public FruitBuyer(String usr_id, int appleCnt, int money) {
		setUsrid(usr_id);
		setAppleCnt(appleCnt);
		setMoney(money);
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
	public int getAppleCnt() {
		return appleCnt;
	}
	public void setAppleCnt(int appleCnt) {
		this.appleCnt = appleCnt;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void buyFruit(FruitSeller s, int money) {
		int cnt = s.salesFruit(money);
		appleCnt += cnt;
		this.money -= money;
	}
}
