package com.example.mini_project.controller;

import com.example.mini_project.dto.CarParkDto;
import com.example.mini_project.service.CarParkService;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carparks")
@Validated
public class CarParkController {

    private final CarParkService carParkService;

    public CarParkController(CarParkService carParkService) {
        this.carParkService = carParkService;
    }

    @GetMapping("/nearest")
    public List<CarParkDto> nearest(
            @RequestParam @NotNull @DecimalMin(value = "-90") @DecimalMax(value = "90") Double latitude,
            @RequestParam @NotNull @DecimalMin(value = "-180") @DecimalMax(value = "180") Double longitude,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "per_page", defaultValue = "10") int perPage) {
        return carParkService.findNearest(latitude, longitude, page, perPage);
    }
}
