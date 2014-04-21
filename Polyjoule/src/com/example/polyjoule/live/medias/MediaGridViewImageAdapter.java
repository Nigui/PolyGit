package com.example.polyjoule.live.medias;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.polyjoule.slidingmenu.MainActivity;
import com.xtremelabs.imageutils.AdapterImagesAssistant;
import com.xtremelabs.imageutils.AdapterImagesAssistant.PrecacheInformationProvider;
import com.xtremelabs.imageutils.ImageLoader;
import com.xtremelabs.imageutils.ImageLoader.Options;
import com.xtremelabs.imageutils.ImageLoaderListener;
import com.xtremelabs.imageutils.ImageRequest;
import com.xtremelabs.imageutils.ImageReturnedFrom;
import com.xtremelabs.imageutils.PrecacheRequest;

public class MediaGridViewImageAdapter extends BaseAdapter {

	private int imageWidth;
	private Activity _activity;
	private ArrayList<String> listImagesURL;
	
	private AdapterImagesAssistant mImagePrecacheAssistant;
	private ImageLoader imageloader;
	private Options mOptions;
	private LayoutInflater layoutInflater;
	private Context context;
	

	public MediaGridViewImageAdapter(int imageWidth, Activity _activity,ArrayList<String> listImagesURL,ImageLoader mloader) {
		super();
		this.imageWidth = imageWidth;
		this._activity = _activity;
		this.listImagesURL = listImagesURL;
		
		this.context = _activity.getApplicationContext();
		layoutInflater = LayoutInflater.from(this.context);
		this.imageloader = mloader;
		
		mImagePrecacheAssistant = new AdapterImagesAssistant(imageloader, new PrecacheInformationProvider() {
			@Override
			public int getCount() {
				return getCount();
			}

			@Override
			public List<String> getRequestsForDiskPrecache(int position) {
				List<String> list = new ArrayList<String>();
				// if (position % 2 == 0) {
				list.add((String) getItem(position) + "1");
				list.add((String) getItem(position) + "2");
				return list;
			}

			@Override
			public List<PrecacheRequest> getRequestsForMemoryPrecache(int position) {
				List<PrecacheRequest> list = new ArrayList<PrecacheRequest>();
				list.add(new PrecacheRequest((String) getItem(position) + "1", new Options()));
				list.add(new PrecacheRequest((String) getItem(position) + "2", new Options()));
				return list;
			}
		});

		mImagePrecacheAssistant.setMemCacheRange(5);
		mImagePrecacheAssistant.setDiskCacheRange(10);
	}

	@Override
	public int getCount() {
		return this.listImagesURL.size();
	}

	@Override
	public Object getItem(int position) {
		return this.listImagesURL.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(_activity);
        } else {
            imageView = (ImageView) convertView;
        }
        
        ImageRequest request = new ImageRequest(imageView,listImagesURL.get(position));
		request.setImageLoaderListener(mListener);
		mImagePrecacheAssistant.loadImage(request, position);
		
        // image view click listener
        imageView.setOnClickListener(new OnImageClickListener(position));
 
        return imageView;
        
	}

	class OnImageClickListener implements OnClickListener {
		 
        int _postion;
 
        // constructor
        public OnImageClickListener(int position) {
            this._postion = position;
        }
 
        @Override
        public void onClick(View v) {
        	// on selecting grid view image
            // launch full screen activity
        	Fragment frag = new MediasFullScreenFragment(listImagesURL);
        	Bundle bundl = new Bundle();
        	bundl.putInt("position", _postion);
        	frag.setArguments(bundl);
        	((MainActivity)_activity).changeFragment(frag);
        }
 
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
