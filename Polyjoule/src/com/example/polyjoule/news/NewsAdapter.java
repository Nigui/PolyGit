package com.example.polyjoule.news;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.polyjoule.PolyjouleApplication;
import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Article;

public class NewsAdapter extends BaseAdapter {

	
	/**
	 * List of news to shows.
	 */
	private ArrayList<Article> articles;
	
	/**
	 * Layout inflater of NewsActivity use to inflate News_item.
	 */
	private LayoutInflater layoutInflater;
	
	
	/**
	 * Constructor of NewsAdapter. news member is initialize with NewsList.
	 * @param newsActivity reference on newsActivity.
	 * @param NewsList list of item to show on listView.
	 */
	public NewsAdapter(NewsActivity newsActivity, ArrayList<Article> articleList) {
		this.articles = new ArrayList<Article>(articleList);
		layoutInflater=newsActivity.getLayoutInflater();
	}

	/**
	 * Indicate number of item on news.
	 * @return size of news.
	 */
	public int getCount() {
		return articles.size();
	}

	/**
	 * Getter of item corresponding to position.
	 * @param arg0 position of item.
	 * @return item corresponding to position.
	 */
	public Object getItem(int arg0) {
		return articles.get(arg0);
	}

	/**
	 * Method not use.
	 */
	public long getItemId(int position) {
		return 0;
	}

	/**
	 * Method to fill listView.
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ItemHolder itemHolder;
		
		if(convertView==null){
			convertView=layoutInflater.inflate(R.layout.news_item,parent,false);
			
			itemHolder= new ItemHolder();
			itemHolder.titleView= (TextView)convertView.findViewById(R.id.news_title);
			itemHolder.textView = (TextView)convertView.findViewById(R.id.news_text);
			itemHolder.titleBuilder= new StringBuilder();
			itemHolder.textBuilder=new StringBuilder();
			
			convertView.setTag(itemHolder);
		}
		else{
			itemHolder= (ItemHolder)convertView.getTag();
		}

		itemHolder.titleView.setText(articles.get(position).getTitreFr());
		itemHolder.textView.setText(articles.get(position).getContenuFr());
		
		return convertView;
	}	
	
	/**
	 * Inner class use to save reference of News_item
	 */
	class ItemHolder{
		/**
		 * Reference on R.id.news_name
		 */
		private TextView titleView;
		
		/**
		 * Reference on R.id.News_version
		 */
		private TextView textView;
		
		/**
		 * Reference on  StringBuilder use to update titleView.
		 */
		private StringBuilder titleBuilder;
		
		/**
		 * Reference on StringBuilder use to update textView.
		 */
		private StringBuilder textBuilder;
	}

}
