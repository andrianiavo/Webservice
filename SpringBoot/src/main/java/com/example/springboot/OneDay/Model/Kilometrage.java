package com.example.springboot.OneDay.Model;

import com.example.springboot.Base.FonctionBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Kilometrage {
    long idKilommetrage;
    String daty;
    double debut;
    double fin;
    long idAvion;

    public Kilometrage(String daty, double debut, double fin, long idAvion) {
        this.daty = daty;
        this.debut = debut;
        this.fin = fin;
        this.idAvion = idAvion;
    }

    public long getIdKilommetrage() {
        return idKilommetrage;
    }

    public void setIdKilommetrage(long idKilommetrage) {
        this.idKilommetrage = idKilommetrage;
    }

    public String getDaty() {
        return daty;
    }

    public void setDaty(String daty) {
        this.daty = daty;
    }

    public double getDebut() {
        return debut;
    }

    public void setDebut(double debut) {
        this.debut = debut;
    }

    public double getFin() {
        return fin;
    }

    public void setFin(double fin) {
        this.fin = fin;
    }

    public long getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(long idAvion) {
        this.idAvion = idAvion;
    }

    public Kilometrage() {
    }

    public static List<Kilometrage>allKilommetrage(long idAvion) throws Exception {
        String sql="select daty,debut,fin from kilometrage where idAvion="+idAvion;
        Vector<Object>[]all= FonctionBase.select(sql);
        List<Kilometrage>allList=new ArrayList<>();
        for (int i = 0; i <all[0].size() ; i++) {
            Kilometrage kilo=new Kilometrage();
            kilo.setDaty(all[0].elementAt(i).toString());
            kilo.setDebut((Double) all[1].elementAt(i));
            kilo.setFin((Double) all[2].elementAt(i));
            Long c=idAvion;
            kilo.setIdAvion(idAvion);
            allList.add(kilo);
        }
        return allList;
    }
}
