package com.hin.spatial.postgis.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CityTest {

    @Bean
    public JtsModule jtsModule(){
        return new JtsModule();
    }

    @Test
    void testJson() throws IOException {

        var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JtsModule());

        GeometryFactory gf = new GeometryFactory();
        Point point = gf.createPoint(new Coordinate(1.2345678, 2.3456789));

        String geojson = objectMapper.writeValueAsString(point);

        InputStream targetStream = new ByteArrayInputStream(geojson.getBytes());
        Point point2 = objectMapper.readValue(targetStream, Point.class);

        assertEquals(point, point2);
    }

}