package com.aqib.hospital.controller;

import com.aqib.hospital.entity.DiagnosisEntity;
import com.aqib.hospital.entity.HealthEntity;
import com.aqib.hospital.entity.PersonalEntity;
import com.aqib.hospital.model.*;
import com.aqib.hospital.repository.DiagnosisRepo;
import com.aqib.hospital.repository.HealthRepo;
import com.aqib.hospital.repository.PersonalRepo;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    @Autowired
    DiagnosisRepo diagnosisRepo;

    @Autowired
    HealthRepo healthRepo;

    @Autowired
    PersonalRepo personalRepo;

    public PersonalDetail createPersonalDetails(PersonalDetail personalDetail){
        PersonalEntity personalEntity = new PersonalEntity();
        HealthEntity healthEntity = new HealthEntity();
        DiagnosisEntity diagnosisEntity = new DiagnosisEntity();
        BeanUtils.copyProperties(personalDetail,personalEntity);
        personalEntity = personalRepo.save(personalEntity);
        personalDetail.setId(personalEntity.getId());
        healthEntity.setId(personalEntity.getId());
        diagnosisEntity.setId(personalEntity.getId());
        healthRepo.save(healthEntity);
        diagnosisRepo.save(diagnosisEntity);

        return personalDetail;
    }

    public HealthDetail createHealthDetails(HealthDetail healthDetail, String phoneNumber){
        HealthEntity healthEntity = new HealthEntity();
        String id = personalRepo.findByPhoneNumber(phoneNumber).get().getId();
        BeanUtils.copyProperties(healthDetail,healthEntity);
        healthEntity.setId(id);
        healthRepo.save(healthEntity);
        healthDetail.setId(healthEntity.getId());
        return healthDetail;
    }

    public Diagnosis createDiagnosisDetails(Diagnosis diagnosis, String phoneNumber){
        DiagnosisEntity diagnosisEntity = new DiagnosisEntity();
        String id = personalRepo.findByPhoneNumber(phoneNumber).get().getId();
        BeanUtils.copyProperties(diagnosis,diagnosisEntity);
        diagnosisEntity.setId(id);
        diagnosisRepo.save(diagnosisEntity);
        diagnosis.setId(diagnosisEntity.getId());
        return diagnosis;
    }
}
