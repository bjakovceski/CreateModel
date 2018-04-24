package SPARQL;

import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static List<String> musicLinks(){
        ParameterizedSparqlString qs = new ParameterizedSparqlString(""
                +"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                +"PREFIX dbo:<http://dbpedia.org/ontology/>\n"

                +"PREFIX vrank:<http://purl.org/voc/vrank#>\n"

                +"SELECT ?s ?v\n"
                +"FROM<http://dbpedia.org>\n"
                +"FROM<http://people.aifb.kit.edu/ath/#DBpedia_PageRank>\n"
                +"WHERE{\n"
                +"{?s rdf:type dbo:MusicalArtist.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:BackScene.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:ClassicalMusicArtist.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:Instrumentalist.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:MusicDirector.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:Singer.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:MusicComposer.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:SongWriter.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:MusicFestival.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:MusicGenre.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:MusicalWork.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:Album.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:ArtistDiscography.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:ClassicalMusicComposition.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:Musical.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:NationalAnthem.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:Opera.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:Single.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:Song.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:EurovisionSongContestEntry.}\n"
                +"UNION\n"
                +"{?s rdf:type dbo:Band.}\n"

                +"?s vrank:hasRank/vrank:rankValue ?v.\n"
                +"}\n"
                +"ORDER BY DESC(?v) LIMIT 40"
        );
        QueryExecution exec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", qs.asQuery());

        ResultSet results = exec.execSelect();
        List<String> links = new ArrayList<>();
        while (results.hasNext()) {
            links.add(results.next().get("s").toString());
        }
        return links;
    }
}
