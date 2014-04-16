/**
 * 
 */
package br.com.brasilct.codechallenge.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.brasilct.codechallenge.common.Util;
import br.com.brasilct.codechallenge.domain.line.Line;
import br.com.brasilct.codechallenge.domain.line.LineRepository;

/**
 * @author eduardobregaida
 * 
 */
public class LineRepositoryTest extends AbstractRepositoryTestSupport {

    @Autowired
    private LineRepository repository;

    @Test
    public void deveriaBuscarDadosInseridos() {
	for (Line line : Util.converteLineCSV()) {
	    repository.save(line);
	}

	Assert.assertTrue(repository.findAll().size() > 0);
    }

}
