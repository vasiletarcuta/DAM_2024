package com.example.carddesanatate;

import android.icu.text.DateFormat;

import java.io.Serializable;
import java.util.Date;

public class Programare implements Serializable {
    String CNPPacient;
    Date dataProgramarii;
    String oraProgramarii;
    String denumireSpital;
    String numeMedic;

    public Programare(String CNPPacient, Date dataProgramarii, String oraProgramarii, String denumireSpital,  String numeMedic) {
        this.CNPPacient = CNPPacient;
        this.dataProgramarii = dataProgramarii;
        this.oraProgramarii = oraProgramarii;
        this.denumireSpital = denumireSpital;
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

    public String getNumeMedic() {
        return numeMedic;
    }

    public void setNumeMedic(String numeMedic) {
        this.numeMedic = numeMedic;
    }

    @Override
    public String toString() {
        return "Programare{" +
                "CNPPacient='" + CNPPacient + '\'' +
                ", dataProgramarii=" + dataProgramarii +
                ", oraProgramarii='" + oraProgramarii + '\'' +
                ", denumireSpital='" + denumireSpital + '\'' +
                ", numeMedic='" + numeMedic + '\'' +
                '}';
    }
}
