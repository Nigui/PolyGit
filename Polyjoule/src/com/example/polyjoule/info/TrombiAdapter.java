package com.example.polyjoule.info;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.polyjoule.DBObjects.Membre;
import com.polyjoule.application.R;
import com.xtremelabs.imageutils.ImageLoader;
import com.xtremelabs.imageutils.ImageRequest;

public class TrombiAdapter extends BaseAdapter{

	private ArrayList<Membre> membres;
	private Context context;
	private ImageLoader mloader;
	private LayoutInflater layoutInflater;
	private ImageRequest request;
	
	
	
	
	public TrombiAdapter(Context context,ArrayList<Membre> membres,ImageLoader mloader) {
		super();
		this.membres = membres;
		this.context = context;
		this.mloader = mloader;
		layoutInflater= LayoutInflater.from(this.context);
		
	}

	@Override
	public int getCount() {
		if( membres == null ) return 0;
		else return membres.size();
	}

	@Override
	public Object getItem(int position) {
		return membres.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	class ItemHolder{

		private ImageView photoMembre;
		private TextView nom;
		private TextView fonction;
		private TextView mail;
		private WebView description;
		private ImageView more;
		private LinearLayout parent;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ItemHolder item = new ItemHolder();
		Membre membre = membres.get(position);
		
		convertView=layoutInflater.inflate(R.layout.equipe_trombi_item, parent,false);
		item.photoMembre = (ImageView)convertView.findViewById(R.id.membre_photo);
		item.nom = (TextView)convertView.findViewById(R.id.membre_nom);
		item.fonction = (TextView)convertView.findViewById(R.id.membre_fonction);
		item.mail = (TextView)convertView.findViewById(R.id.membre_mail);
		item.description = (WebView)convertView.findViewById(R.id.membre_description);
		item.more = (ImageView)convertView.findViewById(R.id.membre_more);
		item.parent = (LinearLayout) convertView.findViewById(R.id.membre_layout);
		
		//Initialisation de la photo
		if( membre.getPhotoPath()!=null && !membre.getPhotoPath().isEmpty()){
			request = new ImageRequest("http://www.polyjoule.org/administration/ressources/data/Participants/"+membre.getPhotoPath());
			request.setImageView(item.photoMembre);
			mloader.loadImage(request);
		}
		
		//initialisation des données de l'interface
		item.nom.setText(membre.getPrenom()+" "+membre.getNom().toUpperCase());
		item.fonction.setText(membre.getRole());
		item.mail.setText(membre.getMail());
		item.description.loadData(membre.getBioFR(), "text/html", "utf-8");
		item.description.setVisibility(View.GONE);
		item.more.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if( item.description.getVisibility() == View.VISIBLE ){
					item.description.setVisibility(View.GONE);
					item.more.setImageResource(R.drawable.arrow_down);
				}
				else{
					item.description.setVisibility(View.VISIBLE);
					item.more.setImageResource(R.drawable.arrow_up);
				}
				item.description.reload();
			}
		});
		
		item.parent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if( item.description.getVisibility() == View.VISIBLE ){
					item.description.setVisibility(View.GONE);
					item.more.setImageResource(R.drawable.arrow_down);
				}
				else{
					item.description.setVisibility(View.VISIBLE);
					item.more.setImageResource(R.drawable.arrow_up);
				}
				item.description.reload();
			}
		});
		
		return convertView;
	}

}
