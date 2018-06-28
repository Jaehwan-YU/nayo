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

	public void BookmarkService() {
		this.recipeId = null;
		this.regEmail = null;
	}
	
	public void BookmarkService(String regEmail) {
		this.regEmail = regEmail;
	} 
	
	public BookmarkService(String recipeId, String regEmail) {
		//여기 원래 레시피타이틀이랑 심플인트로 가지고 와야하는데..
		//연결 어떻게 하나유?ㅋㅋㅋㅋㅋㅋㅋㅋ 고민해봅시다
		this.recipeId = recipeId;
		this.regEmail = regEmail;
	}

	public List<BookmarkService> getBookMarkList(String regEmail) throws ClassNotFoundException, SQLException {
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
		pstmt.setString(1, regEmail );
		ResultSet rs = pstmt.executeQuery(sql);
			
		while(rs.next()) {		
			BookmarkService bookmark = new BookmarkService(rs.getString("TITLE"),
													rs.getString("SIMPLE_INTRO"));
			//System.out.println(shop);
			list = bookmark.getBookMarkList(regEmail);
	}
		return list;
	}

	void addBookMark(String memberEmail, String RecipeId) {
		
	}

	void deleteBookMark(String memberEmail, String RecipeId) {
		
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
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
}
