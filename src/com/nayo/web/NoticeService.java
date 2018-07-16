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

		String sql = "SELECT *\r\n" + 
					"FROM(SELECT ROWNUM NUM, N.*\r\n" + 
					"    FROM(SELECT C.NAME, N.ID, N.TITLE, N.CONTENT, N.REG_ID, N.REG_DATE\r\n" + 
					"        FROM(SELECT *\r\n" + 
					"            FROM NOTICE\r\n" + 
					"            WHERE "+field+" LIKE ?) N\r\n" + 
					"        INNER JOIN NOTICE_CATE C\r\n" + 
					"        ON N.NOTICE_CATE_ID = C.ID\r\n" + 
					"        ORDER BY REG_DATE DESC) N)\r\n" + 
					"WHERE NUM BETWEEN ? AND ?";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, (page-1)*10+1);
	    st.setInt(3, page*10);
		
		ResultSet rs = st.executeQuery();
			
		while(rs.next()) {		
			Notice notice = new Notice(rs.getInt("ID"),
									   rs.getString("TITLE"),
									   rs.getDate("REG_DATE"),
									   rs.getString("CONTENT"),
									   rs.getString("REG_ID"),
									   rs.getString("NAME"));
			
			list.add(notice);
		}

		
		rs.close();
	    st.close();
	    con.close();
	      
		return list;

	}

	public Notice getNotice(int id) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "SELECT * " + 
					"FROM NOTICE " +
					"WHERE ID = ?";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
			
		while(rs.next()) {		
			Notice notice = new Notice(rs.getInt("ID"),
									   rs.getString("TITLE"),
									   rs.getDate("REG_DATE"),
									   rs.getString("CONTENT"),
									   rs.getString("REG_ID"));
			
			rs.close();
		    st.close();
		    con.close();
		    
			return notice;
		}
		return null;
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
