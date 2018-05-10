package domains;

import java.io.IOException;

public class SpecifyNewPaperText {

    public static void main(String[] args) throws IOException {
        String all3DomainsTextPath = "C:/Users/Jakovcheski/Desktop/All3DomainsBBCText.tsv";
        String politicsTextPath = "C:/Users/Jakovcheski/Desktop/PoliticsBBCText.tsv";
        String sportTextPath = "C:/Users/Jakovcheski/Desktop/SportBBCText.tsv";
        String transportationTextPath = "C:/Users/Jakovcheski/Desktop/TransportationBBCText.tsv";
        SpecificAllDomains.specifyDomain(all3DomainsTextPath,0);
        PoliticsSpecificDomain.specifyDomain(politicsTextPath,0);
        SportSpecificDomain.specifyDomain(sportTextPath,0);
        TransportationSpecificDomain.specifyDomain(sportTextPath,0);
    }
}
