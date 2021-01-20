package com.example.cep_api.API.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coordenada {
    @SerializedName("lon")
    @Expose
    private double longitude;

    @SerializedName("lat")
    @Expose
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Coordenada(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
