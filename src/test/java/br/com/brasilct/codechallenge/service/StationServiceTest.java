/**
 * 
 */
package br.com.brasilct.codechallenge.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResult;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Metrics;
import org.springframework.data.mongodb.core.geo.Point;

import br.com.brasilct.codechallenge.domain.station.Station;
import br.com.brasilct.codechallenge.domain.station.StationService;

/**
 * @author eduardobregaida
 * 
 */
public class StationServiceTest extends AbstractServiceTestSupport {

    @Autowired
    private StationService service;

    @Test
    public void deveriaBuscarDadosInseridos() {
	service.loadData();
	Assert.assertTrue(service.findAll().size() > 0);
    }

    @Test
    public void deveriaTrazerUmCaminho() {
	Point point = new Point(51.5028, -0.2801);
	GeoResults<Station> locations = service.findByPositionNear(point,
		new Distance(1, Metrics.KILOMETERS));
	for (GeoResult<Station> station : locations) {
	    System.out.println("Estação: " + station.getContent().getName());
	}

    }

    @Test
    public void deveriaTrazerUmCaminhoComDoisPontos() {
	Point point = new Point(51.5028, -0.2801);
	Point pointTwo = new Point(51.5439, -0.2759);
	Box box = new Box(point, pointTwo);
	Collection<Station> locations = service.findByPositionWithin(box);
	for (Station station : locations) {
	    System.out.println("Estação: " + station.getName());
	}

    }
}
