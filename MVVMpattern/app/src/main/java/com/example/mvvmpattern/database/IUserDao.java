package com.example.mvvmpattern.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mvvmpattern.model.User;

@Dao
public interface IUserDao {

    @Query("delete from User")
    public void deleteUser();

    @Insert
    void insertUser(User user);

    @Query("select * from User where email = :email and password = :password")
    public User findUser(String email, String password);

    @Query("select * from User where email = :username")
    public User findExistsEmail(String username);


}
