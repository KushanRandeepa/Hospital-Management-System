package edu.icet.repository;

import edu.icet.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientEntity,String> {
   List<PatientEntity> findByName(String name);

   List<PatientEntity> findByAddress(String address);

   List<PatientEntity> findByNic(String nic);

   List<PatientEntity> findByCategory(String category);

   List<PatientEntity> findByBloodGroup(String bloodGroup);

   Optional<PatientEntity> findTopByOrderByIdDesc();
}