package com.aqib.hospital.controller;

import com.aqib.hospital.entity.DiagnosisEntity;
import com.aqib.hospital.entity.HealthEntity;
import com.aqib.hospital.entity.PersonalEntity;
import com.aqib.hospital.model.Diagnosis;
import com.aqib.hospital.model.HealthDetail;
import com.aqib.hospital.model.PatientDetail;
import com.aqib.hospital.model.PersonalDetail;
import com.aqib.hospital.repository.DiagnosisRepo;
import com.aqib.hospital.repository.HealthRepo;
import com.aqib.hospital.repository.PersonalRepo;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientDetailResolver implements GraphQLResolver<PatientDetail> {

    @Autowired
    PersonalRepo personalRepo;

    @Autowired
    HealthRepo healthRepo;

    @Autowired
    DiagnosisRepo diagnosisRepo;

    public PersonalDetail personalDetail(PatientDetail patientDetail){
        if(!patientDetail.getPersonal()) {
            PersonalDetail personalDetail = new PersonalDetail();
            personalDetail.setId(patientDetail.getId());
            personalDetail.setFirstName("");
            personalDetail.setLastName("");
            personalDetail.setAddress("");
            personalDetail.setPhoneNumber("");
            return personalDetail;
        }
        PersonalEntity personalEntity = personalRepo.findById(patientDetail.getId()).get();
        PersonalDetail personalDetail = new PersonalDetail();
        BeanUtils.copyProperties(personalEntity,personalDetail);
        return personalDetail;
    }

    public HealthDetail healthDetail(PatientDetail patientDetail){
        HealthEntity healthEntity = healthRepo.findById(patientDetail.getId()).get();
        HealthDetail healthDetail = new HealthDetail();
        BeanUtils.copyProperties(healthEntity,healthDetail);
        return healthDetail;
    }

    public Diagnosis diagnosis(PatientDetail patientDetail){
        DiagnosisEntity diagnosisEntity = diagnosisRepo.findById(patientDetail.getId()).get();
        Diagnosis diagnosis = new Diagnosis();
        BeanUtils.copyProperties(diagnosisEntity,diagnosis);
        return diagnosis;
    }
}
