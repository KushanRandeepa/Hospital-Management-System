package edu.icet.service;

import edu.icet.dto.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    void addAppointment(Appointment appointment);

    List<Appointment> getAppointment();

    Boolean deleteAppointment(Integer id);

    Appointment searchById(Integer id);

    List<Appointment> searchByRoomNumber(Integer roomNumber);

    List<Appointment> searchByQueNumber(Integer queNumber);

    List<Appointment> searchByDateTime(LocalDateTime dateTime);

    List<Appointment> searchByPatientId(Integer patientID);

    List<Appointment> searchByAdminId(Integer adminId);
}
