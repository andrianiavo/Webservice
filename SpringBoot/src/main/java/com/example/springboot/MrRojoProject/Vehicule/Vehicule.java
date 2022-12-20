package com.example.springboot.MrRojoProject.Vehicule;


import javax.persistence.*;

@Entity
@Table(name = "vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idVehicule;
    @Column(name = "marque")
    String marque ;
    @Column(name = "matricule")
    String matricule;

    public Vehicule(long idVehicule, String marque, String matricule) {
        this.idVehicule = idVehicule;
        this.marque = marque;
        this.matricule = matricule;
    }

    public Vehicule() {
    }

    public long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(long idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}
