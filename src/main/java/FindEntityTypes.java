import org.apache.jena.ext.com.google.common.base.Optional;
import org.apache.jena.rdf.model.*;
import org.rdfhdt.hdt.hdt.HDT;
import org.rdfhdt.hdt.hdt.HDTManager;
import org.rdfhdt.hdtjena.HDTGraph;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FindEntityTypes {

    private static Long start = System.nanoTime();
    static BufferedWriter bw;

    static {
        try {
            bw = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/TESTTESTallDomains.ttl"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String fileTypesPath = "C:/Users/Jakovcheski/Desktop/THESIS/instance_types_en.ttl";
    private static Model model = ModelFactory.createDefaultModel();

    static {
        model.read(fileTypesPath);
    }

    private static String fileHDTPath = "C:/Users/Jakovcheski/Desktop/THESIS/cleanLinks_en.hdt";

    // Load HDT file using the hdt-java library
    private static HDT hdt;

    static {
        try {
            hdt = HDTManager.mapIndexedHDT(fileHDTPath, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create Jena Model on top of HDT.
    private static HDTGraph graph = new HDTGraph(hdt);
    private static Model modelLinks = ModelFactory.createModelForGraph(graph);

    private static void readFromAbstract() throws IOException {
        String filePath = "C:/Users/Jakovcheski/Desktop/THESIS/nif-abstract/nif-abstract-context_en.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        Map<String, String> entityType = new LinkedHashMap<>();
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.indexOf("#isString") > 0) {
                    String[] links = line.split(">\\s+");
                    String[] parsedLink = links[0].split("&nif=context");
                    entityType = readFromNifLinks(parsedLink[0].substring(1, parsedLink[0].length()));
                    divideTextToWordAtLineWithType(links[2], entityType);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
            if (bw != null) {
                bw.close();
            }
        }
        System.err.println("TOTAL TIME: " + ((System.nanoTime() - start) / 1_000_000_000) + " s");
    }

    //TODO USE .HDT formatf
    private static Map<String, String> readFromNifLinks(String link) throws IOException {
        Long start = System.nanoTime();
//        int i = 0;
        System.err.println("\nLink from abstract " + link + "\n");
        Map<String, String> types = new LinkedHashMap<>(); //key: entity, value: type
        boolean foundLink = false;
//        Resource subject = null;     // get the subject
        Property predicate = null;   // get the predicate
        RDFNode object = null;      // get the object
        String[] subject = null;     // get the subject
        // Use Jena Model as Read-Only data storage, e.g. Using Jena ARQ for SPARQL.
        StmtIterator iter = modelLinks.listStatements();
        while (iter.hasNext()) {

            if (true) {
                Statement stmt = iter.nextStatement();  // get next statement
                subject = String.valueOf(stmt.getSubject()).split("&nif");     // get the subject
                predicate = stmt.getPredicate();   // get the predicate
                object = stmt.getObject();      // get the object
//                System.err.println("subject " + subject[0]);
            }
//            i++;
//            System.err.println(i);
//            if(!foundLink) {
//                Statement stmt = iter.nextStatement();  // get next statement
//                subject = String.valueOf(stmt.getSubject()).split("&nif");     // get the subject
//                predicate = stmt.getPredicate();   // get the predicate
//                object = stmt.getObject();      // get the object
////                System.err.println("subject " + stmt.getSubject());
//            }
//            if (subject[0].equals(link)) {
//                System.err.println("predicate " + predicate);
//                if (String.valueOf(predicate).contains("#anchorOf")) {
//                    foundLink = true;
//                    System.err.println("\nObject " + object);
//                    if (iter.hasNext()) {
//                        Statement nextStmt = iter.nextStatement();
//                        String[] newSubject = String.valueOf(nextStmt.getSubject()).split("&nif");
//                        System.err.println("old subject " + subject[0]);
//                        System.err.println("new subject " + newSubject[0]);
//                        RDFNode newObject = nextStmt.getObject();
//                        System.err.println("new object " + newObject);
//                        String type = readFromInstanceTypesAndReturnTypeWithJena(String.valueOf(newObject));
//                        System.err.println("Type " + type);
//                        if (!type.equals("OTHER")) {
//                            types.put(String.valueOf(object), type); //key: entity, value: type
//                        }
//                        if(iter.hasNext()){
//                            Statement newNextStatement = iter.nextStatement();
//                            String[] newNextSubject = String.valueOf(newNextStatement.getSubject()).split("&nif");
//                            System.err.println("next subject " + newNextSubject[0]);
//                            System.err.println("parsed subject " + newSubject[0]);
//                            //break while loop if you reach end of the subjects in links
//                            if(!(newNextSubject[0].equals(newSubject[0]))){
//                                System.err.println("readFromNifLinks total time: " + (System.nanoTime() - start) / 1_000_000 + " ms");
//                                return types;
//                            }else {
//                                subject[0] = newNextSubject[0];
//                                predicate = newNextStatement.getPredicate();
//                                object = newNextStatement.getObject();
//                            }
//                        }
//                    }
//                }
//            }else{
////                Statement stmt = iter.nextStatement();
//            }
//            if(i > (64916210/2)){
//                System.err.println("****************************END*******************");
//                return types;
//            }
            //64916210 total lines but we need /2 lines to count
        }

        System.err.println("readFromNifLinks total time: " + (System.nanoTime() - start) / 1_000_000 + " ms");
        return types;
    }

    private static String readFromInstanceTypesAndReturnTypeWithJena(String linkFromNifLinks) throws IOException {
        String ontologyType = "OTHER";
        // list the statements in the Model
        StmtIterator iter = model.listStatements();
        System.err.println("Link from nif links: " + linkFromNifLinks);
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();  // get next statement
            Resource subject = stmt.getSubject();     // get the subject
//            Property predicate = stmt.getPredicate();   // get the predicate
            RDFNode object = stmt.getObject();      // get the object
            if (String.valueOf(subject).equals(linkFromNifLinks)) {
                System.err.println("subject from return type " + subject);
                System.err.println("Object from return type " + object);
                String[] type = String.valueOf(object).split("ontology/");
                if (type.length > 1) {
                    ontologyType = type[1];
                }
            }
        }
        return ontologyType;
    }

    private static void divideTextToWordAtLineWithType(String text, Map<String, String> entityType) throws IOException {
        Long start = System.nanoTime();
        String[] words = text.substring(1, text.length() - 3).split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");
        System.err.println("entites " + entityType);
        Map<String, String> splittedKeyMap = new HashMap<>();
        entityType.forEach((s, v) -> {
            String[] keyWords = s.split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");//split keys from map to one word
            for (String key :
                    keyWords) {
                splittedKeyMap.put(key, v);
            }
        });

        try {
            for (String word : words) {
                String value = splittedKeyMap.get(word);
                if (value != null) {
                    bw.write(word + "\t" + value + "\n");
                } else {
                    bw.write(word + "\t" + "O\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bw.flush();
        }
        System.err.println("divideTextToWordAtLineWithType total time " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    public static void main(String[] args) {
        try {
            readFromAbstract();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
