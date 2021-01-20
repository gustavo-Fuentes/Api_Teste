package com.example.cep_api.API;

import com.example.cep_api.API.models.Clouds;
import com.example.cep_api.API.models.Coordenada;
import com.example.cep_api.API.models.Main;
import com.example.cep_api.API.models.Sys;
import com.example.cep_api.API.models.Weather;
import com.example.cep_api.API.models.Wind;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ClimaResponse { //Objeto raiz

    @SerializedName("base")
    @Expose
    private String base;

    @SerializedName("visibility")
    @Expose
    private int visibilidade;

    @SerializedName("dt")
    @Expose
    private int dt;

    @SerializedName("timezone")
    @Expose
    private int tempoZona;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String nome;
//------------------------------------------------


    @SerializedName("cod")
    @Expose
    private int codigoResposta;

    @SerializedName("coord")
    @Expose
    private Coordenada coord;

    @SerializedName("weather")
    @Expose
    private List<Weather> clima;

    @SerializedName("main")
    @Expose
    private Main temperaturas;

    @SerializedName("wind")
    @Expose
    private Wind vento;

    @SerializedName("clouds")
    @Expose
    private Clouds nuvens;

    @SerializedName("sys")
    @Expose
    private Sys sys;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(int visibilidade) {
        this.visibilidade = visibilidade;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getTempoZona() {
        return tempoZona;
    }

    public void setTempoZona(int tempoZona) {
        this.tempoZona = tempoZona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoResposta() {
        return codigoResposta;
    }

    public void setCodigoResposta(int codigoResposta) {
        this.codigoResposta = codigoResposta;
    }

    public Coordenada getCoord() {
        return coord;
    }

    public void setCoord(Coordenada coord) {
        this.coord = coord;
    }

    public List<Weather> getClima() {
        return clima;
    }

    public void setClima(List<Weather> clima) {
        this.clima = clima;
    }

    public Main getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(Main temperaturas) {
        this.temperaturas = temperaturas;
    }

    public Wind getVento() {
        return vento;
    }

    public void setVento(Wind vento) {
        this.vento = vento;
    }

    public Clouds getNuvens() {
        return nuvens;
    }

    public void setNuvens(Clouds nuvens) {
        this.nuvens = nuvens;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }
}
