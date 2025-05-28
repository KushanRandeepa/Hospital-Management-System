package edu.icet.controller;

import edu.icet.dto.MedicalReport;
import edu.icet.service.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController

@RequestMapping("/medical-report")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole( 'DOCTOR' , 'PATIENT')")

public class MedicalReportController {

    final MedicalReportService service;


    @PostMapping("/add-medical-report")
    @ResponseStatus(HttpStatus.CREATED)
    public void medicalReport(@RequestBody MedicalReport medicalReport){
        service.addMedicalReport(medicalReport);
    }

    @GetMapping("/view-all-reports")
    public List<MedicalReport>getMedicalReports(){
        return service.getAll();
    }


    @DeleteMapping("/delete-medical-report/{id}")
    public boolean deleteMedicalReport(@PathVariable Integer id){
        return service.deleteMedicalReport(id);
    }
    @GetMapping("/search-medicalRep-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicalReport searchMedicalReportById(@PathVariable Integer id){
        return service.searchMedicalReportById(id);
    }
    @GetMapping("/search-medicalRep-by-category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicalReport> searchMedicalReportByCategory(@PathVariable String category){
        return service.searchMedicalReportByCategory(category);
    }
    @GetMapping("/search-medicalRep-by-dateTime/{dateTime}")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicalReport> searchMedicalReportByDateTime(@PathVariable LocalDateTime dateTime){
        return service.searchMedicalReportByDateTime(dateTime);
    }
    @GetMapping("/search-medicalRep-by-patientId/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicalReport> searchMedicalReportByPatientId(@PathVariable Integer patientId){
        return service.searchMedicalReportByPatientId(patientId);
    }
    @GetMapping("/search-medicalRep-by-adminId/{adminId}")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicalReport> searchMedicalReportByAdminId(@PathVariable Integer adminId){
        return service.searchMedicalReportByAdminId(adminId);
    }
    @GetMapping("/search-medicalRep-by-labNumber/{labNumber}")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicalReport>searchMedicalReportByLabNumber(@PathVariable Integer labNumber){
        return service.searchMedicalReportByLabNumber(labNumber);
    }
}
