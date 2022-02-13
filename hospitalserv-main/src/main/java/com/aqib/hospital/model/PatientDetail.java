package com.aqib.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
@NoArgsConstructor
public class PatientDetail {
    String id;
    Boolean personal;
    PersonalDetail personalDetail;
    HealthDetail healthDetail;
    Diagnosis diagnosis;
}
