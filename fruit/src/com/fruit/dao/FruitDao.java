package com.fruit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FruitDao {
	private static FruitDao dao = new FruitDao();
	
	private FruitDao() {}
	
	public static FruitDao getInstance() {
		return dao;
	}
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/fruit";
			String user = "root";
			String password = "cs1234";
			conn = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			System.out.println("connect" + e);
		}
		return conn;
	}
	
	public String fruitSellerLogin(String id) {
		
		String passwd=null;
		try
		{
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement
			("select passwd from fruitSeller where id = ?;");
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				passwd = rs.getString(1);
		}catch(Exception e)
		{
			
		}
		return passwd;
	}

}






