package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Toast;

import static com.example.activity.SecondActivity.REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        // Intent intent=new Intent(Intent.ACTION_DIAL);
                        Intent intent= new Intent();
                        intent.setClass(MainActivity.this,ThirdActivity.class);
                        startActivity(intent);}
                }
        );

    }

}