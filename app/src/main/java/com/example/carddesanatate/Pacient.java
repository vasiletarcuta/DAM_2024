package com.example.carddesanatate;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pacienti")
public class Pacient {

    @PrimaryKey(autoGenerate = true)
    String idPacient; // Primary Key
    String nume;
    String Prenume;
    String CNP;
    String Email;
    String parola;
    Sex sex;

    enum Sex{
        MASCULIN,
        FEMININ
    }

    public Pacient(String nume, String prenume, String CNP, String email, String parola, String sex) {
        this.sex = Sex.valueOf(sex);
        Prenume = prenume;
        this.parola = parola;
        this.nume = nume;
        Email = email;
        this.CNP = CNP;
    }

    public String getId() {
        return idPacient;
    }

    public void setId(String idPacient) {
        this.idPacient = idPacient;
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
