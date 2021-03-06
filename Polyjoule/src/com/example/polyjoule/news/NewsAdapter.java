package com.example.polyjoule.news;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.utils.Tools;
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

public class NewsAdapter extends BaseAdapter {


	/**
	 * List of news to shows.
	 */
	private ArrayList<Article> articles;
	private Article header;

	/**
	 * Layout inflater of NewsActivity use to inflate News_item.
	 */
	private LayoutInflater layoutInflater;

	private Context context;

	private ImageLoader imageloader;
	private AdapterImagesAssistant mImagePrecacheAssistant;

	
	private Dimensions mBounds;
	private Options mOptions;


	/**
	 * Constructor of NewsAdapter. news member is initialize with NewsList.
	 * @param newsActivity reference on newsActivity.
	 * @param NewsList list of item to show on listView.
	 */
	public NewsAdapter(NewsFragment newsFragment, ArrayList<Article> articleList,ImageLoader mloader) {
		this.header = articleList.get(0);
		this.articles = articleList;
		this.context = newsFragment.getActivity().getApplicationContext();
		layoutInflater= LayoutInflater.from(context);
		this.imageloader = mloader;

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
				return NewsAdapter.this.getCount();
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
		itemHolder= new ItemHolder();
		Article art = articles.get(position);
		
		if(articles.get(position).equals(header)){
	
				convertView=layoutInflater.inflate(R.layout.item_header,parent,false);
				itemHolder.imageView = (ImageView)convertView.findViewById(R.id.news_header_image);
				itemHolder.titleView= (TextView)convertView.findViewById(R.id.news_header_title);
				itemHolder.dateView = (TextView)convertView.findViewById(R.id.news_header_date);
		
				convertView.setTag(itemHolder);
		}
		else{	
				convertView=layoutInflater.inflate(R.layout.news_item,parent,false);
				itemHolder.imageView = (ImageView)convertView.findViewById(R.id.news_list_image);
				itemHolder.titleView= (TextView)convertView.findViewById(R.id.news_list_title);
				itemHolder.dateView = (TextView)convertView.findViewById(R.id.news_list_date);
	
				convertView.setTag(itemHolder);
		}

		/** Initialisation avec les données **/
		/** titre **/
		itemHolder.titleView.setText(art.getTitreFr());
		/** date **/
		itemHolder.dateView.setText(art.getSimpleDateFormat());
		/** image **/
		Options o = new Options();

		ImageRequest request = new ImageRequest(itemHolder.imageView,art.getUrlPhotoPrincipale());
		request.setImageLoaderListener(mListener);
		request.setOptions(o);
		mImagePrecacheAssistant.loadImage(request, position);

		/** fin initialisation **/

		return convertView;
	}	

	/**
	 * Inner class use to save reference of News_item
	 */
	class ItemHolder{


		private ImageView imageView;

		/**
		 * Reference on R.id.news_name
		 */
		private TextView titleView;

		private TextView dateView;
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
