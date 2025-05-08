package edu.icet.service.impl;

import edu.icet.dto.Appointment;
import edu.icet.entity.AppointmentEntity;
import edu.icet.repository.AppointmentRepository;
import edu.icet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AppointmentServiceImpl implements AppointmentService {

    final AppointmentRepository repository;
    final ModelMapper mapper;

    @Override
    public void addAppointment(Appointment appointment) {
        repository.save(mapper.map(appointment, AppointmentEntity.class));
    }

    @Override
    public List<Appointment> getAppointment() {
        List<Appointment>appointments=new ArrayList<>();
        repository.findAll().forEach(appointmentEntity -> appointments.add(mapper.map(appointmentEntity, Appointment.class)));
        return appointments;
    }

    @Override
    public Boolean deleteAppointment(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Appointment searchById(Integer id) {
        return  mapper.map(repository.findById(id),Appointment.class);
    }

    @Override
    public List<Appointment> searchByRoomNumber(Integer roomNumber) {
        List<Appointment>appointments = new ArrayList<>();
        repository.findByRoomNumber(roomNumber).forEach(appointmentEntity -> appointments.add(mapper.map(appointmentEntity,Appointment.class)));
        return appointments;
    }

    @Override
    public List<Appointment> searchByQueNumber(Integer queNumber) {
        List<Appointment>appointments = new ArrayList<>();
        repository.findByQueNumber(queNumber).forEach(appointmentEntity -> appointments.add(mapper.map(appointmentEntity,Appointment.class)));
        return appointments;
    }

    @Override
    public List<Appointment> searchByDateTime(LocalDateTime dateTime) {
        List<Appointment>appointments = new ArrayList<>();
        repository.findByDateTime(dateTime).forEach(appointmentEntity -> appointments.add(mapper.map(appointmentEntity,Appointment.class)));
        return appointments;
    }

    @Override
    public List<Appointment> searchByPatientId(Integer patientId) {
        List<Appointment> appointments=new ArrayList<>();
        repository.findByPatientId(patientId).forEach(appointmentEntity -> appointments.add(mapper.map(appointmentEntity, Appointment.class)));
        return appointments;
    }

    @Override
    public List<Appointment> searchByAdminId(Integer adminId) {
        List<Appointment> appointments=new ArrayList<>();
        repository.findByAdminId(adminId).forEach(appointmentEntity -> appointments.add(mapper.map(appointmentEntity, Appointment.class)));
        return appointments;
    }

}
