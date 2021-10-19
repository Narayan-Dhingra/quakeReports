package com.example.quakereports.Modal;

import androidx.annotation.NonNull;

public class EarthQuake {

    private String cityName;
    private long time;
    private double magnitude;
    private String url;

    public EarthQuake(String cityName, long time, double magnitude, String url) {
        this.cityName = cityName;
        this.time = time;
        this.magnitude = magnitude;
        this.url = url;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @NonNull
    @Override
    public String toString() {
        return "EarthQuake{" +
                "cityName='" + cityName + '\'' +
                ", date=" + time +
                ", magnitude=" + magnitude +
                '}';
    }
}
