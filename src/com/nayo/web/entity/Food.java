package com.nayo.web.entity;

import java.sql.Date;

public class Food {
	
	private String id;
	private String name;
	private int foodLife;
	private Date sellLife;
	private Date regDate;
	private String useDate;
	private String regEmail;
	private String foodCate;
	private String keepArea;
	private String foodImg;
	
	public Food() {
		
	}
	public Food(String id, String name, int foodLife, Date sellLife) {
		
	}
	public Food(String id, String name, int foodLife, Date sellLife, Date regDate, String useDate, String regEmail,
			String foodCate, String keepArea, String foodImg) {
		this.id = id;
		this.name = name;
		this.foodLife = foodLife;
		this.sellLife = sellLife;
		this.regDate = regDate;
		this.useDate = useDate;
		this.regEmail = regEmail;
		this.foodCate = foodCate;
		this.keepArea = keepArea;
		this.foodImg = foodImg;
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
	public Date getSellLife() {
		return sellLife;
	}
	public void setSellLife(Date sellLife) {
		this.sellLife = sellLife;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
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
	
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", foodLife=" + foodLife + ", sellLife=" + sellLife + ", regDate="
				+ regDate + ", useDate=" + useDate + ", regEmail=" + regEmail + ", foodCate=" + foodCate + ", keepArea="
				+ keepArea + "]";
	}
	
}
