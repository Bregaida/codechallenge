/**
 * 
 */
package br.com.brasilct.codechallenge.domain.station;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author eduardobregaida
 * 
 */
public interface StationRepository extends MongoRepository<Station, String> {
    // public Collection<Station> findSimpleRoute(double latitude, double
    // longitude);

}