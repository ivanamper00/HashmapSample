package com.example.loginsamplemvvm.service;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.loginsamplemvvm.model.RatesModel;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories {
    private static Repositories instance;

    public static Repositories getInstance(){
        if(instance == null){
            instance = new Repositories();
        }
        return instance;
    }

    public MutableLiveData<HashMap<String, String>> getRates(){
        MutableLiveData<HashMap<String, String>> list = new MutableLiveData<>();
        list.setValue(new HashMap<>());
        RetrofitService.retrofitService(Api.class).getRates()
                .enqueue(new Callback<RatesModel>() {
                    @Override
                    public void onResponse(@NotNull Call<RatesModel> call, @NotNull Response<RatesModel> response) {
                        Log.d("result_rates", new Gson().toJson(response.body()));
                        RatesModel ratesModel = response.body();
                        list.setValue(ratesModel.getRates());
                    }
                    @Override
                    public void onFailure(@NotNull Call<RatesModel> call, @NotNull Throwable t) { }
                });
        return list;
    }

}
