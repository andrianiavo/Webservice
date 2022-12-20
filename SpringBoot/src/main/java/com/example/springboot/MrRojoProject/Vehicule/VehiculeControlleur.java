package com.example.springboot.MrRojoProject.Vehicule;



import com.example.springboot.MrRojoProject.Teste.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculeControlleur")
public class VehiculeControlleur {
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @GetMapping("/vehicules")
    public List<Vehicule> getAllEmployee(){
        return vehiculeRepository.findAll();
    }

    @PostMapping("/vehicule")
    public Vehicule createEmployer(@Validated @RequestBody Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }

    @GetMapping("vehicule/{id}")
    public ResponseEntity<Vehicule> getEmployeeById(@PathVariable(value = "id") long id) throws ResourceNotFound {
        Vehicule employer= vehiculeRepository.findById(id).orElseThrow(()->new ResourceNotFound("Vehicule not found for this id ::"+id));
        return ResponseEntity.ok().body(employer);
    }

    @PutMapping("/vehicule/{id}")
    public ResponseEntity<Vehicule> updateEmployee(@PathVariable(value = "id") long id, @RequestBody Vehicule employer) throws ResourceNotFound {
        Vehicule employee=vehiculeRepository.findById(id).orElseThrow(()->new ResourceNotFound("Vehicule not found"));
        employee.setMarque(employer.getMarque());
        employee.setMatricule(employer.getMatricule());
        vehiculeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/vehicule/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") long id) throws ResourceNotFound {
        Vehicule employer= vehiculeRepository.findById(id).orElseThrow(()->new ResourceNotFound("Vehicule not found for this id ::"+id));
        vehiculeRepository.delete(employer);
        return ResponseEntity.ok().build();
    }
}
