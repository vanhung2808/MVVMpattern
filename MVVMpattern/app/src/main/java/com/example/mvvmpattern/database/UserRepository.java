package com.example.mvvmpattern.database;

import android.app.Application;

import com.example.mvvmpattern.model.User;

public class UserRepository {
    public IUserDao iUserDao;
    public UserDatabase userDatabase;
    public UserRepository(Application application) {
        userDatabase = UserDatabase.getDatabase(application);
        iUserDao = userDatabase.userDao();
    }

    public void deleteUser() {
        userDatabase.userDao().deleteUser();
    }
    public void insertUser(final User user) {
        userDatabase.userDao().insertUser(user);
    }

    public boolean findUser(String email, String password) {
        if(iUserDao.findUser(email,password) == null) {
            return false;
        }
        return true;
    }

    public boolean findExitsEmail(String email) {
        if(iUserDao.findExistsEmail(email) == null) {
            return false;
        }
        return true;
    }
    public static User newUser(String email, String password) {
        User user = new User(email,password);
        return user;
    }
}
