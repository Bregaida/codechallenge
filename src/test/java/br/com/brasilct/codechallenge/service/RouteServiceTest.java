package br.com.brasilct.codechallenge.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.brasilct.codechallenge.domain.route.RouteService;

public class RouteServiceTest extends AbstractServiceTestSupport {

    @Autowired
    private RouteService service;

    @Test
    public void deveriaBuscarDadosInseridos() {
	service.loadData();
	Assert.assertTrue(service.findAll().size() > 0);
    }
}
