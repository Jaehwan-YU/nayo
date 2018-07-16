package com.nayo.web.entity;

import java.sql.Date;

public class Notice {
		
	private int id;
	private String title;
	private String content;
	private Date regDate;
	private String regId;
	private String noticeCate;
	
	
	public Notice() {
		
	}
	
	public Notice(int id, String title, Date regDate, String content, String regId, String noticeCate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.regId = regId;
		this.noticeCate = noticeCate;
	}
	public Notice(int id, String title, Date regDate, String content, String regId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.regId = regId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
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

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", regId="
				+ regId + ", noticeCate=" + noticeCate + "]";
	}
	
}
