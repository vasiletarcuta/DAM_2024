package com.example.carddesanatate;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MedicDAO {

    @Insert
    void insertMedic(Medic medic);

    @Update
    void updateMedic(Medic medic);

    @Delete
    void deleteMedic(Medic medic);

    @Query("SELECT * FROM medici WHERE Specialziare = :specializare")
    List<Medic> getMediciBySpecializare(String specializare);

    @Query("SELECT * FROM medici WHERE idMedic = :id")
    Medic getMedicById(int id);

    @Query("DELETE FROM medici WHERE idMedic = :id")
    void deleteMedicById(int id);
}

