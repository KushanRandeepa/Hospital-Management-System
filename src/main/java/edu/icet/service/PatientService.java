package edu.icet.service;

import edu.icet.dto.Patient;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);

    List<Patient> getPatient();

    void deletePatient(Integer id);

    List<Patient> searchByName(String name);

    Patient searchById(Integer id);

    List<Patient> searchByAddress(String address);

    List<Patient> searchByNic(String nic);

    List<Patient> searchByCategory(String category);

    List<Patient> searchByBloodGroup(String bloodGroup);


}

