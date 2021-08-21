package com.example.loginsamplemvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class RatesModel {
    @SerializedName("provider")
    String provider;
    @SerializedName("terms")
    String terms;
    @SerializedName("base")
    String base;
    @SerializedName("date")
    String date;
    @SerializedName("time_last_updated")
    String timeLastUpdated;
    @SerializedName("rates")
    HashMap<String,String> rates;

    public RatesModel(String provider, String terms, String base, String date, String timeLastUpdated, HashMap<String, String> rates) {
        this.provider = provider;
        this.terms = terms;
        this.base = base;
        this.date = date;
        this.timeLastUpdated = timeLastUpdated;
        this.rates = rates;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeLastUpdated() {
        return timeLastUpdated;
    }

    public void setTimeLastUpdated(String timeLastUpdated) {
        this.timeLastUpdated = timeLastUpdated;
    }

    public HashMap<String, String> getRates() {
        if(rates == null) rates = new HashMap<>();
        return rates;
    }

    public void setRates(HashMap<String, String> rates) {
        this.rates = rates;
    }
}
