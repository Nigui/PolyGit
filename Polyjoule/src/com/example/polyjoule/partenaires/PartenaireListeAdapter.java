package com.example.polyjoule.partenaires;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.polyjoule.R;
import com.loopj.android.image.SmartImageView;

public class PartenaireListeAdapter extends ArrayAdapter<PartenaireItem> {
	
	Context context;

	public PartenaireListeAdapter(Context context, int textViewResourceId, List<PartenaireItem> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
	}
	
	/*private view holder class*/
    private class ViewHolder {
        SmartImageView imageView;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        PartenaireItem rowItem = getItem(position);
 
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.partenaire_liste_item, null);
            holder = new ViewHolder();
            holder.imageView = (SmartImageView) convertView.findViewById(R.id.partenaire_liste_item_logo);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
 
        holder.imageView.setImageUrl(rowItem.getImageURL());
 
        return convertView;
    }
	
	
}
