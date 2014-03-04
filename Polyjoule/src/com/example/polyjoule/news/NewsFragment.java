package com.example.polyjoule.news;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.example.polyjoule.slidingmenu.MainActivity;
import com.example.polyjoule.utils.Tools;

public class NewsFragment extends ListFragment {
	
	private Article currentArticle;
	private ArrayList<Article> listArticle;
	private Article headerArticle;
	
	/** GUI **/
	private ImageView headerImageView;
	private TextView headerTitleText;
	private TextView headerDateText;
	private TextView headerContentText;
	
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
		//ListView
		
		//Activer lorsqu'on est connecter au wifi de poly
		listArticle = new ArrayList<Article>();
		
		
		listArticle = DataBaseGetters.getArticlesFromDB();
		
		headerArticle = listArticle.get(0);
		
		
		
	 }
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_news, container, false);
	        
			/** Initialise l'interface, le header **/
			this.headerImageView = (ImageView) rootView.findViewById(R.id.news_header_image);
			this.headerTitleText = (TextView) rootView.findViewById(R.id.news_header_title);
			this.headerTitleText.setText(headerArticle.getTitreFr());
			this.headerDateText = (TextView) rootView.findViewById(R.id.news_header_date);
			String date = Tools.transformCalendarToSimpleString(headerArticle.getDateCreation());
			this.headerDateText.setText(date);
			this.headerContentText = (TextView) rootView.findViewById(R.id.news_header_content);
			this.headerContentText.setText(Html.fromHtml(headerArticle.getContenuFr()).toString().trim());
			
			
	 		NewsListener articleListener = new NewsListener(this);
			setListAdapter(new NewsAdapter(this,listArticle));
			
	        return rootView;
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
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		((MainActivity)getActivity()).changeFragmentNews(listArticle.get(position));
		
		
	}
}
