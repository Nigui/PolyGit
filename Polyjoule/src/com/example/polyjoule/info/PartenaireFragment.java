package com.example.polyjoule.info;

import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.ListView;

import com.example.polyjoule.DBObjects.Partenaire;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.polyjoule.application.R;
import com.xtremelabs.imageutils.ImageLoader;

public class PartenaireFragment extends ListFragment {

	private ArrayList<Partenaire> listPartenaire;
	private ImageLoader mImageLoader;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		listPartenaire = new DataBaseGetters(getActivity()).getPartenairesFromDB();;

		mImageLoader = ImageLoader.buildImageLoaderForSupportFragment(this);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_partenaire, container, false);

		/** Initialise l'interface, le header **/	  

		setListAdapter(new PartenaireAdapter(this,listPartenaire,mImageLoader));
		
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
		// TODO Auto-generated method stub
		super.onDestroy();

		mImageLoader.destroy();
	}

	/**
	 * Implemetation of onResume.
	 */
	public void onResume() {
		super.onResume();
		setListAdapter(new PartenaireAdapter(this,listPartenaire,mImageLoader));

	}

	/**
	 * Listener of listview child. Save child as current city and read trail of
	 * it. Launch MenuCityActivity.
	 */
	public void onListItemClick(ListView l, View v, int position, long id) {

		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(listPartenaire.get(position).getWebsiteURL()));
		startActivity(intent);

	}
}
