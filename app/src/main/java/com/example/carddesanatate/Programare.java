package com.example.carddesanatate;

import android.icu.text.DateFormat;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "programari")
public class Programare implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int idProgramare;

    private int idPacient;
    private int idMedic;
    private String CNPPacient;
    private Date dataProgramarii;
    private String oraProgramarii;
    private String denumireSpital;
    private String numeMedic;

    public Programare(int idPacient, int idMedic, String CNPPacient, Date dataProgramarii, String oraProgramarii, String denumireSpital, String numeMedic) {
        this.idPacient = idPacient;
        this.idMedic = idMedic;
        this.CNPPacient = CNPPacient;
        this.dataProgramarii = dataProgramarii;
        this.oraProgramarii = oraProgramarii;
        this.denumireSpital = denumireSpital;
        this.numeMedic = numeMedic;
    }

    public int getIdProgramare() {
        return idProgramare;
    }

    public void setIdProgramare(int idProgramare) {
        this.idProgramare = idProgramare;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
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
                "idProgramare=" + idProgramare +
                ", CNPPacient='" + CNPPacient + '\'' +
                ", dataProgramarii=" + dataProgramarii +
                ", oraProgramarii='" + oraProgramarii + '\'' +
                ", denumireSpital='" + denumireSpital + '\'' +
                ", numeMedic='" + numeMedic + '\'' +
                '}';
    }
}
