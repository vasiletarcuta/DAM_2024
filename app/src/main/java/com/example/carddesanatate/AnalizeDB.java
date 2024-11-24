package com.example.carddesanatate;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Analize.class}, version = 1, exportSchema = false)
public abstract class AnalizeDB extends RoomDatabase {
    private static AnalizeDB instance;
    private static final String DB_NAME = "analize.db";

    public static synchronized AnalizeDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AnalizeDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract AnalizeDAO getAnalizeDAO();
}
