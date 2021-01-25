package com.example.weather_api.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather_api.API.CurrentClimaResponse;
import com.example.weather_api.API.WeekForecastResponse;

import com.example.weather_api.API.CurrentWeatherInterface;
import com.example.weather_api.API.ForecastWeatherInterface;
import com.example.weather_api.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView cidade;
    TextView temperatura;
    TextView descricao;

    EditText busca;
    Button enviar;

    ImageView fundo;

    private String coordenada_lat;
    private String coordenada_lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//----------------------------------------------
        cidade =        findViewById(R.id.cidade_);
        temperatura =   findViewById(R.id.celsius_);
        descricao =     findViewById(R.id.descricao_);

        busca =     findViewById(R.id.search_);
        enviar =    findViewById(R.id.send_);


        fundo.setVisibility(View.INVISIBLE);
//----------------------------------------------

        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CurrentWeatherInterface currentService = retro.create(CurrentWeatherInterface.class);
        //ForecastWeatherInterface forecastService = retro.create(ForecastWeatherInterface.class);
        String chave = "38bdec46ec68359e875cd8364ceb19e9";

        String cidade = "" + busca.getText().toString();
        currentService.getClimaAtual("diadema", chave).enqueue(new Callback<CurrentClimaResponse>() {

            @Override
            public void onResponse(Call<CurrentClimaResponse> call, Response<CurrentClimaResponse> response) {
                int code = response.code();
                if (code == 200){
                    System.out.println("" + response.body().getNome());
                }

            }

            @Override
            public void onFailure(Call<CurrentClimaResponse> call, Throwable t) {
                //Log.i("Errooooo", "Ferrou: " + t.getMessage());
            }
        });


    }
}