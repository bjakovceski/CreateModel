package domains;

import divideText.DivideTextToOneWordAtLine;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class PoliticsSpecificDomain {

    public static void specifyDomain(String filePath, int abstractLinksLimit) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/PoliticsSpecifyDomainWithTop40Links.tsv"));
//        String filePath = "C:\\Users\\Jakovcheski\\Desktop\\PoliticsDomainWithTop40Links.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        BufferedWriter bwPoliticsCoarseGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/PoliticsCoarseGrainedTop" + abstractLinksLimit + "Links.tsv"));
        BufferedWriter bwPoliticsFineGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/PoliticsFineGrainedTop" + abstractLinksLimit + "Links.tsv"));

        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split("\\s");
                switch (splittedLine[1]) {
                    case "Parliament":
                    case "PoliticalParty":
                    case "GeopoliticalOrganization":
                        bwPoliticsCoarseGrained.write(splittedLine[0] + "\tPOLITICS\n");
                        bwPoliticsFineGrained.write(line + "\n");
                        break;
                    case "Chancellor":
                    case "Ambassador":
                    case "Politician":
                    case "Congressman":
                    case "Deputy":
                    case "Governor":
                    case "Lieutenant":
                    case "Mayor":
                    case "MemberOfParliament":
                    case "Minister":
                    case "President":
                    case "PrimeMinister":
                    case "Senator":
                    case "VicePresident":
                    case "VicePrimeMinister":
                    case "OfficeHolder":
                        bwPoliticsCoarseGrained.write(splittedLine[0] + "\tPOLITICS\n");
                        bwPoliticsFineGrained.write(splittedLine[0] + "\tPolitician\n");
                        break;
                    case "PoliticianSpouse":
                    case "PersonFunction":
                    case "PoliticalFunction":
                    case "Profession":
                    case "TopicalConcept":
                    case "PoliticalConcept":
                    case "Election":
                        bwPoliticsCoarseGrained.write(splittedLine[0] + "\tPOLITICS\n");
                        bwPoliticsFineGrained.write(line + "\n");
                        break;
                    default:
                        bwPoliticsCoarseGrained.write(splittedLine[0] + "\tO\n");
                        bwPoliticsFineGrained.write(splittedLine[0] + "\tO\n");
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
            if (bwPoliticsCoarseGrained != null) {
                bwPoliticsCoarseGrained.close();
            }
            if (bwPoliticsFineGrained != null) {
                bwPoliticsFineGrained.close();
            }
        }
    }
//
//    public static void main(String[] args) {
//        try {
//            specifyDomain();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
