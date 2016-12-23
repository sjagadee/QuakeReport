package com.example.android.quakereport;


import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
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
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) tvMagnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(curEarthQuake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

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

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.mag1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.mag2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.mag3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.mag4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.mag5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.mag6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.mag7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.mag8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.mag9;
                break;
            default:
                magnitudeColorResourceId = R.color.mag10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
