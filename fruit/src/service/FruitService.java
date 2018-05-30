package service;

import java.util.*;

import vo.*;
import dao.*;

public class FruitService {
	private static FruitService service = new FruitService();
	public FruitDAO fdao = FruitDAO.getInstance();

	private FruitService(){

	}
	public static FruitService getInstance() {
		return service;
	}
	public void updateFruit(String id, int cnt, int price) {
		fdao.updateFruit(id, cnt, price);
	}
	public ArrayList<FruitSellerInfo> searchSellerInfo(){
		return fdao.searchSellerInfo();
	}
	public ArrayList<FruitSeller> searchSellerInfo(String id){
		return fdao.searchSellerInfo(id);
	}
	public void updateBuyerMoney(String id, int money) {
		fdao.updateBuyerMoney(id, money);
	}
	public ArrayList<FruitBuyer> searchBuyerInfo(String id){
		return fdao.searchBuyerInfo(id);
	}
	public void updateBuyerdata(FruitBuyer buyer_info) {
		fdao.updateBuyerdata(buyer_info);
	}
	public void updateSellerdata(FruitSeller seller_info) {
		fdao.updateSellerdata(seller_info);
	}
}
