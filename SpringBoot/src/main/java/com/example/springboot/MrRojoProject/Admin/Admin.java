package com.example.springboot.MrRojoProject.Admin;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nomAdmin")
    String nomAdmin ;
    @Column(name = "pwd")
    String pwd ;

    public Admin(long id, String nomAdmin, String pwd) {
        this.id = id;
        this.nomAdmin = nomAdmin;
        this.pwd = pwd;
    }

    public Admin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
