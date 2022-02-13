package com.aqib.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("diagnosis_details")
public class DiagnosisEntity {
    @Id
    String id;
    String DoctorName;
    String HospitalName;
    String referredHospital;
    String referredDoc;
    List<String> doctorDiagnosis;
}
