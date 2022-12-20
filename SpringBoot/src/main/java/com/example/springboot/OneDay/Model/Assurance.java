package com.example.springboot.OneDay.Model;

public class Assurance {
    long idAssurance;
    long idAvion;
    String daty;
    long idType;

    public long getIdAssurance() {
        return idAssurance;
    }

    public void setIdAssurance(long idAssurance) {
        this.idAssurance = idAssurance;
    }

    public long getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(long idAvion) {
        this.idAvion = idAvion;
    }

    public String getDate() {
        return daty;
    }

    public void setDate(String date) {
        this.daty = date;
    }

    public long getIdType() {
        return idType;
    }

    public void setIdType(long idType) {
        this.idType = idType;
    }

    public Assurance() {
    }



}
