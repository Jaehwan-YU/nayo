package com.nayo.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopbagService {
	private String name;
	private String regEmail;
	private String buyDay;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ShopbagService a = new ShopbagService();
		
		a.getShopbagList();
		
	}
	
	public void ShopbagService() {
		this.name = null;
		this.regEmail = null;
		this.buyDay = null;
	}
	public void ShopbagService(String regEmail) {
		this.regEmail = regEmail;
	}
	
	void getShopbagList() throws ClassNotFoundException, SQLException{
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		//String sql = "SELECT * FROM MEMBER WHERE NAME LIKE '%"+search+"%'";
		String sql = "SELECT * FROM SHOPBAG";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			
		System.out.println(rs.getString("name"));
		}
		
	}
	void addShopbag(String memberEmail) {}
	void deleteShopbag(String shopbagId) {}
	
	
	
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
