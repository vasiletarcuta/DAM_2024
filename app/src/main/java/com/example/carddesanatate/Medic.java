package com.example.carddesanatate;

import java.util.Date;

public class Medic {

    int idMedic;
    String Nume;
    String Prenume;
    String SpitalDeProvenienta;

    public Medic(int idMedic, String nume, String prenume, String spitalDeProvenienta) {
        this.idMedic = idMedic;
        Nume = nume;
        Prenume = prenume;
        SpitalDeProvenienta = spitalDeProvenienta;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
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
}
