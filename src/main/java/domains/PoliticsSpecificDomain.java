package domains;

import divideText.DivideTextToOneWordAtLine;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class PoliticsSpecificDomain {

    public static void specifyDomain() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/PoliticsSpecifyDomainWithTop40Links.tsv"));
        String filePath = "C:\\Users\\Jakovcheski\\Desktop\\PoliticsDomainWithTop40Links.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split("\\s");
                if (splittedLine[1].equals("Parliament") || splittedLine[1].equals("PoliticalParty") || splittedLine[1].equals("GeopoliticalOrganization")
                        || splittedLine[1].equals("Chancellor") || splittedLine[1].equals("Ambassador") || splittedLine[1].equals("Politician")
                        || splittedLine[1].equals("Congressman") || splittedLine[1].equals("Deputy") || splittedLine[1].equals("Governor")
                        || splittedLine[1].equals("Lieutenant") || splittedLine[1].equals("Mayor") || splittedLine[1].equals("MemberOfParliament")
                        || splittedLine[1].equals("Minister") || splittedLine[1].equals("President") || splittedLine[1].equals("PrimeMinister")
                        || splittedLine[1].equals("Senator") || splittedLine[1].equals("VicePresident") || splittedLine[1].equals("VicePrimeMinister")
                        || splittedLine[1].equals("PoliticianSpouse") || splittedLine[1].equals("PersonFunction") || splittedLine[1].equals("PoliticalFunction")
                        || splittedLine[1].equals("Profession") || splittedLine[1].equals("TopicalConcept") || splittedLine[1].equals("PoliticalConcept")
                        ) {
                    bw.write(splittedLine[0] + "\tPOLITICS\n");
                    bw.flush();
                } else {
                    bw.write(splittedLine[0] + "\tO\n");
                    bw.flush();
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
    }

    public static void main(String[] args) {
        try {
            specifyDomain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
