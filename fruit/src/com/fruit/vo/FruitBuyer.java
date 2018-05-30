package com.fruit.vo;

public class FruitBuyer {
	private String id;
	private String passwd;
	private int money;
	private int appleCount;
	
	public FruitBuyer() {}
	public FruitBuyer(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
		appleCount = 0;
		money = 0;
	}
	public void buyFruit(FruitSeller s, int money){
		int count = s.salesFruit(money);
		appleCount += count;
		this.money -= money;
	}
}










