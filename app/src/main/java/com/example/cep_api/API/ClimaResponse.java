package com.example.cep_api.API;

import com.example.cep_api.API.models.Current;
import com.example.cep_api.API.models.LocationClass;
import com.google.gson.annotations.SerializedName;


public class ClimaResponse { //Objeto raiz

    @SerializedName("location")
    private final LocationClass location;

    @SerializedName("current")
    private final Current current;

    public ClimaResponse(LocationClass location, Current current) {
        this.location = location;
        this.current = current;
    }

    public Current getCurrent() {
        return current;
    }

    public LocationClass getLocation() {
        return location;
    }


}
