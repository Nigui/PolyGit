package com.example.polyjoule.live.medias;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.polyjoule.application.R;
import com.xtremelabs.imageutils.AdapterImagesAssistant;
import com.xtremelabs.imageutils.AdapterImagesAssistant.PrecacheInformationProvider;
import com.xtremelabs.imageutils.Dimensions;
import com.xtremelabs.imageutils.ImageLoader;
import com.xtremelabs.imageutils.ImageLoader.Options;
import com.xtremelabs.imageutils.ImageLoaderListener;
import com.xtremelabs.imageutils.ImageRequest;
import com.xtremelabs.imageutils.ImageReturnedFrom;
import com.xtremelabs.imageutils.PrecacheRequest;

public class MediasFullScreenAdapter extends PagerAdapter {
 
    private Activity _activity;
    private ArrayList<String> _imagePaths;
    private LayoutInflater inflater;
    
    private ImageLoader mImageLoader;
	private ImageRequest request;
	private AdapterImagesAssistant mImagePrecacheAssistant;
	private LayoutInflater layoutInflater;
	private final Dimensions mBounds;
	private final Options mOptions;
 
    // constructor
    public MediasFullScreenAdapter(Activity activity,ArrayList<String> imagePaths,ImageLoader imageLoader) {
        this._activity = activity;
        this._imagePaths = imagePaths;
        

		layoutInflater = LayoutInflater.from(activity.getApplicationContext());
        this.mImageLoader = imageLoader;

        Point size = new Point();
        try {
        	activity.getWindowManager().getDefaultDisplay().getSize(size);
        } catch (java.lang.NoSuchMethodError ignore) { // Older device
        	size.x = activity.getWindowManager().getDefaultDisplay().getWidth();
        	size.y = activity.getWindowManager().getDefaultDisplay().getHeight();
        }
		mBounds = new Dimensions(size.x / 2, (int) ((size.x / 800f) * 200f));
		mOptions = new Options();
		mOptions.widthBounds = mBounds.width;
		mOptions.heightBounds = mBounds.height;
        
        mImagePrecacheAssistant = new AdapterImagesAssistant(this.mImageLoader, new PrecacheInformationProvider() {
			@Override
			public int getCount() {
				return getCount();
			}

			@Override
			public List<String> getRequestsForDiskPrecache(int position) {
				List<String> list = new ArrayList<String>();
				list.add((String) _imagePaths.get(position) + "1");
				list.add((String) _imagePaths.get(position) + "2");
				return list;
			}

			@Override
			public List<PrecacheRequest> getRequestsForMemoryPrecache(int position) {
				List<PrecacheRequest> list = new ArrayList<PrecacheRequest>();
				list.add(new PrecacheRequest((String) _imagePaths.get(position) + "1", mOptions));
				list.add(new PrecacheRequest((String) _imagePaths.get(position) + "2", mOptions));
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
        
        Options o = new Options();
        
        request = new ImageRequest(imgDisplay,_imagePaths.get(position));
		request.setImageLoaderListener(mListener);
		request.setOptions(o);
		mImagePrecacheAssistant.loadImage(request,position);
		
        ((ViewPager) container).addView(viewLayout);
  
        return viewLayout;
    }
     
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
  
    }
    
    ImageLoaderListener mListener = new ImageLoaderListener() {
		@Override
		public void onImageLoadError(String error) {
			Log.i("ImageLoader", "Image load failed! Message: " + error);
		}

		@Override
		public void onImageAvailable(ImageView imageView, Bitmap bitmap, ImageReturnedFrom returnedFrom) {
			imageView.setImageBitmap(bitmap);
		}
	};
}
