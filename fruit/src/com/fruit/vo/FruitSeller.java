package com.fruit.vo;

public class FruitSeller {
	String id;
	String passwd;
	int money;
	int appleCount;
	int applePrice;
	
	public FruitSeller() {}
	public FruitSeller(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
		money = 0;
	}
	public int salesFruit(int money) {
		int count = money / applePrice;
		appleCount -= count;
		this.money += money;
		return count;
	}
}
