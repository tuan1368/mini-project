package com.example.mini_project.service;

import com.example.mini_project.carrepository.CarParkInformationRepository;
import com.example.mini_project.dto.CarParkDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class CarParkService {
    private final CarParkInformationRepository repository;

    public CarParkService(CarParkInformationRepository repository) {
        this.repository = repository;
    }


    public Page<CarParkDto> findNearestAvailableCarParks(
            double latitude, double longitude, int page, int perPage) {

        PageRequest pageable = PageRequest.of(page, perPage);

        return repository.findNearestAvailableCarParks(latitude, longitude, pageable);
    }
}
