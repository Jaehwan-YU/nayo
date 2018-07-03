package com.nayo.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nayo.web.NoticeService;

public class BookmarkService {
	
	private String recipeId;
	private String regEmail;	

	public BookmarkService() {
		this.recipeId = null;
		this.regEmail = null;
	}
	
	public BookmarkService(String memberEmail) {
		this.regEmail = memberEmail;
	} 
	
	public BookmarkService(String recipeId, String memberEmail) {
		
		this.recipeId = recipeId;
		this.regEmail = memberEmail;
	}

	public List<BookmarkService> getBookMarkList(String memberEmail) throws ClassNotFoundException, SQLException {
		List<BookmarkService> list = new ArrayList<BookmarkService>();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "SELECT R.TITLE, R.SIMPLE_INTRO"
				+ "FROM RECIPE R"
				+ "WHERE R.ID =(SELECT B.RECIPE_ID"
								+ "FROM BOOKMARK B"
								+ "INNER JOIN MEMBER M"
								+ "ON B.REG_EMAIL = ?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail );
		ResultSet rs = pstmt.executeQuery(sql);
			
		while(rs.next()) {		
			BookmarkService bookmark = new BookmarkService(rs.getString("TITLE"),
													rs.getString("SIMPLE_INTRO"));
			//System.out.println(shop);
			list.add(bookmark);
	}
		return list;
	}

	void addBookMark(String memberEmail, String RecipeId) throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
		String sql = "INSERT INTO BOOKMARK(RECIPE_ID, REG_EMAIL) VALUES(?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail );
		pstmt.setString(2, recipeId );
		ResultSet rs = pstmt.executeQuery(sql);
	}

	void deleteBookMark(String memberEmail, String recipeId) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
		String sql = "DELETE FROM BOOKMARK WHERE REG_EMAIL = ? AND RECIPE_ID = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail );
		pstmt.setString(2, recipeId );
		ResultSet rs = pstmt.executeQuery(sql);
	}
	
	
	
	public String getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String memberEmail) {
		this.regEmail = memberEmail;
	}
}
