package com.example.polyjoule.livreDor;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.ListView;

import com.example.polyjoule.DBObjects.LivreOr;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.example.polyjoule.slidingmenu.ArticleFragment;
import com.example.polyjoule.slidingmenu.MainActivity;
import com.example.polyjoule.utils.Tools;
import com.polyjoule.application.R;

public class LivreDorFragment extends ListFragment {

	private ArrayList<LivreOr> listLivreOR;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		listLivreOR = new DataBaseGetters(getActivity()).getLivreOrFromDB();

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_livre_or, container, false);

		/** Initialise l'interface, le header **/	  

		setListAdapter(new LivreOrAdapter(this,listLivreOR));
		
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

		LivreOr current = listLivreOR.get(position);
		((MainActivity)getActivity()).changeLivreOrItem(current.getAuteur(), Tools.transformCalendarToSimpleString(current.getDate()), current.getMessage());
	}
}
