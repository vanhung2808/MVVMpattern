package com.example.mvvm.viewmodel;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.model.User;

public class UserViewModel extends ViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    private User user;
    private Context context;

    public UserViewModel(User user, Context context) {
        this.user = user;
        this.context = context;
    }
    public void onLoginCLick() {
        user.setEmail(email.getValue());
        user.setPassword(password.getValue());

        if (!user.isValidEmail()) {
            Toast.makeText(context,"Invalid Email", Toast.LENGTH_SHORT).show();
        }
        else if (!user.isValidPassword()) {
            Toast.makeText(context,"Invalid Password", Toast.LENGTH_SHORT).show();
        }
        else if (user.isValidCredential()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "Login Successfull", Toast.LENGTH_SHORT).show();

                }
            }, 500);
        }
        else {
            Toast.makeText(context,"Invalid Credential", Toast.LENGTH_SHORT).show();
        }
    }
}
