package com.nayo.web.entity;

public class Ingredients {
	
	private int id;
	private int recipeId;
	private String name;
	private String quantity;
	private int mainOrSub;
	
	public Ingredients(int id, int recipeId, String name, String quantity, int mainOrSub) {
		super();
		this.id = id;
		this.recipeId = recipeId;
		this.name = name;
		this.quantity = quantity;
		this.mainOrSub = mainOrSub;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getMainOrSub() {
		return mainOrSub;
	}

	public void setMainOrSub(int mainOrSub) {
		this.mainOrSub = mainOrSub;
	}

	@Override
	public String toString() {
		return "Ingredients [id=" + id + ", recipeId=" + recipeId + ", name=" + name + ", quantity=" + quantity
				+ ", mainOrSub=" + mainOrSub + "]";
	}
	
	
}
