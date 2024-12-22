package com.example.carddesanatate;

public class PacientAsigurat extends Pacient{

    Boolean esteAsigurat;


    public PacientAsigurat(String nume, String prenume, String CNP, String email, String parola, String sex, Boolean esteAsigurat) {
        super(nume, prenume, CNP, email, parola, sex);
        this.esteAsigurat = esteAsigurat;
    }

    public Boolean getEsteAsigurat() {
        return esteAsigurat;
    }

    public void setEsteAsigurat(Boolean esteAsigurat) {
        this.esteAsigurat = esteAsigurat;
    }

    @Override
    public String toString() {
        return "PacientAsigurat{" +
                "esteAsigurat=" + esteAsigurat +
                ", nume='" + nume + '\'' +
                ", Prenume='" + Prenume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
