package com.nayo.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nayo.web.member.ShopbagService;

public class NoticeService {
	
	private String id;
	private String title;
	private String content;
	private String regDate;
	private String regId;
	private String cateName;

	public void NoticeService() {
		this.id = null;
		this.title = null;
		this.content = null;
		this.regDate = null;
		this.regId = null;
		this.cateName = null;
	}
	
	public NoticeService(String cateName, String id, String title,
			String content, String regId,String regDate) {
		this.cateName = cateName;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regId = regId;
		this.regDate = regDate;
	}
	
	public List<NoticeService> getNoticeList(NoticeService noticeService) throws ClassNotFoundException, SQLException {
		List<NoticeService> list = new ArrayList<NoticeService>();
		
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
			NoticeService notice = new NoticeService(rs.getString("CATE_NAME"),
													rs.getString("ID"),
													rs.getString("TITLE"),
													rs.getString("CONTENT"),
													rs.getString("REG_ID"),
													rs.getString("REG_DATE"));
			//System.out.println(shop);
			list = notice.getNoticeList(noticeService);
		}
		
		return list;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
}
