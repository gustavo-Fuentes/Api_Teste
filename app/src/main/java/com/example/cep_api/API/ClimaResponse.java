package com.example.cep_api.API;

import com.example.cep_api.API.models.LocationClass;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ClimaResponse { //Objeto raiz

    @SerializedName("location")
    private final LocationClass location;

    public ClimaResponse(LocationClass location) {
        this.location = location;
    }

    public LocationClass getLocation() {
        return location;
    }

    //    public ClimaResponse(List<LocationClass> location) {
//        this.location = location;
//    }
//
//    public List<LocationClass> getLocation() {
//        return location;
//    }
}
