package com.example.mini_project.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
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

    public void setCarParkNo(String carParkNo) {
        this.carParkNo = carParkNo;
    }

    public void setTotalLots(Integer totalLots) {
        this.totalLots = totalLots;
    }

    public void setAvailableLots(Integer availableLots) {
        this.availableLots = availableLots;
    }

    public void setLastUpdatedAt(Instant lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

}
