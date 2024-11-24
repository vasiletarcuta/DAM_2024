package com.example.carddesanatate;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
@Entity(tableName = "medici")
public class Medic {

    @PrimaryKey(autoGenerate = true)
    private int idMedic;
    String Nume;
    String Prenume;
    String SpitalDeProvenienta;
    String Specialziare;

    public Medic(String nume, String prenume, String spitalDeProvenienta, String specialziare) {
        Nume = nume;
        Prenume = prenume;
        SpitalDeProvenienta = spitalDeProvenienta;
        Specialziare = specialziare;
    }

    public int getIdMedic() {
        return this.idMedic;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public String getSpitalDeProvenienta() {
        return SpitalDeProvenienta;
    }

    public void setSpitalDeProvenienta(String spitalDeProvenienta) {
        SpitalDeProvenienta = spitalDeProvenienta;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "idMedic=" + idMedic +
                ", Nume='" + Nume + '\'' +
                ", Prenume='" + Prenume + '\'' +
                ", SpitalDeProvenienta='" + SpitalDeProvenienta + '\'' +
                '}';
    }
}
