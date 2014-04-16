/**
 * 
 */
package br.com.brasilct.codechallenge.domain.route;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.brasilct.codechallenge.domain.line.Line;

/**
 * @author eduardobregaida
 * 
 */
@Document
public class Route {

    @Id
    private String id;
    private Line line;
    private String name;
    private String colour;
    private String stripe;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Line getLine() {
	return line;
    }

    public void setLine(Line line) {
	this.line = line;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getColour() {
	return colour;
    }

    public void setColour(String colour) {
	this.colour = colour;
    }

    public String getStripe() {
	return stripe;
    }

    public void setStripe(String stripe) {
	this.stripe = stripe;
    }

}
