package com.example.cep_api.API.models;

import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("temp_c")
    private final double temp_celsius;

    @SerializedName("is_day")
    private final int isDay;

    @SerializedName("condition")
    private final CurrentContitional condicao;

    @SerializedName("humidity")
    private final int humidade;

    @SerializedName("cloud")
    private final int porcentagemNuvem;


    public CurrentContitional getCondicao() {
        return condicao;
    }

    public Current(double temp_celsius, int isDay, CurrentContitional condicao, int humidade, int porcentagemNuvem) {
        this.temp_celsius = temp_celsius;
        this.isDay = isDay;
        this.condicao = condicao;
        this.humidade = humidade;
        this.porcentagemNuvem = porcentagemNuvem;
    }

    public double getTemp_celsius() {
        return temp_celsius;
    }

    public int getIsDay() {
        return isDay;
    }

    public int getHumidade() {
        return humidade;
    }

    public int getPorcentagemNuvem() {
        return porcentagemNuvem;
    }
}


