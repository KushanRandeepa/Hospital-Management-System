package edu.icet.service.impl;

import edu.icet.dto.Patient;
import edu.icet.entity.PatientEntity;
import edu.icet.entity.UserEntity;
import edu.icet.repository.PatientRepository;
import edu.icet.repository.UserRepository;
import edu.icet.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    final UserRepository userRepository;
    final PatientRepository repository;
    final ModelMapper mapper;


    @Override
    public List<Patient> getPatient() {
        List<Patient> patientList = new ArrayList<>();
        repository.findAll().forEach(patientEntity -> patientList.add(mapper.map(patientEntity, Patient.class)));
        return patientList;
    }

    @Override
    public void addPatient(Patient patient) {

        String newId=generateNewId();
        patient.setId(newId);
        repository.save(mapper.map(patient, PatientEntity.class));

        UserEntity userEntity=new UserEntity();
        userEntity.setCustomId(newId);
        userEntity.setUsername(patient.getName());
        userEntity.setPassword("1234");
        userRepository.save(userEntity);
    }

    private String generateNewId() {
        String lastId = repository.findTopByOrderByIdDesc().map(entity->entity.getId()).orElse("PT000");
        int number=Integer.parseInt(lastId.substring(2));
        number++;
        return String.format("PT%03d",number);
    }

    @Override
    public void deletePatient(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Patient> searchByName(String name) {
        List<Patient> patients = new ArrayList<>();
        repository.findByName(name).forEach(patientEntity -> patients.add(mapper.map(patientEntity, Patient.class)));
        return patients;
    }

    @Override
    public Patient searchById(String id) {
        return mapper.map(repository.findById(id),Patient.class);
    }

    @Override
    public List<Patient> searchByAddress(String address) {
        List<Patient> patients = new ArrayList<>();
        repository.findByAddress(address).forEach(patientEntity -> patients.add( mapper.map(patientEntity,Patient.class)));
        return patients;
    }

    @Override
    public List<Patient> searchByNic(String nic) {
        List<Patient> patients = new ArrayList<>();
        repository.findByNic(nic).forEach(patientEntity -> patients.add(mapper.map(patientEntity,Patient.class)));
        return patients;
    }

    @Override
    public List<Patient> searchByCategory(String category) {
        List<Patient> patients = new ArrayList<>();
        repository.findByCategory(category).forEach(patientEntity -> patients.add(mapper.map(patientEntity,Patient.class)));
        return patients;
    }

    @Override
    public List<Patient> searchByBloodGroup(String bloodGroup) {
        List<Patient> patients = new ArrayList<>();
        repository.findByBloodGroup(bloodGroup).forEach(patientEntity -> patients.add(mapper.map(patientEntity, Patient.class)));
        return patients;
    }
}


