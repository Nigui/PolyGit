package com.example.polyjoule.live.medias;

import java.util.ArrayList;
import java.util.List;

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
import com.xtremelabs.imageutils.AdapterImagesAssistant;
import com.xtremelabs.imageutils.ImageLoader;
import com.xtremelabs.imageutils.ImageRequest;
import com.xtremelabs.imageutils.PrecacheRequest;
import com.xtremelabs.imageutils.AdapterImagesAssistant.PrecacheInformationProvider;
import com.xtremelabs.imageutils.ImageLoader.Options;

public class MediasFullScreenAdapter extends PagerAdapter {
 
    private Activity _activity;
    private ArrayList<String> _imagePaths;
    private LayoutInflater inflater;
    
    private ImageLoader mImageLoader;
	private ImageRequest request;
	private AdapterImagesAssistant mImagePrecacheAssistant;
	private LayoutInflater layoutInflater;
 
    // constructor
    public MediasFullScreenAdapter(Activity activity,ArrayList<String> imagePaths,ImageLoader imageLoader) {
        this._activity = activity;
        this._imagePaths = imagePaths;
        

		layoutInflater = LayoutInflater.from(activity.getApplicationContext());
        this.mImageLoader = imageLoader;
        
        mImagePrecacheAssistant = new AdapterImagesAssistant(this.mImageLoader, new PrecacheInformationProvider() {
			@Override
			public int getCount() {
				return getCount();
			}

			@Override
			public List<String> getRequestsForDiskPrecache(int position) {
				List<String> list = new ArrayList<String>();
				// if (position % 2 == 0) {
				list.add((String) _imagePaths.get(position) + "1");
				list.add((String) _imagePaths.get(position) + "2");
				return list;
			}

			@Override
			public List<PrecacheRequest> getRequestsForMemoryPrecache(int position) {
				List<PrecacheRequest> list = new ArrayList<PrecacheRequest>();
				list.add(new PrecacheRequest((String) _imagePaths.get(position) + "1", new Options()));
				list.add(new PrecacheRequest((String) _imagePaths.get(position) + "2", new Options()));
				return list;
			}
		});
    
        mImagePrecacheAssistant.setMemCacheRange(5);
		mImagePrecacheAssistant.setDiskCacheRange(10);
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
