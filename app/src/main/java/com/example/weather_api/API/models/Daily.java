package com.example.weather_api.API.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {


    @SerializedName("weather")
    private List<Weather> clima;

    @SerializedName("pressure")
    private int pressao;

    @SerializedName("humidity")
    private int humidade;

    @SerializedName("wind_speed")
    private double vento_velocidade;

    @SerializedName("wind_deg")
    private double vento_graus;

    @SerializedName("clouds")
    private int nuvens;

    @SerializedName("pop")
    private double pop;

    @SerializedName("rain")
    private double chuva;

    @SerializedName("uvi")
    private double nivel_uv;

    public List<Weather> getClima() {
        return clima;
    }

    public void setClima(List<Weather> clima) {
        this.clima = clima;
    }

    public int getPressao() {
        return pressao;
    }

    public void setPressao(int pressao) {
        this.pressao = pressao;
    }

    public int getHumidade() {
        return humidade;
    }

    public void setHumidade(int humidade) {
        this.humidade = humidade;
    }

    public double getVento_velocidade() {
        return vento_velocidade;
    }

    public void setVento_velocidade(double vento_velocidade) {
        this.vento_velocidade = vento_velocidade;
    }

    public double getVento_graus() {
        return vento_graus;
    }

    public void setVento_graus(double vento_graus) {
        this.vento_graus = vento_graus;
    }

    public int getNuvens() {
        return nuvens;
    }

    public void setNuvens(int nuvens) {
        this.nuvens = nuvens;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public double getChuva() {
        return chuva;
    }

    public void setChuva(double chuva) {
        this.chuva = chuva;
    }

    public double getNivel_uv() {
        return nivel_uv;
    }

    public void setNivel_uv(double nivel_uv) {
        this.nivel_uv = nivel_uv;
    }
}
