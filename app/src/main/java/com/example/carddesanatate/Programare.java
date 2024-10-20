package com.example.carddesanatate;

import android.icu.text.DateFormat;

import java.util.Date;

public class Programare {
    String CNPPacient;
    Date dataProgramarii;
    String oraProgramarii;

    String denumireSpital;
    int idMedic;
    String numeMedic;

    public Programare(String CNPPacient, Date dataProgramarii, String oraProgramarii, String denumireSpital, int idMedic, String numeMedic) {
        this.CNPPacient = CNPPacient;
        this.dataProgramarii = dataProgramarii;
        this.oraProgramarii = oraProgramarii;
        this.denumireSpital = denumireSpital;
        this.idMedic = idMedic;
        this.numeMedic = numeMedic;
    }

    public String getCNPPacient() {
        return CNPPacient;
    }

    public void setCNPPacient(String CNPPacient) {
        this.CNPPacient = CNPPacient;
    }

    public Date getDataProgramarii() {
        return dataProgramarii;
    }

    public void setDataProgramarii(Date dataProgramarii) {
        this.dataProgramarii = dataProgramarii;
    }

    public String getOraProgramarii() {
        return oraProgramarii;
    }

    public void setOraProgramarii(String oraProgramarii) {
        this.oraProgramarii = oraProgramarii;
    }

    public String getDenumireSpital() {
        return denumireSpital;
    }

    public void setDenumireSpital(String denumireSpital) {
        this.denumireSpital = denumireSpital;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public String getNumeMedic() {
        return numeMedic;
    }

    public void setNumeMedic(String numeMedic) {
        this.numeMedic = numeMedic;
    }
}
