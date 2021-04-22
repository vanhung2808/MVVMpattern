package com.example.a_f1;

import android.os.Parcelable;

import java.io.Serializable;

public class User implements Serializable {
    private String Email;
    private String Name;

    public User(String email, String name) {
        Email = email;
        Name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
