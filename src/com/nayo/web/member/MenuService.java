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

import com.nayo.web.entity.Menu;
import com.nayo.web.entity.Recipe;

public class MenuService {
	private String url;
	private String user;
	private String password;
	
	public MenuService(ServletContext servletContext) throws IOException {
		InputStream is = servletContext.getResourceAsStream("WEB-INF/db.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	public Menu getMenu(String memberEmail, Date menuDate, int mill) throws SQLException, ClassNotFoundException {
		
		Menu menu;
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/

		String sql = "SELECT * FROM MENU M INNER JOIN RECIPE R ON M.RECIPE_ID = R.ID "
				+ "WHERE M.REG_EMAIL = ? AND "
				+ "M.MENU_DATE = ? AND "
				+ "M.MILL = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail);
		pstmt.setDate(2, menuDate);
		pstmt.setInt(3, mill);
		
		ResultSet rs = pstmt.executeQuery();

		if(rs.next()) {
			menu = new Menu(rs.getString("REG_EMAIL"),
					rs.getDate("MENU_DATE"), 
					rs.getInt("MILL"),
					rs.getInt("RECIPE_ID"),
					rs.getInt("ID"),
					rs.getString("TITLE"),
					null);

			rs.close();
			pstmt.close();
			con.close();
			
			return menu;
		}
		
		return null;

	}
	public List<Menu> getMenu(String memberEmail) throws SQLException, ClassNotFoundException {
		List<Menu> list = new ArrayList<>();
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/

		String sql = "SELECT *\r\n" + 
					"FROM RECIPE R\r\n" + 
					"INNER JOIN (SELECT *\r\n" + 
					"            FROM MENU\r\n" + 
					"            WHERE REG_EMAIL = ?) M\r\n" + 
					"ON R.ID = M.RECIPE_ID";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail);

		ResultSet rs = pstmt.executeQuery();

		if(rs.next()) {
			Menu menu = new Menu(rs.getString("REG_EMAIL"),
					rs.getDate("MENU_DATE"), 
					rs.getInt("MILL"),
					rs.getInt("RECIPE_ID"),
					rs.getInt("ID"),
					rs.getString("TITLE"),
					rs.getString("MAIN_IMG"));

			list.add(menu);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return list;

	}
	
	public void addMenu(Menu menu) throws SQLException, ClassNotFoundException {
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "INSERT INTO MENU(MENU_DATE, MILL, RECIPE_ID, REG_EMAIL)\r\n" + 
					"VALUES(?,?,?,?)";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDate(1, menu.getMenuDate());
		pstmt.setInt(2, menu.getMill());
		pstmt.setInt(3, menu.getRecipeId());
		pstmt.setString(4, menu.getRegEmail());
		
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0? "등록 완료":"등록 실패");
		
		con.close();
		pstmt.close();
	}
	public void setMenu(Menu menu) throws SQLException, ClassNotFoundException {
	
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "UPDATE MENU SET RECIPE_ID = ? WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, menu.getRecipeId());
		pstmt.setInt(2, menu.getId());
		
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0? "수정 완료":"수정 실패");
		
		con.close();
		pstmt.close();
	}
	public void deleteMenu(Menu menu) throws SQLException, ClassNotFoundException {
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "DELETE FROM MENU WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, menu.getId());
		
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0? "삭제 완료":"삭제 실패");
		
		con.close();
		pstmt.close();
		
	}
}
