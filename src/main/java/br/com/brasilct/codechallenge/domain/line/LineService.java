/**
 * 
 */
package br.com.brasilct.codechallenge.domain.line;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilct.codechallenge.common.AbstractService;
import br.com.brasilct.codechallenge.common.Util;

/**
 * @author eduardobregaida
 * 
 */

@Service
public class LineService extends AbstractService<Line, String> {

    @Autowired
    public void setRepository(LineRepository lineRepository) {
	super.setRepository(lineRepository);
    }

    public void loadData() {
	for (Line line : Util.converteLineCSV()) {
	    this.save(line);
	}
    }

    @Override
    public String getSortAttribute() {
	return "id";
    }

}
