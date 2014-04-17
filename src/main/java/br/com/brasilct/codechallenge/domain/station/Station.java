/**
 * 
 */
package br.com.brasilct.codechallenge.domain.station;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author eduardobregaida
 * 
 */
@Document
public class Station {

    @Id
    private String id;
    private String identificacao;
    private String stationNumber;
    private String name;
    private double[] position;
    private String displayName;
    private String zone;
    private String totalLines;
    private String rail;

    public String getIdentificacao() {
	return identificacao;
    }

    public void setIdentificacao(String identificacao) {
	this.identificacao = identificacao;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getStationNumber() {
	return stationNumber;
    }

    public void setStationNumber(String stationNumber) {
	this.stationNumber = stationNumber;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public double[] getPosition() {
	return position;
    }

    public void setPosition(double[] position) {
	this.position = position;
    }

    public String getDisplayName() {
	return displayName;
    }

    public void setDisplayName(String displayName) {
	this.displayName = displayName;
    }

    public String getZone() {
	return zone;
    }

    public void setZone(String zone) {
	this.zone = zone;
    }

    public String getTotalLines() {
	return totalLines;
    }

    public void setTotalLines(String totalLines) {
	this.totalLines = totalLines;
    }

    public String getRail() {
	return rail;
    }

    public void setRail(String rail) {
	this.rail = rail;
    }

}
