package com.example.mini_project.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "car_park_availability")
public class CarParkAvailability {

    @Id
    @Column(name = "car_park_no")
    private String carParkNo;

    @Column(name = "total_lots")
    private Integer totalLots;

    @Column(name = "available_lots")
    private Integer availableLots;

    @Column(name = "last_updated_at")
    private Instant lastUpdatedAt;

}
