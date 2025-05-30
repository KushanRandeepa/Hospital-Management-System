package edu.icet.controller;

import edu.icet.dto.Appointment;
import edu.icet.service.AppointmentService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
@PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR' )")
@CrossOrigin
public class AppointmentController {

    final AppointmentService service;

    @PostMapping("/add-appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAppointment(@RequestBody Appointment appointment) {
        service.addAppointment(appointment);
    }

    @GetMapping("/get-all")

    public List<Appointment> getAllAppointment() {
        return service.getAppointment();
    }

    @DeleteMapping("/delete-appointment/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean deleteAppointment(@PathVariable String id) {
        return service.deleteAppointment(id);
    }

    @PutMapping("/update-appointment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAppointment(@RequestBody Appointment appointment) {
        service.addAppointment(appointment);
    }

    @GetMapping("/search-by-id/{id}")
    public Appointment searchAppointmentById(@PathVariable String  id) {
        return service.searchById(id);
    }

    @GetMapping("/search-by-patientId/{patientId}")
    public List<Appointment> searchAppointmentByPatientId(@PathVariable String patientId) {
        return service.searchByPatientId(patientId);
    }
    @GetMapping("/search-by-adminId/{adminId}")
    public List<Appointment> searchAppointmentByAdminId(@PathVariable String  adminId) {
        return service.searchByAdminId(adminId);
    }

    @GetMapping("/search-by-roomNumber/{roomNumber}")
    public List<Appointment> searchAppointmentByRoomNumber(@PathVariable Integer roomNumber) {
        return service.searchByRoomNumber(roomNumber);
    }

    @GetMapping("/search-by-queNumber/{queNumber}")
    public List<Appointment> searchAppointmentByQueNumber(@PathVariable Integer queNumber) {
        return service.searchByQueNumber(queNumber);
    }


}
