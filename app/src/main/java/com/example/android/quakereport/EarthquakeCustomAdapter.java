package com.example.android.quakereport;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by srinivas on 12/19/16.
 *
 * Custom Adapter
 */
public class EarthquakeCustomAdapter extends ArrayAdapter<EarthQuake>{

    public EarthquakeCustomAdapter(Activity context, ArrayList<EarthQuake> earthQuakes) {
        super(context, 0, earthQuakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView =  convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        EarthQuake curEarthQuake = getItem(position);

        TextView tvMagnitude = (TextView) listItemView.findViewById(R.id.tvMagnitude);
        TextView tvCityName = (TextView) listItemView.findViewById(R.id.tvNameofCity);
        TextView tvDate = (TextView) listItemView.findViewById(R.id.tvDate);

        tvMagnitude.setText(String.valueOf(curEarthQuake.getMagnitude()));
        tvCityName.setText(curEarthQuake.getCityName());
        tvDate.setText(curEarthQuake.getDate());

        return listItemView;
    }
}
