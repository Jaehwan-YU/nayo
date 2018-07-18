package com.nayo.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nayo.web.entity.Member;

public class MyInfoService {
	
	
	public Member getMemberInfo(String memberEmail, String pwd) throws SQLException, ClassNotFoundException {
		
		Member member = new Member();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "SELECT * FROM MEMBER WHERE EMAIL = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, memberEmail);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			member.setEmail(rs.getString("EMAIL"));
			member.setPwd(rs.getString("PWD"));
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
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

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
}
