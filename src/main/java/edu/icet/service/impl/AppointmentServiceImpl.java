package edu.icet.service.impl;

import edu.icet.dto.Appointment;
import edu.icet.entity.AppointmentEntity;
import edu.icet.repository.AppointmentRepository;
import edu.icet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AppointmentServiceImpl implements AppointmentService {

    final AppointmentRepository repository;
    final ModelMapper mapper;

    @Override
    public void addAppointment(Appointment appointment) {
        Integer pendingCount  = repository.countByStatus("PENDING");
        appointment.setId(generateNewId());
        appointment.setQueNumber(pendingCount + 1);
        repository.save(mapper.map(appointment, AppointmentEntity.class));
    }

    private String generateNewId() {
        String lastId = repository.findTopByOrderByIdDesc().map(entity->entity.getId()).orElse("AP000");
        int number=Integer.parseInt(lastId.substring(2));
        number++;
        return String.format("AP%03d",number);
    }


    @Override
    public List<Appointment> getAppointment() {
        List<Appointment>appointments=new ArrayList<>();
        repository.findAll().forEach(appointmentEntity -> appointments.add(mapper.map(appointmentEntity, Appointment.class)));
        return appointments;
    }

    @Override
    public Boolean deleteAppointment(String id) {
        repository.deleteById(id);

        return true;
    }

    @Override
    public Appointment searchById(String id) {
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
    public List<Appointment> searchByPatientId(String patientId) {
        List<Appointment> appointments=new ArrayList<>();
        repository.findByPatientId(patientId).forEach(appointmentEntity -> appointments.add(mapper.map(appointmentEntity, Appointment.class)));
        return appointments;
    }



    @Override
    public void updateAppointment(Appointment appointment) {
        appointment.setStatus("COMPLETED");
        repository.save(mapper.map(appointment, AppointmentEntity.class));

    }

}
