package com.example.polyjoule.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Article;

public class NewsDetailFragment extends Fragment {
	
	private View rootView;
	private Article article;
	private WebView webview;
	

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_news_details, container, false);
		
		Bundle bundle= getArguments(); 
		article=(Article)bundle.getSerializable("article");
		
        initUI();
        
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}
	 private void initUI(){
		 webview =  (WebView)rootView.findViewById(R.id.article_detail);
		 webview.getSettings().setJavaScriptEnabled(true);
		 webview.loadDataWithBaseURL(null, article.getContenuFr(), "text/html", "utf-8", null);
	 }

}
