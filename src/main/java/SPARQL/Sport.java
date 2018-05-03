package SPARQL;

import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class Sport {
    public static List<String> SportLinks(int queryLimit) {
        ParameterizedSparqlString qs = new ParameterizedSparqlString(""
                + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX dbo:<http://dbpedia.org/ontology/>\n" +
                "PREFIX vrank:<http://purl.org/voc/vrank#>\n" +

                "SELECT DISTINCT ?s ?v\n" +
                "FROM<http://dbpedia.org>\n" +
                "FROM<http://people.aifb.kit.edu/ath/#DBpedia_PageRank>\n" +

                "WHERE{\n" +
                "{?s rdf:type dbo:Sport.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SportsLeague.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SportsTeam.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Athlete.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:AustralianRulesFootballPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:BadmintonPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:BaseballPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:BasketballPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Bodybuilder.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Boxer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Canoeist.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:ChessPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Cricketer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Cyclist.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:DartsPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Fencer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:GaelicGamesPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:GolfPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:GridironFootballPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Gymnast.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:HandballPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:HighDiver.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:HorseRider.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Jockey.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:LacrossePlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:MartialArtist.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:MotorsportRacer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:NationalCollegiateAthleticAssociationAthlete .}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:NetballPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:PokerPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:RugbyPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SnookerPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SoccerPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SquashPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Surfer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Swimmer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:TableTennisPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:TeamMember.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:TennisPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:VolleyballPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:WaterPoloPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:WinterSportPlayer.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Wrestler.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Coach.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:OrganisationMember.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SportsManager.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SportsEvent.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Race.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Tournament.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:WrestlingEvent.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SportCompetitionResult.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SportsSeason.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:Referee.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SportFacility.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:CricketGround.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:GolfCourse.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:RaceTrack.}\n" +
                "UNION\n" +
                "{?s rdf:type dbo:SkiArea.}\n" +
                "\n" +
                "?s vrank:hasRank/vrank:rankValue ?v.\n" +
                "}\n" +
                "ORDER BY DESC(?v) LIMIT " + queryLimit
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
