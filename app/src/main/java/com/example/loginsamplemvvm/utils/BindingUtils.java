package com.example.loginsamplemvvm.utils;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginsamplemvvm.view.CurrencyAdapter;

import java.util.HashMap;

public class BindingUtils {
    @BindingAdapter("android:recyclerData")
    public static void recyclerData(RecyclerView view, HashMap<String,String> list) {
        view.setAdapter(new CurrencyAdapter(view.getContext(), list));
        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}
