package com.example.polyjoule.course;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.DBObjects.Rubrique;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.example.polyjoule.slidingmenu.MainActivity;
import com.polyjoule.application.R;

public class VoitureFragment extends Fragment{
	
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
	 }

	public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_voiture, container, false);
		
		/** Initialise l'interface, le header **/
		
		TextView text1= (TextView) rootView.findViewById(R.id.cityJoule);
		TextView text2= (TextView) rootView.findViewById(R.id.polyJoule);
		
		text1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	ArrayList<Rubrique> listRubrique = new DataBaseGetters(container.getContext()).getRubriqueFromDBWhithID(8);
            	((MainActivity)getActivity()).changeArticle(listRubrique.get(0).getTitreFR(), listRubrique.get(0).getDescriptionFR());
            }
        });
		
		text2.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
           	ArrayList<Article> listRubrique = new DataBaseGetters(container.getContext()).getArticlesFromDBWithID(-1, 60);
           	((MainActivity)getActivity()).changeArticle(listRubrique.get(0).getTitreFr(), listRubrique.get(0).getContenuFr());
           }
       });
		
		
       return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}

}
