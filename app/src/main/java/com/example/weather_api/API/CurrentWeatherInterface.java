package com.example.weather_api.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrentWeatherInterface { //responsavel por fazer as requisições do clima atual
    @GET("weather")
    Call<CurrentClimaResponse> getClimaAtual(
            @Query("q") String city,
            @Query("appid") String apikey);
}
