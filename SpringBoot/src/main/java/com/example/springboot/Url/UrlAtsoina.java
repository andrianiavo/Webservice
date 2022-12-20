package com.example.springboot.Url;

import com.example.springboot.Base.FonctionBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/url")
public class UrlAtsoina {
    @Autowired
    private RequeteRepository requete;

    @GetMapping("/insert/{sql}")
    public  void response( @PathVariable String sql) throws Exception {
        sql=sql.replace("&&","'");
        sql=sql.replace("_"," ");
        sql=sql.replaceAll("--","\\)");
        sql=sql.replaceAll("-N-","\\(");
        System.out.println(sql);
        FonctionBase.modifBase(sql);
    }

    @GetMapping("/request")
    public List<Requete>request(){
        return requete.findAll();
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id) throws Exception {
        String sql="delete from requete where idrequest="+id;
        FonctionBase.modifBase(sql);
    }
}
