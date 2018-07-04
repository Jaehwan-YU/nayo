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
		
		String sql = "SELECT R.ID "
				+", TITLE "
				+", SIMPLE_INTRO "
				+", PROCESS "
				+", REG_EMAIL "
				+", KCALORY "
				+", N.NAME N"
				+", S.NAME S"
				+", T.NAME T"
				+" FROM RECIPE R "
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
						rs.getString("ID"),
						rs.getString("TITLE"),
						rs.getString("SIMPLE_INTRO"), 
						rs.getString("PROCESS"),
						rs.getString("REG_EMAIL"),
						rs.getInt("KCALORY"),
						rs.getString("N"),
						rs.getString("S"), 
						rs.getString("T")
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
		//������ �Է� ���� ���� ����
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
