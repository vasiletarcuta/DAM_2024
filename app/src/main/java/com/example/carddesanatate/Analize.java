package com.example.carddesanatate;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "analize")
public class Analize implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int idAnalize;

    private int idPacient;
    private String numeAnalize;
    private String denumireSpital;
    private String numePacient;
    private String prenumePacient;
    private String CNP;
    private String numeMedic;
    private String sectieSptial;

    // poate un cod QR de scanat ca sa nu se mai adauge manual detaliile

    public Analize(int idPacient, String numeAnalize, String denumireSpital, String numePacient, String prenumePacient, String CNP, String numeMedic, String sectieSptial) {
        this.idPacient = idPacient;
        this.numeAnalize = numeAnalize;
        this.denumireSpital = denumireSpital;
        this.numePacient = numePacient;
        this.prenumePacient = prenumePacient;
        this.CNP = CNP;
        this.numeMedic = numeMedic;
        this.sectieSptial = sectieSptial;
    }

    // Getters și Setters
    public int getIdAnalize() {
        return idAnalize;
    }

    public void setIdAnalize(int idAnalize) {
        this.idAnalize = idAnalize;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public String getNumeAnalize() {
        return numeAnalize;
    }

    public void setNumeAnalize(String numeAnalize) {
        this.numeAnalize = numeAnalize;
    }

    public String getDenumireSpital() {
        return denumireSpital;
    }

    public void setDenumireSpital(String denumireSpital) {
        this.denumireSpital = denumireSpital;
    }

    public String getNumePacient() {
        return numePacient;
    }

    public void setNumePacient(String numePacient) {
        this.numePacient = numePacient;
    }

    public String getPrenumePacient() {
        return prenumePacient;
    }

    public void setPrenumePacient(String prenumePacient) {
        this.prenumePacient = prenumePacient;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getNumeMedic() {
        return numeMedic;
    }

    public void setNumeMedic(String numeMedic) {
        this.numeMedic = numeMedic;
    }

    public String getSectieSptial() {
        return sectieSptial;
    }

    public void setSectieSptial(String sectieSptial) {
        this.sectieSptial = sectieSptial;
    }

    @Override
    public String toString() {
        return "Analize{" +
                "idAnalize=" + idAnalize +
                ", numeAnalize='" + numeAnalize + '\'' +
                ", denumireSpital='" + denumireSpital + '\'' +
                ", numePacient='" + numePacient + '\'' +
                ", prenumePacient='" + prenumePacient + '\'' +
                ", CNP='" + CNP + '\'' +
                ", numeMedic='" + numeMedic + '\'' +
                ", sectieSptial='" + sectieSptial + '\'' +
                '}';
    }
}