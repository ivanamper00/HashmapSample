package com.example.loginsamplemvvm.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginsamplemvvm.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {

    public Context context;
    public List<Map.Entry<String,String>> currencies = new ArrayList<>();
    public CurrencyAdapter(Context context, HashMap<String, String> currencies) {
        this.context = context;
        this.currencies.addAll(currencies.entrySet());
    }

    @NonNull
    @NotNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_currencies, parent, false);
        return new CurrencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CurrencyViewHolder holder, int position) {
        Map.Entry<String,String> currency = currencies.get(position);

        holder.currency.setText(currency.getKey());
        holder.value.setText(currency.getValue());
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public void updateList(HashMap<String, String> searchedRates) {
        this.currencies.addAll(searchedRates.entrySet());
    }

    static class CurrencyViewHolder extends RecyclerView.ViewHolder{
        public TextView currency;
        public TextView value;
        public CurrencyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            currency = itemView.findViewById(R.id.currency);
            value = itemView.findViewById(R.id.value);
        }
    }
}
