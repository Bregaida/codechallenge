/**
 * 
 */
package br.com.brasilct.codechallenge.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.brasilct.codechallenge.domain.line.LineService;

/**
 * @author eduardobregaida
 * 
 */
public class LineServiceTest extends AbstractServiceTestSupport {

    @Autowired
    private LineService service;

    @Test
    public void deveriaBuscarDadosInseridos() {
	service.loadData();
	Assert.assertTrue(service.findAll().size() > 0);
    }

}
