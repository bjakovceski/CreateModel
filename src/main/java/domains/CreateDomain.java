package domains;

import SPARQL.Music;
import SPARQL.Politics;
import SPARQL.Sport;
import SPARQL.Transportation;
import divideText.DivideTextToOneWordAtLine;
import entityTypes.FindEntityTypes;

import java.io.*;
import java.util.*;

public class CreateDomain {
    private static Long start = System.nanoTime();

    private static List<String> fileLinksName = new LinkedList<>();
    private static List<String> instanceTypeFileNames = new LinkedList<>();

    private static void listFilesForNifLinksFolder(final File folder, String type) {
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                listFilesForNifLinksFolder(fileEntry, type);
            } else {
                if (type.equals("links")) {
                    fileLinksName.add(fileEntry.getAbsolutePath());
                } else {
                    instanceTypeFileNames.add(fileEntry.getAbsolutePath());
                }
            }
        }
    }

    static BufferedWriter bw;
    static BufferedWriter bwText;

    static {
        try {
            bw = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/MusicDomainWithTop40Links.ttl"));
            bwText = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/MusicDomainWithTop40LinksText.ttl"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDomain() throws IOException {
        //nif links
        final File nifLinksFolder = new File("C:\\Users\\Jakovcheski\\Desktop\\DataTree");
        listFilesForNifLinksFolder(nifLinksFolder, "links");

        //instance types
        final File instanceTypesFolder = new File("C:\\Users\\Jakovcheski\\Desktop\\InstanceTypes");
        listFilesForNifLinksFolder(instanceTypesFolder, "instances");

        String filePath = "C:/Users/Jakovcheski/Desktop/THESIS/nif-abstract/clean-nif-abstract-context_en.ttl";

        List<String> sparqlLinks = new LinkedList<>();
//        sparqlLinks.addAll(Politics.PoliticsLinks());
//        sparqlLinks.addAll(Sport.SportLinks());
//        sparqlLinks.addAll(Transportation.TransportationLinks());
        sparqlLinks.addAll(Music.musicLinks());

        System.err.println("size" + sparqlLinks.size());
        int i = 0;
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] links = line.split(">\\s+");
                String[] parsedLink = links[0].split("\\?dbpv");
                for (String link : sparqlLinks) {
                    if (parsedLink[0].substring(1).equals(link)) {
                        i++;
                        Map<String, String> entityType = new LinkedHashMap<>();
                        entityType = FindEntityTypes.readFromNifLinks(parsedLink[0], fileLinksName, instanceTypeFileNames);
                        FindEntityTypes.divideTextToWordAtLineWithType(bw, links[2], entityType);
                        bwText.write(links[2] +"\n");
                        bwText.flush();
                    }
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
            if (bwText != null) {
                bwText.close();
            }

            System.err.println("Total founded links " + i);

            DivideTextToOneWordAtLine.main(null);
//            TransportationSpecificDomain.main(null);
        }
    }

    public static void main(String[] args) {
        try {
            createDomain();
            System.err.println("TOTAL TIME " + (System.nanoTime() - start));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
