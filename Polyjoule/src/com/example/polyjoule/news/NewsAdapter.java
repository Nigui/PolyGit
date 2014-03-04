package com.example.polyjoule.news;

import java.util.ArrayList;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.utils.Tools;

public class NewsAdapter extends BaseAdapter {

	
	/**
	 * List of news to shows.
	 */
	private ArrayList<Article> articles;
	
	/**
	 * Layout inflater of NewsActivity use to inflate News_item.
	 */
	private LayoutInflater layoutInflater;
	
	NewsFragment context;
	
	
	/**
	 * Constructor of NewsAdapter. news member is initialize with NewsList.
	 * @param newsActivity reference on newsActivity.
	 * @param NewsList list of item to show on listView.
	 */
	public NewsAdapter(NewsFragment NewsFragment, ArrayList<Article> articleList) {
		this.articles = new ArrayList<Article>(articleList);
		this.articles.remove(0);
		layoutInflater=NewsFragment.getLayoutInflater(null);
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
			itemHolder.imageView = (ImageView)convertView.findViewById(R.id.news_list_image);
			itemHolder.titleView= (TextView)convertView.findViewById(R.id.news_list_title);
			itemHolder.dateView = (TextView)convertView.findViewById(R.id.news_list_date);
			itemHolder.textView = (TextView)convertView.findViewById(R.id.news_list_content);
			itemHolder.titleBuilder= new StringBuilder();
			itemHolder.dateBuilder=new StringBuilder();
			itemHolder.textBuilder=new StringBuilder();
			
			convertView.setTag(itemHolder);
		}
		else{
			itemHolder= (ItemHolder)convertView.getTag();
		}
		
		itemHolder.titleView.setText(articles.get(position).getTitreFr());
		//parse date en string
		String date = Tools.transformCalendarToSimpleString(articles.get(position).getDateCreation());
		itemHolder.dateView.setText(date);
		
		itemHolder.textView.setText(Html.fromHtml(articles.get(position).getContenuFr()).toString().trim());
		
		return convertView;
	}	
	
	/**
	 * Inner class use to save reference of News_item
	 */
	class ItemHolder{
		

		private ImageView imageView;
		
		/**
		 * Reference on R.id.news_name
		 */
		private TextView titleView;

		private TextView dateView;
		
		/**
		 * Reference on R.id.News_version
		 */
		private TextView textView;
		
		
		/**
		 * Reference on  StringBuilder use to update titleView.
		 */
		private StringBuilder titleBuilder;
		
		private StringBuilder dateBuilder;
		
		/**
		 * Reference on StringBuilder use to update textView.
		 */
		private StringBuilder textBuilder;
	}

}
