package com.example.polyjoule.live.medias;
import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.polyjoule.application.R;
import com.xtremelabs.imageutils.ImageLoader;


public class MediasFullScreenFragment extends Fragment {

	private MediasFullScreenAdapter adapter;
	private ViewPager viewPager;
	private View rootView;
	
	private ArrayList<String> imagesURL;
	private ImageLoader mImageLoader;
	
	public MediasFullScreenFragment(ArrayList<String> imagesURL) {
		super();
		this.imagesURL = imagesURL;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

        mImageLoader = ImageLoader.buildImageLoaderForSupportFragment(this);
		rootView = inflater.inflate(R.layout.medias_fullscreen_view, container, false);

		viewPager = (ViewPager) rootView.findViewById(R.id.pager);

		Bundle bd = new Bundle();
		int position = bd.getInt("position");

		adapter = new MediasFullScreenAdapter(this.getActivity(),imagesURL,mImageLoader);

		viewPager.setAdapter(adapter);

		// displaying selected image first
		viewPager.setCurrentItem(position);
		return rootView;
	}
}
