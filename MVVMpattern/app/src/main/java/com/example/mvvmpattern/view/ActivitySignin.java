package com.example.mvvmpattern.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvmpattern.R;
import com.example.mvvmpattern.model.User;
import com.example.mvvmpattern.viewmodel.UserViewModel;
import com.example.mvvmpattern.viewmodel.UserViewModelFactory;

public class ActivitySignin extends AppCompatActivity {
    private EditText etEmail, etPassword, etConfigPassword;
    private Button btSignin;
    private UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        userViewModel = new ViewModelProvider(this, new UserViewModelFactory(getApplication())).get(UserViewModel.class);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfigPassword = findViewById(R.id.et_config_password);
        btSignin = findViewById(R.id.bt_signin2);

        btSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws NumberFormatException {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String configPassword = etConfigPassword.getText().toString();

                if (userViewModel.findByUserName(email)) {
                    Toast.makeText(getApplication(), "Đã tồn tại tài khoản", Toast.LENGTH_LONG).show();
                }
                else if (!userViewModel.findByUserName(email) && (password.equals(configPassword)) && (email != null)) {
                    User user = new User(email,password);
                    userViewModel.insertUser(user);
                    Toast.makeText(getApplication(),"Đã đăng kí thành công", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplication(),"Thông tin đăng kí không hợp lệ",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}