package com.nayo.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nayo.web.entity.Notice;
import com.nayo.web.member.ShopbagService;

public class NoticeService {
	
	private Notice notice;
	private List<Notice> noticeList;

	public void NoticeService() {
		
		notice = new Notice();
		noticeList = new ArrayList<Notice>();
		
		
	}
	
	public NoticeService(Notice notice) {
		this.notice = notice;
		this.noticeList = new ArrayList<Notice>();
		
	}
	
	public NoticeService(List<Notice> noticeList) {
		this.notice = new Notice();
		this.noticeList = noticeList;
	}
	
	public List<Notice> getNoticeList() throws ClassNotFoundException, SQLException {
		
		List<Notice> tempList = new ArrayList<Notice>();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String user = "c##nayoadmin";
		String password = "skdy0514";

		String sql = "SELECT C.NAME, N.ID, N.TITLE, N.CONTENT, N.REG_ID, N.REG_DATE"
					+ "FROM NOTICE N"
					+ "INNER JOIN NOTICE_CATE C"
					+ "ON N.NOTICE_CATE_ID = C.ID";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
			
		while(rs.next()) {		
			Notice notice = new Notice(rs.getString("ID"),
									   rs.getString("TITLE"),
									   rs.getString("CONTENT"),
									   rs.getString("REG_DATE"),
									   rs.getString("REG_ID"),
									   rs.getString("NAME"));
			
			tempList.add(notice);
		}
		return tempList;

	}
	
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}

}
