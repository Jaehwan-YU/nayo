package com.nayo.web.entity;

public class Recipe {
		
	private String id;
	private String title;
	private String simpleIntro;
	private String process;
	private String regEmail;
	private int kcalory;
	private String national;
	private String situation;
	private String recipeType;
	
	
	public Recipe() {
		
	}
	
	public Recipe(String id, String title, String simpleIntro, String process, String regEmail, int kcalory,
			String national, String situation, String recipeType) {
		
		this.id = id;
		this.title = title;
		this.simpleIntro = simpleIntro;
		this.process = process;
		this.regEmail = regEmail;
		this.kcalory = kcalory;
		this.national = national;
		this.situation = situation;
		this.recipeType = recipeType;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSimpleIntro() {
		return simpleIntro;
	}
	public void setSimpleIntro(String simpleIntro) {
		this.simpleIntro = simpleIntro;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public int getKcalory() {
		return kcalory;
	}
	public void setKcalory(int kcalory) {
		this.kcalory = kcalory;
	}
	public String getRegEmail() {
		return regEmail;
	}
	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getRecipeType() {
		return recipeType;
	}
	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", simpleIntro=" + simpleIntro + ", process=" + process
				+ ", regEmail=" + regEmail + ", kcalory=" + kcalory + ", national=" + national + ", situation="
				+ situation + ", recipeType=" + recipeType + "]";
	}
	
	
}
