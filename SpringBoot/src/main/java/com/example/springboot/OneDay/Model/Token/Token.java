package com.example.springboot.OneDay.Model.Token;
import com.example.springboot.OneDay.Model.Admin;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_token;
    @Column(name = "id_utilisateur")
    long id_user ;
    @Column(name = "valeur")
    String valeur;
    @Column(name = "daty_expiration")
    LocalDateTime daty;

    public static  Token generer(Admin ad)
    {

        TokenRepository TokVehiculeRepository;
        LocalDateTime dt=LocalDateTime.now();
        dt.plusMinutes(15);
        Token val=new Token(ad.getIdAdmin(),genererValeurToken(ad),dt);
        return  val;
    }
    static  String genererValeurToken(Admin ad)
    {
        String value=ad.getLogin()+ad.getPwd()+ad.getIdAdmin()+LocalDateTime.now().toString();
        String sha1="";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e){
            e.printStackTrace();
        }
       return sha1;
    }
    public Token() {
    }

    public Token(long id_user, String valeur, LocalDateTime daty) {
        this.id_user = id_user;
        this.valeur = valeur;
        this.daty = daty;
    }

    public Token(long id_token, long id_user, String valeur, LocalDateTime daty) {
        this.id_token = id_token;
        this.id_user = id_user;
        this.valeur = valeur;
        this.daty = daty;
    }

    public long getId_token() {
        return id_token;
    }

    public long getId_user() {
        return id_user;
    }

    public String getValeur() {
        return valeur;
    }

    public LocalDateTime getDaty() {
        return daty;
    }
}
