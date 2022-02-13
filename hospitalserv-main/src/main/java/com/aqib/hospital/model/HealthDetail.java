package com.aqib.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
@NoArgsConstructor
public class HealthDetail {
    String id;
    String height;
    String weight;
    String bloodPressure;
    String temperature;
    String sugar;
    String cholesterol;
}
