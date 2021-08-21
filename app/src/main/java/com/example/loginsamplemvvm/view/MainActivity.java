package com.example.loginsamplemvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import com.example.loginsamplemvvm.R;
import com.example.loginsamplemvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;
    public MutableLiveData<String> searchCurrency = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        initComponents();
    }

    private void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setMainViewModel(mainViewModel);
        binding.setView(this);
        binding.setLifecycleOwner(this);
    }

    private void initComponents() {
        mainViewModel.initDataListen(this);
        searchCurrency.observe(this, s -> mainViewModel.search(s));
    }

}