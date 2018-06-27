package com.nayo.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopbagService {
	private String name;
	private String regEmail;
	private String buyDay;
	
	public void ShopbagService() {
		this.name = null;
		this.regEmail = null;
		this.buyDay = null;
	}
	public void ShopbagService(String regEmail) {
		this.regEmail = regEmail;
	}
	
	void getShopbagList(){
		
	}
	void addShopbag(String memberEmail) {}
	void deleteShopbag(String shopbagId) {}
	
	public void main(String[] args) throws ClassNotFoundException, SQLException {
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	public String getBuyDay() {
		return buyDay;
	}
	public void setBuyDay(String buyDay) {
		this.buyDay = buyDay;
	}
}
