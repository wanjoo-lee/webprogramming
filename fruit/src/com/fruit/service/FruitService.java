package com.fruit.service;

import com.fruit.dao.FruitDao;

public class FruitService {
	private static FruitService service = new FruitService();
	private FruitDao dao = FruitDao.getInstance();
	private FruitService() {}
	
	public static FruitService getInstance()
	{
		return service;
	}
	
	public String fruitSellerLogin(String id)
	{
		return dao.fruitSellerLogin(id);
	}
}
