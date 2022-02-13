package com.aqib.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
@NoArgsConstructor
public class PersonalDetail {
    String id;
    String firstName;
    String middleName;
    String lastName;
    String address;
    String phoneNumber;
}
