package com.nayo.web.member;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.nayo.web.entity.Shopbag;

public class ShopbagService {
	
	private String url;
	private String user;
	private String password;

	public ShopbagService(ServletContext servletContext) throws IOException {

		InputStream is = servletContext.getResourceAsStream("WEB-INF/db.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");	
	}

	public List<Shopbag> getShopbagList(String memberEmail) throws ClassNotFoundException, SQLException{
		List<Shopbag> list = new ArrayList<Shopbag>();
		
		String sql = "SELECT * FROM SHOPBAG WHERE REG_EMAIL = ? AND BUY_DAY IS NULL";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail);
		ResultSet rs = pstmt.executeQuery();
			
		while(rs.next()) {		
			Shopbag shopbag = new Shopbag(rs.getString("NAME"),
													rs.getString("REG_EMAIL"),
													rs.getDate("BUY_DAY"));
			list.add(shopbag);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;		
	}
	
	public List<Shopbag> getShopbagList(String memberEmail, int keepTip) throws ClassNotFoundException, SQLException{
		List<Shopbag> list = new ArrayList<Shopbag>();
		
		String sql = "SELECT NAME\r\n" + 
					"FROM (SELECT K.FOOD_CATE_ID ID, K.NAME, K.FOOD_IMG\r\n" + 
					"        FROM KEEP_TIP K\r\n" + 
					"        INNER JOIN (SELECT NAME\r\n" + 
					"                    FROM SHOPBAG\r\n" + 
					"                    WHERE REG_EMAIL = ?) S\r\n" + 
					"        ON K.NAME = S.NAME)\r\n" + 
					"WHERE ID = ?";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail);
		pstmt.setInt(2, keepTip);
		ResultSet rs = pstmt.executeQuery();
			
		while(rs.next()) {		
			Shopbag shopbag = new Shopbag(rs.getString("NAME"));
			list.add(shopbag);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;		
	}
	
	public void addShopbag(String name, String memberEmail) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO SHOPBAG(NAME, REG_EMAIL) VALUES(?,?)";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, memberEmail);
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0?"등록 완료":"등록 실패");
		
		pstmt.close();
		con.close();
	}
	
	public void setShopbag(String name) throws ClassNotFoundException, SQLException {
		String sql = "";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.close();
		con.close();
	}
	
	public void deleteShopbag(String name, String memberEmail) throws ClassNotFoundException, SQLException {
		
		String sql = "DELETE FROM SHOPBAG WHERE NAME = ? AND REG_EMAIL = ?";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, memberEmail);
		int cnt = pstmt.executeUpdate();

		System.out.println(cnt>0 ? "삭제완료":"삭제실패");
		
		pstmt.close();
		con.close();
	}

}
