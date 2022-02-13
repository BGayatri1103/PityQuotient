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
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    DiagnosisRepo diagnosisRepo;

    @Autowired
    HealthRepo healthRepo;

    @Autowired
    PersonalRepo personalRepo;

    public PatientDetail patientDetail(String id, Boolean personal){
        PatientDetail patientDetail = new PatientDetail();
        patientDetail.setId(id);
        patientDetail.setPersonal(personal);
        return patientDetail;
    }

    public PersonalDetail getPersonalDetail(String id){
        PersonalEntity personalEntity = personalRepo.findById(id).get();
        PersonalDetail personalDetail = new PersonalDetail();
        BeanUtils.copyProperties(personalEntity,personalDetail);
        return personalDetail;
    }

    public HealthDetail getHealthDetail(String id){
        HealthEntity healthEntity = healthRepo.findById(id).get();
        HealthDetail healthDetail = new HealthDetail();
        BeanUtils.copyProperties(healthEntity,healthDetail);
        return healthDetail;
    }

    public Diagnosis getDiagnosisDetail(String id){
        DiagnosisEntity diagnosisEntity = diagnosisRepo.findById(id).get();
        Diagnosis diagnosis = new Diagnosis();
        BeanUtils.copyProperties(diagnosisEntity,diagnosis);
        return diagnosis;
    }
}
