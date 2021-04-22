package com.example.mvvmpattern.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvmpattern.R;
import com.example.mvvmpattern.viewmodel.UserViewModel;
import com.example.mvvmpattern.viewmodel.UserViewModelFactory;

public class MainActivity extends AppCompatActivity {
    private Button btLogin, btSingnup;
    private EditText etEmail, etPassword;
    private UserViewModel userViewModel;
    private static String KEY = "Hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin = findViewById(R.id.bt_login);
        btSingnup = findViewById(R.id.bt_signup1);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        userViewModel = new ViewModelProvider(this, new UserViewModelFactory(getApplication())).get(UserViewModel.class);
        userViewModel.deleteUser();
        userViewModel.insertUser(userViewModel.newUser("abc@gmail.com","123"));

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws NumberFormatException {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if(userViewModel.findUser(email,password)){
                    Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
                    intent.putExtra(KEY, email);
                    startActivity(intent);
               }
                else if(userViewModel.findExistsEmail(email)) {
                    Toast.makeText(getApplication(),"Mật khẩu không chính xác", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplication(),"Thông tin đăng nhập không chính xác", Toast.LENGTH_LONG).show();
                }
            }
        });

        btSingnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivitySignup.class);
                startActivity(intent);
            }
        });
    }


}