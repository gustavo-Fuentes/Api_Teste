package com.example.cep_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.cep_api.API.ApiInterface;
import com.example.cep_api.API.EnderecoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface service = retro.create(ApiInterface.class);
        service.getEndereco("09910620").enqueue(new Callback<EnderecoResponse>() {
            @Override
            public void onResponse(Call<EnderecoResponse> call, Response<EnderecoResponse> response) {
                Log.i("a", "" + response.body().getCep());
                Log.i("a", "" + response.body().getBairro());
            }

            @Override
            public void onFailure(Call<EnderecoResponse> call, Throwable t) {

            }
        });
    }

}