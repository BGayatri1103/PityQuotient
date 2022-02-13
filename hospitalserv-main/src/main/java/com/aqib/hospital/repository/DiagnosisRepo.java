package com.aqib.hospital.repository;

import com.aqib.hospital.entity.DiagnosisEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiagnosisRepo extends MongoRepository<DiagnosisEntity, String> {
}
