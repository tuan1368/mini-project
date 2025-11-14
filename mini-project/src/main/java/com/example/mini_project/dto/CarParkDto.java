package com.example.mini_project.dto;

public class CarParkDto {
    private final String address;
    private final Double latitude;
    private final Double longitude;
    private final Integer total_lots;
    private final Integer available_lots;

    public CarParkDto(String address,
                      Double latitude,
                      Double longitude,
                      Integer total_lots,
                      Integer available_lots) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.total_lots = total_lots;
        this.available_lots = available_lots;
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

    public Integer getTotal_lots() {
        return total_lots;
    }

    public Integer getAvailable_lots() {
        return available_lots;
    }
}
