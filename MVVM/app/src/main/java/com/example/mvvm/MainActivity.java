package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;

import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.factory.UserViewModelFactory;
import com.example.mvvm.model.User;
import com.example.mvvm.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        UserViewModel userViewModel = ViewModelProvider.of(this, new UserViewModelFactory(this, new User())).get(User)
    }
}