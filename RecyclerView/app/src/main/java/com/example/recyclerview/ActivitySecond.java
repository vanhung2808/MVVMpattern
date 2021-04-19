package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySecond extends AppCompatActivity {
    public static final String KEY = "key";
    public static final String CONTEXT = "Moi dien day du thong tin";
    private Context mContext;
    private Button btAdd;
    private EditText etTitle;
    private EditText etLyric;
    private EditText etArtic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btAdd = findViewById(R.id.bt_add_2);
        etTitle = findViewById(R.id.et_title);
        etLyric = findViewById(R.id.et_lyric);
        etArtic =findViewById(R.id.et_artic);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws NumberFormatException{
                String title = etTitle.getText().toString().trim();
                String lyric = etLyric.getText().toString().trim();
                String artic = etArtic.getText().toString().trim();
                Song s = new Song(R.drawable.son_tung, title, lyric, artic);
                Intent i = new Intent();
                i.putExtra(KEY, s);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}