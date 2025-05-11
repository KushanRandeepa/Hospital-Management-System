package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MedicalReport {

    private Integer id;
    private  String category;
    private String pdfSrc;
    private LocalDateTime dateTime;
    private Integer patientId;
    private Integer adminId;
    private Integer labNumber;
}
