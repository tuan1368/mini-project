package com.example.mini_project.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_park_information")
public class CarParkInformation {

    @Id
    private String carParkNo; // unique identifier

    private String address;
    private Double latitude;
    private Double longitude;
    private Integer totalLots;
    private Integer availableLots;

    public CarParkInformation() {
    }

    public CarParkInformation(String carParkNo,
                              String address,
                              Double latitude,
                              Double longitude,
                              Integer totalLots,
                              Integer availableLots) {
        this.carParkNo = carParkNo;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.totalLots = totalLots;
        this.availableLots = availableLots;
    }

    public String getCarParkNo() {
        return carParkNo;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getTotalLots() {
        return totalLots;
    }

    public Integer getAvailableLots() {
        return availableLots;
    }

    public void setCarParkNo(String carParkNo) {
        this.carParkNo = carParkNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setTotalLots(Integer totalLots) {
        this.totalLots = totalLots;
    }

    public void setAvailableLots(Integer availableLots) {
        this.availableLots = availableLots;
    }
}
