package com.nayo.web.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nayo.web.entity.Food;

public class FoodService {

	Food food;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		FoodService fs = new FoodService();
		Date date = null;

		fs.addFood("woghks2045@gmail.com", "닭고기");

	}

	public FoodService() {
		food = new Food();
	}

	public List<Food> getFoodList(String memberEmail, int keepArea) throws ClassNotFoundException, SQLException {
		List<Food> list = new ArrayList<Food>();

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "SELECT * FROM FOOD WHERE REG_EMAIL = ? AND KEEP_AREA_ID = ? AND USE_DATE IS NULL";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail);
		pstmt.setInt(2, keepArea);
		ResultSet rs = pstmt.executeQuery();


		while (rs.next()) {
			food = new Food(rs.getString("ID"),
					rs.getString("NAME"), 
					rs.getInt("FOOD_LIFE"), 
					rs.getDate("SELL_LIFE"));
			// System.out.println(shop);
			list.add(food);
		}
		rs.close();
		pstmt.close();
		con.close();

		return list;
	}

	public void addFood(String memberEmail, String foodName) throws SQLException, ClassNotFoundException {

		int foodLife = 90;
		int foodCateId = 1;
		int keepAreaId = 1;
		String foodImg = "default img";

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String addSql = "INSERT INTO FOOD(ID, NAME, FOOD_LIFE, REG_EMAIL, FOOD_CATE_ID, KEEP_AREA_ID, FOOD_IMG)"
				+ " VALUES(FOOD_SEQ.nextval, ?, ?, ?, ?, ?, ?)";

		String selectSql = "SELECT * FROM KEEP_TIP WHERE NAME = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement selectStmt = con.prepareStatement(selectSql);
		PreparedStatement addStmt = con.prepareStatement(addSql);

		selectStmt.setString(1, foodName);

		ResultSet selectRs = selectStmt.executeQuery();

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

		int cnt = addStmt.executeUpdate();

		System.out.println(cnt > 0 ? "등록 되었습니다." : "등록 실패했습니다.");

		selectRs.close();
		addStmt.close();
		selectStmt.close();
		con.close();
	}

	public void setFood(int foodId, Date sellLife, int foodLife, int keepAreaId)
			throws SQLException, ClassNotFoundException {

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

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

	public void deleteFood(int foodId) throws SQLException, ClassNotFoundException {

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "DELETE FROM FOOD WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, foodId);
		int cnt = pstmt.executeUpdate();

		System.out.println(cnt > 0 ? "식재료를 삭제했습니다" : "삭제실패");

		pstmt.close();
		con.close();

	}

	public Food getFoodDetail(int foodId) throws SQLException, ClassNotFoundException {

		Food food = new Food();

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

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
}
