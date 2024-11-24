package com.example.carddesanatate;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pacienti")
public class Pacient {

    @PrimaryKey(autoGenerate = true)
    private int idPacient; // Primary Key
    String nume;
    String Prenume;

    String CNP;
    String Email;
    enum Sex{
        MASCULIN,
        FEMININ
    }

    public Pacient(String nume, String prenume, String CNP, String email) {
        this.nume = nume;
        this.Prenume = prenume;
        this.CNP = CNP;
        this.Email = email;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        this.Prenume = prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "nume='" + nume + '\'' +
                ", Prenume='" + Prenume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
