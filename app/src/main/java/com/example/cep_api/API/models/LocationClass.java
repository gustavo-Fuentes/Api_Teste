package com.example.cep_api.API.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationClass {
    @SerializedName("name")
    private String nome;

    @SerializedName("region")
    private String regiao;

    @SerializedName("country")
    private String pais;

    @SerializedName("tz_id")
    private String tz_id;

    public LocationClass(String nome, String regiao, String pais, String tz_id) {
        this.nome = nome;
        this.regiao = regiao;
        this.pais = pais;
        this.tz_id = tz_id;
    }

    public String getPais() {
        return pais;
    }

    public String getTz_id() {
        return tz_id;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }
}
