package com.example.polyjoule.course;

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
import android.widget.ImageView;

import com.example.polyjoule.DBObjects.Rubrique;
import com.example.polyjoule.externeDataBase.DataBaseGetters;
import com.example.polyjoule.slidingmenu.MainActivity;
import com.polyjoule.application.R;

public class CourseFragment extends Fragment{


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_course, container, false);

		/** Initialise l'interface, le header **/

		ImageView educeco= (ImageView) rootView.findViewById(R.id.imageView1);
		ImageView shelleco= (ImageView) rootView.findViewById(R.id.imageView2);
		ImageView voitures= (ImageView) rootView.findViewById(R.id.imageView3);

		educeco.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ArrayList<Rubrique> listRubrique = new DataBaseGetters(container.getContext()).getRubriqueFromDBWhithID(20);
				((MainActivity)getActivity()).changeArticle(listRubrique.get(0).getTitreFR(), listRubrique.get(0).getDescriptionFR());
			}
		});

		shelleco.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ArrayList<Rubrique> listRubrique = new DataBaseGetters(container.getContext()).getRubriqueFromDBWhithID(2);
				((MainActivity)getActivity()).changeArticle(listRubrique.get(0).getTitreFR(), listRubrique.get(0).getDescriptionFR());
			}
		});

		voitures.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Fragment fragment = new VoitureFragment();
				((MainActivity)getActivity()).changeFragment(fragment);
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
