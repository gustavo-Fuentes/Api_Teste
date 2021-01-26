package com.example.weather_api.Activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeekForeceast extends AppCompatActivity {

    private WeatherAdapter adapter;
    EditText cidade;
    Button btn;

    String[] datas = new String[8];
    String[] minMax = new String[8];
    String[] humidade = new String[8];
    String[] vento = new String[8];

    static double lon, lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_forecast);

        cidade = findViewById(R.id._cidade);
        btn = findViewById(R.id._enviar);


//----------------------------------------Retrofit-------------------------------------------------
        String chave = "38bdec46ec68359e875cd8364ceb19e9"; // <---- your key here

        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CurrentWeatherInterface currentService = retro.create(CurrentWeatherInterface.class);

//-------------------------------------------------------------------------------------------------

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentService.getClimaAtual(cidade.getText().toString() ,chave).enqueue(new Callback<CurrentClimaResponse>() {
                    @Override
                    public void onResponse(Call<CurrentClimaResponse> call, Response<CurrentClimaResponse> response) {
                        if(response.code() == 200){
                            lon = response.body().getCoord().getLongitude();
                            lat = response.body().getCoord().getLatitude();
                            getWeekForecast(lon, lat, retro, chave);
                        }
                    }

                    @Override
                    public void onFailure(Call<CurrentClimaResponse> call, Throwable t) {
                    }
                });
            }
        });

    }

    public void getWeekForecast(double lon, double lat, Retrofit retro, String chave){

        ForecastWeatherInterface forecastService = retro.create(ForecastWeatherInterface.class);
        forecastService.getClimaSemanalCoord(lat, lon, "metric", "minutely,current,hourly", chave).enqueue(new Callback<WeekForecastResponse>() {
            @Override
            public void onResponse(Call<WeekForecastResponse> call, Response<WeekForecastResponse> response) {
                if (response.code() == 200){
                    for(int i=0; i < response.body().getDia().size(); i++){
                        double minC = response.body().getDia().get(i).getTempo().getTemp_minima();
                        double maxC =  response.body().getDia().get(i).getTempo().getTemp_maxima();

                        try {
                            datas = getDias();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        minMax[i] = (int)(minC) + "/" + (int)(maxC);
                        humidade[i] = response.body().getDia().get(i).getHumidade() + " %";
                        vento[i] = response.body().getDia().get(i).getVento_velocidade() + " m/s";

                    }

                    adapter = new WeatherAdapter(WeekForeceast.this, datas, minMax, humidade, vento);
                    RecyclerView rv = findViewById(R.id.recycle_view_main);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<WeekForecastResponse> call, Throwable t) {

            }
        });


    }

    public String[] getDias() throws ParseException {

        DateFormat dia = new SimpleDateFormat("dd");
        Calendar calendar = Calendar.getInstance();

        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        int dow;

        String[] days = new String[8];

        for (int i = 0; i < 8; i++)
        {

            String dayName = "";
            dow = calendar.get(Calendar.DAY_OF_WEEK);
            switch (dow){

                case 1:
                    dayName = "Domingo";
                    break;
                case 2:
                    dayName = "Segunda";
                    break;
                case 3:
                    dayName = "Terça";
                    break;
                case 4:
                    dayName = "Quarta";
                    break;
                case 5:
                    dayName = "Quinta";
                    break;
                case 6:
                    dayName = "Sexta";
                    break;
                case 7:
                    dayName = "Sabado";
                    break;
            }

            days[i] = dayName + "  " + dia.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }

        return days;
    }

}
