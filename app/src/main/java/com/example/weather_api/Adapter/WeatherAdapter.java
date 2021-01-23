package com.example.weather_api.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.weather_api.R;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>{
    String dia, temp, humidade ,vento;
    Context context;

    public WeatherAdapter(Context ct, String dia, String temp, String humidade ,String ventoDesc){
        this.context = ct;
        this.dia = dia;
        this.temp = temp;
        this.humidade = humidade;
        this.vento = ventoDesc;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.weather_item, parent, false);

        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        holder.myText1.setText(dia);
        holder.myText2.setText(temp);
        holder.myText3.setText(humidade);
        holder.myText4.setText(vento);
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{
        TextView myText1, myText2, myText3, myText4;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.diaSemana);
            myText2 = itemView.findViewById(R.id.minMax);
            myText3 = itemView.findViewById(R.id.humidade);
            myText4 = itemView.findViewById(R.id.vento);
        }
    }

}

