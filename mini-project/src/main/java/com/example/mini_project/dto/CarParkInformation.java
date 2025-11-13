package com.example.mini_project.dto;

import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;
import jakarta.persistence.*;

@Entity
@Getter
@Setter

@Table(name = "car_park_information")
public class CarParkInformation {

    @Id
    @Column(name = "car_park_no")
    private String carParkNo;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(columnDefinition = "geography(Point, 4326)")
    private Point location;

}
