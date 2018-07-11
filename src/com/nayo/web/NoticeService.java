package com.nayo.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nayo.web.entity.Notice;

public class NoticeService {
	
	public List<Notice> getNoticeList(int page) throws ClassNotFoundException, SQLException {
		return getNoticeList("title", "", page);
	}
	
public List<Notice> getNoticeList(String field, String query, int page) throws ClassNotFoundException, SQLException {
		
		List<Notice> list = new ArrayList();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "SELECT C.NAME, N.ID, N.TITLE, N.CONTENT, N.REG_ID, N.REG_DATE "
					+ "FROM NOTICE N "
					+ "INNER JOIN NOTICE_CATE C "
					+ "ON N.NOTICE_CATE_ID = C.ID";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement st = con.prepareStatement(sql);		
		
		ResultSet rs = st.executeQuery();
			
		while(rs.next()) {		
			Notice notice = new Notice(rs.getString("NAME"),
									   rs.getString("ID"),
									   rs.getString("TITLE"),
									   rs.getString("CONTENT"),
									   rs.getString("REG_ID"),
									   rs.getDate("REG_DATE"));
			
			list.add(notice);
		}

		
		rs.close();
	    st.close();
	    con.close();
	      
		return list;

	}
	
	public int getNoticeCount(String field, String query) throws ClassNotFoundException, SQLException {
		int count = 0;
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	    String user = "c##nayoadmin";
	    String password = "skdy0514";
	      
	    String sql = "SELECT COUNT(ID) COUNT "
	    			+ "FROM NOTICE "
	    			+ "WHERE "+field+" LIKE ?";
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con = DriverManager.getConnection(url, user, password);      
	    PreparedStatement st = con.prepareStatement(sql);
	    st.setString(1, "%"+query+"%");
		
	    ResultSet rs = st.executeQuery();
		
	    if(rs.next())
	    	count = rs.getInt("COUNT");
		
	    rs.close();
	    st.close();
	    con.close();
	      
		return count;
}
}
