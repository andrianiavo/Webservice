package com.example.springboot.MrRojoProject.Admin;

import com.example.springboot.MrRojoProject.Function.Functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admiControlleur")
public class AdminControlleur {
    @Autowired
    private AdminRepository adminRepository;
    @PostMapping("/admin")

    public Admin logAdmin(@Validated @RequestBody Admin admin){
        return Functions.log(admin.getNomAdmin(),admin.getPwd(),adminRepository);
    }
    @PostMapping("/adminInsert")
    public Admin createEmployer(@Validated @RequestBody Admin admin){
        return adminRepository.save(admin);
    }
}
