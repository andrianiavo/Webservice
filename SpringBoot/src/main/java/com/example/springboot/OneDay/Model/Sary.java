package com.example.springboot.OneDay.Model;

public class Sary {
    long idSary;
    long idAvion;
    String lien;

    public Sary(long idAvion, String lien) {
        this.idAvion = idAvion;
        this.lien = lien;
    }

    public Sary() {
    }

    public long getIdSary() {
        return idSary;
    }

    public void setIdSary(long idSary) {
        this.idSary = idSary;
    }

    public long getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(long idAvion) {
        this.idAvion = idAvion;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
}
