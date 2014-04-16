/**
 * 
 */
package br.com.brasilct.codechallenge.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.brasilct.codechallenge.domain.station.StationService;

/**
 * @author eduardobregaida
 * 
 */
public class StationServiceTest {

    @Autowired
    private StationService service;

    @Test
    public void deveriaBuscarDadosInseridos() {
	service.loadData();
	Assert.assertTrue(service.findAll().size() > 0);
    }

}
