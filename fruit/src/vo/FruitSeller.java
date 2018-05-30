package vo;

public class FruitSeller {
	private String usr_id, usr_pw;
	private int money, appleCnt, applePrice;
	
	public FruitSeller() {}
	public FruitSeller(String usr_id, String usr_pw) {
		setUsrid(usr_id);
		setUsrpw(usr_pw);
	}
	public FruitSeller(String user_id, int appleCnt, int applePrice, int money) {
		setUsrid(user_id);
		setApplecnt(appleCnt);
		setApplePrice(applePrice);
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
	public int getApplecnt() {
		return appleCnt;
	}
	public void setApplecnt(int appleCnt) {
		this.appleCnt=appleCnt;
	}
	public int getApplePrice() {
		return applePrice;
	}
	public void setApplePrice(int applePrice) {
		this.applePrice=applePrice;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money=money;
	}
	public int salesFruit(int money) {
		int cnt = money/this.applePrice;
		this.appleCnt -= cnt;
		this.money += money;
		return cnt;
	}
}
