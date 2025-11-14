package com.example.mini_project.component;

import com.example.mini_project.repository.CarParkInformationRepository;
import com.example.mini_project.dto.CarParkInformation;
import com.example.mini_project.service.CoordinateConversionService;
import com.opencsv.CSVReader;
import jakarta.transaction.Transactional;
import org.locationtech.jts.geom.Point;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.io.Reader;

@Component
public class CsvDataInitializer implements CommandLineRunner {

    private final ResourceLoader resourceLoader;
    private final CoordinateConversionService conversionService;
    private final CarParkInformationRepository repository;

    public CsvDataInitializer(ResourceLoader resourceLoader,
                              CoordinateConversionService conversionService,
                              CarParkInformationRepository repository) {
        this.resourceLoader = resourceLoader;
        this.conversionService = conversionService;
        this.repository = repository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        try (Reader reader = new InputStreamReader(
                resourceLoader.getResource("classpath:data/HDBCarparkInformation.csv").getInputStream()
        );
             CSVReader csvReader = new CSVReader(reader)) {

            String[] header = csvReader.readNext();
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                String carParkNo = line[0];
                String address = line[1];
                double xCoord = Double.parseDouble(line[2]);
                double yCoord = Double.parseDouble(line[3]);
                Point wgs84Point = conversionService.convertSvy21ToWgs84Point(xCoord, yCoord);

                CarParkInformation info = new CarParkInformation();
                info.setCarParkNo(carParkNo);
                info.setAddress(address);
                info.setLatitude(wgs84Point.getY());
                info.setLongitude(wgs84Point.getX());

                repository.save(info);
            }
        }
    }
}
