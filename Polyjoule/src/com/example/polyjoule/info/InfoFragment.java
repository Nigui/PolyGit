package com.example.polyjoule.info;

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

public class InfoFragment extends Fragment{


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_info, container, false);

		/** Initialise l'interface, le header **/

		TextView text1= (TextView) rootView.findViewById(R.id.partenaire);
		TextView text2= (TextView) rootView.findViewById(R.id.equipe);
		TextView text3= (TextView) rootView.findViewById(R.id.historique);
		TextView text4= (TextView) rootView.findViewById(R.id.persoCle);
		TextView text5= (TextView) rootView.findViewById(R.id.contact);


		text1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				((MainActivity)getActivity()).changePartenaire();
			}
		});

		text2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ArrayList<Article> listRubrique = DataBaseGetters.getArticlesFromDBWithID(-1, 60);
				((MainActivity)getActivity()).changeArticle(listRubrique.get(0).getTitreFr(), listRubrique.get(0).getContenuFr());
			}
		});
		text3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ArrayList<Rubrique> listRubrique = DataBaseGetters.getRubriqueFromDBWhithID(8);
				((MainActivity)getActivity()).changeArticle(listRubrique.get(0).getTitreFR(), listRubrique.get(0).getDescriptionFR());
			}
		});

		text4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				PersoClé perso = new PersoClé();
				((MainActivity)getActivity()).changeFragment(perso);
			}
		});
		text5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ContactFragment contact = new ContactFragment();
				((MainActivity)getActivity()).changeFragment(contact);
			}
		});



		return rootView;
	}

	public void onResume() {
		super.onResume();

	}

}