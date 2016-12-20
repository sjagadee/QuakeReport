package com.example.android.quakereport;

/**
 * Created by srinivas on 12/19/16.
 *
 * EarthQuake POJO class
 */
public class EarthQuake {

    private String cityName;
    private float magnitude;
    private String date;

    public EarthQuake() {
    }

    public EarthQuake(String cityName, float magnitude, String date) {
        this.cityName = cityName;
        this.magnitude = magnitude;
        this.date = date;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
