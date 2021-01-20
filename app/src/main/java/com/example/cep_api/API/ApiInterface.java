package com.example.cep_api.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface { //responsavel por fazer as requisições
    @GET("weather")
    Call<ClimaResponse> getClima(
            @Query("q") String cidade,
            @Query("appid") String apikey);
}
