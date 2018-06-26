package com.nayo.root.service;

public class RootService {

	public static void main(String[] args) {
		// 처음 들어와서 홈페이지 보기
		getRecipeList();
		getNoticeList();
		
		//고객센터 들렀을때 
		getNoticeList();
			//고객센터의 FAQ
			getFAQList();
			
		//레시피메뉴 들어갔을때
		getRecipeList();
		
			
	}

}
