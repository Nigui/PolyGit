package com.example.polyjoule.news;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.polyjoule.PolyjouleApplication;
import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.utils.DataBaseConnector;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class NewsActivity extends ListActivity {

	private SlidingMenu slidingMenu;
	
	private Article currentArticle;
	private ArrayList<Article> listArticle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		
		//Sliding menu
		slidingMenu = ((PolyjouleApplication) getApplication()).getSlidingMenu();
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMenu(R.layout.sliding_menu);

		//ListView
		
		//Activer lorsqu'on est connecter au wifi de poly
		listArticle = new ArrayList<Article>();
		Article art;
		for (int i = 0; i < 50; i++) {	
			art = new Article();
			art.setAuteur("Tralala");
			art.setTitreFr("Important Text");
			listArticle.add(art);
		}
		
		//listArticle = DataBaseConnector.getArticlesFromDB();
		
		NewsListener articleListener = new NewsListener(this);
		setListAdapter(new NewsAdapter(this,listArticle));
		
	}

	/**
	 * Implemetation of onResume.
	 */
	public void onResume() {
		super.onResume();
		setListAdapter(new NewsAdapter(this,listArticle));
		
	}

	/**
	 * Listener of listview child. Save child as current city and read trail of
	 * it. Launch MenuCityActivity.
	 */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		Article newsSelect = (Article) getListAdapter().getItem(position);
		
		this.currentArticle = newsSelect;
		
		Intent intent = new Intent(this, NewsDetailActivity.class);
		//intent.putExtra("Article", listArticle.);
		this.startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		if (slidingMenu.isMenuShowing()) {
			slidingMenu.toggle();
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			this.slidingMenu.toggle();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}
}
