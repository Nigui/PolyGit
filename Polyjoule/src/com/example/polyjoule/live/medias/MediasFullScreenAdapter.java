package com.example.polyjoule.live.medias;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.polyjoule.application.R;
import com.xtremelabs.imageutils.ImageLoader;
import com.xtremelabs.imageutils.ImageRequest;

public class MediasFullScreenAdapter extends PagerAdapter {
 
    private Activity _activity;
    private ArrayList<String> _imagePaths;
    private LayoutInflater inflater;
    
    private ImageLoader mImageLoader;
	private ImageRequest request;
 
    // constructor
    public MediasFullScreenAdapter(Activity activity,ArrayList<String> imagePaths,ImageLoader imageLoader) {
        this._activity = activity;
        this._imagePaths = imagePaths;
        this.mImageLoader = imageLoader;
    }
 
    @Override
    public int getCount() {
        return this._imagePaths.size();
    }
 
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }
     
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgDisplay;
  
        inflater = (LayoutInflater) _activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.medias_fullscreen_image, container, false);
  
        imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
         
        request = new ImageRequest(_imagePaths.get(position));
		request.setImageView(imgDisplay);
		mImageLoader.loadImage(request);
         
        
  
        ((ViewPager) container).addView(viewLayout);
  
        return viewLayout;
    }
     
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
  
    }
}
