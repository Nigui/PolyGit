package com.example.polyjoule.live.medias;

import java.util.ArrayList;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.polyjoule.DBObjects.Photo;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.example.polyjoule.live.medias.Slider.SliderConstant;
import com.example.polyjoule.utils.Tools;
import com.polyjoule.application.R;
import com.xtremelabs.imageutils.ImageLoader;

public class MediasFragment extends Fragment{
	
    private ArrayList<String> imageURL = new ArrayList<String>();
    private MediaGridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;
    private View rootView;
    
    private ImageLoader mImageLoader;
	

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		imageURL =  new DataBaseGetters(getActivity()).getPhotosURLFromDB();
		
        mImageLoader = ImageLoader.buildImageLoaderForSupportFragment(this);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_medias_gridview, container, false);
        
		gridView = (GridView) rootView.findViewById(R.id.media_grid_view);
		// Initilizing Grid View
        InitilizeGridLayout();
        
        //TODO Get path for images
        
        adapter = new MediaGridViewImageAdapter(columnWidth, this.getActivity(),imageURL,mImageLoader);
        
        // setting grid view adapter
        gridView.setAdapter(adapter);
        
		rootView.setOnKeyListener(new OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
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
		adapter = new MediaGridViewImageAdapter(columnWidth, this.getActivity(),imageURL,mImageLoader);
        
        // setting grid view adapter
        gridView.setAdapter(adapter);
		
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();

		mImageLoader.destroy();
	}

	private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,SliderConstant.GRID_PADDING, r.getDisplayMetrics());
 
        columnWidth = (int) ((Tools.getScreenWidth(rootView.getContext()) - ((SliderConstant.NUM_OF_COLUMNS + 1) * padding)) / SliderConstant.NUM_OF_COLUMNS);
 
        gridView.setNumColumns(SliderConstant.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding,
                (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }

}
