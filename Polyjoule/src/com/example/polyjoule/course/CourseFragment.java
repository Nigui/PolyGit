package com.example.polyjoule.course;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.polyjoule.slidingmenu.MainActivity;
import com.polyjoule.application.R;

public class CourseFragment extends Fragment{
	
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
	 }

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_course, container, false);
		
		/** Initialise l'interface, le header **/
		
		ImageView image1= (ImageView) rootView.findViewById(R.id.imageView1);
		ImageView image2= (ImageView) rootView.findViewById(R.id.imageView2);
		
		image1.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View view) {
		            	((MainActivity)getActivity()).changeFragmentCourse(1);
		            }
		        });
		
		image2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	((MainActivity)getActivity()).changeFragmentCourse(2);
            }
        });
		
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}

}
