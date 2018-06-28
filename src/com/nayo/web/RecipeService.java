package com.nayo.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipeService {

	private List<Recipe> recipeList;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		RecipeService test = new RecipeService();
		
		test.recipeList = new ArrayList<Recipe>();
		
		test.getRecipeList();
		
		test.printRecipeList();
		
	}
	
	void RecipeService() {
		
	}
	

	void getRecipeList() throws SQLException, ClassNotFoundException {
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
		String sql = "SELECT R.ID �Խù�ȣ"
				+", TITLE ���ĸ�"
				+", SIMPLE_INTRO ���ټҰ�"
				+", PROCESS ��������"
				+", REG_EMAIL �����"
				+", KCALORY ����"
				+", N.NAME ����"
				+", S.NAME ��Ȳ"
				+", T.NAME ���� "
				+"FROM RECIPE R "
				+"INNER JOIN NATIONAL N "
				+"ON N.ID = R.NATIONAL_ID "
				+"INNER JOIN SITUATION S "
				+"ON S.ID = R.SITUATION_ID "
				+"INNER JOIN RECIPE_TYPE T "
				+"ON T.ID = R.RECIPE_TYPE_ID";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
	
		while(rs.next()) {
		
		Recipe temp = new Recipe(
				rs.getString("�Խù�ȣ"),
				rs.getString("���ĸ�"),
				rs.getString("���ټҰ�"), 
				rs.getString("��������"),
				rs.getString("�����"),
				rs.getInt("����"),
				rs.getString("����"),
				rs.getString("��Ȳ"), 
				rs.getString("����")
				);
	
		
		this.recipeList.add(temp);
		
		}
	}
	
	void getRecipe() {
		
	}
	
	void addRecipe() {
		
	}
	
	void setRecipe() {
		
	}
	
	void printRecipeList() {
		
		for(int i=0; i<this.recipeList.size();i++) {
		System.out.print(this.recipeList.get(i).getId()
				+this.recipeList.get(i).getTitle()
				+this.recipeList.get(i).getSimpleIntro()
				+this.recipeList.get(i).getKcalory()
				+this.recipeList.get(i).getNational()
				+this.recipeList.get(i).getSituation()
				+this.recipeList.get(i).getRecipeType()
				+this.recipeList.get(i).getRegEmail()
				+this.recipeList.get(i).getProcess()
				);
		}
	}	
}
