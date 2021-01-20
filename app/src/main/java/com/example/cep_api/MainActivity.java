package com.example.cep_api;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cep_api.API.ApiInterface;
import com.example.cep_api.API.ClimaResponse;

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

        fundo =     findViewById(R.id.backgroud_img);
        fundo.setVisibility(View.INVISIBLE);
//----------------------------------------------


        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface service = retro.create(ApiInterface.class);

        String chave = "38bdec46ec68359e875cd8364ceb19e9";

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.getClima("diadema", chave).enqueue(new Callback<ClimaResponse>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(Call<ClimaResponse> call, Response<ClimaResponse> response) {
                        int code = response.code();
                        double coordenada_lon = response.body().getCoord().getLongitude();


                        if(code == 200){
                            cidade.setText(coordenada_lon + "");
                            //cidade.setText("isso funciona");
                        }

                        else{
                            Log.i("Errooooo","Ferrou: " + response.code() );
                        }
                    }

                    @Override
                    public void onFailure(Call<ClimaResponse> call, Throwable t) {
                        Log.i("Errooooo", "Ferrou: " + t.getMessage());
                    }
                });
            }
        });
    }
}