package com.example.polyjoule.live;

import com.polyjoule.application.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LiveFragment extends Fragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_live, container, false);
        
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}

}
