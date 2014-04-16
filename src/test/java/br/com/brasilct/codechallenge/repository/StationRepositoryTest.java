/**
 * 
 */
package br.com.brasilct.codechallenge.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.brasilct.codechallenge.common.Util;
import br.com.brasilct.codechallenge.domain.station.StationRepository;

/**
 * @author eduardobregaida
 * 
 */
public class StationRepositoryTest extends AbstractRepositoryTestSupport {

    @Autowired
    private StationRepository repository;

    @Test
    public void deveriaBuscarDadosInseridos() {
	repository.save(Util.converteStationCSV());

	Assert.assertTrue(repository.findAll().size() > 0);
    }

    // @Test
    // public void deveriaListarUmCaminho() {
    // for (Station station : repository.findSimpleRoute(1, 40)) {
    // System.out.println(station.getName());
    // System.out.println(station.getLatitude());
    // System.out.println(station.getLongitude());
    // }
    //
    // }

    /*
     * Um método que liste um caminho (contendo todas as estações) qualquer
     * entre a estação X e a estação Y 2. Um método que liste o menor caminho
     * (contendo todas as estações) ( considerando paradas ) entre a estação X e
     * a estação Y 3. Um método que calcule o tempo aproximando da viagem no
     * item 2, considerando que ao passar de uma estação adjacente a próxima o
     * passageiro gaste 3 minutos e ao trocar de linha gaste 12 minutos.
     */

}
