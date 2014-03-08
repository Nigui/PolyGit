package com.example.polyjoule.live.medias;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.polyjoule.application.R;

public class MediasFragment extends Fragment{
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_medias, container, false);
        
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}

}
