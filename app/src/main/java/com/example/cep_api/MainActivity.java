package com.example.cep_api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
                .baseUrl("https://api.weatherapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface service = retro.create(ApiInterface.class);

        String chave = "fb8c3a9b303f42678ef213517210501";

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.getClima(chave, busca.getText().toString()).enqueue(new Callback<ClimaResponse>() {
                    @Override
                    public void onResponse(Call<ClimaResponse> call, Response<ClimaResponse> response) {

                        cidade.setText(response.body().getLocation().getNome());
                        temperatura.setText( Double.toString(response.body().getCurrent().getTemp_celsius()));

                        if(response.body().getCurrent().getIsDay() == 1){
                            fundo.setVisibility(View.VISIBLE);
                            fundo.setImageResource(R.drawable.day_wallpaper);
                        }
                        else {
                            fundo.setVisibility(View.VISIBLE);
                            fundo.setImageResource(R.drawable.night_wallpaper);
                        }
                    }

                    @Override
                    public void onFailure(Call<ClimaResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}