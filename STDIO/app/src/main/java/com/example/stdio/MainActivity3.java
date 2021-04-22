package com.example.stdio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Fragment newFragment = new Fragment1();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Fragment newFragment2 = new Fragment2();
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();

                transaction2.replace(R.id.container, newFragment2);
                transaction2.addToBackStack(null);

                transaction2.commit();

            }
        }, 5000);

    }

}