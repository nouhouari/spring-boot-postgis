package com.hin.spatial.postgis.repo;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hin.spatial.postgis.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	@Query(value="SELECT * from us_cities where ST_DistanceSphere(geom, :p) < :distanceM", nativeQuery = true)
	List<City> findNearWithinDistance(Point p, double distanceM);
}
