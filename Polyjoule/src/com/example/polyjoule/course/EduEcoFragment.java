package com.example.polyjoule.course;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.polyjoule.application.R;
import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.DBObjects.Rubrique;
import com.example.polyjoule.externeDataBase.DataBaseGetters;

public class EduEcoFragment extends Fragment{
	private View rootView;
	private Article article;
	private TextView titreArticle, corpsArticle;
	private ImageView imageArticle;
	private ArrayList<Rubrique> listRubrique;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.article, container, false);
		
		listRubrique = DataBaseGetters.getRubriqueFromDBWhithID(20);
		
        initUI();
        
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}
	 
	 private void initUI(){
		 titreArticle =  (TextView)rootView.findViewById(R.id.titre_article);
		 imageArticle =  (ImageView)rootView.findViewById(R.id.image_article);
		 corpsArticle =  (TextView)rootView.findViewById(R.id.corps_article);
		 
		titreArticle.setText(listRubrique.get(0).getTitreFR());
		corpsArticle.setText(Html.fromHtml(listRubrique.get(0).getDescriptionFR()), TextView.BufferType.SPANNABLE);
	 
	 }

}
