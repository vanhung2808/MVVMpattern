package com.example.a_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

class User implements Serializable {
    String ten;
}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent();
                    intent.setClass(MainActivity.this,Fragment.class);
                    startActivity(intent);
                }
            }
        );
    }
}