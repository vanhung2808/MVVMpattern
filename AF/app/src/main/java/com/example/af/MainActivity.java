package com.example.af;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText =findViewById(R.id.edittext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st=editText.getText().toString();
                FragmentManager fragmentManager=getSupportFragmentManager();
                Fragment1 frg1= new Fragment1();
                frg1= (Fragment1) fragmentManager.findFragmentById(R.id.fragment);
                frg1.textView.setText(st);
            }
        });
    }
}