package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.activity.SecondActivity.REQUEST_CODE;

public class ThirdActivity extends AppCompatActivity {
  //  public static final String key="show";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        findViewById(R.id.button2).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        Intent intent= new Intent();
                        intent.setClass(ThirdActivity.this,FourthActivity.class);
                        intent.putExtra("key","Ao quan");
                        startActivity(intent);

                    }
                }
        );

        Intent intent=new Intent(this,FourthActivity.class);
        startActivityForResult(intent,0x9345);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try{
        super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == 0x9345 && resultCode == ThirdActivity.RESULT_OK) {
                String result = data.getStringExtra(FourthActivity.EXTRA_DATA);
                TextView textView;
                textView = findViewById(R.id.textView5);
                textView.setText(result);
            }
        }
        catch (Exception e){
            Toast.makeText(ThirdActivity.this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }

}