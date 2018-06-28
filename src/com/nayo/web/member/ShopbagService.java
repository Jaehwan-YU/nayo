package com.nayo.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShopbagService {
	private String name;
	private String regEmail;
	private String buyDay;
	
	public ShopbagService(String name, String regEmail, String buyDay) {
		this.name = name;
		this.regEmail = regEmail;
		this.buyDay = buyDay;
	}
	public void ShopbagService() {
		this.name = null;
		this.regEmail = null;
		this.buyDay = null;
	}
	public void ShopbagService(String regEmail) {
		this.regEmail = regEmail;
	}

	
	public List<ShopbagService> getShopbagList(ShopbagService shopbagservice) throws ClassNotFoundException, SQLException{
		List<ShopbagService> list = new ArrayList<ShopbagService>();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "SELECT * FROM SHOPBAG WHERE REG_EMAIL = ?";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, shopbagservice.regEmail);
		ResultSet rs = pstmt.executeQuery(sql);
			
		while(rs.next()) {		
			ShopbagService shop = new ShopbagService(rs.getString("NAME"),
													rs.getString("REG_EMAIL"),
													rs.getString("BUY_DAY"));
			System.out.println(shop);
			list = shop.getShopbagList(shopbagservice);
		}
		return list;		
	}
	
	void addShopbag(String name, String regEmail) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "INSERT INTO SHOPBAG(NAME, REG_EMAIL) VALUES(?,?)";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, regEmail);
		ResultSet rs = pstmt.executeQuery(sql);
	}
	void deleteShopbag(String name) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "DELETE FROM SHOPBAG WHERE NAME = ? AND REG_EMAIL = ?";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, regEmail);
		ResultSet rs = pstmt.executeQuery(sql);
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	public String getBuyDay() {
		return buyDay;
	}
	public void setBuyDay(String buyDay) {
		this.buyDay = buyDay;
	}
}
