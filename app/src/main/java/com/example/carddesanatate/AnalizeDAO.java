package com.example.carddesanatate;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AnalizeDAO {

    @Insert
    void insertAnalize(Analize analiza);

    @Update
    void updateAnalize(Analize analiza);

    @Delete
    void deleteAnalize(Analize analiza);

    @Query("SELECT * FROM analize")
    List<Analize> getAllAnalize();

    @Query("SELECT * FROM analize WHERE idAnalize = :id")
    Analize getAnalizeById(int id);

    @Query("SELECT * FROM analize WHERE CNP = :cnp")
    List<Analize> getAnalizeByCNP(String cnp);
}
