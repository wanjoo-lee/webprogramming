package dao;

import java.sql.*;
import java.util.*;

import vo.*;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	public static boolean chk_query = false;

	private MemberDAO() {

	}
	public static MemberDAO getInstance() {
		return dao;
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
	public void memberRegister(FruitBuyer member, int user_class) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String regi_user_id = member.getUsrid();
			String regi_user_pw = member.getUsrpw();
			String query = "INSERT INTO userdata values('"+regi_user_id+"','"+regi_user_pw+"','"+user_class+"');";
			System.out.println(query);
			stmt.executeUpdate(query);
			chk_query = true;
		}catch(Exception e) {
			
		}finally {
			close(conn, stmt, rs);
		}
	}public void buyerRegister(FruitBuyer member) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String regi_user_id = member.getUsrid();
			String query = "INSERT INTO buyerdata(user_id) values('"+regi_user_id+"');";
			System.out.println(query);
			stmt.executeUpdate(query);
			chk_query = true;
		}catch(Exception e) {
			
		}finally {
			close(conn, stmt, rs);
		}
	}
	public void memberRegister(FruitSeller member, int user_class) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String regi_user_id = member.getUsrid();
			String regi_user_pw = member.getUsrpw();
			String query = "INSERT INTO userdata values('"+regi_user_id+"','"+regi_user_pw+"','"+user_class+"');";
			System.out.println(query);
			stmt.executeUpdate(query);
			chk_query = true;
		}catch(Exception e) {
			
		}finally {
			close(conn, stmt, rs);
		}
	}
	public void sellerRegister(FruitSeller member) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		chk_query = false;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String regi_user_id = member.getUsrid();
			String query = "INSERT INTO sellerdata(user_id) values('"+regi_user_id+"');";
			System.out.println(query);
			stmt.executeUpdate(query);
			chk_query = true;
		}catch(Exception e) {
			
		}finally {
			close(conn, stmt, rs);
		}
	}
	public Member memberSearch(String id) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = connect();
			stmt = conn.createStatement();
			String query = "select * from userdata where user_id='"+id+"';";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				member = new Member();
				member.setUsrid(rs.getString(1));
				member.setUsrpw(rs.getString(2));
				member.setUsrClass(Integer.parseInt(rs.getString(3)));
			}
		}catch(Exception e){

		}finally {
			close(conn, stmt, rs);
		}
		System.out.println(member);
		return member;
	}
}
