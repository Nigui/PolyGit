package com.example.polyjoule.utils;

import java.util.Calendar;
import java.util.TimeZone;

public class Tools {

	public static Calendar parseStringToCalendar(String date){
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
		
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		
		System.out.println(cal.getTime().toString());
		
		
		return cal;
	}

	
	public static String parseCalendarToString(Calendar date){
		
		return date.get(Calendar.YEAR)+"-"+date.get(Calendar.DAY_OF_MONTH)+"-"+date.get(Calendar.MONTH)+" "+date.get(Calendar.HOUR_OF_DAY)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND);
	}

	public static int parseBooleanToInt(boolean b){
		return b==true ? 1 : 0;
	}

	public static boolean parseIntToBoolean(int i){
		return i == 0 ? false : true;
	}
	
	public static String transformCalendarToSimpleString(Calendar date){
		
		String ret = "le ";
		
		ret += date.get(Calendar.DAY_OF_MONTH);
		
		
		switch( date.get(Calendar.MONTH) )
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
		ret+= date.get(Calendar.YEAR);
		
		ret+=" à "+date.get(Calendar.HOUR_OF_DAY)+":"+date.get(Calendar.MINUTE);
		
		
		return ret;
	}

}
