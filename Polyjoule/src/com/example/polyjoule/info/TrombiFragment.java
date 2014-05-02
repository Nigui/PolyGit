package com.example.polyjoule.info;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.polyjoule.DBObjects.Membre;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.polyjoule.application.R;
import com.xtremelabs.imageutils.ImageLoader;

public class TrombiFragment extends ListFragment {

	
	private ArrayList<Membre> membres;
	private int idAnnee;
	private ImageLoader mImageLoader;
	
	public TrombiFragment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrombiFragment(int annee) {
		super();
		if( annee == 2013 ) this.idAnnee = 13;
		else this.idAnnee = 05;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.equipe_trombi, container, false);

		membres = new DataBaseGetters(getActivity()).getTrombiFromDB(idAnnee);
		mImageLoader = ImageLoader.buildImageLoaderForSupportFragment(this);
		
		setListAdapter(new TrombiAdapter(getActivity(),membres,mImageLoader));
		
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
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		mImageLoader.destroy();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setListAdapter(new TrombiAdapter(getActivity(),membres,mImageLoader));
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
	}

	
}
