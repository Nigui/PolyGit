package com.example.polyjoule.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Article;

public class NewsDetailFragment extends Fragment {
	
	private View rootView;
	private Article article;
	private TextView titreArticle, corpsArticle;
	private ImageView imageArticle;
	

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_news_details, container, false);
		
		Bundle bundle= getArguments(); 
		article=(Article)bundle.getSerializable("article");
		
        initUI();
        
        int num = bundle.getInt("num");
        System.out.println(num);
        
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}
	 
	 
	 
	 private void initUI(){
		 titreArticle =  (TextView)rootView.findViewById(R.id.titre_article);
		 imageArticle =  (ImageView)rootView.findViewById(R.id.image_article);
		 corpsArticle =  (TextView)rootView.findViewById(R.id.corps_article);
		 
		 titreArticle.setText(article.getTitreFr());
		 //corpsArticle.setText(Html.fromHtml(article.getContenuFr()), TextView.BufferType.SPANNABLE);
		 corpsArticle.setText(article.getAuteur());
		titreArticle.setText(article.getTitreFr());
		corpsArticle.setText(Html.fromHtml(article.getContenuFr()), TextView.BufferType.SPANNABLE);
	 }

}
