package com.example.mini_project.dto.availability;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.List;

/**
 * Ánh xạ phần tử đầu tiên bên trong mảng "items".
 * Chứa timestamp và danh sách dữ liệu của các bãi đỗ xe.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiItem {

    private Instant timestamp;

    @JsonProperty("carpark_data")
    private List<CarParkData> carparkData;

    // Getters và Setters
    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public List<CarParkData> getCarparkData() {
        return carparkData;
    }

    public void setCarparkData(List<CarParkData> carparkData) {
        this.carparkData = carparkData;
    }
}
