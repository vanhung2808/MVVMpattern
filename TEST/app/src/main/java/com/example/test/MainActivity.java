package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

class User  implements Serializable{
    String name;
}

public class MainActivity extends AppCompatActivity {
    private  User var;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  var.name="Nguyen van hung";
        findViewById(R.id.button1).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Activity2.class);
                    //    intent.putExtra("key","a");
                    //    intent.putExtra("key2",3);
                    //    intent.putExtra("key3",var);
                        startActivityForResult(intent, 100);
                    }
                }
        );

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Tag","onStop()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {

                String returnString = data.getStringExtra("keyName");

                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(returnString);
            }
        }
    }
}