package com.aqib.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("health_details")
@NoArgsConstructor
public class HealthEntity {
    @Id
    String id;
    String height;
    String weight;
    String bloodPressure;
    String temperature;
    String sugar;
    String cholesterol;
}
