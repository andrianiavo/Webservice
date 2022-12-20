package com.example.springboot.OneDay.Model.Url;

import com.example.springboot.OneDay.Model.Admin;
import com.example.springboot.OneDay.Model.Avion;
import com.example.springboot.OneDay.Model.Kilometrage;
import com.example.springboot.OneDay.Model.Token.Token;
import com.example.springboot.OneDay.Model.Token.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oneday")
public class Url {
    @Autowired
    TokenRepository tokenRepository;

    @GetMapping("/avions")
    public Avion[]listeAvion() throws Exception {
        String sql="select idAvion,nom,model,path from v_profil";
        return Avion.getAllAvion(sql);
    }

    @GetMapping("detail/{idAvion}")
    public List<Kilometrage>listeKilometrage(@PathVariable long idAvion) throws Exception {
        return Kilometrage.allKilommetrage(idAvion);
    }

    @PostMapping("/connect")
    public Token logAdmin(@Validated @RequestBody Admin admin){
        try {
            Admin ad=Admin.log(admin.getLogin(),admin.getPwd());
            if (ad!=null) {
                Token val=Token.generer(ad);
                tokenRepository.save(val);
                return val;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    @GetMapping("assurance/{mois}")
    public Avion[]assurance1mois(@PathVariable int mois) throws Exception {
        String sql="select idAvion,model,nom  from  v_assurance where restant >0 and restant<="+mois*30;
        return Avion.getAllAvion(sql);
    }
}
