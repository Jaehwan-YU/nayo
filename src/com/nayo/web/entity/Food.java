package com.nayo.web.entity;

import java.sql.Date;

public class Food {
	
	private String id;
	private String name;
	private int foodLife;
	private Date sellLife;
	private Date regDate;
	private Date useDate;
	private String regEmail;
	private int foodCateId;
	private int keepAreaId;
	private String foodImg;
	private int restLife;
	
	public Food() {
		
	}
	public Food(String name, int foodCateId) {
		this.name = name;
		this.foodCateId = foodCateId;
				
	}
	public Food(String id, String name, int foodLife, Date sellLife, int keepAreaId, int restLife) {
		this.id = id;
		this.name = name;
		this.foodLife = foodLife;
		this.sellLife = sellLife;
		this.keepAreaId = keepAreaId;
		this.restLife = restLife;
	}
	public Food(String id, String name, int foodLife, Date sellLife, Date regDate, Date useDate, String regEmail,
			int foodCateId, int keepAreaId, String foodImg, int restLife) {
		this.id = id;
		this.name = name;
		this.foodLife = foodLife;
		this.sellLife = sellLife;
		this.regDate = regDate;
		this.useDate = useDate;
		this.regEmail = regEmail;
		this.foodCateId = foodCateId;
		this.keepAreaId = keepAreaId;
		this.foodImg = foodImg;
		this.restLife = restLife;
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
	public Date getUseDate() {
		return useDate;
	}
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	public int getFoodCateId() {
		return foodCateId;
	}
	public void setFoodCateId(int foodCateId) {
		this.foodCateId = foodCateId;
	}
	public int getKeepAreaId() {
		return keepAreaId;
	}
	public void setKeepAreaId(int keepAreaId) {
		this.keepAreaId = keepAreaId;
	}
	
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public int getRestLife() {
		return restLife;
	}
	public void setRestLife(int restLife) {
		this.restLife = restLife;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", foodLife=" + foodLife + ", sellLife=" + sellLife + ", regDate="
				+ regDate + ", useDate=" + useDate + ", regEmail=" + regEmail + ", foodCate=" + foodCateId + ", keepArea="
				+ keepAreaId + "]";
	}
	
}
