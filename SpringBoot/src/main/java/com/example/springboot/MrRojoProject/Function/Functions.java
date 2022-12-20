package com.example.springboot.MrRojoProject.Function;


import com.example.springboot.MrRojoProject.Admin.Admin;
import com.example.springboot.MrRojoProject.Admin.AdminRepository;

import java.util.List;

public class Functions {
    public static Admin log(String nom, String pwd, AdminRepository adminBase){
        List<Admin>all= adminBase.findAll();
        for (Admin admin : all){
            System.out.println("ity ny passWord : "+admin.getPwd());
            if (admin.getNomAdmin().equals(nom) && admin.getPwd().equals(pwd)){
                return admin;
            }
        }
        return null;
    }

    /*public static String genereToken(Admin test)
    {
        if (test==null)return null;
        else {
            Date now=new Date();
            Date d2=new Date();
            d2.setMinutes(d2.getMinutes()+10);
            String valiny= Jwts.builder()
                    .setSubject(test.getId())
                    .setIssuedAt(now)
                    .setExpiration(d2)
                    .claim("roles", test.getId())
                    .signWith(SignatureAlgorithm.HS512, "secretKeyByteArray")
                    .compact();
            System.out.println("tken ="+valiny);
            return valiny;
        }
    }*/
}
