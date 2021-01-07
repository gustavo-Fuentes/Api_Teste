package com.example.cep_api.API.models;

import com.google.gson.annotations.SerializedName;

public class CurrentContitional {
    @SerializedName("text")
    private final String descricao;

    public String getDescricao() {
        return descricao;
    }

    public CurrentContitional(String descricao) {
        this.descricao = descricao;
    }
}
