/**
 * 
 */
package br.com.brasilct.codechallenge.domain.station;

import java.util.Collection;

import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 * 
 */
public interface StationRepository extends MongoRepository<Station, String> {

    Collection<Station> findByPositionWithin(Circle c);

    Collection<Station> findByPositionWithin(Box b);

    Collection<Station> findByPositionNear(Point p);

    Collection<Station> findByPositionNear(Point p, Distance d);
}