package com.hin.spatial.postgis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hin.spatial.postgis.model.City;
import com.hin.spatial.postgis.repo.CityRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CityService {

	@Autowired
	private CityRepository repo;
	
	// WGS-84 SRID
	private GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);
	
	public Page<City> findAll(Pageable page){
		return repo.findAll(page);
	}
	
	public List<City> findAround(double lat, double lon, double distanceM){
		log.info("Looking for city around ({},{}) withing {} meters", lat, lon, distanceM);
		Point p = factory.createPoint(new Coordinate(lon, lat));
		return repo.findNearWithinDistance(p, distanceM);
	}
}
