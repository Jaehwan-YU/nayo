package com.nayo.web.entity;

public class Report {
	
	private String reportEmail;
	private String recipeId;
	private String reportCate;
	private String content;
	
	
	
	
	public Report(String reportEmail, String recipeId, String reportCate, String content) {

		this.reportEmail = reportEmail;
		this.recipeId = recipeId;
		this.reportCate = reportCate;
		this.content = content;
	}
	
	public String getReportEmail() {
		return reportEmail;
	}
	public void setReportEmail(String reportEmail) {
		this.reportEmail = reportEmail;
	}
	public String getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}
	public String getReportCate() {
		return reportCate;
	}
	public void setReportCate(String reportCate) {
		this.reportCate = reportCate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Report [reportEmail=" + reportEmail + ", recipeId=" + recipeId + ", reportCate=" + reportCate
				+ ", content=" + content + "]";
	}
	
}
