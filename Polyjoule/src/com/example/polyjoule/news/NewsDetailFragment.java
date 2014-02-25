package com.example.polyjoule.news;

import java.util.ArrayList;

import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Article;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.Html;

public class NewsDetailFragment extends Activity {
	
	private Article article;
	private TextView titreArticle, corpsArticle;
	private ImageView imageArticle;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_news_details);
	        
	        Bundle extras = getIntent().getExtras();
			
			this.article = (Article)extras.get("Article");	
			initUI();
	    }
	 
	 private void initUI(){
		 titreArticle =  (TextView)this.findViewById(R.id.titre_article);
		 imageArticle =  (ImageView)this.findViewById(R.id.image_article);
		 corpsArticle =  (TextView)this.findViewById(R.id.corps_article);
		 
		 titreArticle.setText(article.getTitreFr());
		 corpsArticle.setText(Html.fromHtml(article.getContenuFr()), TextView.BufferType.SPANNABLE);
	 }

}
