package com.hin.spatial.postgis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

@Entity(name = "us_cities")
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@ToString
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
