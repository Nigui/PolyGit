package com.example.polyjoule.info;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.TextView;

import com.example.polyjoule.DBObjects.Article;
import com.example.polyjoule.DBObjects.Rubrique;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.example.polyjoule.slidingmenu.MainActivity;
import com.polyjoule.application.R;

public class InfoFragment extends Fragment{


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_info, container, false);

		/** Initialise l'interface, le header **/

		TextView text1= (TextView) rootView.findViewById(R.id.partenaire);
		TextView text2= (TextView) rootView.findViewById(R.id.equipe);
		TextView text3= (TextView) rootView.findViewById(R.id.historique);
		TextView text4= (TextView) rootView.findViewById(R.id.persoCle);
		TextView text5= (TextView) rootView.findViewById(R.id.contact);


		text1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				((MainActivity)getActivity()).changePartenaire();
			}
		});

		text2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				((MainActivity)getActivity()).changeFragment(new EquipesFragment());
			}
		});
		text3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ArrayList<Rubrique> listRubrique = new DataBaseGetters(container.getContext()).getRubriqueFromDBWhithID(8);
				((MainActivity)getActivity()).changeArticle(listRubrique.get(0).getTitreFR(), listRubrique.get(0).getDescriptionFR());
			}
		});

		text4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				PersoCle perso = new PersoCle();
				((MainActivity)getActivity()).changeFragment(perso);
			}
		});
		text5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ContactFragment contact = new ContactFragment();
				((MainActivity)getActivity()).changeFragment(contact);
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