package com.example.weather_api.API.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys {

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNascer_sol() {
        return nascer_sol;
    }

    public void setNascer_sol(int nascer_sol) {
        this.nascer_sol = nascer_sol;
    }

    public int getPor_sol() {
        return por_sol;
    }

    public void setPor_sol(int por_sol) {
        this.por_sol = por_sol;
    }

    public Sys(String pais, int nascer_sol, int por_sol) {
        this.pais = pais;
        this.nascer_sol = nascer_sol;
        this.por_sol = por_sol;
    }

    @SerializedName("country")
    @Expose
    private String pais;

    @SerializedName("sunrise")
    @Expose
    private int nascer_sol;

    @SerializedName("sunset")
    @Expose
    private int por_sol;
}
