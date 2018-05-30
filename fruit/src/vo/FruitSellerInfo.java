package vo;

public class FruitSellerInfo {
	private String user_id;
	private int  apple_cnt, apple_price, money;

	public FruitSellerInfo() {}
	public FruitSellerInfo(String user_id, int apple_cnt, int apple_price) {
		setUserid(user_id);
		setApplecnt(apple_cnt);
		setApplePrice(apple_price);
	}
	public FruitSellerInfo(String user_id, int apple_cnt, int apple_price, int money) {
		setUserid(user_id);
		setApplecnt(apple_cnt);
		setApplePrice(apple_price);
		setMoney(money);
	}
	public String getUserid() {
		return user_id;
	}
	public void setUserid(String user_id) {
		this.user_id=user_id;
	}
	public int getApplecnt() {
		return apple_cnt;
	}
	public void setApplecnt(int apple_cnt) {
		this.apple_cnt=apple_cnt;
	}
	public int getApplePrice() {
		return apple_price;
	}
	public void setApplePrice(int apple_price) {
		this.apple_price=apple_price;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money=money;
	}
}
