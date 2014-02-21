package com.example.polyjoule.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

	
	public static String parseDateToString(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(date);
	}

	public static int parseBooleanToInt(boolean b){
		return b==true ? 1 : 0;
	}

	public static boolean parseIntToBoolean(int i){
		return i == 0 ? false : true;
	}
}
