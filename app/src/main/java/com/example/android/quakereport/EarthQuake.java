package com.example.android.quakereport;

/**
 * Created by srinivas on 12/19/16.
 *
 * EarthQuake POJO class
 */
public class EarthQuake {

    private String cityName;
    private Double magnitude;
    private String date;

    public EarthQuake() {
    }

    public EarthQuake(String cityName, Double magnitude, String date) {
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

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
