package com.example.polyjoule.info;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.polyjoule.DBObjects.Participant;
import com.example.polyjoule.DBObjects.Participation;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.polyjoule.application.R;
import com.xtremelabs.imageutils.ImageLoader;
import com.xtremelabs.imageutils.ImageRequest;

public class PersoCle extends Fragment{
	private ImageView image1;
	private ImageView image2;
	private TextView role1; 
	private TextView role2;
	private TextView nom1;
	private TextView nom2;
	private WebView desciption1;
	private WebView desciption2;
	
	private ArrayList<Participant> perso1;
	private ArrayList<Participation> perso1Role;
	private ArrayList<Participant> perso2;
	private ArrayList<Participation> perso2Role;
	
	private ImageRequest request;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_perso_cle, container, false);
		
		ImageLoader mImageLoader = ImageLoader.buildImageLoaderForSupportFragment(this);
			
		 // les d��finitions de type mime et de l'encodage
	      final String mimeType = "text/html";
	      final String encoding = "utf-8";
		
		perso1 = new DataBaseGetters(container.getContext()).getParticipantsFromDBWithID(10);
		perso2 = new DataBaseGetters(container.getContext()).getParticipantsFromDBWithID(11);
		perso1Role = new DataBaseGetters(container.getContext()).getParticipationFromDBWithID(10);
		perso2Role = new DataBaseGetters(container.getContext()).getParticipationFromDBWithID(11);
		
		image1= (ImageView) rootView.findViewById(R.id.imagePerso1);
		image2= (ImageView) rootView.findViewById(R.id.imagePerso2);
		role1= (TextView) rootView.findViewById(R.id.role1);
		role2= (TextView) rootView.findViewById(R.id.role2);
		nom1= (TextView) rootView.findViewById(R.id.nom1);
		nom2= (TextView) rootView.findViewById(R.id.nom2);
		desciption1= (WebView) rootView.findViewById(R.id.description1);
		desciption2= (WebView) rootView.findViewById(R.id.description2);
		
		//Images
		request = new ImageRequest("http://www.polyjoule.org/administration/ressources/data/Participants/"+perso1.get(0).getPhotoURL());
		request.setImageView(image1);
		mImageLoader.loadImage(request);
		
		request = new ImageRequest("http://www.polyjoule.org/administration/ressources/data/Participants/"+perso2.get(0).getPhotoURL());
		request.setImageView(image2);
		mImageLoader.loadImage(request);
		
		//Textes
		role1.setText(perso1Role.get(0).getRole());
		role2.setText(perso2Role.get(0).getRole());
		nom1.setText(perso1.get(0).getNom());
		nom2.setText(perso2.get(0).getNom());
		desciption1.loadData(perso1.get(0).getBioFR(), mimeType, encoding);
		desciption2.loadData(perso2.get(0).getBioFR(), mimeType, encoding);
        
        return rootView;
	}
	
	public void onResume() {
		super.onResume();
		
	}
	
}