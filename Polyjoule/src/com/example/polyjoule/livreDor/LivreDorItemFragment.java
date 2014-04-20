package com.example.polyjoule.livreDor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.TextView;

import com.polyjoule.application.R;

public class LivreDorItemFragment extends Fragment {

	private TextView pseudo;
	private TextView date;
	private TextView contenu;
	
	private String pseudoString;
	private String dateString;
	private String contenuString;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		super.onCreateView(inflater, container, savedInstanceState);
		
		View rootView = inflater.inflate(R.layout.livreor_item_detail, container, false);
		
		pseudo = (TextView) rootView.findViewById(R.id.livreor_pseudo);
		date = (TextView) rootView.findViewById(R.id.livreor_date);
		contenu = (TextView) rootView.findViewById(R.id.livreor_contenu);
		
		
		Bundle bundle= getArguments(); 
		pseudoString=bundle.getString("pseudo");
		dateString=bundle.getString("date");
		contenuString=bundle.getString("corps");
		
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

	@Override
	public void onResume() {
		super.onResume();
	}

	private void initUI(){
		
		this.pseudo.setText(this.pseudoString);
		this.date.setText(this.dateString);
		this.contenu.setText(this.contenuString);
	}
}
