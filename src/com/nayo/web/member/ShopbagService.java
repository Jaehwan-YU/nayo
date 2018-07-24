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

public class ShopbagService {
	private String name;
	private String regEmail;
	private Date buyDay;
	private String url;
	private String user;
	private String password;
	
	public ShopbagService(String name, String memberEmail, Date buyDay) {
		this.name = name;
		this.regEmail = memberEmail;
		this.buyDay = buyDay;
	}
	public ShopbagService(ServletContext servletContext) throws IOException {

		InputStream is = servletContext.getResourceAsStream("WEB-INF/db.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		
		
	}
	public ShopbagService(String memberEmail) {
		this.regEmail = memberEmail;
	}

	
	public List<ShopbagService> getShopbagList(String memberEmail) throws ClassNotFoundException, SQLException{
		List<ShopbagService> list = new ArrayList<ShopbagService>();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "SELECT * FROM SHOPBAG WHERE REG_EMAIL = ? AND BUY_DAY IS NULL";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail);
		ResultSet rs = pstmt.executeQuery();
			
		while(rs.next()) {		
			ShopbagService shop = new ShopbagService(rs.getString("NAME"),
													rs.getString("REG_EMAIL"),
													rs.getDate("BUY_DAY"));
			list.add(shop);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;		
	}
	
	public void addShopbag(String name, String memberEmail) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

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
	
	public void deleteShopbag(String name, String memberEmail) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

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
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String memberEmail) {
		this.regEmail = memberEmail;
	}
	public Date getBuyDay() {
		return buyDay;
	}
	public void setBuyDay(Date buyDay) {
		this.buyDay = buyDay;
	}
}
