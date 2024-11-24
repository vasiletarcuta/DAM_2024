package com.example.carddesanatate;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "asigurari")
public class Asigurare {

    @PrimaryKey(autoGenerate = true)
    private int idAsigurare;

    private int idPacient;
    private String tipAsigurare;
    private String companieAsigurare;
    private double sumaAcoperita;

    public Asigurare(int idPacient, String tipAsigurare, String companieAsigurare, double sumaAcoperita) {
        this.idPacient = idPacient;
        this.tipAsigurare = tipAsigurare;
        this.companieAsigurare = companieAsigurare;
        this.sumaAcoperita = sumaAcoperita;
    }

    public int getIdAsigurare() {
        return idAsigurare;
    }

    public void setIdAsigurare(int idAsigurare) {
        this.idAsigurare = idAsigurare;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public String getTipAsigurare() {
        return tipAsigurare;
    }

    public void setTipAsigurare(String tipAsigurare) {
        this.tipAsigurare = tipAsigurare;
    }

    public String getCompanieAsigurare() {
        return companieAsigurare;
    }

    public void setCompanieAsigurare(String companieAsigurare) {
        this.companieAsigurare = companieAsigurare;
    }

    public double getSumaAcoperita() {
        return sumaAcoperita;
    }

    public void setSumaAcoperita(double sumaAcoperita) {
        this.sumaAcoperita = sumaAcoperita;
    }
}

