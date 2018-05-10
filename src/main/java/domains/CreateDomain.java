package domains;

import SPARQL.Politics;
import SPARQL.Sport;
import SPARQL.Transportation;
import divideText.DivideTextToOneWordAtLine;
import entityTypes.FindEntityTypes;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CreateDomain {
    private static Long start = System.nanoTime();
    private static int queryLimit = 1000;
    private static int abstractLinksLimit = 500;
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

    private static BufferedWriter bw;
    private static BufferedWriter bwText;
    private static BufferedWriter bwCleanedAbstract;
    private static BufferedWriter bwPoliticsCleanedAbstract;
    private static BufferedWriter bwSportCleanedAbstract;
    private static BufferedWriter bwTransportationCleanedAbstract;
    private static String bwAllLinksFile = "C:/Users/Jakovcheski/Desktop/All3DomainsTop" + abstractLinksLimit + "LinksWithSameProcessedLinksOnAbstract.ttl";
    private static String abstractFile = "C:/Users/Jakovcheski/Desktop/CleanedNifAbstract" + abstractLinksLimit + "Links.ttl";
    private static String politicsAbstractFile = "C:/Users/Jakovcheski/Desktop/CleanedNifPoliticsAbstract" + abstractLinksLimit + "Links.ttl";
    private static String sportAbstractFile = "C:/Users/Jakovcheski/Desktop/CleanedNifSportAbstract" + abstractLinksLimit + "Links.ttl";
    private static String transportationAbstractFile = "C:/Users/Jakovcheski/Desktop/CleanedNifTransportationAbstract" + abstractLinksLimit + "Links.ttl";

    static {
        try {
            bw = new BufferedWriter(new FileWriter(bwAllLinksFile));
            bwText = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/All3DomainsTop" + abstractLinksLimit + "LinksTextWithSameProcessedLinksOnAbstract.ttl"));
            bwCleanedAbstract = new BufferedWriter(new FileWriter(abstractFile));
            bwPoliticsCleanedAbstract = new BufferedWriter(new FileWriter(politicsAbstractFile));
            bwSportCleanedAbstract = new BufferedWriter(new FileWriter(sportAbstractFile));
            bwTransportationCleanedAbstract = new BufferedWriter(new FileWriter(transportationAbstractFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> politicsLinks = Politics.PoliticsLinks(queryLimit);
    private static List<String> sportLinks = Sport.SportLinks(queryLimit);
    private static List<String> transportationLinks = Transportation.TransportationLinks(queryLimit);


    private static void createDomain() throws IOException {
//        politicsLinks = politicsLinks.subList(600, politicsLinks.size()-1);
//        sportLinks = sportLinks.subList(600, sportLinks.size()-1);
//        transportationLinks = transportationLinks.subList(600, transportationLinks.size()-1);
        //nif links
        final File nifLinksFolder = new File("C:\\Users\\Jakovcheski\\Desktop\\DataTree");
        listFilesForNifLinksFolder(nifLinksFolder, "links");

        //instance types
        final File instanceTypesFolder = new File("C:\\Users\\Jakovcheski\\Desktop\\InstanceTypes");
        listFilesForNifLinksFolder(instanceTypesFolder, "instances");

//        String filePath = "C:/Users/Jakovcheski/Desktop/THESIS/nif-abstract/clean-nif-abstract-context_en.ttl";

        int politics = 0;
        int sport = 0;
        int transportation = 0;
        FileInputStream inputStream = null;
        Scanner sc = null;

        minNumberOfLinks();

        String bwPoliticsGrainedFilePath = "C:/Users/Jakovcheski/Desktop/PoliticsGrained" + abstractLinksLimit + "Links.tsv";
        String bwSportGrainedFilePath = "C:/Users/Jakovcheski/Desktop/SportGrained" + abstractLinksLimit + "Links.tsv";
        String bwTransportationGrainedFilePath = "C:/Users/Jakovcheski/Desktop/TransportationGrained" + abstractLinksLimit + "Links.tsv";
        BufferedWriter bwPoliticsGrained = new BufferedWriter(new FileWriter(bwPoliticsGrainedFilePath));
        BufferedWriter bwSportGrained = new BufferedWriter(new FileWriter(bwSportGrainedFilePath));
        BufferedWriter bwTransportationGrained = new BufferedWriter(new FileWriter(bwTransportationGrainedFilePath));

        try {
            boolean shouldLoopPolitics = true;
            boolean shouldLoopSport = true;
            boolean shouldLoopTransportation = true;

            inputStream = new FileInputStream(abstractFile);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                if (politics >= abstractLinksLimit && sport >= abstractLinksLimit && transportation >= abstractLinksLimit) {
                    break;
                }
                boolean foundPolitics = false;
                boolean foundSport = false;

                String line = sc.nextLine();
                String[] links = line.split(">\\s+");
                String[] parsedLink = links[0].split("\\?dbpv");
                if (shouldLoopPolitics) {
                    for (String politicsLink : politicsLinks) {
                        if (parsedLink[0].substring(1).equals(politicsLink)) {
                            if (politics < abstractLinksLimit) {
                                writeToFile(parsedLink[0], links[2], bw, bwPoliticsGrained);
                                politics++;
                            } else {
                                shouldLoopPolitics = false;
                            }
                            foundPolitics = true;
                        }
                    }
                }
                if (!foundPolitics) {
                    if (shouldLoopSport) {
                        for (String sportLink : sportLinks) {
                            if (parsedLink[0].substring(1).equals(sportLink)) {
                                if (sport < abstractLinksLimit) {
                                    System.err.println("sport");
                                    writeToFile(parsedLink[0], links[2], bw, bwSportGrained);
                                    sport++;
                                    System.err.println("sport end");
                                } else {
                                    shouldLoopSport = false;
                                }
                            }
                        }
                    }
                    if (shouldLoopTransportation) {
                        if (!foundSport) {
                            for (String transportationLink : transportationLinks) {
                                if (parsedLink[0].substring(1).equals(transportationLink)) {
                                    if (transportation < abstractLinksLimit) {
                                        writeToFile(parsedLink[0], links[2], bw, bwTransportationGrained);
                                        transportation++;
                                    } else {
                                        shouldLoopTransportation = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.err.println("politics " + politics);
            System.err.println("sport " + sport);
            System.err.println("transportation " + transportation);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
            }
            if (bwText != null) {
                bwText.close();
            }
            if (bwPoliticsGrained != null) {
                bwPoliticsGrained.close();
            }
            if (bwSportGrained != null) {
                bwSportGrained.close();
            }
            if (bwTransportationGrained != null) {
                bwTransportationGrained.close();
            }
            SpecificAllDomains.specifyDomain(bwAllLinksFile, abstractLinksLimit);
            PoliticsSpecificDomain.specifyDomain(bwPoliticsGrainedFilePath, abstractLinksLimit);
            SportSpecificDomain.specifyDomain(bwSportGrainedFilePath, abstractLinksLimit);
            TransportationSpecificDomain.specifyDomain(bwTransportationGrainedFilePath, abstractLinksLimit);
        }
    }

    private static void writeToFile(String parsedLink, String text, BufferedWriter bwAllDomains,
                                    BufferedWriter bwGrained) throws IOException {
        Map<String, String> entityType = new LinkedHashMap<>();
        entityType = FindEntityTypes.readFromNifLinks(parsedLink, fileLinksName, instanceTypeFileNames);
        FindEntityTypes.divideTextToWordAtLineWithType(bwAllDomains, text, entityType, bwGrained);
        bwText.write(text + "\n");
        bwText.flush();
    }

    private static void minNumberOfLinks() throws IOException {
        String filePath = "C:/Users/Jakovcheski/Desktop/THESIS/nif-abstract/clean-nif-abstract-context_en.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        int min = 0;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            Map<Integer, String> politicsAbstractsMap = new TreeMap<>();
            Map<Integer, String> sportAbstractsMap = new TreeMap<>();
            Map<Integer, String> transportationAbstractsMap = new TreeMap<>();
            while (sc.hasNextLine()) {
                boolean foundPolitics = false;
                boolean foundSport = false;
                String line = sc.nextLine();
                String[] parsedLink = line.split("\\?dbpv");
                for (int p = 0; p < politicsLinks.size(); p++) {
                    if (parsedLink[0].substring(1).equals(politicsLinks.get(p))) {
                        politicsAbstractsMap.put(p, line);
                        foundPolitics = true;
                    }
                }
                if (!foundPolitics) {
                    for (int s = 0; s < sportLinks.size(); s++) {
                        if (parsedLink[0].substring(1).equals(sportLinks.get(s))) {
                            sportAbstractsMap.put(s, line);
                            foundSport = true;
                        }
                    }
                    if (!foundSport) {
                        for (int t = 0; t < transportationLinks.size(); t++) {
                            if (parsedLink[0].substring(1).equals(transportationLinks.get(t))) {
                                transportationAbstractsMap.put(t, line);

                            }
                        }
                    }
                }
            }
            min = Math.min(politicsAbstractsMap.size(), Math.min(sportAbstractsMap.size(), transportationAbstractsMap.size()));
            System.err.println("min: " + min);
            if (abstractLinksLimit > min) {
                throw new RuntimeException("abstractLinksLimit is bigger than minimum number of founded links on nif-abstract, min: " + min);
            }
            politicsAbstractsMap.forEach((key, value) -> createAbstracts(value, bwPoliticsCleanedAbstract));
            sportAbstractsMap.forEach((key, value) -> createAbstracts(value, bwSportCleanedAbstract));
            transportationAbstractsMap.forEach((key, value) -> createAbstracts(value, bwTransportationCleanedAbstract));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
            if (bwPoliticsCleanedAbstract != null) {
                bwPoliticsCleanedAbstract.close();
            }
            if (bwSportCleanedAbstract != null) {
                bwSportCleanedAbstract.close();
            }
            if (bwTransportationCleanedAbstract != null) {
                bwTransportationCleanedAbstract.close();
            }
            if (bwCleanedAbstract != null) {
                bwCleanedAbstract.close();
            }
        }
    }

    private static void createAbstracts(String value, BufferedWriter bwDomainAbstracts) {
        try {
            bwDomainAbstracts.write(value + "\n");
            bwCleanedAbstract.write(value + "\n");
        } catch (IOException e) {
            e.printStackTrace();
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
