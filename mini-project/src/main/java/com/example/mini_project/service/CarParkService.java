package com.example.mini_project.service;

import com.example.mini_project.dto.CarParkDto;
import java.util.List;

public interface CarParkService {
    List<CarParkDto> findNearest(double latitude, double longitude, int page, int perPage);
}
