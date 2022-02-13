package com.aqib.hospital.repository;

import com.aqib.hospital.entity.HealthEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HealthRepo extends MongoRepository<HealthEntity,String> {
}
