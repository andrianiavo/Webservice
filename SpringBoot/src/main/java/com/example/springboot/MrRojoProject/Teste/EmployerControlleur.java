package com.example.springboot.MrRojoProject.Teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiv1")
public class EmployerControlleur {
    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping("/employees")
    public List<Employer> getAllEmployee(){
        return employerRepository.findAll();
    }

    @PostMapping("/employees")
    public Employer createEmployer(@Validated @RequestBody Employer employee){
        return employerRepository.save(employee);
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<Employer> getEmployeeById(@PathVariable(value = "id") long id) throws ResourceNotFound {
        Employer employer= employerRepository.findById(id).orElseThrow(()->new ResourceNotFound("Employee not found for this id ::"+id));
        return ResponseEntity.ok().body(employer);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employer> updateEmployee(@PathVariable(value = "id") long id, @RequestBody Employer employer) throws ResourceNotFound {
        Employer employee=employerRepository.findById(id).orElseThrow(()->new ResourceNotFound("Employee not found"));
        employee.setFirstName(employer.getFirstName());
        employee.setLastName(employer.getLastName());
        employee.setEmailId(employer.getEmailId());
        employerRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") long id) throws ResourceNotFound {
        Employer employer= employerRepository.findById(id).orElseThrow(()->new ResourceNotFound("Employee not found for this id ::"+id));
        employerRepository.delete(employer);
        return ResponseEntity.ok().build();
    }
}
