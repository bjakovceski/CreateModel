package domains;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SpecificAllDomains {
    public static void specifyDomain(String filePath, int abstractLinksLimit) throws IOException {
        BufferedWriter bwFineGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/All3DomainsTop" +
                abstractLinksLimit + "LinksTextWithSameProcessedLinksOnAbstractFineGrainedSpecified.tsv"));
        BufferedWriter bwCoarseGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/All3DomainsTop" +
                abstractLinksLimit + "LinksTextWithSameProcessedLinksOnAbstractCoarseGrainedSpecified.tsv"));

        //UNCOMMENT THIS FOR NEW PAPER ANNOTATION
//        BufferedWriter bwFineGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/All3DomainsBBCFineGrainedSpecified.tsv"));
//        BufferedWriter bwCoarseGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/All3DomainsTopBBCCoarseGrainedSpecified.tsv"));

        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split("\\s");
                if (splittedLine.length > 1) {
                    switch (splittedLine[1]) {
                        case "Parliament":
                        case "PoliticalParty":
                        case "GeopoliticalOrganization":
                            bwCoarseGrained.write(splittedLine[0] + "\tPOLITICS\n");
                            bwFineGrained.write(line + "\n");
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
                            bwCoarseGrained.write(splittedLine[0] + "\tPOLITICS\n");
                            bwFineGrained.write(splittedLine[0] + "\tPolitician\n");
                            break;
                        case "PoliticianSpouse":
                        case "PersonFunction":
                        case "PoliticalFunction":
                        case "Profession":
                        case "TopicalConcept":
                        case "PoliticalConcept":
                            bwCoarseGrained.write(splittedLine[0] + "\tPOLITICS\n");
                            bwFineGrained.write(line + "\n");
                            break;

                        //TRANSPORTATION DOMAIN
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
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tAircraft\n");
                            break;
                        case "Automobile":
                        case "automobilePlatform":
                        case "bodyStyle":
                        case "transmission":
                        case "AutomobileEngine":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tAutomobile\n");
                            break;
                        case "Locomotive":
                        case "boiler":
                        case "CylinderCount":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tLocomotive\n");
                            break;
                        case "MilitaryVehicle":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(line + "\n");
                            break;
                        case "Motorcycle":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(line + "\n");
                            break;
                        case "On-SiteTransportation":
                        case "ConveyorSystem":
                        case "Escalator":
                        case "MovingWalkway":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tOn-SiteTransportation\n");
                            break;
                        case "Rocket":
                        case "countryOrigin":
                        case "finalFlight":
                        case "lowerEarthOrbitPayload":
                        case "maidenFlight":
                        case "rocketFunction":
                        case "rocketStages":
                        case "RocketEngine":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tRocket\n");
                            break;
                        case "Ship":
                        case "captureDate":
                        case "homeport":
                        case "layingDown":
                        case "maidenVoyage":
                        case "numberOfPassengers":
                        case "shipCrew":
                        case "shipLaunch":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tShip\n");
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
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tSpaceShuttle\n");
                            break;
                        case "SpaceStation":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(line + "\n");
                            break;
                        case "Spacecraft":
                        case "cargoFuel":
                        case "cargoGas":
                        case "cargoWater":
                        case "rocket":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tSpacecraft\n");
                            break;
                        case "Train":
                        case "locomotive":
                        case "wagon":
                        case "TrainCarriage":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tTrain\n");
                            break;
                        case "Tram":
                        case "PublicTransitSystem":
                        case "Airline":
                        case "BusCompany":
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tPublicTransitSystem\n");
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
                            bwCoarseGrained.write(splittedLine[0] + "\tTRANSPORTATION\n");
                            bwFineGrained.write(splittedLine[0] + "\tInfrastructure\n");
                            break;

//                    SPORT DOMAIN
                        case "Sport":
                        case "firstOlympicEvent":
                        case "footedness":
                        case "TeamSport":
                        case "SportsClub":
                        case "HockeyClub":
                        case "RugbyClub":
                        case "SoccerClub":
                        case "chairmanTitle":
                        case "clubsRecordGoalscorer":
                        case "fansgroup":
                        case "firstGame":
                        case "ground":
                        case "largestWin":
                        case "managerTitle":
                        case "worstDefeat":
                        case "NationalSoccerClub":
                            bwCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                            bwFineGrained.write(splittedLine[0] + "\tSportsClub\n");
                            break;
                        case "SportsLeague":
                        case "AmericanFootballLeague":
                        case "AustralianFootballLeague":
                        case "AutoRacingLeague":
                        case "BaseballLeague":
                        case "BasketballLeague":
                        case "BowlingLeague":
                        case "BoxingLeague":
                        case "CanadianFootballLeague":
                        case "CricketLeague":
                        case "CurlingLeague":
                        case "CyclingLeague":
                        case "FieldHockeyLeague":
                        case "FormulaOneRacing":
                        case "GolfLeague":
                        case "HandballLeague":
                        case "IceHockeyLeague":
                        case "InlineHockeyLeague":
                        case "LacrosseLeague":
                        case "MixedMartialArtsLeague":
                        case "MotorcycleRacingLeague":
                        case "PaintballLeague":
                        case "PoloLeague":
                        case "RadioControlledRacingLeague":
                        case "RugbyLeague":
                        case "SoccerLeague":
                        case "SoftballLeague":
                        case "SpeedwayLeague":
                        case "TennisLeague":
                        case "VideogamesLeague":
                        case "VolleyballLeague":
                            bwCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                            bwFineGrained.write(splittedLine[0] + "\tSportsLeague\n");
                            break;
                        case "SportsTeam":
                        case "AmericanFootballTeam":
                        case "AustralianFootballTeam":
                        case "BaseballTeam":
                        case "BasketballTeam":
                        case "CanadianFootballTeam":
                        case "CricketTeam":
                        case "CyclingTeam":
                        case "FormulaOneTeam":
                        case "HandballTeam":
                        case "HockeyTeam":
                        case "SpeedwayTeam":
                            bwCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                            bwFineGrained.write(splittedLine[0] + "\tSportsTeam\n");
                            break;
                        case "Athlete":
                        case "ArcherPlayer":
                        case "AthleticsPlayer":
                        case "AustralianRulesFootballPlayer":
                        case "BadmintonPlayer":
                        case "BaseballPlayer":
                        case "BasketballPlayer":
                        case "Bodybuilder":
                        case "Boxer":
                        case "AmateurBoxer":
                        case "BullFighter":
                        case "Canoeist":
                        case "ChessPlayer":
                        case "Cricketer":
                        case "Cyclist":
                        case "DartsPlayer":
                        case "Fencer":
                        case "GaelicGamesPlayer":
                        case "GolfPlayer":
                        case "GridironFootballPlayer":
                        case "AmericanFootballPlayer":
                        case "CanadianFootballPlayer":
                        case "Gymnast":
                        case "HandballPlayer":
                        case "HighDiver":
                        case "HorseRider":
                        case "Jockey":
                        case "LacrossePlayer":
                        case "MartialArtist":
                        case "MotorsportRacer":
                        case "MotorcycleRider":
                        case "MotocycleRacer":
                        case "SpeedwayRider":
                        case "RacingDriver":
                        case "DTMRacer":
                        case "FormulaOneRacer":
                        case "NascarDriver":
                        case "RallyDriver":
                        case "NationalCollegiateAthleticAssociationAthlete":
                        case "NetballPlayer":
                        case "PokerPlayer":
                        case "Rower":
                        case "RugbyPlayer":
                        case "SnookerPlayer":
                        case "SnookerChamp":
                        case "SoccerPlayer":
                        case "SquashPlayer":
                        case "Surfer":
                        case "Swimmer":
                        case "TableTennisPlayer":
                        case "TeamMember":
                        case "TennisPlayer":
                        case "VolleyballPlayer":
                        case "BeachVolleyballPlayer ":
                        case "WaterPoloPlayer":
                        case "WinterSportPlayer":
                        case "Biathlete":
                        case "BobsleighAthlete ":
                        case "CrossCountrySkier":
                        case "Curler":
                        case "FigureSkater":
                        case "IceHockeyPlayer":
                        case "NordicCombined":
                        case "Skater":
                        case "Ski_jumper":
                        case "Skier":
                        case "SpeedSkater":
                        case "Wrestler":
                        case "SumoWrestler":
                        case "Athletics":
                        case "currentWorldChampion":
                            bwCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                            bwFineGrained.write(splittedLine[0] + "\tAthlete\n");
                            break;
                        case "Coach":
                        case "AmericanFootballCoach":
                        case "CollegeCoach":
                        case "VolleyballCoach":
                            bwCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                            bwFineGrained.write(splittedLine[0] + "\tCoach\n");
                            break;
                        case "OrganisationMember":
                        case "SportsTeamMember":
                            bwCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                            bwFineGrained.write(splittedLine[0] + "\tOrganisationMember\n");
                            break;
                        case "SportsManager":
                        case "SoccerManager":
                            bwCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                            bwFineGrained.write(splittedLine[0] + "\tSportsManager\n");
                            break;
                        case "SportsEvent":
                        case "CyclingCompetition":
                        case "FootballMatch":
                        case "GrandPrix":
                        case "InternationalFootballLeagueEvent":
                        case "MixedMartialArtsEvent":
                        case "NationalFootballLeagueEvent":
                        case "Olympics":
                        case "OlympicEvent":
                        case "Race":
                        case "CyclingRace":
                        case "HorseRace":
                        case "MotorRace":
                        case "Tournament":
                        case "GolfTournament":
                        case "SoccerTournament":
                        case "TennisTournament":
                        case "WomensTennisAssociationTournament":
                        case "WrestlingEvent":
                        case "SportCompetitionResult":
                        case "OlympicResult":
                        case "SnookerWorldRanking":
                        case "SportsSeason":
                        case "MotorsportSeason":
                        case "SportsTeamSeason":
                        case "BaseballSeason":
                        case "FootballLeagueSeason":
                        case "NationalFootballLeagueSeason":
                        case "NCAATeamSeason":
                        case "SoccerClubSeason":
                        case "SoccerLeagueSeason":
                        case "MotorSportSeason":
                            bwCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                            bwFineGrained.write(splittedLine[0] + "\tSportsEvent\n");
                            break;
                        default:
                            bwCoarseGrained.write(splittedLine[0] + "\tO\n");
                            bwFineGrained.write(splittedLine[0] + "\tO\n");
                            break;
                    }
                } else {
                    System.err.println("hereeeee");
                    System.err.println(line);
                    bwCoarseGrained.write(splittedLine[0] + "\tO\n");
                    bwFineGrained.write(splittedLine[0] + "\tO\n");
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
            if (bwCoarseGrained != null) {
                bwCoarseGrained.close();
            }
            if (bwFineGrained != null) {
                bwFineGrained.close();
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
