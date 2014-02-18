package com.example.polyjoule;

import android.app.Application;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class PolyjouleApplication extends Application {

	private SlidingMenu slidingMenu;

	@Override
	public void onCreate() {
		super.onCreate();
		
		//SlidingMenu
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.setShadowWidthRes(R.dimen.slidingmenu_shadow_width);
		slidingMenu.setShadowDrawable(R.drawable.sliding_menu_shadow);
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		slidingMenu.setFadeDegree(0.35f);
		
	}

	public SlidingMenu getSlidingMenu() {
		return slidingMenu;
	}
}
