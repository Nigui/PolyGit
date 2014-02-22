package com.example.polyjoule.livreDor;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.polyjoule.R;

public class LivreDorActivity extends Activity{

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_live, container, false);
        
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}	
}
