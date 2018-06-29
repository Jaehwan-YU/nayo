package com.nayo.web.entity;

public class Notice {
		
	private String id;
	private String title;
	private String content;
	private String regDate;
	private String regId;
	private String noticeCate;
	
	
	
	public Notice(String id, String title, String content, String regDate, String regId, String noticeCate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.regId = regId;
		this.noticeCate = noticeCate;
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
	public String getNoticeCate() {
		return noticeCate;
	}
	public void setNoticeCate(String noticeCate) {
		this.noticeCate = noticeCate;
	}
	
}
