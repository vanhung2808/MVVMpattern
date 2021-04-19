package com.example.mvvmpattern.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvmpattern.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract IUserDao userDao();
    private static final String DATABASE_NAME = "User.db";
    private static volatile UserDatabase instance;

    static UserDatabase getDatabase(Context context) {
        if(instance == null) {
            synchronized (UserDatabase.class){
                if(instance == null) {
//                    instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DATABASE_NAME)
//                            .allowMainThreadQueries()
//                            .build();
                    instance = Room.databaseBuilder(context,UserDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
                }
            }
        }

        return instance;
    }
}
