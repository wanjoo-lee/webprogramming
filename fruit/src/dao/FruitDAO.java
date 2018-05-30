package dao;

import java.sql.*;
import java.util.*;

import vo.*;

public class FruitDAO {
	private static FruitDAO fdao = new FruitDAO();
	public static boolean chk_query = false;

	private FruitDAO() {

	}
	public static FruitDAO getInstance() {
		return fdao;
	}
	public Connection connect() {
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/fruit";
			String user = "root";
			String pwd = "cs1234";

			conn = DriverManager.getConnection(url,user,pwd);
		}catch(Exception e) {
			return null;
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				System.out.println("Error : com.dev.dao.MemberDAO / conn.close()" + e);
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.println("Error : com.dev.dao.MemberDAO / pstmt.close()" + e);
			}
		}
		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {
				System.out.println("Error : com.dev.dao.MemberDAO / rs.close()" + e);
			}
		}
	}
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				System.out.println("Error : com.dev.dao.MemberDAO / conn.close()" + e);
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			}catch(Exception e) {
				System.out.println("Error : com.dev.dao.MemberDAO / stmt.close()" + e);
			}
		}
		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {
				System.out.println("Error : com.dev.dao.MemberDAO / rs.close()" + e);
			}
		}
	}
	public static boolean chkQuery() {
		//정상적인 DBquery 성공 여부 반환
		return chk_query;
	}
	public void updateFruit(String id, int cnt, int price) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String query = "UPDATE sellerdata set apple_cnt='"+cnt+"', apple_price='"+price+"' where user_id='"+id+"';";
			System.out.println(query);
			stmt.executeUpdate(query);
			chk_query = true;
		}catch(Exception e) {

		}finally {
			close(conn, stmt, rs);
		}
	}
	public ArrayList<FruitSellerInfo> searchSellerInfo(){
		ArrayList<FruitSellerInfo> list = new ArrayList<FruitSellerInfo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		FruitSellerInfo info = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String query = "select * from sellerdata;";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String seller_id = rs.getString(2);
				int apple_cnt = rs.getInt(3);
				int apple_price = rs.getInt(4);
//				System.out.println(seller_id+"/"+apple_cnt+"/"+apple_price);
				info = new FruitSellerInfo(seller_id, apple_cnt, apple_price);
				list.add(info);
			}
			chk_query=true;
		}catch(Exception e) {

		}finally {
			close(conn, stmt, rs);
		}
		return list;
	}
	public ArrayList<FruitSeller> searchSellerInfo(String id){
		ArrayList<FruitSeller> list = new ArrayList<FruitSeller>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		FruitSeller info = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String query = "select * from sellerdata where user_id='"+id+"';";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String seller_id = rs.getString(2);
				int apple_cnt = rs.getInt(3);
				int apple_price = rs.getInt(4);
				int seller_money = rs.getInt(5);
//				System.out.println(seller_id+"/"+apple_cnt+"/"+apple_price);
				info = new FruitSeller(seller_id, apple_cnt, apple_price, seller_money);
				list.add(info);
				chk_query=true;
			}
		}catch(Exception e) {

		}finally {
			close(conn, stmt, rs);
		}
		return list;
	}
	public ArrayList<FruitBuyer> searchBuyerInfo(String id){
		ArrayList<FruitBuyer> list = new ArrayList<FruitBuyer>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		FruitBuyer info = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String query = "select * from buyerdata where user_id='"+id+"';";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String buyer_id = rs.getString(2);
				int apple_cnt = rs.getInt(3);
				int buyer_money = rs.getInt(4);
//				System.out.println(seller_id+"/"+apple_cnt+"/"+apple_price);
				info = new FruitBuyer(buyer_id, apple_cnt, buyer_money);
				list.add(info);
			}
			chk_query=true;
		}catch(Exception e) {

		}finally {
			close(conn, stmt, rs);
		}
		return list;
	}
	public void updateBuyerMoney(String id, int money) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String query = "update buyerdata set money='"+money+"' where user_id='"+id+"';";
			System.out.println(query);
			stmt.executeUpdate(query);
			chk_query=true;
		}catch(Exception e) {

		}finally {
			close(conn, stmt, rs);
		}
	}
	public void updateBuyerdata(FruitBuyer buyer_info){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String buyer_id = buyer_info.getUsrid();
			int buyer_buy_apple_cnt = buyer_info.getAppleCnt();
			int buyer_money = buyer_info.getMoney();
			String query = "update buyerdata set apple_cnt='"+buyer_buy_apple_cnt+"', money='"+buyer_money+"' where user_id='"+buyer_id+"';";
			System.out.println(query);
			stmt.executeUpdate(query);
			chk_query=true;
		}catch(Exception e) {

		}finally {
			close(conn, stmt, rs);
		}
	}
	public void updateSellerdata(FruitSeller seller_info){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String seller_id = seller_info.getUsrid();
			int seller_apple_cnt = seller_info.getApplecnt();
			int seller_money = seller_info.getMoney();
			String query = "update sellerdata set apple_cnt='"+seller_apple_cnt+"', money='"+seller_money+"' where user_id='"+seller_id+"';";
			System.out.println(query);
			stmt.executeUpdate(query);
			chk_query=true;
		}catch(Exception e) {

		}finally {
			close(conn, stmt, rs);
		}
	}
}
