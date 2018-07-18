package com.nayo.web;

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

	public List<Recipe> getRecipeList(){
		
		List<Recipe> tempList = new ArrayList<Recipe>();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
		String sql = "SELECT "
				+"N.NAME N"
				+", S.NAME S"
				+", T.NAME T"
				+", R.* FROM RECIPE R "
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
						rs.getInt("ID"),
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
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return tempList;
	}
	
	public Recipe getRecipe(int id) {
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
		String sql = "SELECT "
				+"N.NAME N"
				+", S.NAME S"
				+", T.NAME T"
				+", R.* FROM RECIPE R "
				+"INNER JOIN NATIONAL N "
				+"ON N.ID = R.NATIONAL_ID "
				+"INNER JOIN SITUATION S "
				+"ON S.ID = R.SITUATION_ID "
				+"INNER JOIN RECIPE_TYPE T "
				+"ON T.ID = R.RECIPE_TYPE_ID WHERE R.ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try {
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				Recipe temp = new Recipe(
						rs.getInt("ID"),
						rs.getString("TITLE"),
						rs.getString("SIMPLE_INTRO"), 
						rs.getString("PROCESS"),
						rs.getString("REG_EMAIL"),
						rs.getInt("KCALORY"),
						rs.getString("N"),
						rs.getString("S"), 
						rs.getString("T")
						);
							
				rs.close();
				pstmt.close();
				con.close();
				
				return temp;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void addRecipe(Recipe recipe) throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
		String sql = "INSERT INTO RECIPE(ID, TITLE, SIMPLE_INTRO, PROCESS, REG_EMAIL, KCALORY, NATIONAL_ID,"
				+ "SITUATION_ID, RECIPE_TYPE_ID) "
				+ "VALUES(RECIPE_SEQ.nextval,?,?,?,?,?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, recipe.getTitle());
		pstmt.setString(2, recipe.getSimpleIntro());
		pstmt.setString(3, recipe.getProcess());
		pstmt.setString(4, recipe.getRegEmail());
		pstmt.setInt(5, recipe.getKcalory());
		pstmt.setInt(6, recipe.getNationalId());
		pstmt.setInt(7, recipe.getSituationId());
		pstmt.setInt(8, recipe.getRecipeTypeId());
		
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0?"등록완료":"등록실패");
	
	}
	
		
	public void setRecipe(Recipe recipe) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";
		
		String sql = "UPDATE RECIPE SET "
				+ "TITLE = ?, "
				+ "SIMPLE_INTRO = ?, "
				+ "PROCESS = ?, "
				+ "KCALORY = ?, "
				+ "NATIONAL_ID = ?, "
				+ "SITUATION_ID = ?, "
				+ "RECIPE_TYPE_ID = ? "
				+ "WHERE ID = ?";
				
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, recipe.getTitle());
		pstmt.setString(2, recipe.getSimpleIntro());
		pstmt.setString(3, recipe.getProcess());
		pstmt.setInt(5, recipe.getKcalory());
		pstmt.setInt(6, recipe.getNationalId());
		pstmt.setInt(7, recipe.getSituationId());
		pstmt.setInt(8, recipe.getRecipeTypeId());
		pstmt.setInt(9, recipe.getId());
		
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0?"수정 완료":"수정 실패");
	
	}
		
}
