package edu.icet.repository;

import edu.icet.entity.MedicalReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicalReportRepository extends JpaRepository<MedicalReportEntity,Integer> {
    List<MedicalReportEntity> findByCategory(String category);

    List<MedicalReportEntity> findByDateTime(LocalDateTime dateTime);

    List<MedicalReportEntity>  findByPatientId(Integer patientId);

    List<MedicalReportEntity>  findByAdminId(Integer adminId);

    List<MedicalReportEntity>  findByLabNumber(Integer labNumber);
}
