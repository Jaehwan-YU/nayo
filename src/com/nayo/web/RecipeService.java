package com.nayo.web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.nayo.web.entity.Recipe;
import com.nayo.web.entity.RecipeCate;

public class RecipeService {
	private String url;
	private String user;
	private String password;

	public RecipeService() {
		
	}
	public RecipeService(ServletContext servletContext) throws IOException {
		InputStream is = servletContext.getResourceAsStream("WEB-INF/db.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}

	public List<Recipe> getRecipeList(){
		
		List<Recipe> tempList = new ArrayList<Recipe>();
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
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
						rs.getString("MAIN_IMG"),
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
	
public List<Recipe> getRecipeList(String memberEmail) throws ClassNotFoundException, SQLException{
	
		List<Recipe> tempList = new ArrayList<Recipe>();
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "SELECT * FROM RECIPE WHERE REG_EMAIL = ?";
		
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
			tempList.add(recipe);
		}
		
		con.close();
		st.close();
		rs.close();
		
		return tempList;
	}

	public Recipe getRecipe(int id) {
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
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
						rs.getString("MAIN_IMG"),
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
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "INSERT INTO RECIPE(ID, TITLE, SIMPLE_INTRO, MAIN_IMG, REG_EMAIL, KCALORY, NATIONAL_ID,"
				+ "SITUATION_ID, RECIPE_TYPE_ID) "
				+ "VALUES(RECIPE_SEQ.nextval,?,?,?,?,?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, recipe.getTitle());
		pstmt.setString(2, recipe.getSimpleIntro());
		pstmt.setString(3, recipe.getMainImg());
		pstmt.setString(4, recipe.getRegEmail());
		pstmt.setInt(5, recipe.getKcalory());
		pstmt.setInt(6, recipe.getNationalId());
		pstmt.setInt(7, recipe.getSituationId());
		pstmt.setInt(8, recipe.getRecipeTypeId());
		
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0?"등록완료":"등록실패");
	
	}
	
		
	public void setRecipe(Recipe recipe) throws ClassNotFoundException, SQLException {
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "UPDATE RECIPE SET "
				+ "TITLE = ?, "
				+ "SIMPLE_INTRO = ?, "
				+ "MAIN_IMG = ?, "
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
		pstmt.setString(3, recipe.getMainImg());
		pstmt.setInt(5, recipe.getKcalory());
		pstmt.setInt(6, recipe.getNationalId());
		pstmt.setInt(7, recipe.getSituationId());
		pstmt.setInt(8, recipe.getRecipeTypeId());
		pstmt.setInt(9, recipe.getId());
		
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt>0?"수정 완료":"수정 실패");
	
	}
	
	public List<Recipe> getCookableRecipeList(String memberEmail) throws ClassNotFoundException, SQLException{
		
		List<Recipe> list = new ArrayList<>();
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "select (m.point-n.point2) point, m.recipe_id from \r\n" + 
				"(select recipe_ID, sum(point) point from\r\n" + 
				"(select recipe_id, case when main_or_sub = 1 then count*10 else count end point from \r\n" + 
				"(select recipe_id, main_or_sub, count(ID) count from ingredients group by recipe_id, main_or_sub)) \r\n" + 
				"group by recipe_id) m inner join \r\n" + 
				"(select sum(point) point2, recipe_id from \r\n" + 
				"(select recipe_id, main_or_sub, case when main_or_sub =1 then count_f*10 else count_f end point from \r\n" + 
				"(select count(i.id) count_f, recipe_id, main_or_sub from ingredients i inner join \r\n" + 
				"(select * from food where reg_email = ?) f on i.name = f.name group by recipe_id, main_or_sub)) \r\n" + 
				"group by recipe_id) n on m.recipe_id = n.recipe_id order by point";
		
		String sql2 = "select*from recipe where id = ?";
				
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt.setString(1, memberEmail);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()) {
			pstmt2.setString(1, rs.getString("recipe_id"));
			ResultSet rs2 = pstmt2.executeQuery();
						if(rs2.next()) {
							Recipe recipe = new Recipe(rs2.getInt("id"),
									rs2.getString("title"),
									rs2.getString("simple_intro"), 
									rs2.getString("MAIN_IMG"));
							
							list.add(recipe);
							
							rs2.close();
						}
		}
		rs.close();
		pstmt2.close();
		pstmt.close();
		con.close();
		
		return list;
	}
	
	public List<ArrayList<RecipeCate>> getRecipeCateList() throws SQLException, ClassNotFoundException{
			
		List<ArrayList<RecipeCate>> list = new ArrayList<>();
		ArrayList<RecipeCate> national = new ArrayList<>();
		ArrayList<RecipeCate> situation = new ArrayList<>();
		ArrayList<RecipeCate> recipeType = new ArrayList<>();
		
		String sql1 = "select * from national";
		String sql2 = "select * from situation";
		String sql3 = "select * from recipe_type";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt1 = con.createStatement();
		Statement stmt2 = con.createStatement();
		Statement stmt3 = con.createStatement();
		
		ResultSet rs1 = stmt1.executeQuery(sql1);
		ResultSet rs2 = stmt2.executeQuery(sql2);
		ResultSet rs3 = stmt3.executeQuery(sql3);
		
		while(rs1.next()) {
			RecipeCate rc = new RecipeCate(rs1.getString("name"), rs1.getInt("id"));
			national.add(rc);
		}
		
	 	while(rs2.next()) {
			RecipeCate rc = new RecipeCate(rs2.getString("name"), rs2.getInt("id"));
			situation.add(rc);
			
		}
		while(rs3.next()) {
			RecipeCate rc = new RecipeCate(rs3.getString("name"), rs3.getInt("id"));
			recipeType.add(rc);
		}
		
		list.add(national);
		list.add(situation);
		list.add(recipeType);
		
		rs3.close();
		rs2.close();
		rs1.close();
		stmt3.close();
		stmt2.close();
		stmt1.close();
		con.close();
		
		return list;
	}
	
}
