package com.example.polyjoule.info;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.polyjoule.DBObjects.Partenaire;
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

public class PartenaireAdapter extends BaseAdapter {

	
	/**
	 * List of news to shows.
	 */
	private ArrayList<Partenaire> articles;
	
	/**
	 * Layout inflater of NewsActivity use to inflate News_item.
	 */
	private LayoutInflater layoutInflater;
	
	private Context context;
	
	private ImageLoader imageloader;
	private AdapterImagesAssistant mImagePrecacheAssistant;
	
	private final String IMAGE_URI;
	private static final String IMAGE_FILE_NAME = "articleTmpImage.jpg";

	private Dimensions mBounds;
	private Options mOptions;
	
	
	/**
	 * Constructor of NewsAdapter. news member is initialize with NewsList.
	 * @param newsActivity reference on newsActivity.
	 * @param NewsList list of item to show on listView.
	 */
	public PartenaireAdapter(PartenaireFragment partenaireFragment, ArrayList<Partenaire> articleList,ImageLoader mloader) {
		
		this.articles = articleList;
		this.context = partenaireFragment.getActivity().getApplicationContext();
		layoutInflater= LayoutInflater.from(context);
		this.imageloader = mloader;
		
		IMAGE_URI = "file://" + context.getCacheDir() + File.separator + IMAGE_FILE_NAME;
		
		loadImageToFile();
		
		DisplayMetrics display = context.getResources().getDisplayMetrics();

		Point size = new Point();
		size.x = display.widthPixels;
		size.y = display.heightPixels;
		
		mBounds = new Dimensions(size.x / 2, (int) ((size.x / 800f) * 200f));
		mOptions = new Options();
		mOptions.widthBounds = mBounds.width;
		mOptions.heightBounds = mBounds.height;
		
		mImagePrecacheAssistant = new AdapterImagesAssistant(imageloader, new PrecacheInformationProvider() {
			@Override
			public int getCount() {
				return PartenaireAdapter.this.getCount();
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
				list.add(new PrecacheRequest((String) getItem(position) + "1", mOptions));
				list.add(new PrecacheRequest((String) getItem(position) + "2", mOptions));
				return list;
			}
		});
		
		mImagePrecacheAssistant.setMemCacheRange(5);
		mImagePrecacheAssistant.setDiskCacheRange(10);
	}

	/**
	 * Indicate number of item on news.
	 * @return size of news.
	 */
	public int getCount() {
		if( articles == null ) return 0;
		else return articles.size();
	}

	/**
	 * Getter of item corresponding to position.
	 * @param arg0 position of item.
	 * @return item corresponding to position.
	 */
	public Object getItem(int arg0) {
		return articles.get(arg0);
	}

	/**
	 * Method not use.
	 */
	public long getItemId(int position) {
		return 0;
	}

	/**
	 * Method to fill listView.
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ItemHolder itemHolder;
		Partenaire art = articles.get(position);
		
		if(convertView==null){
			
			convertView=layoutInflater.inflate(R.layout.partenaire_item,parent,false);
			
			itemHolder= new ItemHolder();
			itemHolder.imageView = (ImageView)convertView.findViewById(R.id.partenaire_list_image);
			
			convertView.setTag(itemHolder);
		}
		else{
			itemHolder= (ItemHolder)convertView.getTag();
		}
		
		/** Initialisation avec les données **/

		/** image **/
		Options o = new Options();
		
		//ImageRequest request = new ImageRequest(itemHolder.imageView,art.getUrlPhotoPrincipale());
		ImageRequest request = new ImageRequest(itemHolder.imageView,"http://www.polyjoule.org/administration/ressources/data/Logos/"+art.getLogoURL());
		request.setImageLoaderListener(mListener);
		request.setOptions(o);
		mImagePrecacheAssistant.loadImage(request, position);
		
		/** fin initialisation **/
		
		return convertView;
	}	
	
	private void loadImageToFile() {
		StrictMode.setThreadPolicy(ThreadPolicy.LAX);
		try {
			URI uri = new URI(IMAGE_URI);
			final File imageFile = new File(uri.getPath());
			final FileOutputStream fos = new FileOutputStream(imageFile);
			Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.ic_twitter)).getBitmap();
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
		} catch (final FileNotFoundException e) {
			throw new RuntimeException("Could not find kitteh.");
		} catch (URISyntaxException e) {
			throw new RuntimeException("Poorly named kitteh.");
		}
	}
	
	/**
	 * Inner class use to save reference of News_item
	 */
	class ItemHolder{

		private ImageView imageView;
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
