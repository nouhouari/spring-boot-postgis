package com.hin.spatial.postgis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.vividsolutions.jts.geom.Point;

import lombok.Data;

@Data
@Entity(name = "us_cities")
public class City {

	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="`POP_2010`")
	private long population2010;
	
	@Column(name="`ELEV_IN_FT`")
	private long altitude;
	
	@Column(columnDefinition = "geometry(Point,4326)")
	private Point geom;
}
