package com.example.polyjoule.slidingmenu;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
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
        
        rootView.setOnKeyListener(new OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    Log.v("back","back");
	                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                }
                return false;
            }
        } );
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
		
		 // les d��finitions de type mime et de l'encodage
	      final String mimeType = "text/html";
	      final String encoding = "utf-8";
	      
		   //------video
		  int depart = 0;
		  String lienVideo = "";
		  int debut_lien = 0, fin_lien = 0, fin=0;
		  
		  
		    for(int i = 0; i<corps.length();i++){
		  	 if(corps.charAt(i) == '<'){
		  		 if(corps.charAt(i+1) == 'i'){
		  			 if(corps.charAt(i+2) == 'f'){
		  				 if(corps.charAt(i+3) == 'r'){
		  					 if(corps.charAt(i+4) == 'a'){
		  						 if(corps.charAt(i+5) == 'm'){
		  							 if(corps.charAt(i+6) == 'e'){
				  					 depart = i;
				  					 while(corps.charAt(i) != '<' || 
				  							 corps.charAt(i+1) != '/' || 
				  							 corps.charAt(i+2) != 'i' ||  
				  							 corps.charAt(i+3) != 'f' ||  
				  							 corps.charAt(i+4) != 'r' ||  
				  							 corps.charAt(i+5) != 'a' || 
				  							 corps.charAt(i+6) != 'm' || 
				  							 corps.charAt(i+7) != 'e' || 
				  							 corps.charAt(i+8) != '>'){
				  						 		i++;
						  						 if(corps.charAt(i) == 's' &&
						  						     corps.charAt(i+1) == 'r' &&
						  							 corps.charAt(i+2) == 'c' &&
						  							 corps.charAt(i+3) == '=' ){
						  							 
						  							 	i = i+5;//1er lettre après "
						  							 	debut_lien = i;
						  							 	
						  							 	while(corps.charAt(i) != '"'){
						  							 		i++;
						  							 	}
						  							 	
						  							 	fin_lien = i;//Dernière lettre avant le "
						  							 	lienVideo = corps.substring(debut_lien, fin_lien);
						  						 }
				  					 		}
				  					 	fin = i+9;
		  							 }
		  						 }
		  					 } 
		  				 }
		  			 }
		  		 }
		  	 }
		   }
		    
		    if(depart != 0 && fin !=0){
		    	String video = "<a href=\""+lienVideo+"\">Lien video</a>";
		    	corps = corps.replace(corps.substring(depart, fin), video);
		    }
		   
	      
	      //------IMAGES
	     depart = 0; 
	     int imgAjout = 0;
	      
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
