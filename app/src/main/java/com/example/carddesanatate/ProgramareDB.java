package com.example.carddesanatate;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Programare.class}, version = 1, exportSchema = false)
public abstract class ProgramareDB extends RoomDatabase {
    private static ProgramareDB instance;
    private static final String DB_NAME = "programari.db";

    public static synchronized ProgramareDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            ProgramareDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract ProgramareDAO getProgramareDAO();
}
