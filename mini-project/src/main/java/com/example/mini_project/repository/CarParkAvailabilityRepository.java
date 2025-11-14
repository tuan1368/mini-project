package com.example.mini_project.repository;

import com.example.mini_project.dto.CarParkAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarParkAvailabilityRepository extends JpaRepository<CarParkAvailability, String> {
}
