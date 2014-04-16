/**
 * 
 */
package br.com.brasilct.codechallenge.domain.station;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
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
    @GeoSpatialIndexed
    private String latitude;
    @GeoSpatialIndexed
    private String longitude;
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

    public String getLatitude() {
	return latitude;
    }

    public void setLatitude(String latitude) {
	this.latitude = latitude;
    }

    public String getLongitude() {
	return longitude;
    }

    public void setLongitude(String longitude) {
	this.longitude = longitude;
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
