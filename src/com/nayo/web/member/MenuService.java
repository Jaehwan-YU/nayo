package com.nayo.web.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nayo.web.entity.Menu;

public class MenuService {
	
	public Menu getMenu(String memberEmail, Date menuDate, int mill) throws SQLException, ClassNotFoundException {
		
		Menu menu;
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

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
	
	public void addMenu(Menu menu) throws SQLException, ClassNotFoundException {
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
		String sql = "INSERT INTO MENU(ID, MENU_DATE, MILL, RECIPE_ID, REG_EMAIL) "
				+ "VALUES(?,?,?,?,?)";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, menu.getId());
		pstmt.setDate(2, menu.getMenuDate());
		pstmt.setInt(3, menu.getMill());
		pstmt.setInt(4, menu.getRecipeId());
		pstmt.setString(5, menu.getRegEmail());
		
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0? "등록 완료":"등록 실패");
		
		con.close();
		pstmt.close();
	}
	public void setMenu(Menu menu) throws SQLException, ClassNotFoundException {
	
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
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
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
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
