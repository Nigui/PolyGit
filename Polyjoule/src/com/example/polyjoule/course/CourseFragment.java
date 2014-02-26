package com.example.polyjoule.course;

import com.example.polyjoule.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CourseFragment extends Fragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_course, container, false);
        
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}

}
