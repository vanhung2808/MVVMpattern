package com.example.mvvmpattern.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvmpattern.R;

public class ActivityLogin extends AppCompatActivity {
    private Intent intent;
    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvWelcome = findViewById(R.id.tv_welcome);
        String email = getIntent().getStringExtra("key");
        tvWelcome.setText("Welcome\n"+email);
    }
}