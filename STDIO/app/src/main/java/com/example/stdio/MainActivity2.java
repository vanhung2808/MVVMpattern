package com.example.stdio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import javax.security.auth.login.LoginException;

public class MainActivity2 extends Activity {
   // protected String TAG="Trang thai";
    protected void onCreate(Bundle saveInStanceState){
        super.onCreate(saveInStanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                  //  Intent intent=new Intent(Intent.ACTION_DIAL);
                    Intent intent= new Intent();
                    intent.setClass(MainActivity2.this,MainActivity3.class);
                    startActivity(intent);}
                }
        );

        Log.i("TAG","onCreate");
    }
    protected void onStart(){
        super.onStart();
        Log.i("TAG","onStart");
    }
    protected void onResume(){
        super.onResume();
        Log.i("TAG","onResume");
    }
    protected void onPause(){
        super.onPause();
        Log.i("TAG","onPause");
    }
    protected void onStop(){
        super.onStop();
        Log.i("TAG","onStop");
    }
    protected void onRestart(){
        super.onRestart();
        Log.i("TAG","onRestart");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i("TAG","onDestroy");
    }
    public void onDataSelected(String data) {
        Log.d("MyActivity","Value: " + data);
    }
    public interface OnFragmentManager {
        void onDateSelected(String data);
    }
}
