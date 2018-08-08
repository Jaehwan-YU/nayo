package com.nayo.web.entity;

import java.sql.Date;

public class Menu {
	private String regEmail;
	private Date menuDate;
	private int mill;
	private int recipeId;
	private int id;
	private String title;
	private String menuPic;
	

	public Menu() {
		
	}

	public Menu(String regEmail, Date menuDate, int mill, int recipeId, int id, String title, String menuPic) {
		this.regEmail = regEmail;
		this.menuDate = menuDate;
		this.mill = mill;
		this.recipeId = recipeId;
		this.id = id;
		this.title = title;
		this.menuPic = menuPic;
	}
	
	public String getRegEmail() {
		return regEmail;
	}

	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}

	public Date getMenuDate() {
		return menuDate;
	}

	public void setMenuDate(Date menuDate) {
		this.menuDate = menuDate;
	}

	public int getMill() {
		return mill;
	}

	public void setMill(int mill) {
		this.mill = mill;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
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
	
	public String getMenuPic() {
		return menuPic;
	}
	
	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}

	@Override
	public String toString() {
		return "Menu [regEmail=" + regEmail + ", menuDate=" + menuDate + ", mill=" + mill + ", recipeId=" + recipeId
				+ ", id=" + id + ", title=" + title + ", menuPic=" + menuPic + "]";
	}

	
	
}
