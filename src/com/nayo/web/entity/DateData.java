package com.nayo.web.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DateData {
	String year = "";
	String month = "";
	String day = "";
	String value = "";
	String schedule = "";
	String schedule_detail = "";
	
	public DateData() {
		
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getSchedule_detail() {
		return schedule_detail;
	}
	public void setSchedule_detail(String schedule_detail) {
		this.schedule_detail = schedule_detail;
	}
	
	public Map<String, Integer> today_info(DateData dateData){
		Map<String, Integer> today_data = new HashMap<>();
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(dateData.getYear()), Integer.parseInt(dateData.getMonth()),1);
		
		int startDay = cal.getMinimum(java.util.Calendar.DATE);
		int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
		
		Calendar todayCal = Calendar.getInstance();
		SimpleDateFormat ysdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat msdf = new SimpleDateFormat("M");
		
		int today_year = Integer.parseInt(ysdf.format(todayCal.getTime()));
		int today_month = Integer.parseInt(msdf.format(todayCal.getTime()));
		
		int search_year = Integer.parseInt(dateData.getYear());
		int search_month = Integer.parseInt(dateData.getMonth());
		
		int today = -1;
		if(today_year == search_year && today_month == search_month) {
			SimpleDateFormat dsdf = new SimpleDateFormat("dd");
			today = Integer.parseInt(dsdf.format(todayCal.getTime()));
		}
		
		search_month = search_month-1;
		
		Map<String, Integer> before_after_calendar = before_after_calendar(search_year,search_month);
		
		System.out.println("search_month : " + search_month);
		
		today_data.put("start", start);
		today_data.put("startDay", startDay);
		today_data.put("endDay", endDay);
		today_data.put("today", today);
		today_data.put("search_year", search_year);
		today_data.put("search_month", search_month+1);
		today_data.put("before_year", before_after_calendar.get("before_year"));
		today_data.put("before_month", before_after_calendar.get("before_month"));
		today_data.put("after_year", before_after_calendar.get("after_year"));
		today_data.put("after_month", before_after_calendar.get("after_month"));
		
		return today_data;
	}
	private Map<String, Integer> before_after_calendar(int search_year, int search_month) {
		Map<String, Integer> before_after_data = new HashMap<>();
		int before_year = search_year;
		int before_month = search_month-1;
		int after_year = search_year;
		int after_month = search_month+1;
		
		if(before_month < 0) {
			before_month = 11;
			before_year = search_year-1;
		}
		
		if(after_month > 11) {
			after_month = 0;
			after_year = search_year+1;
		}
		
		before_after_data.put("before_year", before_year);
		before_after_data.put("before_month", before_month);
		before_after_data.put("after_year", after_year);
		before_after_data.put("after_month", after_month);
		
		return before_after_data;
	}
	public DateData(String year, String month, String day, String value, String schedule, String schedule_detail) {

		this.year = year;
		this.month = month;
		this.day = day;
		this.value = value;
		this.schedule = schedule;
		this.schedule_detail = schedule_detail;
	}
	public DateData(String year, String month, String day, String value) {
		if((month != null && month != "") && (day != null && day != "")) {
			this.year = year;
			this.month = month;
			this.day = day;
			this.value = value;
		}
	}
	@Override
	public String toString() {
		return "DateData [year=" + year + ", month=" + month + ", day=" + day + ", value=" + value + "]";
	}
	
	
}
