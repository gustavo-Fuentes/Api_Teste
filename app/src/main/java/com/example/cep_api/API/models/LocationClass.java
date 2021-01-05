package com.example.cep_api.API.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationClass {
    @SerializedName("name")
    private String nome;

    @SerializedName("region")
    private String regiao;

    public LocationClass(String nome, String regiao) {
        this.nome = nome;
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }
}
