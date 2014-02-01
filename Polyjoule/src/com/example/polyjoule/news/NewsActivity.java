package com.example.polyjoule.news;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.polyjoule.PolyjouleApplication;
import com.example.polyjoule.R;

public class NewsActivity extends ListActivity {

	/**
	 * Listener used in NewsActivity
	 */
	private NewsListener newsListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		//Test
		newsListener = new NewsListener(this);
		setListAdapter(new NewsAdapter(this));

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
}
