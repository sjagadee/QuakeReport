package com.example.android.quakereport;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        TextView tvTime = (TextView) listItemView.findViewById(R.id.tvTime);

        tvMagnitude.setText(String.valueOf(curEarthQuake.getMagnitude()));
        tvCityName.setText(curEarthQuake.getCityName());

        String data = curEarthQuake.getDate();
        long inMilliSecondDate = Long.valueOf(data);

        Date dateObj = new Date(inMilliSecondDate);

        tvDate.setText(formattedDate(dateObj));
        tvTime.setText(formattedTime(dateObj));

        return listItemView;
    }

    private String formattedDate(Date dateObj) {

        SimpleDateFormat simpleDate = new SimpleDateFormat("LLL dd, yyyy");
        return simpleDate.format(dateObj);

    }

    private String formattedTime(Date dateObj) {

        SimpleDateFormat simpleDate = new SimpleDateFormat("h:mm a");
        return simpleDate.format(dateObj);

    }
}
