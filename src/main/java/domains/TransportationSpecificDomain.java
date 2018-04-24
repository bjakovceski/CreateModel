package domains;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TransportationSpecificDomain {

    public static void specifyDomain() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/TransportationSpecifyDomainWithTop40Links.tsv"));
        String filePath = "C:\\Users\\Jakovcheski\\Desktop\\TransportationDomainWithTop40Links.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split("\\s");
                if (splittedLine[1].equals("Aircraft") || splittedLine[1].equals("aircraftType") || splittedLine[1].equals("aircraftUser")
                        || splittedLine[1].equals("ceiling") || splittedLine[1].equals("dischargeAverage") || splittedLine[1].equals("enginePower")
                        || splittedLine[1].equals("engineType") || splittedLine[1].equals("gun") || splittedLine[1].equals("powerType")
                        || splittedLine[1].equals("wingArea") || splittedLine[1].equals("wingspan") || splittedLine[1].equals("MilitaryAircraft")
                        || splittedLine[1].equals("Automobile") || splittedLine[1].equals("automobilePlatform") || splittedLine[1].equals("bodyStyle")
                        || splittedLine[1].equals("enginePower") || splittedLine[1].equals("engineType") || splittedLine[1].equals("powerType")
                        || splittedLine[1].equals("transmission") || splittedLine[1].equals("Locomotive") || splittedLine[1].equals("boiler")
                        || splittedLine[1].equals("boilerPressure") || splittedLine[1].equals("CylinderCount") || splittedLine[1].equals("engineType")
                        || splittedLine[1].equals("powerType") || splittedLine[1].equals("MilitaryVehicle") || splittedLine[1].equals("Motorcycle")
                        || splittedLine[1].equals("On-SiteTransportation") || splittedLine[1].equals("ConveyorSystem") || splittedLine[1].equals("Escalator")
                        || splittedLine[1].equals("MovingWalkway") || splittedLine[1].equals("Rocket") || splittedLine[1].equals("countryOrigin")
                        || splittedLine[1].equals("finalFlight") || splittedLine[1].equals("lowerEarthOrbitPayload") || splittedLine[1].equals("maidenFlight")
                        || splittedLine[1].equals("rocketFunction") || splittedLine[1].equals("rocketStages") || splittedLine[1].equals("Ship")
                        || splittedLine[1].equals("captureDate") || splittedLine[1].equals("homeport") || splittedLine[1].equals("layingDown")
                        || splittedLine[1].equals("maidenVoyage") || splittedLine[1].equals("numberOfPassengers") || splittedLine[1].equals("shipCrew")
                        || splittedLine[1].equals("shipLaunch") || splittedLine[1].equals("SpaceShuttle") || splittedLine[1].equals("contractAward")
                        || splittedLine[1].equals("Crews") || splittedLine[1].equals("firstFlight") || splittedLine[1].equals("lastFlight")
                        || splittedLine[1].equals("missions") || splittedLine[1].equals("numberOfCrew") || splittedLine[1].equals("numberOfLaunches")
                        || splittedLine[1].equals("satellitesDeployed") || splittedLine[1].equals("SpaceStation") || splittedLine[1].equals("Spacecraft")
                        || splittedLine[1].equals("cargoFuel") || splittedLine[1].equals("cargoGas") || splittedLine[1].equals("cargoWater")
                        || splittedLine[1].equals("rocket") || splittedLine[1].equals("Train") || splittedLine[1].equals("locomotive")
                        || splittedLine[1].equals("wagon") || splittedLine[1].equals("TrainCarriage") || splittedLine[1].equals("Tram")
                        || splittedLine[1].equals("Engine") || splittedLine[1].equals("AutomobileEngine") || splittedLine[1].equals("RocketEngine")
                        || splittedLine[1].equals("PublicTransitSystem") || splittedLine[1].equals("Airline") || splittedLine[1].equals("BusCompany")
                        || splittedLine[1].equals("Infrastructure") || splittedLine[1].equals("Airport") || splittedLine[1].equals("Port")
                        || splittedLine[1].equals("RestArea") || splittedLine[1].equals("RouteOfTransportation") || splittedLine[1].equals("Bridge")
                        || splittedLine[1].equals("RailwayLine") || splittedLine[1].equals("RailwayTunnel") || splittedLine[1].equals("WaterwayTunnel")
                        || splittedLine[1].equals("Station") || splittedLine[1].equals("MetroStation") || splittedLine[1].equals("RailwayStation")
                        || splittedLine[1].equals("RouteStop") || splittedLine[1].equals("TramStation") || splittedLine[1].equals("engineType")
                        || splittedLine[1].equals("boilerPressure") || splittedLine[1].equals("CylinderCount") || splittedLine[1].equals("engineType")
                        ) {
                    bw.write(splittedLine[0] + "\tTRANSPORTATION\n");
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
