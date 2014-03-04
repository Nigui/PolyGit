package com.example.polyjoule.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Tools {

	public static Date parseStringToDate(String date){
		Date ret = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		
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
		
		cal.set(Calendar.HOUR, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		
		return cal.getTime();
	}

	
	public static String parseDateToString(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		cal.setTime(date);
		
		return cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+" "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
	}

	public static int parseBooleanToInt(boolean b){
		return b==true ? 1 : 0;
	}

	public static boolean parseIntToBoolean(int i){
		return i == 0 ? false : true;
	}
	
	public static String transformToSimpleDate(Date date){
		String ret = "le ";
		Calendar cal = Calendar.getInstance();

		cal.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		cal.setTime(date);
		
		ret += cal.get(Calendar.DAY_OF_MONTH);
		
		
		switch( cal.get(Calendar.MONTH) )
		{
			case 1 : ret+= " Janvier ";break;
			case 2 : ret+= " Février ";break;
			case 3 : ret+= " Mars ";break;
			case 4 : ret+= " Avril ";break;
			case 5 : ret+= " Mai ";break;
			case 6 : ret+= " Juin ";break;
			case 7 : ret+= " Juillet ";break;
			case 8 : ret+= " Aout ";break;
			case 9 : ret+= " Septembre ";break;
			case 10 : ret+= " Octobre ";break;
			case 11 : ret+= " Novembre ";break;
			case 12 : ret+= " Décembre ";break;
			default : ret+= " ";break;
		}
		ret+= cal.get(Calendar.YEAR);
		
		ret+=" à "+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE);
		
		
		return ret;
	}
}
