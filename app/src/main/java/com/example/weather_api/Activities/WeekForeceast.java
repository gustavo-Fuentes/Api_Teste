package com.example.weather_api.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather_api.API.CurrentClimaResponse;
import com.example.weather_api.API.CurrentWeatherInterface;
import com.example.weather_api.API.ForecastWeatherInterface;
import com.example.weather_api.API.WeekForecastResponse;
import com.example.weather_api.Adapter.WeatherAdapter;
import com.example.weather_api.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeekForeceast extends AppCompatActivity {

    private WeatherAdapter adapter;
    EditText cidade;
    Button btn;
    double lon, lat;

    // TODO: Cirar um vetor de dia da semana, min°/max°, humidade e velocidade do vento

    private String minMax[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_forecast);

        cidade = findViewById(R.id._cidade);
        btn = findViewById(R.id._enviar);

        String chave = "38bdec46ec68359e875cd8364ceb19e9";

        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CurrentWeatherInterface currentService = retro.create(CurrentWeatherInterface.class);

        currentService.getClimaAtual("diadema" ,chave).enqueue(new Callback<CurrentClimaResponse>() {
            @Override
            public void onResponse(Call<CurrentClimaResponse> call, Response<CurrentClimaResponse> response) {
                if(response.code() == 200){
                    assert response.body() != null;
                    lon = response.body().getCoord().getLongitude();
                    lat = response.body().getCoord().getLatitude();
                }
            }

            @Override
            public void onFailure(Call<CurrentClimaResponse> call, Throwable t) {

            }
        });

        ForecastWeatherInterface forecastService = retro.create(ForecastWeatherInterface.class);
        forecastService.getClimaSemanal(lat, lon, "minutely,current,hourly", chave).enqueue(new Callback<WeekForecastResponse>() {
            @Override
            public void onResponse(Call<WeekForecastResponse> call, Response<WeekForecastResponse> response) {

                if (response.code() == 200){


                    // TODO: os vetores vao receber os dados dessa chamada

                }

            }

            @Override
            public void onFailure(Call<WeekForecastResponse> call, Throwable t) {

            }
        });



        // TODO: atribuir os vetores criados no começo da activity e inseria no adapter abaixo

        adapter = new WeatherAdapter(this, "sabado 23","19°/21°", "50%", "10km/h");
        RecyclerView rv = findViewById(R.id.recycle_view_main);
        rv.setAdapter(adapter);

    }
}