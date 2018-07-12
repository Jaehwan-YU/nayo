package com.nayo.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nayo.web.entity.Food;

public class FoodService {
	
	Food food;
	
	public FoodService() {
		food = new Food();
	}
	
	public List<Food> getFoodList(String memberEmail, int keepArea) throws ClassNotFoundException, SQLException	{
		List<Food> list = new ArrayList<Food>();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "SELECT * FROM FOOD WHERE REG_EMAIL = ? AND KEEP_AREA_ID = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberEmail);
		pstmt.setInt(2, keepArea);
		ResultSet rs = pstmt.executeQuery();
			
		while(rs.next()) {		
			food = new Food(rs.getString("NAME"),rs.getString("SELL_LIFE"));
			//System.out.println(shop);
			list.add(food);		
			}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}	
	void addFood(String memberEmail, String foodName){
		
	}
	void setFood(String foodId){
		
	}
	void deleteFood(String foodId){
		
	}
	
	public Food getFoodDetail() {
		
		
		return food;
	}
}
