package com.example.polyjoule.info;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.polyjoule.application.R;

public class ContactFragment extends Fragment{
	
	private ImageView facebook;
	private ImageView twitter;
	private EditText email;
	private EditText objet;
	private EditText message;
	private Button envoie;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.activity_contact, container, false);
        
		
		facebook = (ImageView) rootView.findViewById(R.id.contactfacebook);
		twitter = (ImageView) rootView.findViewById(R.id.contacttwitter);
		objet = (EditText) rootView.findViewById(R.id.contactobjet);
		message = (EditText) rootView.findViewById(R.id.contactmessage);
		envoie = (Button) rootView.findViewById(R.id.contactenvoie);
		
		facebook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String facebookURL = rootView.getResources().getString(R.string.facebook);
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookURL));
				startActivity(intent);
			}
		});
		
		twitter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String twitterUrl = rootView.getResources().getString(R.string.twitter);
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl));
				startActivity(intent);
			}
		});
		
		envoie.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String subject = objet.getText().toString();
				String content = message.getText().toString();
				String to = rootView.getResources().getString(R.string.contactemail);;
				

				Builder d = new AlertDialog.Builder(rootView.getContext())
                .setTitle("Erreur dans le formulaire")
                .setPositiveButton(android.R.string.ok, null);
				
				if( subject == null || subject.isEmpty() ){
					d.setMessage("Veuillez saisir un objet");
					d.show();
				}
				else if( content == null || content.isEmpty() ){
					d.setMessage("Veuillez saisir un message");
					d.show();
				}
				else{
					Intent email = new Intent(Intent.ACTION_SEND);
					email.putExtra(Intent.EXTRA_EMAIL, to);
					email.putExtra(Intent.EXTRA_SUBJECT, subject);
					email.putExtra(Intent.EXTRA_TEXT, content);
	 
					//need this to prompts email client only
					email.setType("message/rfc822");
	 
					startActivity(Intent.createChooser(email, "Choose an Email client :"));
				}
			}
		});
		
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
	
	public void onResume() {
		super.onResume();
		
	}
	
}
