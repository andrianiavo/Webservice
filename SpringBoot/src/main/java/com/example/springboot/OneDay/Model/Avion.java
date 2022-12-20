package com.example.springboot.OneDay.Model;

import com.example.springboot.Base.FonctionBase;

import java.util.Vector;

public class Avion {
    long idAvion;
    String nom;
    String model;
    String path;

    public Avion(String nom, String model, String path) {
        this.nom = nom;
        this.model = model;
        this.path = path;
    }

    public Avion() {
    }

    public long getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(long idAvion) {
        this.idAvion = idAvion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static Avion[]getAllAvion(String sql) throws Exception {
        Vector<Object>[]all= FonctionBase.select(sql);
        Vector<Avion>avions=new Vector<>();
        for (int i = 0; i <all[0].size() ; i++) {
            Avion avion=new Avion();
            avion.setIdAvion(Long.parseLong( all[0].elementAt(i).toString()));
            avion.setNom((String) all[1].elementAt(i));
            avion.setModel((String) all[2].elementAt(i));
            avion.setPath((String) all[3].elementAt(i));
            avions.add(avion);
        }
        Avion[]listeAll=new Avion[avions.size()];
        for (int i = 0; i < listeAll.length ; i++) {
            listeAll[i]=avions.elementAt(i);
        }
        return listeAll;
    }
}
