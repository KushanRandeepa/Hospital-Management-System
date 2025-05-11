package edu.icet.service.impl;

import edu.icet.dto.MedicalReport;
import edu.icet.entity.MedicalReportEntity;
import edu.icet.repository.MedicalReportRepository;
import edu.icet.service.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service

public class MedicalReportServiceImpl implements MedicalReportService {

    final MedicalReportRepository repository;
    final ModelMapper mapper;

    @Override
    public void addMedicalReport(MedicalReport medicalReport) {
        repository.save(mapper.map(medicalReport, MedicalReportEntity.class));
    }

    @Override
    public List<MedicalReport> getAll() {
        List<MedicalReport>medicalReportsList=new ArrayList<>();
        repository.findAll().forEach(medicalReportEntity -> medicalReportsList.add(mapper.map(medicalReportEntity,MedicalReport.class)));
        return medicalReportsList;
    }

    @Override
    public boolean deleteMedicalReport(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public MedicalReport searchMedicalReportById(Integer id) {
       return mapper.map(repository.findById(id),MedicalReport.class);
    }

    @Override
    public List<MedicalReport> searchMedicalReportByCategory(String category) {
        List<MedicalReport>medicalReportsList=new ArrayList<>();
        repository.findByCategory(category).forEach(medicalReportEntity -> medicalReportsList.add(mapper.map(medicalReportEntity,MedicalReport.class)));
        return medicalReportsList;
    }

    @Override
    public List<MedicalReport> searchMedicalReportByDateTime(LocalDateTime dateTime) {
        List<MedicalReport>medicalReportsList=new ArrayList<>();
        repository.findByDateTime(dateTime).forEach(medicalReportEntity -> medicalReportsList.add(mapper.map(medicalReportEntity,MedicalReport.class)));
        return medicalReportsList;
    }

    @Override
    public List<MedicalReport> searchMedicalReportByPatientId(Integer patientId) {
        List<MedicalReport>medicalReportsList=new ArrayList<>();
        repository.findByPatientId(patientId).forEach(medicalReportEntity -> medicalReportsList.add(mapper.map(medicalReportEntity,MedicalReport.class)));
        return medicalReportsList;
    }

    @Override
    public List<MedicalReport> searchMedicalReportByAdminId(Integer adminId) {
        List<MedicalReport>medicalReportsList=new ArrayList<>();
        repository.findByAdminId(adminId).forEach(medicalReportEntity -> medicalReportsList.add(mapper.map(medicalReportEntity,MedicalReport.class)));
        return medicalReportsList;
    }

    @Override
    public List<MedicalReport> searchMedicalReportByLabNumber(Integer labNumber) {
        List<MedicalReport>medicalReportsList=new ArrayList<>();
        repository.findByLabNumber(labNumber).forEach(medicalReportEntity -> medicalReportsList.add(mapper.map(medicalReportEntity,MedicalReport.class)));
        return medicalReportsList;
    }
}
