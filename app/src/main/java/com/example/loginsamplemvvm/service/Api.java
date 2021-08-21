package com.example.loginsamplemvvm.service;

import com.example.loginsamplemvvm.model.RatesModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("latest/usd")
    Call<RatesModel> getRates();

}
