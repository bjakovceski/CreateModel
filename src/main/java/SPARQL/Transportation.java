package SPARQL;

import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class Transportation {
    public static List<String> TransportationLinks(int queryLimit) {
        ParameterizedSparqlString qs = new ParameterizedSparqlString(""
                + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX dbo:<http://dbpedia.org/ontology/>\n"
                + "PREFIX vrank:<http://purl.org/voc/vrank#>\n"

                + "SELECT DISTINCT ?s ?v\n"

                + "FROM<http://dbpedia.org>\n"
                + "FROM<http://people.aifb.kit.edu/ath/#DBpedia_PageRank>\n"

                + "WHERE{\n"
                + "{?s rdf:type dbo:Aircraft.}\n"
                + " UNION\n"
                + "{?s rdf:type dbo:Automobile.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Locomotive.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:MilitaryVehicle.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Motorcycle.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:On-SiteTransportation.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Rocket.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Ship.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:SpaceShuttle.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:SpaceStation.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Spacecraft.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Train.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:TrainCarriage.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Tram.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Engine.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:AutomobileEngine.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:RocketEngine.}\n"
                + "UNION\n"
                + "{\n"
                + "?s rdf:type dbo:Company.\n"
                + "?s rdf:type dbo:PublicTransitSystem.\n"
                + "}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Airline.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:BusCompany.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Infrastructure.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Airport.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Port.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:RestArea.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:RouteOfTransportation.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Bridge.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:RailwayLine.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:RailwayTunnel.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Road.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:RoadJunction.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:RoadTunnel.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:WaterwayTunnel.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:Station.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:MetroStation.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:RailwayStation.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:RouteStop.}\n"
                + "UNION\n"
                + "{?s rdf:type dbo:TramStop.}\n"

                + "?s vrank:hasRank/vrank:rankValue ?v.\n"
                + "}\n"
                + "ORDER BY DESC(?v) LIMIT " + queryLimit
        );
        QueryExecution exec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", qs.asQuery());

        ResultSet results = exec.execSelect();
        List<String> links = new ArrayList<>();
        while (results.hasNext()) {
            links.add(results.next().get("s").toString());
        }
        exec.close();
        return links;
    }
}
