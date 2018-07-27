package com.nayo.web.entity;



public class Bookmark {
	private String recipeId;
	private String regEmail;
	
	public Bookmark() {
		
	}
	
	public Bookmark(String recipeId, String regEmail) {
		this.recipeId = recipeId;
		this.regEmail = regEmail;
	}
	
	public String getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

	public String getRegEmail() {
		return regEmail;
	}

	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}

	@Override
	public String toString() {
		return "Bookmark [recipeId=" + recipeId + ", regEmail=" + regEmail + "]";
	}
	
}
