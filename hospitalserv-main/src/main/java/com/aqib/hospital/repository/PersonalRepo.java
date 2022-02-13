package com.aqib.hospital.repository;

import com.aqib.hospital.entity.PersonalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonalRepo extends MongoRepository<PersonalEntity,String> {
    Optional<PersonalEntity> findByPhoneNumber(String phoneNumber);
}
