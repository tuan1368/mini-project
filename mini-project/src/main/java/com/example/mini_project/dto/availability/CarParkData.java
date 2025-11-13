package com.example.mini_project.dto.availability;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarParkData {

    @JsonProperty("carpark_number")
    private String carparkNumber;

    @JsonProperty("carpark_info")
    private List<LotInfo> lotInfo;

    // Getters và Setters
    public String getCarparkNumber() {
        return carparkNumber;
    }

    public void setCarparkNumber(String carparkNumber) {
        this.carparkNumber = carparkNumber;
    }

    public List<LotInfo> getLotInfo() {
        return lotInfo;
    }

    public void setLotInfo(List<LotInfo> lotInfo) {
        this.lotInfo = lotInfo;
    }
}
