/**
 * 
 */
package br.com.brasilct.codechallenge.domain.station;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void loadData() {
	for (Station route : Util.converteStationCSV()) {
	    save(route);
	}
    }

    @Override
    public String getSortAttribute() {
	return "name";
    }

    // public Collection<Station> findSimpleRoute(double latitude, double
    // longitude) {
    // return ((StationService) getRepository()).findSimpleRoute(latitude,
    // longitude);
    // }
}