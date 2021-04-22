package com.example.a_f1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements OnClickSendData  {
    private EditText editText;
    private EditText editText2;
    private Button button;
    private String mEmail="";
    private ImageView imageView;
//    private User user1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= findViewById(R.id.edittext1);
        button= findViewById(R.id.button1);
        editText2=findViewById(R.id.edittext2);
        imageView=findViewById(R.id.image);
        Glide.with(getApplicationContext())
                .load("https://images.viblo.asia/bf34dbbd-d0c8-4c95-8356-6f9b3010ca31.png").CEN
                .into(imageView);
       // nhandulieu();
        Fragment1 fragment1=new Fragment1();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_frame,fragment1);
        fragmentTransaction.commit();
        fragment1.setOnClickSendData(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                senddatatoFragment();
            }
        });
    }
   /* private void nhandulieu() {
        Intent intent=getIntent();
        if(intent != null) {
            String st = intent.getStringExtra("key2");
            if (st != null)
                editText.setText(st);
        }
    }*/


    private void senddatatoFragment() {
        String st=editText.getText().toString();
        String stname=editText2.getText().toString();
        User user= new User(st,stname);
//        Bundle bundle= new Bundle();
//        bundle.putString("key",st);
//        bundle.putSerializable("key3", user);
//        Fragment1 frg= new Fragment1();
//        frg.setArguments(bundle);


    }

    @Override
    public void SendatatoACtvity(User user) {
        Log.d("AAA",user.toString());
        editText.setText(user.getEmail());
        editText2.setText(user.getName());
//        user1=new User(user.getEmail(),user.getName());
    }

//    public String getmEmail() {
//        return mEmail;
//    }
//
//    public EditText getEditText() {
//        return editText;
//    }
//
//    public EditText getEditText2() {
//        return editText2;
//    }
}