package com.example.polyjoule.news;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.example.polyjoule.slidingmenu.MainActivity;
import com.polyjoule.application.R;
import com.xtremelabs.imageutils.ImageLoader;

public class NewsFragment extends ListFragment {

	private ArrayList<Article> listArticle;

	/** GUI **/
	LinearLayout headerLayout;

	private ImageLoader mImageLoader;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//ListView

		//Activer lorsqu'on est connecter au wifi de poly
		listArticle = new ArrayList<Article>();

		mImageLoader = ImageLoader.buildImageLoaderForSupportFragment(this);

		listArticle = new DataBaseGetters(getActivity()).getArticlesFromDB(10);

	}
	

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		this.getView().setFocusableInTouchMode(true);
		this.getView().requestFocus();
		this.getView().setOnKeyListener(new OnKeyListener()
        {	@Override
			public boolean onKey( View v, int keyCode, KeyEvent event ){
        		if( keyCode == KeyEvent.KEYCODE_BACK ){
        			getActivity().finish();
        		}
        		return true;
        	}
        } );
	}


	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_news, container, false);

		/** Initialise l'interface, le header **/

		setListAdapter(new NewsAdapter(this,listArticle,mImageLoader));

		return rootView;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		mImageLoader.destroy();
	}

	/**
	 * Implemetation of onResume.
	 */
	public void onResume() {
		super.onResume();
		setListAdapter(new NewsAdapter(this,listArticle,mImageLoader));

	}

	/**
	 * Listener of listview child. Save child as current city and read trail of
	 * it. Launch MenuCityActivity.
	 */
	public void onListItemClick(ListView l, View v, int position, long id) {

		((MainActivity)getActivity()).changeArticle(listArticle.get(position).getTitreFr(), listArticle.get(position+1).getContenuFr());


	}
}
