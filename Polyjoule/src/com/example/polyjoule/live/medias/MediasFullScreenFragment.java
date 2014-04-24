package com.example.polyjoule.live.medias;
import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
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
        
		rootView = inflater.inflate(R.layout.medias_fullscreen_view, container, false);

		viewPager = (ViewPager) rootView.findViewById(R.id.pager);

        mImageLoader = ImageLoader.buildImageLoaderForSupportFragment(this);
        
		Bundle bd = getArguments();
		int position = bd.getInt("position");

		adapter = new MediasFullScreenAdapter(this.getActivity(),imagesURL,mImageLoader);

		viewPager.setAdapter(adapter);

		// displaying selected image first
		viewPager.setCurrentItem(position);

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
	public void onDestroy() {
		super.onDestroy();
		mImageLoader.destroy();
	}
}
