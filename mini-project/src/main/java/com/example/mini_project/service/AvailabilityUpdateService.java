package com.example.mini_project.service;

import com.example.mini_project.carrepository.CarParkAvailabilityRepository;
import com.example.mini_project.dto.CarParkAvailability;
import com.example.mini_project.dto.availability.ApiItem;
import com.example.mini_project.dto.availability.ApiResponse;
import com.example.mini_project.dto.availability.CarParkData;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;

@Service
public class AvailabilityUpdateService {

    private final WebClient webClient;
    private final CarParkAvailabilityRepository repository;

    public AvailabilityUpdateService(WebClient webClient, CarParkAvailabilityRepository repository) {
        this.webClient = webClient;
        this.repository = repository;
    }

    @Transactional
    public void updateAvailabilityData() {

        ApiResponse response = webClient.get()
                .uri("/carpark-availability")
                .retrieve()
                .bodyToMono(ApiResponse.class)
                .block();

        if (response != null && response.getItems() != null) {
            ApiItem apiItem = response.getItems().get(0);

            for (CarParkData data : apiItem.getCarparkData()) {
                CarParkAvailability avail = new CarParkAvailability();
                avail.setCarParkNo(data.getCarparkNumber());
                avail.setTotalLots(Integer.valueOf(data.getLotInfo().get(0).getTotalLots()));
                avail.setAvailableLots(Integer.valueOf(data.getLotInfo().get(0).getLotsAvailable()));
                avail.setLastUpdatedAt(Instant.now());

                repository.save(avail);
            }
        }
    }
}
