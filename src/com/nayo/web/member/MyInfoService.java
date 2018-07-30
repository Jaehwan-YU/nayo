package com.nayo.web.member;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.nayo.web.entity.Member;

public class MyInfoService {
	private String url;
	private String user;
	private String password;
	
	public MyInfoService(ServletContext servletContext) throws IOException {
		InputStream is = servletContext.getResourceAsStream("WEB-INF/db.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}


	public Member getMemberInfo(String memberEmail) throws SQLException, ClassNotFoundException {
		
		Member member = new Member();
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/

		String sql = "SELECT * FROM MEMBER WHERE EMAIL = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, memberEmail);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			member.setEmail(rs.getString("EMAIL"));
			member.setNickname(rs.getString("NICKNAME"));
			member.setBirth(rs.getString("BIRTH"));
			member.setGender(rs.getInt("GENDER"));
			member.setIntro(rs.getString("INTRO"));
			member.setProfilepic(rs.getString("PROFILEPIC"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		
		return  member;
	}
	

	public void setMemberInfo(Member member) throws SQLException, ClassNotFoundException {
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/

		String sql = "UPDATE MEMBER SET PWD = ?, NICKNAME = ?, BIRTH = ?, GENDER = ?, INTRO = ?, PROFILEPIC = ? "
				+ "WHERE EMAIL = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, member.getPwd());
		pstmt.setString(2, member.getBirth());
		pstmt.setInt(3, member.getGender());
		pstmt.setString(4, member.getIntro());
		pstmt.setString(5, member.getProfilepic());
		pstmt.setString(6, member.getEmail());
		
		int cnt = pstmt.executeUpdate();

		System.out.println(cnt>0? "수정완료":"수정실패");
		
		pstmt.close();
		con.close();
		
		
	}
	
	public boolean login(String memberEmail, String pwd) throws SQLException, ClassNotFoundException {
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/
		
		String sql = "SELECT PWD FROM MEMBER WHERE EMAIL = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, memberEmail);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			if(rs.getString("PWD").equals(pwd)) {
				
				rs.close();
				pstmt.close();
				con.close();
				
				return true;
			}
			else {
				rs.close();
				pstmt.close();
				con.close();
				
				return false;
			}
				
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return false;
	}
	
	public void SignUp(String memberEmail, String pwd, String nickname) throws SQLException, ClassNotFoundException {
		
		Member member = new Member();
		
		/*String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";*/

		String sql = "INSERT INTO MEMBER(EMAIL, PWD, NICKNAME) "
					+ "VALUES(?,?,?)";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, memberEmail);
		pstmt.setString(2, pwd);
		pstmt.setString(3, nickname);

		ResultSet rs = pstmt.executeQuery();

		
		rs.close();
		pstmt.close();
		con.close();

	}
	
}
