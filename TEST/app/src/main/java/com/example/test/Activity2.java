package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        findViewById(R.id.button2).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editText=(EditText)findViewById(R.id.Edittext1);
                        String st=editText.getText().toString();

                        Intent intent=new Intent();
                        intent.putExtra("keyName",st);
                        setResult(RESULT_OK,intent);
                        finish();
                        onBackPressed();
                    }
                }
        );

    //    String st=getIntent().getStringExtra("key");
    //    User u= (User) getIntent().getSerializableExtra("key3");
    //    Log.e("Ten",u.name);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Tag","onResume");
    }
}