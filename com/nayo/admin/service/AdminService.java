package com.nayo.admin.service;

public class AdminService {

	public static void main(String[] args) {
		
		//���� Ȩ���� �α��� 
		rogin();
		
		//�α��� �� ù ȭ��
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
