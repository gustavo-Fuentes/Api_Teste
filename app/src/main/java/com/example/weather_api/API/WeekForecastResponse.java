package com.example.weather_api.API;

import com.example.weather_api.API.models.Daily;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeekForecastResponse { //Objeto resposta do clima da semana
    @SerializedName("lat")
    private double lat;

    @SerializedName("lon")
    private double lon;

    @SerializedName("timezone")
    private String timezone;



    @SerializedName("daily")
    private List<Daily> dia;



    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }


}
