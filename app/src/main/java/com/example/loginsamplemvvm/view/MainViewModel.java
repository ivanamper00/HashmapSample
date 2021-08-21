package com.example.loginsamplemvvm.view;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginsamplemvvm.service.Repositories;

import java.util.HashMap;
import java.util.Map;

public class MainViewModel extends ViewModel {

    private Repositories repositories = Repositories.getInstance();
    private MutableLiveData<HashMap<String, String>> rates = repositories.getRates();
    private HashMap<String, String> searchRates = new HashMap<>();

    public LiveData<HashMap<String, String>> getRates() {
        return rates;
    }

    public void search(String s) {
        Log.d("search", s);
        HashMap<String, String> searchedRates = new HashMap<>();
        for(Map.Entry<String, String> rate: searchRates.entrySet()){
            if(rate.getKey().toLowerCase().contains(s.toLowerCase())){
                searchedRates.put(rate.getKey(),rate.getValue());
            }
        }
        if(searchedRates.isEmpty()) rates.setValue(searchRates);
        else rates.setValue(searchedRates);
    }

    public void initDataListen(LifecycleOwner lifeCycle) {
        repositories.getRates().observe(lifeCycle, it -> searchRates = it);
    }
}
