package com.nayo.web.member;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.nayo.web.NoticeService;
import com.nayo.web.entity.Bookmark;
import com.nayo.web.entity.Recipe;

public class BookmarkService {
	private String url;
	private String user;
	private String password;
	
	public BookmarkService(ServletContext servletContext) throws IOException {
		InputStream is = servletContext.getResourceAsStream("WEB-INF/db.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}

	public List<Recipe> getBookmarkList(String memberEmail) throws ClassNotFoundException, SQLException {
		List<Recipe> list = new ArrayList();
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/

		String sql = "SELECT *\r\n" + 
				"FROM RECIPE R\r\n" + 
				"WHERE R.ID =(SELECT B.RECIPE_ID\r\n" + 
				"                FROM BOOKMARK B\r\n" + 
				"                WHERE B.REG_EMAIL = (SELECT M.EMAIL\r\n" + 
				"                                        FROM MEMBER M\r\n" + 
				"                                        WHERE EMAIL = ?))";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberEmail);
		ResultSet rs = st.executeQuery();
			
		while(rs.next()) {		
			
			Recipe recipe = new Recipe(rs.getInt("ID"),
										rs.getString("TITLE"),
										rs.getString("SIMPLE_INTRO"),
										rs.getString("MAIN_IMG"));
			//System.out.println(shop);
			list.add(recipe);
		}
		
		con.close();
		st.close();
		rs.close();
		
		return list;
	}

	void addBookMark(String memberEmail, String recipeId) throws SQLException, ClassNotFoundException {
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "INSERT INTO BOOKMARK(RECIPE_ID, REG_EMAIL) VALUES(?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail );
		pstmt.setString(2, recipeId );
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0? "등록 완료":"등록 실패");
		
		con.close();
		pstmt.close();
		
	}

	void deleteBookMark(String memberEmail, String recipeId) throws ClassNotFoundException, SQLException {
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "DELETE FROM BOOKMARK WHERE REG_EMAIL = ? AND RECIPE_ID = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail );
		pstmt.setString(2, recipeId );
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0? "삭제 성공":"삭제 실패");
		
		con.close();
		pstmt.close();
	}
	
	
}
