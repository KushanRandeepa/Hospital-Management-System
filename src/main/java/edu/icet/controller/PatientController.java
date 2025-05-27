package edu.icet.controller;

import edu.icet.dto.Patient;
import edu.icet.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/patient")
public class PatientController {

    final PatientService service;

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('USER')")
    public List<Patient> getPatient() {
        return service.getPatient();
    }

    @PostMapping("/add-patient")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void addPatient(@RequestBody Patient patient){
        service.addPatient(patient);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
        public void deletePatient(@PathVariable String id){
            service.deletePatient(id);
    }
    @PutMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public void updatePatient(@RequestBody Patient patient){
        service.addPatient(patient);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Patient> searchByName(@PathVariable  String name){
       return service.searchByName(name);
    }
    @GetMapping("/search-by-id/{id}")
    public Patient searchById(@PathVariable String id){
        return service.searchById(id);
    }
    @GetMapping("/search-by-address/{address}")
    public List<Patient> searchByAddress(@PathVariable  String address){
        return service.searchByAddress(address);
    }
    @GetMapping("/search-by-nic/{nic}")
    public List<Patient> searchByNic(@PathVariable  String nic){
        return service.searchByNic(nic);
    }
    @GetMapping("/search-by-category/{category}")
    public List<Patient> searchByCategory(@PathVariable  String category){
        return service.searchByCategory(category);
    }
    @GetMapping("/search-by-bloodGroup/{bloodGroup}")
    public List<Patient> searchByBloodGroup(@PathVariable String bloodGroup){
        return service.searchByBloodGroup(bloodGroup);
    }
}
