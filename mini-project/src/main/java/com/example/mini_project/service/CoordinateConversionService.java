package com.example.mini_project.service;

// CoordinateConversionService.java
import org.locationtech.proj4j.*;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

@Service
public class CoordinateConversionService {

    private final CoordinateTransform transform;
    private final GeometryFactory geometryFactory;

    public CoordinateConversionService() {
        CRSFactory crsFactory = new CRSFactory();
        String svy21Params = "+proj=tmerc +lat_0=1.366666666666667 +lon_0=103.8333333333333 +k=1 +x_0=28001.642 +y_0=38744.572 +ellps=WGS84 +units=m +no_defs";
        CoordinateReferenceSystem svy21 = crsFactory.createFromParameters("EPSG:3414", svy21Params);
        CoordinateReferenceSystem wgs84 = crsFactory.createFromName("EPSG:4326");

        this.transform = new BasicCoordinateTransform(svy21, wgs84);
        this.geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
    }

    public Point convertSvy21ToWgs84Point(double x, double y) {
        ProjCoordinate resultCoord = new ProjCoordinate();
        transform.transform(new ProjCoordinate(x, y), resultCoord);

        return geometryFactory.createPoint(new Coordinate(resultCoord.x, resultCoord.y));
    }
}
