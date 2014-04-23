/**
 * 
 */
package br.com.brasilct.codechallenge.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import br.com.brasilct.codechallenge.domain.line.Line;
import br.com.brasilct.codechallenge.domain.route.Route;
import br.com.brasilct.codechallenge.domain.station.Station;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.LatLng;

/**
 * @author eduardobregaida
 * 
 */
public class Util {

    private static final String STATIONS_CSV = "src/main/resources/stations.csv";
    private static final String LINES_CSV = "src/main/resources/lines.csv";
    private static final String ROUTES_CSV = "src/main/resources/routes.csv";
    private static CSVReader reader;
    private static Logger logger = LoggerFactory.getLogger(Util.class);

    public static Collection<Line> converteLineCSV() {

	try {
	    reader = new CSVReader(new FileReader(LINES_CSV), ',');
	    ColumnPositionMappingStrategy<Line> strat = new ColumnPositionMappingStrategy<Line>();
	    String[] columns = new String[] { "station1", "station2", "line" };
	    strat.setColumnMapping(columns);
	    Collection<Line> lines = new ArrayList<>();
	    Line line = null;
	    Station station = null;
	    for (String[] string : reader.readAll()) {
		if (!string[0].equalsIgnoreCase("station1")) {
		    line = new Line();
		    station = new Station();
		    station.setStationNumber(string[0]);
		    line.setStation1(station);
		    station = new Station();
		    station.setStationNumber(string[1]);
		    line.setStation2(station);
		    line.setLineNumber(string[2]);
		    lines.add(line);
		}
	    }
	    return lines;
	} catch (FileNotFoundException e) {
	    logger.error("File not Found: " + e.getMessage());
	} catch (IOException e) {
	    logger.error("IOException: " + e.getMessage());
	}
	return null;
    }

    public static Collection<Route> converteRouteCSV() {
	try {
	    reader = new CSVReader(new FileReader(ROUTES_CSV), ',');
	    ColumnPositionMappingStrategy<Route> strat = new ColumnPositionMappingStrategy<Route>();
	    String[] columns = new String[] { "line", "name", "colour",
		    "stripe" };
	    strat.setColumnMapping(columns);
	    Collection<Route> routes = new ArrayList<>();
	    Route route = null;
	    Line line = null;
	    for (String[] string : reader.readAll()) {
		if (!string[0].equalsIgnoreCase("line")) {
		    route = new Route();
		    line = new Line();
		    line.setLineNumber(string[0]);
		    route.setLine(line);
		    route.setName(string[1]);
		    route.setColour(string[2]);
		    route.setStripe(string[3]);
		    routes.add(route);
		}
	    }
	    return routes;
	} catch (FileNotFoundException e) {
	    logger.error("File not Found: " + e.getMessage());
	} catch (IOException e) {
	    logger.error("IOException: " + e.getMessage());
	}
	return null;
    }

    public static Collection<Station> converteStationCSV() {
	try {
	    reader = new CSVReader(new FileReader(STATIONS_CSV), ',');
	    ColumnPositionMappingStrategy<Route> strat = new ColumnPositionMappingStrategy<Route>();
	    String[] columns = new String[] { "id", "latitude", "longitude",
		    "name", "display_name", "zone", "total_lines", "rail" };
	    strat.setColumnMapping(columns);
	    Collection<Station> stations = new ArrayList<>();
	    Station station = null;
	    for (String[] string : reader.readAll()) {
		if (!string[0].equalsIgnoreCase("id")) {
		    station = new Station();
		    station.setId(string[0]);
		    station.setPosition(new double[] {
			    Double.parseDouble(string[1]),
			    Double.parseDouble(string[2]) });
		    // station.setLatitude(string[1]);
		    // station.setLongitude(string[2]);
		    station.setName(string[3]);
		    station.setDisplayName(string[4]);
		    station.setZone(string[5]);
		    station.setTotalLines(string[6]);
		    station.setRail(string[7]);
		    stations.add(station);
		}
	    }
	    return stations;
	} catch (FileNotFoundException e) {
	    logger.error("File not Found: " + e.getMessage());
	} catch (IOException e) {
	    logger.error("IOException: " + e.getMessage());
	}
	return null;
    }

    public static double getDistancia(double latitude, double longitude,
	    double latitudePto, double longitudePto) {
	double ptolat = Math.toRadians(latitude);
	double ptolon = Math.toRadians(longitude);
	double pto2lat = Math.toRadians(latitudePto);
	double pto2lon = Math.toRadians(longitudePto);

	double dlon, dlat, a, distancia;

	dlon = pto2lon - ptolon;
	dlat = pto2lat - ptolat;

	a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(latitude)
		* Math.cos(latitudePto) * Math.pow(Math.sin(dlon / 2), 2);
	distancia = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	return (distancia * 6378140);
    }

    public static GeocodeResponse getGeoCoding(BigDecimal latitude,
	    BigDecimal longitude, BigDecimal latitudePto,
	    BigDecimal longitudePto) {
	final Geocoder geocoder = new Geocoder();

	LatLng latLng = new LatLng(latitude, longitude);
	LatLng latLng2 = new LatLng(latitudePto, longitudePto);
	GeocoderRequest geocoderRequest = new GeocoderRequestBuilder()
		.setLocation(latLng).getGeocoderRequest();
	GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
	return geocoderResponse;

    }

    public static void main(String[] args) {
	System.out.println("Distancia: "
		+ Util.getGeoCoding(new BigDecimal(-20), new BigDecimal(-49),
			null, null));
    }
}
