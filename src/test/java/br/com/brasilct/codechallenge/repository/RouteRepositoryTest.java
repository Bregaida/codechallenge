/**
 * 
 */
package br.com.brasilct.codechallenge.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.brasilct.codechallenge.common.Util;
import br.com.brasilct.codechallenge.domain.route.Route;
import br.com.brasilct.codechallenge.domain.route.RouteRepository;

/**
 * @author eduardobregaida
 * 
 */
public class RouteRepositoryTest extends AbstractRepositoryTestSupport {

    @Autowired
    private RouteRepository repository;

    @Test
    public void deveriaBuscarDadosInseridos() {
	for (Route route : Util.converteRouteCSV()) {
	    repository.save(route);
	}
	Assert.assertTrue(repository.findAll().size() > 0);
    }

}
