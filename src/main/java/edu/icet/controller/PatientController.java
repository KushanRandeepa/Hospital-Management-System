package edu.icet.controller;

import edu.icet.dto.Patient;
import edu.icet.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
     PatientService service;

    @GetMapping("/get-all")
    public List<Patient> getPatient() {
        return service.getPatient();
    }

    @PostMapping("/add-patient")
    public void addPatient(@RequestBody Patient patient){
        service.addPatient(patient);
    }

    @DeleteMapping("/delete-by-id/{id}")
        public void deletePatient(@PathVariable Integer id){
            service.deletePatient(id);
    }
    @PutMapping("update")
    public void updatePatient(@RequestBody Patient patient){
        service.addPatient(patient);
    }
}
