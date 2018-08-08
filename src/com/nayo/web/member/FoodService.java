package com.nayo.web.member;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.nayo.web.entity.Food;
import com.nayo.web.entity.FoodCate;


public class FoodService {

	private Food food;
	private String url;
	private String user;
	private String password;


	public FoodService(ServletContext servletContext) throws IOException {
		InputStream is = servletContext.getResourceAsStream("WEB-INF/db.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}

	public List<Food> getFoodList(String memberEmail) throws ClassNotFoundException, SQLException {
		List<Food> list = new ArrayList<Food>();

		String sql = "SELECT * FROM FOOD WHERE REG_EMAIL = ? AND USE_DATE IS NULL";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail);
		ResultSet rs = pstmt.executeQuery();


		while (rs.next()) {
			food = new Food(rs.getString("ID"),
					rs.getString("NAME"), 
					rs.getInt("FOOD_LIFE"), 
					rs.getDate("SELL_LIFE"),
					rs.getInt("KEEP_AREA_ID"),
					rs.getInt("REST_LIFE"));
			// System.out.println(shop);
			list.add(food);
		}
		rs.close();
		pstmt.close();
		con.close();

		return list;
	}

	public List<Food> getFoodList(String memberEmail, int keepAreaId) throws ClassNotFoundException, SQLException {
		List<Food> list = new ArrayList<Food>();

		String sql = "SELECT FOOD_DEAD_LINE-sysdate rest_life, food.* FROM FOOD WHERE REG_EMAIL = ? "
				+ "AND KEEP_AREA_ID = ? AND USE_DATE IS NULL "
				+ "order by rest_life";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail);
		pstmt.setInt(2, keepAreaId);
		ResultSet rs = pstmt.executeQuery();


		while (rs.next()) {
			food = new Food(rs.getString("ID"),
					rs.getString("NAME"), 
					rs.getInt("FOOD_LIFE"), 
					rs.getDate("SELL_LIFE"),
					rs.getInt("KEEP_AREA_ID"),
					rs.getInt("REST_LIFE"));
			// System.out.println(shop);
			list.add(food);
		}
		rs.close();
		pstmt.close();
		con.close();

		return list;
	}
	
	public void addFood(String memberEmail, String foodName){

		int foodLife = 90;
		int foodCateId = 1;
		int keepAreaId = 1;
		String foodImg = "default img";

		String addSql = "INSERT INTO FOOD(ID, NAME, FOOD_LIFE, REG_EMAIL, FOOD_CATE_ID, KEEP_AREA_ID, FOOD_IMG, FOOD_DEAD_LINE)"
				+ " VALUES(FOOD_SEQ.nextval, ?, ?, ?, ?, ?, ?, sysdate+?)";

		String selectSql = "SELECT * FROM KEEP_TIP WHERE NAME = ?";

		Connection con = null;
		PreparedStatement selectStmt = null;
		PreparedStatement addStmt = null;
		ResultSet selectRs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			selectStmt = con.prepareStatement(selectSql);
			addStmt = con.prepareStatement(addSql);
			selectStmt.setString(1, foodName);
	
			selectRs = selectStmt.executeQuery();
	
			if (selectRs.next()) {
				foodLife = selectRs.getInt("FOOD_LIFE");
				foodCateId = selectRs.getInt("FOOD_CATE_ID");
				keepAreaId = selectRs.getInt("KEEP_AREA_ID");
				foodImg = selectRs.getString("FOOD_IMG");
			}
	
			addStmt.setString(1, foodName);
			addStmt.setInt(2, foodLife);
			addStmt.setString(3, memberEmail);
			addStmt.setInt(4, foodCateId);
			addStmt.setInt(5, keepAreaId);
			addStmt.setString(6, foodImg);
			addStmt.setInt(7, foodLife);
	
			int cnt = addStmt.executeUpdate();
	
			System.out.println(cnt > 0 ? "등록 되었습니다." : "등록 실패했습니다.");
	
			selectRs.close();
			addStmt.close();
			selectStmt.close();
			con.close();
		}catch(SQLException | ClassNotFoundException e){
				try {
					selectRs.close();
					addStmt.close();
					selectStmt.close();
					con.close();
				} catch (SQLException e1) {
					System.out.println(e1);
				}
				System.out.println(e);
		}
	}

	public void setFood(int foodId, Date sellLife, int foodLife, int keepAreaId)
			throws SQLException, ClassNotFoundException {

		String sql = "UPDATE FOOD SET SELL_LIFE = ?, FOOD_LIFE = ?, KEEP_AREA_ID = ? WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);

		if (sellLife == null)
			pstmt.setString(1, null);
		else
			pstmt.setDate(1, sellLife);

		pstmt.setInt(2, foodLife);
		pstmt.setInt(3, keepAreaId);
		pstmt.setInt(4, foodId);

		int cnt = pstmt.executeUpdate();

		System.out.println(cnt > 0 ? "수정 완료." : "수정 실패했습니다.");

		pstmt.close();
		con.close();

	}

	public void deleteFood(String[] values) {

		String sql = "DELETE FROM FOOD WHERE ID = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			
			for(String v : values) {
				
				pstmt.setString(1, v);
				int cnt = pstmt.executeUpdate();
		
				System.out.println(cnt > 0 ? "식재료를 삭제했습니다" : "삭제실패");
			
			}
			
			pstmt.close();
			con.close();
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e1) {
				System.out.println(e);
			}
		}

	}

	public Food getFoodDetail(int foodId) throws SQLException, ClassNotFoundException {

		Food food = new Food();

		String sql = "SELECT * FROM FOOD WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, foodId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			food.setName(rs.getString("NAME"));
			food.setFoodLife(rs.getInt("FOOD_LIFE"));
			food.setSellLife(rs.getDate("SELL_LIFE"));
			food.setFoodCateId(rs.getInt("FOOD_CATE_ID"));
			food.setKeepAreaId(rs.getInt("KEEP_AREA_ID"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return food;
	}
	
	public List<FoodCate> getFoodCateList() throws SQLException, ClassNotFoundException{
			
			List<FoodCate> list = new ArrayList<>();
			
			String sql = "SELECT * FROM FOOD_CATE";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				FoodCate fc = new FoodCate(rs.getInt("ID"), rs.getString("NAME"));
				
				list.add(fc);
				
			}
			
			con.close();
			stmt.close();
			rs.close();
			
		return list;
		
	}
	
	public List<Food> getMetaFoodList() throws SQLException, ClassNotFoundException{
		
		List<Food> list = new ArrayList<>();
		
		String sql = "SELECT * FROM KEEP_TIP";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
			
		while(rs.next()) {
			
			Food food = new Food(rs.getString("NAME"),
						rs.getInt("FOOD_CATE_ID"));
			
			list.add(food);
			
		}
		
		con.close();
		stmt.close();
		rs.close();
		
		return list;
	}
	
	public void setFoodUse(String[] values){
		
		String sql = "update food set use_date = sysdate where id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			
			for(String v : values) {
			
				pstmt.setString(1, v);
	
				int cnt = pstmt.executeUpdate();
	
				System.out.println(cnt > 0 ? "수정완료" : "수정실패");
				
			}
			pstmt.close();
			con.close();
		}catch(ClassNotFoundException | SQLException e) {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e1) {
				System.out.println(e1);
			}
			System.out.println(e);
		}
		
	}
}
