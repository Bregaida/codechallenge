/**
 * 
 */
package br.com.brasilct.codechallenge.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import br.com.brasilct.codechallenge.domain.line.Line;
import br.com.brasilct.codechallenge.domain.route.Route;
import br.com.brasilct.codechallenge.domain.station.Station;

/**
 * @author eduardobregaida
 * 
 */
public class Util {

    private static final String STATIONS_CSV = "src/main/resources/stations.csv";
    private static final String LINES_CSV = "src/main/resources/lines.csv";
    private static final String ROUTES_CSV = "src/main/resources/routes.csv";
    private static CSVReader reader;

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
	    return lines;
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
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
		route = new Route();
		line = new Line();
		line.setLineNumber(string[0]);
		route.setLine(line);
		route.setName(string[1]);
		route.setColour(string[2]);
		route.setStripe(string[3]);
		routes.add(route);
	    }
	    return routes;
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
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
		station = new Station();
		station.setIdentificacao(string[0]);
		station.setLatitude(string[1]);
		station.setLongitude(string[2]);
		station.setName(string[3]);
		station.setDisplayName(string[4]);
		station.setZone(string[5]);
		station.setTotalLines(string[6]);
		station.setRail(string[7]);
		stations.add(station);
	    }
	    return stations;
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
}
