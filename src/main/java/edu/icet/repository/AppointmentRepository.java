package edu.icet.repository;

import edu.icet.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity,String> {


    List<AppointmentEntity> findByRoomNumber(Integer roomNumber);

    List<AppointmentEntity> findByQueNumber(Integer queNumber);


    List<AppointmentEntity> findByPatientId(String patientId);

    List<AppointmentEntity> findByAdminId(String adminId);

    Optional<AppointmentEntity> findTopByOrderByIdDesc();

    Integer countByStatus(String pending);


}
