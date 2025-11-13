package com.example.mini_project.carrepository;

import com.example.mini_project.dto.CarParkDto;
import com.example.mini_project.dto.CarParkInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarParkInformationRepository extends JpaRepository<CarParkInformation, String> {

    @Query(
            value = "SELECT " +
                    "  info.address AS address, " +
                    "  info.latitude AS latitude, " +
                    "  info.longitude AS longitude, " +
                    "  avail.total_lots AS total_lots, " +
                    "  avail.available_lots AS available_lots " +
                    "FROM " +
                    "  car_park_information AS info " +
                    "JOIN " +
                    "  car_park_availability AS avail ON info.car_park_no = avail.car_park_no " +
                    "WHERE " +
                    "  avail.available_lots > 0 " +
                    "ORDER BY " +
                    "  info.location <-> ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326) ASC", // Sắp xếp theo khoảng cách

            countQuery = "SELECT count(*) " +
                    "FROM car_park_information AS info " +
                    "JOIN car_park_availability AS avail ON info.car_park_no = avail.car_park_no " +
                    "WHERE avail.available_lots > 0",

            nativeQuery = true)
    Page<CarParkDto> findNearestAvailableCarParks(
            @Param("latitude") double latitude,
            @Param("longitude") double longitude,
            Pageable pageable
    );
}
