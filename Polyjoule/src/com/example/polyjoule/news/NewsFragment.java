package com.example.polyjoule.news;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.course.CourseFragment;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.example.polyjoule.slidingmenu.MainActivity;

public class NewsFragment extends ListFragment {
	
	private Article currentArticle;
	private ArrayList<Article> listArticle;
	
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
		//ListView
		
		//Activer lorsqu'on est connecter au wifi de poly
		listArticle = new ArrayList<Article>();
		/*Article art;
		for (int i = 0; i < 50; i++) {	
			art = new Article();
			art.setAuteur("Tralala");
			art.setTitreFr("Important Text");
			art.setContenuFr("Corps de l'article");
			listArticle.add(art);
		}*/
		
		listArticle = DataBaseGetters.getArticlesFromDB();
 		NewsListener articleListener = new NewsListener(this);
		setListAdapter(new NewsAdapter(this,listArticle));
		
	 }
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_news, container, false);
	        
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
