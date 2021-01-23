package com.example.weather_api.API.models;

import com.google.gson.annotations.SerializedName;

public class Temp {

    @SerializedName("day")
    private double dia;

    @SerializedName("min")
    private double temp_minima;

    @SerializedName("max")
    private double temp_maxima;

    @SerializedName("night")
    private double temp_noite;

    @SerializedName("eve")
    private double eve;

    @SerializedName("morn")
    private double temp_manha;

    public double getDia() {
        return dia;
    }

    public void setDia(double dia) {
        this.dia = dia;
    }

    public double getTemp_minima() {
        return temp_minima;
    }

    public void setTemp_minima(double temp_minima) {
        this.temp_minima = temp_minima;
    }

    public double getTemp_maxima() {
        return temp_maxima;
    }

    public void setTemp_maxima(double temp_maxima) {
        this.temp_maxima = temp_maxima;
    }

    public double getTemp_noite() {
        return temp_noite;
    }

    public void setTemp_noite(double temp_noite) {
        this.temp_noite = temp_noite;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getTemp_manha() {
        return temp_manha;
    }

    public void setTemp_manha(double temp_manha) {
        this.temp_manha = temp_manha;
    }
}
