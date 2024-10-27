package com.example.carddesanatate;

public class ContUtilizator {

    String Email;
    String Parola;

    public ContUtilizator(String email, String parola) {
        Email = email;
        Parola = parola;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String parola) {
        Parola = parola;
    }

    @Override
    public String toString() {
        return "ContUtilizator{" +
                "Email='" + Email + '\'' +
                ", Parola='" + Parola + '\'' +
                '}';
    }
}


