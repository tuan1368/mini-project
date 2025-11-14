package com.example.mini_project.controller;

import com.example.mini_project.dto.CarParkDto;
import com.example.mini_project.service.CarParkService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carparks")
@Validated
public class CarParkController {

    private final CarParkService carParkService;

    public CarParkController(CarParkService carParkService) {
        this.carParkService = carParkService;
    }

    @GetMapping("/nearest")
    public ResponseEntity<Page<CarParkDto>> getNearestCarParks(
            @RequestParam @NotNull @Min(-90) @Max(90) Double latitude,
            @RequestParam @NotNull @Min(-180) @Max(180) Double longitude,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int per_page) {

        Page<CarParkDto> results = carParkService.findNearestAvailableCarParks(
                latitude, longitude, page, per_page
        );
        return ResponseEntity.ok(results);
    }
}
