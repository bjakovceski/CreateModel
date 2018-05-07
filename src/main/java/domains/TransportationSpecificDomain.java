package domains;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TransportationSpecificDomain {

    public static void specifyDomain(String filePath, int abstractLinksLimit) throws IOException {
        BufferedWriter bwTransportationCoarseGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/TransportationCoarseGrainedTop" +
                abstractLinksLimit + "LinksWithLowerPageRank.tsv"));
        BufferedWriter bwTransportationFineGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/TransportationFineGrainedTop" +
                abstractLinksLimit + "LinksWithLowerPageRank.tsv"));
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split("\\s");
                switch (splittedLine[1]) {
                    case "Aircraft":
                    case "aircraftType":
                    case "aircraftUser":
                    case "ceiling":
                    case "dischargeAverage":
                    case "enginePower":
                    case "engineType":
                    case "gun":
                    case "powerType":
                    case "wingArea":
                    case "wingspan":
                    case "MilitaryAircraft":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tAircraft\n");
                        break;
                    case "Automobile":
                    case "automobilePlatform":
                    case "bodyStyle":
                    case "transmission":
                    case "AutomobileEngine":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tAutomobile\n");
                        break;
                    case "Locomotive":
                    case "boiler":
                    case "CylinderCount":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tLocomotive\n");
                        break;
                    case "MilitaryVehicle":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(line + "\n");
                        break;
                    case "Motorcycle":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(line + "\n");
                        break;
                    case "On-SiteTransportation":
                    case "ConveyorSystem":
                    case "Escalator":
                    case "MovingWalkway":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tOn-SiteTransportation\n");
                        break;
                    case "Rocket":
                    case "countryOrigin":
                    case "finalFlight":
                    case "lowerEarthOrbitPayload":
                    case "maidenFlight":
                    case "rocketFunction":
                    case "rocketStages":
                    case "RocketEngine":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tRocket\n");
                        break;
                    case "Ship":
                    case "captureDate":
                    case "homeport":
                    case "layingDown":
                    case "maidenVoyage":
                    case "numberOfPassengers":
                    case "shipCrew":
                    case "shipLaunch":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tShip\n");
                        break;
                    case "SpaceShuttle":
                    case "contractAward":
                    case "Crews":
                    case "firstFlight":
                    case "lastFlight":
                    case "missions":
                    case "numberOfCrew":
                    case "numberOfLaunches":
                    case "satellitesDeployed":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tSpaceShuttle\n");
                        break;
                    case "SpaceStation":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(line + "\n");
                        break;
                    case "Spacecraft":
                    case "cargoFuel":
                    case "cargoGas":
                    case "cargoWater":
                    case "rocket":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tSpacecraft\n");
                        break;
                    case "Train":
                    case "locomotive":
                    case "wagon":
                    case "TrainCarriage":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tTrain\n");
                        break;
                    case "Tram":
                    case "PublicTransitSystem":
                    case "Airline":
                    case "BusCompany":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tPublicTransitSystem\n");
                        break;
                    case "Infrastructure":
                    case "Airport":
                    case "Port":
                    case "RestArea":
                    case "RouteOfTransportation":
                    case "Bridge":
                    case "RailwayLine":
                    case "RailwayTunnel":
                    case "WaterwayTunnel":
                    case "Station":
                    case "MetroStation":
                    case "RailwayStation":
                    case "RouteStop":
                    case "TramStation":
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tInfrastructure\n");
                        break;
                    default:
                        bwTransportationCoarseGrained.write(splittedLine[0] + "\tO\n");
                        bwTransportationFineGrained.write(splittedLine[0] + "\tO\n");
                        break;
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
            if (bwTransportationCoarseGrained != null) {
                bwTransportationCoarseGrained.close();
            }
            if (bwTransportationFineGrained != null) {
                bwTransportationFineGrained.close();
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
