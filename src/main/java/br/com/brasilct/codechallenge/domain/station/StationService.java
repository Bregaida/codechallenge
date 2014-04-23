/**
 * 
 */
package br.com.brasilct.codechallenge.domain.station;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import br.com.brasilct.codechallenge.common.AbstractService;
import br.com.brasilct.codechallenge.common.Util;

/**
 * @author eduardobregaida
 * 
 */
@Service
public class StationService extends AbstractService<Station, String> {

    @Autowired
    public void setRepository(StationRepository stationRepository) {
	super.setRepository(stationRepository);
    }

    @Autowired
    MongoTemplate template;

    public void loadData() {
	for (Station route : Util.converteStationCSV()) {
	    this.save(route);
	}
    }

    @Override
    public String getSortAttribute() {
	return "name";
    }

    public GeoResults<Station> findByPositionNear(Point point, Distance distance) {

	NearQuery nearQuery = NearQuery.near(point).maxDistance(distance);

	return template.geoNear(nearQuery, Station.class);
    }

    public Collection<Station> findByPositionWithin(Box box) {
	return ((StationRepository) getRepository()).findByPositionWithin(box);
    }

    public Collection<Station> findByPositionWithin(Circle circle) {
	return ((StationRepository) getRepository())
		.findByPositionWithin(circle);
    }

}