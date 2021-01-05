package com.example.cep_api.API;

public class EnderecoResponse {


    private final String cep;
    private final String longradouro;
    private final String complemento;
    private final String bairro;
    private final String localidade;

    public String getCep() {
        return cep;
    }

    public String getLongradouro() {
        return longradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public EnderecoResponse(String cep, String longradouro, String complemento, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.longradouro = longradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    private final String uf;




}
