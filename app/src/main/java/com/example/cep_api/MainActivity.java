package com.example.cep_api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep_api.API.ApiInterface;
import com.example.cep_api.API.ClimaResponse;
import com.example.cep_api.API.models.LocationClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teste = findViewById(R.id.resultado);

        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface service = retro.create(ApiInterface.class);

        String chave = "fb8c3a9b303f42678ef213517210501";

        service.getClima(chave,"diadema").enqueue(new Callback<ClimaResponse>() {
            @Override
            public void onResponse(Call<ClimaResponse> call, Response<ClimaResponse> response) {

//                String code = "" + response.code();
//                teste.setText( code );

                assert response.body() != null;
                String resultado = "" + response.body().getLocation();
                teste.setText(response.body().getLocation().getRegiao());

            }

            @Override
            public void onFailure(Call<ClimaResponse> call, Throwable t) {

                teste.setText( t.getCause().toString() );
            }
        });
    }

}