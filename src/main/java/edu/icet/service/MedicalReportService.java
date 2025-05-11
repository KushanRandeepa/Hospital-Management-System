package edu.icet.service;

import edu.icet.dto.MedicalReport;
import java.time.LocalDateTime;
import java.util.List;

public interface MedicalReportService {
    void addMedicalReport(MedicalReport medicalReport);

    List<MedicalReport> getAll();

    boolean deleteMedicalReport(Integer id);

    MedicalReport searchMedicalReportById(Integer id);

    List<MedicalReport> searchMedicalReportByCategory(String category);

    List<MedicalReport> searchMedicalReportByDateTime(LocalDateTime dateTime);

    List<MedicalReport> searchMedicalReportByPatientId(Integer patientId);

    List<MedicalReport> searchMedicalReportByAdminId(Integer adminId);

    List<MedicalReport> searchMedicalReportByLabNumber(Integer labNumber);
}
