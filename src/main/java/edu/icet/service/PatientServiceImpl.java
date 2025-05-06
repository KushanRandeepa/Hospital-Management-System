package edu.icet.service;

import edu.icet.dto.Patient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    List<Patient>patientList=new ArrayList<>();

    @Override
    public List<Patient> getPatient() {
        return patientList;
    }

    @Override

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }
}
