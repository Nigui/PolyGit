package com.example.polyjoule.news;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.interneDataBase.PolyjouleDBLoader;
import com.example.polyjoule.interneDataBase.PolyjouleDBOpenHelper;
import com.example.polyjoule.interneDataBase.PolyjouleDBRequetes;


public class NewsActivity extends ListActivity {
	
	private Article currentArticle;
	private ArrayList<Article> listArticle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

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
		}
		*/
		/**PolyjouleDBOpenHelper oh = new PolyjouleDBOpenHelper(this);
		boolean loading = new PolyjouleDBLoader(oh).loadDB();
		if( loading ) System.out.println("Chargement ok"); 
		else System.out.println("echec Chargement");
		
		//====>C'est ici que tu récupère la liste des articles
		for( Article article : new PolyjouleDBRequetes(oh).getArticleInternalFromDB() )
			System.out.println(article.toString()+"\n");
		**/
//		listArticle = DataBaseGetters.getArticlesFromDB();
//		
//		NewsListener articleListener = new NewsListener(this);
		//setListAdapter(new NewsAdapter(this,listArticle));
		
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
		
		//Article newsSelect = (Article) getListAdapter().getItem(position);
		
		//this.currentArticle = newsSelect;
		
		Intent intent = new Intent(this, NewsDetailActivity.class);
		intent.putExtra("Article", listArticle.get(position));

		this.startActivity(intent);
	}
}
