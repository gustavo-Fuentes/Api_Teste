package com.example.weather_api.API.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    @Expose
    private double temperatura_atual;

    @SerializedName("feels_like")
    @Expose
    private double sensacao_temperatura;

    @SerializedName("temp_min")
    @Expose
    private double temperatura_minima;

    @SerializedName("temp_max")
    @Expose
    private double temperatura_maxima;

    @SerializedName("pressure")
    @Expose
    private int pressao;

    @SerializedName("humidity")
    @Expose
    private int humidade;

    public Main(double temperatura_atual,
                double sensacao_temperatura,
                double temperatura_minima,
                double temperatura_maxima,
                int pressao,
                int humidade) {

        this.temperatura_atual = temperatura_atual;
        this.sensacao_temperatura = sensacao_temperatura;
        this.temperatura_minima = temperatura_minima;
        this.temperatura_maxima = temperatura_maxima;
        this.pressao = pressao;
        this.humidade = humidade;
    }

    public double getTemperatura_atual() {
        return temperatura_atual;
    }

    public void setTemperatura_atual(double temperatura_atual) {
        this.temperatura_atual = temperatura_atual;
    }

    public double getSensacao_temperatura() {
        return sensacao_temperatura;
    }

    public void setSensacao_temperatura(double sensacao_temperatura) {
        this.sensacao_temperatura = sensacao_temperatura;
    }

    public double getTemperatura_minima() {
        return temperatura_minima;
    }

    public void setTemperatura_minima(double temperatura_minima) {
        this.temperatura_minima = temperatura_minima;
    }

    public double getTemperatura_maxima() {
        return temperatura_maxima;
    }

    public void setTemperatura_maxima(double temperatura_maxima) {
        this.temperatura_maxima = temperatura_maxima;
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
}
