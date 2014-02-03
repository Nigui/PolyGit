package com.example.polyjoule;

import java.util.ArrayList;

import android.app.Application;

import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.news.News;
import com.example.polyjoule.utils.DataBaseConnector;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class PolyjouleApplication extends Application {

	private SlidingMenu slidingMenu;

	public News currentNews;
	public ArrayList<News> newsList;

	@Override
	public void onCreate() {
		super.onCreate();
		
		DataBaseConnector.getArticlesFromDB();
		
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.setShadowWidthRes(R.dimen.slidingmenu_shadow_width);
		slidingMenu.setShadowDrawable(R.drawable.sliding_menu_shadow);
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		slidingMenu.setFadeDegree(0.35f);
		newsList = new ArrayList<News>();
//		for (int i = 0; i < 50; i++) {
//			newsList.add(new News("Tralala", "Important Text"));
//		}
		
		ArrayList<Article> listArticle = DataBaseConnector.getArticlesFromDB();
		for(int i=0;i<listArticle.size();i++){
			newsList.add(new News(listArticle.get(i).getAuteur(), listArticle.get(i).getTitreFr()));
		}
		
	}

	public News getCurrentNews() {
		return currentNews;
	}

	public ArrayList<News> getNewsList() {
		return newsList;
	}

	public SlidingMenu getSlidingMenu() {
		return slidingMenu;
	}

	public void setCurrentNews(News currentNews) {
		this.currentNews = currentNews;
	}

	public void setNewsList(ArrayList<News> newsList) {
		this.newsList = newsList;
	}
}
