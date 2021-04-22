package com.example.a_f1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.content.ContentValues.TAG;


public class Fragment1 extends Fragment {
//    private static String KEY="key3";
//    private static String KEY2="key4";
    private View mView;
    private EditText editText2;
    private EditText editText3;
    private Button button2;

    private OnClickSendData onClickSendData;

    public void setOnClickSendData(OnClickSendData onClickSendData) {
        this.onClickSendData = onClickSendData;
    }
    //    private MainActivity mainActivity;


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_1, container, false);
//        mainActivity = (MainActivity) getActivity();
        initUI();
       /* Bundle bundle=this.getArguments();
        if(bundle != null){
            String st= bundle.getString("key");
            if(st != null)
                editText2.setText(st);
        }*/
        return mView;
    }

    private void initUI() {
        editText2=mView.findViewById(R.id.edittext2);
        editText3=mView.findViewById(R.id.edittext3);
        button2=mView.findViewById(R.id.button2);
//        User user = (User) getArguments().getSerializable(KEY);
//        if(user.getEmail() != null)
//            editText2.setText(user.getEmail());
//        if(user.getName() != null)
//            editText3.setText(user.getName());
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                senddatatoActivity();

            }
        });
    }

    private void senddatatoActivity() {
        String st= editText2.getText().toString();
        String st1=editText3.getText().toString();
        User user = new User(st,st1);
        onClickSendData.SendatatoACtvity(user);
//        Bundle bundle= new Bundle();
//        bundle.putSerializable(KEY2,user);
     //   mainActivity.getEditText().setText(st);
     //   mainActivity.getEditText2().setText(st1);
       // Intent intent= new Intent();
      //  intent.putExtra("key2",st);


    }
}