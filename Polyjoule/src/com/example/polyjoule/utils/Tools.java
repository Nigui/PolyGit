package com.example.polyjoule.utils;

import java.io.InputStream;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

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
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		
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
			case Calendar.JANUARY : ret+= " Janvier ";break;
			case Calendar.FEBRUARY : ret+= " Février ";break;
			case Calendar.MARCH : ret+= " Mars ";break;
			case Calendar.APRIL : ret+= " Avril ";break;
			case Calendar.MAY : ret+= " Mai ";break;
			case Calendar.JUNE : ret+= " Juin ";break;
			case Calendar.JULY : ret+= " Juillet ";break;
			case Calendar.AUGUST : ret+= " Aout ";break;
			case Calendar.SEPTEMBER : ret+= " Septembre ";break;
			case Calendar.OCTOBER : ret+= " Octobre ";break;
			case Calendar.NOVEMBER : ret+= " Novembre ";break;
			case Calendar.DECEMBER : ret+= " Décembre ";break;
			default : ret+= " ";break;
		}
		ret+= date.get(Calendar.YEAR);
		
		ret+=" à ";
		int calendarHour = date.get(Calendar.HOUR_OF_DAY);
		if( calendarHour<10 ) ret += "0";
		ret += calendarHour+":";
		
		int calendarMin = date.get(Calendar.MINUTE);
		if( calendarMin <10 ) ret+= "0";
		ret+= calendarMin;
		
		
		return ret;
	}

	static Bitmap downloadBitmap(String url) {
        final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
        final HttpGet getRequest = new HttpGet(url);
        try {
            HttpResponse response = client.execute(getRequest);
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.w("ImageDownloader", "Error " + statusCode
                        + " while retrieving bitmap from " + url);
                return null;
            }
 
            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = null;
                try {
                    inputStream = entity.getContent();
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }
            }
        } catch (Exception e) {
            // Could provide a more explicit error message for IOException or
            // IllegalStateException
            getRequest.abort();
            Log.w("ImageDownloader", "Error while retrieving bitmap from " + url);
        } finally {
            if (client != null) {
                client.close();
            }
        }
        return null;
    }
	
	/*
     * getting screen width
     */
    public static int getScreenWidth(Context _context) {
        int columnWidth;
        WindowManager wm = (WindowManager) _context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
 
        final Point point = new Point();
        try {
            display.getSize(point);
        } catch (java.lang.NoSuchMethodError ignore) { // Older device
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        columnWidth = point.x;
        return columnWidth;
    }
	
}
