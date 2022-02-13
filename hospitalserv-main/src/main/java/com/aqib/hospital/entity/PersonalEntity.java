package com.aqib.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("personal_details")
@NoArgsConstructor
public class PersonalEntity {
    @Id
    String id;
    String firstName;
    String middleName;
    String lastName;
    String address;
    String phoneNumber;
}
