package com.example.mini_project.service.impl;

import com.example.mini_project.dto.CarParkDto;
import com.example.mini_project.service.CarParkService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CarParkServiceImpl implements CarParkService {

    @Override
    public List<CarParkDto> findNearest(double latitude, double longitude, int page, int perPage) {
        // Placeholder implementation
        return Collections.emptyList();
    }
}