package com.example.polyjoule.livreDor;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.polyjoule.DBObjects.LivreOr;
import com.example.polyjoule.utils.Tools;
import com.polyjoule.application.R;

public class LivreOrAdapter extends BaseAdapter {


	/**
	 * List of news to shows.
	 */
	private ArrayList<LivreOr> articles;

	/**
	 * Layout inflater of NewsActivity use to inflate News_item.
	 */
	private LayoutInflater layoutInflater;

	private Context context;

	/**
	 * Constructor of NewsAdapter. news member is initialize with NewsList.
	 * @param newsActivity reference on newsActivity.
	 * @param NewsList list of item to show on listView.
	 */
	public LivreOrAdapter(LivreDorFragment LivreOrFragment, ArrayList<LivreOr> articleList) {

		this.articles = articleList;
		this.context = LivreOrFragment.getActivity().getApplicationContext();
		layoutInflater= LayoutInflater.from(context);
	}

	/**
	 * Indicate number of item on news.
	 * @return size of news.
	 */
	public int getCount() {
		if( articles == null ) return 0;
		else return articles.size();
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
		LivreOr art = articles.get(position);

		if(convertView==null){

			convertView=layoutInflater.inflate(R.layout.livre_or_item,parent,false);

			itemHolder= new ItemHolder();

			itemHolder.titleView = (TextView)convertView.findViewById(R.id.livre_or_title);
			itemHolder.dateView = (TextView)convertView.findViewById(R.id.livre_or_date);
			itemHolder.contenuView = (TextView)convertView.findViewById(R.id.livre_or_content);

			convertView.setTag(itemHolder);
		}
		else{
			itemHolder= (ItemHolder)convertView.getTag();
		}

		/** Initialisation avec les données **/

		itemHolder.titleView.setText(art.getAuteur());
		String date = Tools.transformCalendarToSimpleString(art.getDate());
		itemHolder.dateView.setText(date);
		itemHolder.contenuView.setText(art.getMessage());

		/** fin initialisation **/

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

		private TextView dateView;

		/**
		 * Reference on R.id.News_version
		 */
		private TextView contenuView;
	}

}

