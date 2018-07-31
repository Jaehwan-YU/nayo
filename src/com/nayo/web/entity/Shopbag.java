package com.nayo.web.entity;

import java.sql.Date;

public class Shopbag {
	private String name;
	private String regEmail;
	private Date buyDay;
	
	public Shopbag() {
		
	}
	
	public Shopbag(String name, String regEmail, Date buyDay) {
		this.name = name;
		this.regEmail = regEmail;
		this.buyDay = buyDay;
	}

	public Shopbag(String name, String regEmail) {
		this.name = name;
		this.regEmail = regEmail;
	}

	public Shopbag(String name) {
		this.name = name;
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

	public Date getBuyDay() {
		return buyDay;
	}

	public void setBuyDay(Date buyDay) {
		this.buyDay = buyDay;
	}

	@Override
	public String toString() {
		return "Shopbag [name=" + name + ", regEmail=" + regEmail + ", buyDay=" + buyDay + "]";
	}
	
}
