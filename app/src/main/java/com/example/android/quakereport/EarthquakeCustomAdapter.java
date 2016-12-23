package com.example.android.quakereport;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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
        TextView tvDistanceFromTheCity = (TextView) listItemView.findViewById(R.id.tvDistanceFromCity);
        TextView tvCityName = (TextView) listItemView.findViewById(R.id.tvNameofCity);
        TextView tvDate = (TextView) listItemView.findViewById(R.id.tvDate);
        TextView tvTime = (TextView) listItemView.findViewById(R.id.tvTime);

        // Setting city and the distance from the city where the earthquake occurred
        String name = curEarthQuake.getCityName();
        if(name.matches("(?i).*of.*")) {
            String[] parts = name.split("(?<=of)");
            tvDistanceFromTheCity.setText(parts[0]);
            tvCityName.setText(parts[1]);
        } else {
            tvDistanceFromTheCity.setText("Near the");
            tvCityName.setText(name);
        }

        // Setting text for magnitude
        tvMagnitude.setText(formatMagnitude(curEarthQuake.getMagnitude()));

        String data = curEarthQuake.getDate();
        long inMilliSecondDate = Long.valueOf(data);

        Date dateObj = new Date(inMilliSecondDate);

        // Setting time for Date and time
        tvDate.setText(formatDate(dateObj));
        tvTime.setText(formatTime(dateObj));

        return listItemView;
    }

    /*
        Double magnitude = 8.5643;
        if we pass magnitude then the out put would be 8.5 in String format
     */
    private String formatMagnitude(Double magnitude) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(magnitude);
    }

    private String formatDate(Date dateObj) {

        SimpleDateFormat simpleDate = new SimpleDateFormat("LLL dd, yyyy");
        return simpleDate.format(dateObj);

    }

    private String formatTime(Date dateObj) {

        SimpleDateFormat simpleDate = new SimpleDateFormat("h:mm a");
        return simpleDate.format(dateObj);

    }
}
