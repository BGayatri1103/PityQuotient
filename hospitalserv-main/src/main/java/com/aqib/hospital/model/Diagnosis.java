package com.aqib.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Data
@NoArgsConstructor
public class Diagnosis {
    String id;
    String DoctorName;
    String HospitalName;
    String referredHospital;
    String referredDoc;
    List<String> doctorDiagnosis;
}
