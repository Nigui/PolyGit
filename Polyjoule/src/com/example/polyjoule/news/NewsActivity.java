package com.example.polyjoule.news;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.polyjoule.PolyjouleApplication;
import com.example.polyjoule.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class NewsActivity extends ListActivity {

	private SlidingMenu slidingMenu;
	/**
	 * Listener used in NewsActivity
	 */
	private NewsListener newsListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

		newsListener = new NewsListener(this);
		setListAdapter(new NewsAdapter(this));

		slidingMenu = ((PolyjouleApplication) getApplication())
				.getSlidingMenu();
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMenu(R.layout.sliding_menu);
		Log.e(this.toString(),"test");
	}

	/**
	 * Implemetation of onResume.
	 */
	public void onResume() {
		super.onResume();
		setListAdapter(new NewsAdapter(this));
		
	}

	/**
	 * Listener of listview child. Save child as current city and read trail of
	 * it. Launch MenuCityActivity.
	 */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		News newsSelect = (News) getListAdapter().getItem(position);
		((PolyjouleApplication) getApplication()).setCurrentNews(newsSelect);
		Intent intent = new Intent(this, NewsDetailActivity.class);
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
