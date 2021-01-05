package com.example.cep_api.API;

import com.example.cep_api.API.models.LocationClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface { //responsavel por fazer as requisições
    @GET("current.json")
    Call<ClimaResponse> getClima(
            @Query("key") String chave,
            @Query("q") String cidade);
}
