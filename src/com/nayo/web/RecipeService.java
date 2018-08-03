package com.nayo.web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.nayo.web.entity.Ingredients;
import com.nayo.web.entity.Process;
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
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
		} catch (ClassNotFoundException e) {
			
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public ArrayList<Ingredients> getIgredients(int recipeId) {
		
		ArrayList<Ingredients> list = new ArrayList<>();
		
		String sql = "select * from ingredients where recipe_id = ?";
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			st = con.prepareStatement(sql);
			st.setInt(1, recipeId);
			rs = st.executeQuery();
			
			while(rs.next()) {
				Ingredients ing = new Ingredients(rs.getInt("ID"),
						rs.getInt("RECIPE_ID"), 
						rs.getString("NAME"),
						rs.getString("QUANTITY"),
						rs.getInt("MAIN_OR_SUB"));
				
				list.add(ing);
			}
			
			rs.close();
			st.close();
			con.close();
			
			return list;
			
		} catch (SQLException | ClassNotFoundException e) {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<com.nayo.web.entity.Process> getProcess(int recipeId){
		
		ArrayList<com.nayo.web.entity.Process> list = new ArrayList<>();
		
		String sql = "select * from process where recipe_id = ?";
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			st = con.prepareStatement(sql);
			st.setInt(1, recipeId);
			rs = st.executeQuery();
			
			while(rs.next()) {
				Process process  = new Process(rs.getInt("RECIPE_ID"),
						rs.getInt("PROCESS_NUMBER"),
						rs.getString("CONTENT"),
						rs.getString("img"));
				
				list.add(process);
			}
			
			rs.close();
			st.close();
			con.close();
			
			return list;
			
		} catch (SQLException | ClassNotFoundException e) {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void addRecipe(Recipe recipe, ArrayList<String[]> mainIngValues, ArrayList<String[]> subIngValues, ArrayList<String[]> processValues){
		
		String sql1 = "INSERT INTO RECIPE(ID, TITLE, SIMPLE_INTRO, MAIN_IMG, REG_EMAIL, KCALORY, NATIONAL_ID,"
				+ "SITUATION_ID, RECIPE_TYPE_ID) "
				+ "VALUES(RECIPE_SEQ.nextval,?,?,?,?,?,?,?,?)";
		
		String sql2 = "INSERT INTO INGREDIENTS(ID, RECIPE_ID, NAME, QUANTITY, MAIN_OR_SUB)"
				+ " VALUES(INGREDIENTS_SEQ.nextval, RECIPE_SEQ.currval, ?, ?, ?)";
		
		String sql3 = "INSERT INTO PROCESS(RECIPE_ID,PROCESS_NUMBER,CONTENT,IMG)"
				+ " VALUES(RECIPE_SEQ.currval,?,?,?)";
	
		int id = 0;
		
		Connection con = null;
		Savepoint sp = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		try {
		con = DriverManager.getConnection(url, user, password);
		con.setAutoCommit(false);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		sp = con.setSavepoint();
		
		pstmt1 = con.prepareStatement(sql1);
		pstmt2 = con.prepareStatement(sql2);
		pstmt3 = con.prepareStatement(sql2);
		pstmt4 = con.prepareStatement(sql3);
		//recipe 등록 sql 셋팅
		pstmt1.setString(1, recipe.getTitle());
		pstmt1.setString(2, recipe.getSimpleIntro());
		pstmt1.setString(3, recipe.getMainImg());
		pstmt1.setString(4, recipe.getRegEmail());
		pstmt1.setInt(5, recipe.getKcalory());
		pstmt1.setInt(6, recipe.getNationalId());
		pstmt1.setInt(7, recipe.getSituationId());
		pstmt1.setInt(8, recipe.getRecipeTypeId());
		
		int recipeUp = pstmt1.executeUpdate();
		System.out.println(recipeUp>0?"레시피 등록성공" : "등록 실패");
		//ingredients 등록
		for(String[] s : mainIngValues) {
			pstmt2.setString(1,s[0]);
			pstmt2.setString(2,s[1]);
			pstmt2.setInt(3,1);
			int cnt = pstmt2.executeUpdate();
			System.out.println(cnt>0?"등록완료":"등록실패");
		}
		for(String[] s : subIngValues) {
			pstmt3.setString(1,s[0]);
			pstmt3.setString(2,s[1]);
			pstmt3.setInt(3,2);
			
			int cnt = pstmt3.executeUpdate();
			
			System.out.println(cnt>0?"등록완료":"등록실패");
		}
		
		int count = 0;
		for(String[] s : processValues) {	
			count++;
			pstmt4.setInt(1, count);
			pstmt4.setString(2, s[0]);
			pstmt4.setString(3, s[1]);
			
			int cnt = pstmt4.executeUpdate();
			System.out.println(cnt>0?"등록완료":"등록실패");
		}

		con.commit();
		pstmt1.close();
		pstmt2.close();
		pstmt3.close();
		pstmt4.close();
		con.close();
	
		}catch(Exception e){
			try {
				con.rollback(sp);
				pstmt1.close();
				pstmt2.close();
				pstmt3.close();
				pstmt4.close();
				con.close();
			} catch (SQLException e1) {
				System.out.println(e1);
			}
			System.out.println(e);
		}
		
		
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
				"(select * from food where reg_email = ? and use_date is null) f on i.name = f.name group by recipe_id, main_or_sub)) \r\n" + 
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
