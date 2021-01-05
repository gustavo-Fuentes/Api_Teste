package com.example.cep_api.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("{cep}/json")
    Call<EnderecoResponse> getEndereco(@Path("cep") String cep);
}
