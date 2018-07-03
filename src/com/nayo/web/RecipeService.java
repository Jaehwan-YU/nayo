package com.nayo.web;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;

import com.nayo.web.entity.Recipe;

public class RecipeService {

	private List<Recipe> recipeList;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		RecipeService test = new RecipeService();
		
		test.recipeList = new ArrayList<Recipe>();
		
		test.setRecipeList();
		
		test.printRecipeList();
	}
	
	void RecipeService() {
		
	}
	

	public List<Recipe> getRecipeList(){
		
		
		
		List<Recipe> tempList = new ArrayList<Recipe>();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
		String sql = "SELECT R.ID 게시번호"
				+", TITLE 음식명"
				+", SIMPLE_INTRO 한줄소개"
				+", PROCESS 조리과정"
				+", REG_EMAIL 등록자"
				+", KCALORY 열량"
				+", N.NAME 국가"
				+", S.NAME 상황"
				+", T.NAME 종류 "
				+"FROM RECIPE R "
				+"INNER JOIN NATIONAL N "
				+"ON N.ID = R.NATIONAL_ID "
				+"INNER JOIN SITUATION S "
				+"ON S.ID = R.SITUATION_ID "
				+"INNER JOIN RECIPE_TYPE T "
				+"ON T.ID = R.RECIPE_TYPE_ID";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				Recipe temp = new Recipe(
						rs.getString("게시번호"),
						rs.getString("음식명"),
						rs.getString("한줄소개"), 
						rs.getString("조리과정"),
						rs.getString("등록자"),
						rs.getInt("열량"),
						rs.getString("국가"),
						rs.getString("상황"), 
						rs.getString("종류")
						);
				
				
				tempList.add(temp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return tempList;
	}
	
	void getRecipe() {
		
	}
	
	void addRecipe() {
		//웹에서 입력 받은 값을 저장
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
	}
	
	void setRecipe() {
		
	}
	
	public void setRecipeList() throws ClassNotFoundException, SQLException {
		this.recipeList = getRecipeList();
	}
	
	public void printRecipeList() {
		
		for(int i=0; i<recipeList.size();i++) {
		System.out.println(recipeList.get(i).getId()
				+recipeList.get(i).getTitle()
				+recipeList.get(i).getSimpleIntro()
				+recipeList.get(i).getKcalory()
				+recipeList.get(i).getNational()
				+recipeList.get(i).getSituation()
				+recipeList.get(i).getRecipeType()
				+recipeList.get(i).getRegEmail()
				+recipeList.get(i).getProcess()
				);
		}
	}	
}
