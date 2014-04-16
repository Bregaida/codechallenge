/**
 * 
 */
package br.com.brasilct.codechallenge.common;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author eduardobregaida
 * 
 */
public class UtilTest {

    @Test
    public void deveriaLerCSVLinesConvertendoParaObjeto() {
	Assert.assertNotNull(Util.converteLineCSV());
    }

    @Test
    public void deveriaConterLinhaCom411Itens() {
	Assert.assertEquals(411, Util.converteLineCSV().size());
    }

    @Test
    public void deveriaLerCSVRoutesConvertendoParaObjeto() {
	Assert.assertNotNull(Util.converteRouteCSV());
    }

    @Test
    public void deveriaConterRotaCom14Itens() {
	Assert.assertEquals(14, Util.converteRouteCSV().size());
    }

    @Test
    public void deveriaLerCSVStationsConvertendoParaObjeto() {
	Assert.assertNotNull(Util.converteStationCSV());
    }

    @Test
    public void deveriaConterEstacaoCom307Itens() {
	Assert.assertEquals(307, Util.converteStationCSV().size());
    }
}
