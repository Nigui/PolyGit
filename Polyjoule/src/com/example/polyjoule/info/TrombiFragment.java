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

import com.example.polyjoule.DBObjects.Membre;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.polyjoule.application.R;

public class TrombiFragment extends ListFragment {

	
	private ArrayList<Membre> membres;
	private int idAnnee;
	
	public TrombiFragment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrombiFragment(int annee) {
		super();
	
		if( annee == 2012 ) idAnnee = 5;
		else idAnnee = 13;

		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.equipe_trombi, container, false);
		
		
		membres = new DataBaseGetters(getActivity()).getTrombiFromDB(idAnnee);
		
		
		
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

	
}
