package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1= findViewById(R.id.buttonframelayout);

        button2= findViewById(R.id.buttonlinearlayouthor);
        button3 = findViewById(R.id.buttonlinearlayoutver);
        button4 = findViewById(R.id.buttonRelativelayout);
        button5= findViewById(R.id.buttonTablelayout);
        button6= findViewById(R.id.buttonGrid);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout,new Fragment1());
             //   fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout,new Fragment2());
             //   fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout,new Fragment3());
             //   fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout,new Fragment4());
             //   fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout,new Fragment5());
             //   fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout,new Fragment6());
             //   fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}