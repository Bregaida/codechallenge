/**
 * 
 */
package br.com.brasilct.codechallenge.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.brasilct.codechallenge.domain.line.Line;
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
		for (Line line : service.findAll()) {
			System.out.println(line.getId());
			System.out.println(line.getLineNumber());
			System.out.println(line.getStation1());
			System.out.println(line.getStation2());
		}
	}

}
