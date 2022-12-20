package com.example.springboot.MrRojoProject.Kilometrage;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "kilometrage")
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  idkilometre;

    @Column(name = "idvehicule")
    private long idvehicule;

    @Column(name = "dateKilometrage")
    private Date daty;

    @Column(name = "debutKilommetrage")
    private int kilometre_debut;

    @Column(name = "finKilometrage")
    private int kilometre_fin;

    public Kilometrage(long idkilometre, long idvehicule, Date daty, int kilometre_debut, int kilometre_fin) {
        this.idkilometre = idkilometre;
        this.idvehicule = idvehicule;
        this.daty = daty;
        this.kilometre_debut = kilometre_debut;
        this.kilometre_fin = kilometre_fin;
    }

    public long getIdkilometre() {
        return idkilometre;
    }

    public void setIdkilometre(long idkilometre) {
        this.idkilometre = idkilometre;
    }

    public long getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(long idvehicule) {
        this.idvehicule = idvehicule;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public int getKilometre_debut() {
        return kilometre_debut;
    }

    public void setKilometre_debut(int kilometre_debut) {
        this.kilometre_debut = kilometre_debut;
    }

    public int getKilometre_fin() {
        return kilometre_fin;
    }

    public void setKilometre_fin(int kilometre_fin) {
        this.kilometre_fin = kilometre_fin;
    }

    public Kilometrage() {
    }
}
