package com.example.polyjoule.news;

import android.view.View;
import android.view.View.OnClickListener;

public class NewsListener implements OnClickListener {
	/**
	 * Reference on the HomePageActivity.
	 */
	private NewsFragment newsActivity;
	/**
	 * Constructor of HomePageListener
	 * @param activity reference on the HomePageActivity.
	 */
	public NewsListener(NewsFragment activity){
		newsActivity = activity;
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	}

}
