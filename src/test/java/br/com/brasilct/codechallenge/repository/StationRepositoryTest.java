/**
 * 
 */
package br.com.brasilct.codechallenge.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Point;

import br.com.brasilct.codechallenge.common.Util;
import br.com.brasilct.codechallenge.domain.station.Station;
import br.com.brasilct.codechallenge.domain.station.StationRepository;

/**
 * @author eduardobregaida
 * 
 */
public class StationRepositoryTest extends AbstractRepositoryTestSupport {

    @Autowired
    private StationRepository repository;

    // @Test
    public void deveriaBuscarDadosInseridos() {
	repository.save(Util.converteStationCSV());

	Assert.assertTrue(repository.findAll().size() > 0);
    }

    // @Test
    public void deveriaListarUmCaminho() {
	Point point = new Point(51.5028, -0.2801);
	Point pointTwo = new Point(51.5037, 0.0488);
	Box box = new Box(point, pointTwo);
	for (Station station : repository.findByPositionWithin(box)) {
	    System.out.println(station.getName());
	    System.out.println(station.getZone());
	    System.out.println(station.getDisplayName());
	    System.out.println(station.getIdentificacao());
	    System.out.println(station.getRail());
	    System.out.println(station.getTotalLines());
	}

    }

    @Test
    public void deveriaListarMelhorCaminho() {
	Point point = new Point(51.5028, -0.2801);
	Point pointTwo = new Point(51.5037, 0.0488);
	Box box = new Box(point, pointTwo);
	int i = 0;
	for (Station station : repository.findByPositionWithin(box)) {
	    System.out.println(station.getName());
	    i++;
	}
	System.out.println(i);
    }

    /*
     * Um m��todo que liste um caminho (contendo todas as esta����es) qualquer
     * entre a esta����o X e a esta����o Y 2. Um método que liste o menor
     * caminho (contendo todas as estações) ( considerando paradas ) entre a
     * estação X e a estação Y 3. Um m��todo que calcule o tempo aproximando da
     * viagem no item 2, considerando que ao passar de uma esta����o adjacente a
     * pr��xima o passageiro gaste 3 minutos e ao trocar de linha gaste 12
     * minutos.
     */

}
