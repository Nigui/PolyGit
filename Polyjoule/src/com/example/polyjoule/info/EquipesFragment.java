package com.example.polyjoule.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.polyjoule.slidingmenu.MainActivity;
import com.polyjoule.application.R;

public class EquipesFragment extends Fragment{


	private TextView layout2012;
	private TextView layout2013;
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_equipe, container, false);
        
		layout2012 = (TextView) rootView.findViewById(R.id.equipe2012);
		layout2013= (TextView) rootView.findViewById(R.id.equipe2013);
		
		layout2012.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((MainActivity)getActivity()).changeFragment(new TrombiFragment(2012));
			}
		});
		
		layout2013.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((MainActivity)getActivity()).changeFragment(new TrombiFragment(2013));
			}
		});
		
		
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

}

