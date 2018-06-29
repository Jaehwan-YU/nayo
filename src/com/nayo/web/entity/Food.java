package com.nayo.web.entity;

public class Food {
	
	private String id;
	private String name;
	private int foodLife;
	private String sellLife;
	private String regDate;
	private String useDate;
	private String regEmail;
	private String foodCate;
	private String keepArea;
	
	public Food(String id, String name, int foodLife, String sellLife, String regDate, String useDate, String regEmail,
			String foodCate, String keepArea) {
		super();
		this.id = id;
		this.name = name;
		this.foodLife = foodLife;
		this.sellLife = sellLife;
		this.regDate = regDate;
		this.useDate = useDate;
		this.regEmail = regEmail;
		this.foodCate = foodCate;
		this.keepArea = keepArea;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFoodLife() {
		return foodLife;
	}
	public void setFoodLife(int foodLife) {
		this.foodLife = foodLife;
	}
	public String getSellLife() {
		return sellLife;
	}
	public void setSellLife(String sellLife) {
		this.sellLife = sellLife;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	public String getFoodCate() {
		return foodCate;
	}
	public void setFoodCate(String foodCate) {
		this.foodCate = foodCate;
	}
	public String getKeepArea() {
		return keepArea;
	}
	public void setKeepArea(String keepArea) {
		this.keepArea = keepArea;
	}
	
}
