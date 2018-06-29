package com.nayo.web.entity;

public class KeepTip {
	
	private String name;
	private int foodLife;
	private String foodCate;
	private String keepArea;
	
	public KeepTip(String name, int foodLife, String foodCate, String keepArea) {
		
		this.name = name;
		this.foodLife = foodLife;
		this.foodCate = foodCate;
		this.keepArea = keepArea;
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
