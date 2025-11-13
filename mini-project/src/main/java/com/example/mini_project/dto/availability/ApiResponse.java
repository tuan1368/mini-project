package com.example.mini_project.dto.availability;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    private List<ApiItem> items;

    // Getters và Setters
    public List<ApiItem> getItems() {
        return items;
    }

    public void setItems(List<ApiItem> items) {
        this.items = items;
    }
}
