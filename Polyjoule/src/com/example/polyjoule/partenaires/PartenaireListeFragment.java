package com.example.polyjoule.partenaires;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.polyjoule.R;
import com.example.polyjoule.DBObjects.Partenaire;
import com.example.polyjoule.externeDataBase.DataBaseGetters;

public class PartenaireListeFragment extends Activity implements OnItemClickListener{

	private ArrayList<Partenaire> partenaireListe;
	private static final String partenaireURL = "http://www.polyjoule.org/administration/ressources/data/Logos/";
	
	private ListView listView;
    private List<PartenaireItem> rowItems;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		partenaireListe = DataBaseGetters.getPartenairesFromDB();
		
		setContentView(R.layout.partenaire_liste);
		
		rowItems = new ArrayList<PartenaireItem>();
		for(int i=0;i<partenaireListe.size();i++){
			PartenaireItem item = new PartenaireItem(partenaireURL.concat(partenaireListe.get(i).getLogoURL()));
			rowItems.add(item);
		}
		
		listView = (ListView) findViewById(R.id.partenaire_liste);
		PartenaireListeAdapter adapter = new PartenaireListeAdapter(this, R.layout.partenaire_liste_item, rowItems);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		
	}
	
	@Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
            "Item " + (position + 1) + ": " + rowItems.get(position),
            Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

}
