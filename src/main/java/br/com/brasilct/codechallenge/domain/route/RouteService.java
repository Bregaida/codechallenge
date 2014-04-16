/**
 * 
 */
package br.com.brasilct.codechallenge.domain.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilct.codechallenge.common.AbstractService;
import br.com.brasilct.codechallenge.common.Util;

/**
 * @author eduardobregaida
 * 
 */
@Service
public class RouteService extends AbstractService<Route, String> {

    @Autowired
    public void setRepository(RouteRepository routeRepository) {
	super.setRepository(routeRepository);
    }

    public void loadData() {
	for (Route route : Util.converteRouteCSV()) {
	    this.save(route);
	}
    }

    @Override
    public String getSortAttribute() {
	return "id";
    }

}