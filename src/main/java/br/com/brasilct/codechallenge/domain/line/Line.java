/**
 * 
 */
package br.com.brasilct.codechallenge.domain.line;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.brasilct.codechallenge.domain.station.Station;

/**
 * @author eduardobregaida
 * 
 */

@Document
public class Line {

    @Id
    private String id;
    private String lineNumber;
    private Station station1;
    private Station station2;

    public String getLineNumber() {
	return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
	this.lineNumber = lineNumber;
    }

    public Station getStation1() {
	return station1;
    }

    public void setStation1(Station station1) {
	this.station1 = station1;
    }

    public Station getStation2() {
	return station2;
    }

    public void setStation2(Station station2) {
	this.station2 = station2;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

}
