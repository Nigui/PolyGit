package com.example.polyjoule.slidingmenu;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.polyjoule.application.R;
import com.xtremelabs.imageutils.ImageLoader;
import com.xtremelabs.imageutils.ImageRequest;

public class ArticleFragment extends Fragment{
	private View rootView;
	private TextView titreArticle ;
	private WebView web;
	private ImageView imageView;
	private ImageRequest request;
	private LinearLayout corpsArt;
	private ImageLoader mImageLoader;
	private String titre;
	private String corps;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.article, container, false);
		
		Bundle bundle= getArguments(); 
		titre=bundle.getString("titre");
		corps=bundle.getString("corps");
		
        initUI();
        
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}
	 
	 private void initUI(){
		 titreArticle =  (TextView)rootView.findViewById(R.id.titre_article);
		 corpsArt =  (LinearLayout)rootView.findViewById(R.id.corps_article);
		 titreArticle.setText(titre);
		 
		 mImageLoader = ImageLoader.buildImageLoaderForSupportFragment(this);
		
		 // les définitions de type mime et de l'encodage
	      final String mimeType = "text/html";
	      final String encoding = "utf-8";
	      
	      
	      int depart = 0, imgAjout = 0;
	      
	     ArrayList<String> ArrCorps, img;
	     ArrCorps = new ArrayList<String>();
	     img = new ArrayList<String>();
	     
	      for(int i = 0; i<corps.length();i++){
	    	 if(corps.charAt(i) == '<'){
	    		 if(corps.charAt(i+1) == 'i'){
	    			 if(corps.charAt(i+2) == 'm'){
	    				 if(corps.charAt(i+3) == 'g'){
	    					 ArrCorps.add(corps.substring(depart, i-1));
	    					 depart = i;
	    					 while(corps.charAt(i) != '>'){
	    						 i++;
	    					 }
	    					 img.add(corps.substring(depart, i+1));
	    					 depart = i+1;
	    				 }
	    			 }
	    		 }
	    	 }
	      }
	    	 
	     ArrCorps.add(corps.substring(depart, corps.length()-1));
	      
	      String lien;
	      String src;
	      for(int k = 0; k<img.size() ; k++){
		      for(int j = 0 ; j<img.get(k).length() ; j++){
			    	 if((img.get(k).charAt(j) == 's' ) && (img.get(k).charAt(j+1) == 'r' ) && (img.get(k).charAt(j+2) == 'c' ) && (img.get(k).charAt(j+3) == '=') && (img.get(k).charAt(j+4) == '"')){
			    		 depart = j+5;
			    		 j = j+5;
			    		 while(img.get(k).charAt(j) != '"'){
			    			 j++;
			    		 }
			   	      	 lien = "http://www.polyjoule.org";
			    		 src = img.get(k).substring(depart, j);
			    		 lien = lien.concat(src);
			    		 img.set(k, lien);
			    	 }
			     }
	      }
		
		 
		  
	      for(int i = 0; i<ArrCorps.size() ; i++){
	    	  web = new WebView(this.getActivity());
	    	  web.loadData(ArrCorps.get(i), mimeType, encoding);
	    	  corpsArt.addView(web);
	    	  if(img.size() - imgAjout != 0){
	    		  imageView =  new ImageView(this.getActivity());
	    		  request = new ImageRequest(img.get(imgAjout));
	    		  request.setImageView(imageView);
	    		  mImageLoader.loadImage(request);
	    		  corpsArt.addView(imageView);
	    		  imgAjout ++;
	    	  }
	      }
	 }

}
