package com.nayo.web.entity;

public class Process {
	private int recipeId;
	private int processNumber;
	private String content;
	private String img;
	
	public Process(int recipeId, int processNumber, String content, String img) {
		super();
		this.recipeId = recipeId;
		this.processNumber = processNumber;
		this.content = content;
		this.img = img;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getProcessNumber() {
		return processNumber;
	}

	public void setProcessNumber(int processNumber) {
		this.processNumber = processNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
}
