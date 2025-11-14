package com.example.mini_project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarParkDto {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private int availableLots;

    public CarParkDto() {}

    public CarParkDto(String id, String name, double latitude, double longitude, int availableLots) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.availableLots = availableLots;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public int getAvailableLots() { return availableLots; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public void setAvailableLots(int availableLots) { this.availableLots = availableLots; }
}