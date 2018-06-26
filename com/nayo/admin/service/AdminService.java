package com.nayo.admin.service;

public class AdminService {

	public static void main(String[] args) {
		
		//어드민 홈에서 로그인 
		rogin();
		
		//로그인 후 첫 화면
		getReportList();
		
		getKeeptipList();
		addKeeptip();
		setKeeptip(String keeptipId);
		deleteKeeptip(String keeptipId);
		
		
		getNoticeList();
		getNoticeDetail();
		addNotice();
		setNotice(String noticeId);
		deleteNotice(String noticeId);
		
		
		
	}

}
