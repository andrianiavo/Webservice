package com.example.springboot.Url;


import javax.persistence.*;

@Entity
@Table(name = "requete")
public class Requete {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idrequest")
    private Long id;
    @Column(name = "request")
    String request;

    public Requete() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
