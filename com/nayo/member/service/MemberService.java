package com.nayo.member.service;

public class MemberService {

	public static void main(String[] args) {
		
		getRecipeList(String memberEmail);
		getRecipe();
		
		getFoodList(String memberEmail);		
		addFood(String memberEmail);
		setFood(String foodId);
		deleteFood(String foodId);
		
		getBookMarkList();
		addBookMark(String memberEmail, String RecipeId);
		deleteBookMark(String memberEmail, String RecipeId);
		
		getMemberInfo(String memberEmail);
		setMemberInfo(String memberEmail);
		
		getMenuList(String memberEmail);
		addMenu(String memeberEmail);
		setMenu(String menuId);
		deleteMenu();
		
		getShopbagList(String memberEmail);
		addShopbag(String memberEmail);
		deleteShopbag(String shopbagId);
		
	}

}
