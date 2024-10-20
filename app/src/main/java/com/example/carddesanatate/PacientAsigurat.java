package com.example.carddesanatate;

public class PacientAsigurat extends Pacient{

    Boolean esteAsigurat;


    public PacientAsigurat(String nume, String prenume, String CNP, String email, Boolean esteAsigurat) {
        super(nume, prenume, CNP, email);
        this.esteAsigurat=esteAsigurat;
    }

    public Boolean getEsteAsigurat() {
        return esteAsigurat;
    }

    public void setEsteAsigurat(Boolean esteAsigurat) {
        this.esteAsigurat = esteAsigurat;
    }


}
