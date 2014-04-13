package com.example.polyjoule.livreDor;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.polyjoule.DBObjects.LivreOr;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.polyjoule.application.R;

public class LivreDorFragment extends ListFragment {

	private ArrayList<LivreOr> listLivreOR;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		listLivreOR = DataBaseGetters.getLivreOrFromDB();

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_livre_or, container, false);

		/** Initialise l'interface, le header **/	  

		setListAdapter(new LivreOrAdapter(this,listLivreOR));
		return rootView;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	/**
	 * Implemetation of onResume.
	 */
	public void onResume() {
		super.onResume();
		setListAdapter(new LivreOrAdapter(this,listLivreOR));

	}

	/**
	 * Listener of listview child. Save child as current city and read trail of
	 * it. Launch MenuCityActivity.
	 */
	public void onListItemClick(ListView l, View v, int position, long id) {

	}
}
