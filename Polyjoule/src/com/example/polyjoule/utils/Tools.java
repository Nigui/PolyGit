package com.example.polyjoule.utils;

import java.util.Date;

public class Tools {

	public static Date parseStringToDate(String date){
		Date ret = new Date();
		int year;
		int month;
		int day;
		
		int hour;
		int minute;
		int second;
		
		String dateHourArray[] = date.split(" ");
		String dateArray[] = dateHourArray[0].trim().split("-");
		String hourArray[] = dateHourArray[1].trim().split(":");
		
		year = Integer.parseInt(dateArray[0].trim());
		month = Integer.parseInt(dateArray[1].trim());
		day = Integer.parseInt(dateArray[2].trim());
		
		hour = Integer.parseInt(hourArray[0].trim());
		minute = Integer.parseInt(hourArray[1].trim());
		second = Integer.parseInt(hourArray[2].trim());
		
		ret.setDate(day);
		ret.setHours(hour);
		ret.setMinutes(minute);
		ret.setMonth(month);
		ret.setSeconds(second);
		ret.setYear(year);
		
		return ret;
	}
	
}
