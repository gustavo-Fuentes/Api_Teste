package com.example.weather_api.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastWeatherInterface { //responsavel por fazer as requisições da previsao de 4 dias

    @GET("onecall")
    Call<WeekForecastResponse> getClimaSemanal(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("units") String unidade,
            @Query("exclude") String modo,
            @Query("appid") String apikey);

}
