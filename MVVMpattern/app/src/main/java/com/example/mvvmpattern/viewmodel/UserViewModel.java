package com.example.mvvmpattern.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.mvvmpattern.database.UserRepository;
import com.example.mvvmpattern.model.User;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public void deleteUser() {
        userRepository.deleteUser();
    }

    public void insertUser(User user) {
        userRepository.insertUser(user);
    }

    public boolean findUser(String email, String password) {
        if (!userRepository.findUser(email, password)) {
            return false;
        }
        return true;
    }

    public boolean findExistsEmail (String email) {
        if (!userRepository.findExitsEmail(email) ) {
            return false;
        }
        return true;
    }

    public User newUser(String email, String password) {
        return UserRepository.newUser(email,password);
    }
}
