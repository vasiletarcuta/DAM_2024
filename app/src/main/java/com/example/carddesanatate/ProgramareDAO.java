package com.example.carddesanatate;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

@Dao
public interface ProgramareDAO {

    @Insert
    void insertProgramare(Programare programare);

    @Update
    void updateProgramare(Programare programare);

    @Delete
    void deleteProgramare(Programare programare);

    @Query("SELECT * FROM programari")
    List<Programare> getAllProgramari();

    @Query("SELECT * FROM programari WHERE CNPPacient = :cnp")
    List<Programare> getProgramariByCNP(String cnp);

    @Query("SELECT * FROM programari WHERE idMedic = :idMedic")
    List<Programare> getProgramariByMedic(int idMedic);

    @Query("SELECT * FROM programari WHERE dataProgramarii = :data")
    List<Programare> getProgramariByData(Date data);
}
