package com.example.carddesanatate;

import android.media.Image;

import java.io.Serializable;

public class Analize implements Serializable {

    int idAnalize;
    String numeAnalize;
    String denumireSpital;
    String numePacient;
    String prenumePacient;
    String CNP;
    String numeMedic;
    String sectieSptial;

    //poate un cod QR de scanat ca sa nu se mai adauge manual detaliile


    public Analize(int idAnalize, String numeAnalize, String denumireSpital, String numePacient, String prenumePacient, String CNP, String numeMedic, String sectieSptial) {
        this.idAnalize = idAnalize;
        this.numeAnalize = numeAnalize;
        this.denumireSpital = denumireSpital;
        this.numePacient = numePacient;
        this.prenumePacient = prenumePacient;
        this.CNP = CNP;
        this.numeMedic = numeMedic;
        this.sectieSptial = sectieSptial;
    }

    public int getIdAnalize() {
        return idAnalize;
    }

    public void setIdAnalize(int idAnalize) {
        this.idAnalize = idAnalize;
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
