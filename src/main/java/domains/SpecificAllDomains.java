package domains;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SpecificAllDomains {
    public static void specifyDomain() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/All3SpecificDomainsWithTop40Links.tsv"));
        String filePath = "C:\\Users\\Jakovcheski\\Desktop\\All3DomainsWithTop40Links.ttl";
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
                }else if (splittedLine[1].equals("Aircraft") || splittedLine[1].equals("aircraftType") || splittedLine[1].equals("aircraftUser")
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
                } else if (splittedLine[1].equals("Sport") || splittedLine[1].equals("Athletics") || splittedLine[1].equals("currentWorldChampion")
                        || splittedLine[1].equals("firstOlympicEvent") || splittedLine[1].equals("footedness") || splittedLine[1].equals("TeamSport")
                        || splittedLine[1].equals("SportsClub") || splittedLine[1].equals("HockeyClub") || splittedLine[1].equals("RugbyClub")
                        || splittedLine[1].equals("SoccerClub") || splittedLine[1].equals("chairmanTitle") || splittedLine[1].equals("clubsRecordGoalscorer")
                        || splittedLine[1].equals("fansgroup") || splittedLine[1].equals("firstGame") || splittedLine[1].equals("ground")
                        || splittedLine[1].equals("largestWin") || splittedLine[1].equals("managerTitle") || splittedLine[1].equals("worstDefeat")
                        || splittedLine[1].equals("NationalSoccerClub") || splittedLine[1].equals("SportsLeague") || splittedLine[1].equals("AmericanFootballLeague")
                        || splittedLine[1].equals("AustralianFootballLeague") || splittedLine[1].equals("AutoRacingLeague") || splittedLine[1].equals("BaseballLeague")
                        || splittedLine[1].equals("BasketballLeague") || splittedLine[1].equals("BowlingLeague") || splittedLine[1].equals("BoxingLeague")
                        || splittedLine[1].equals("CanadianFootballLeague") || splittedLine[1].equals("CricketLeague") || splittedLine[1].equals("CurlingLeague")
                        || splittedLine[1].equals("CyclingLeague") || splittedLine[1].equals("FieldHockeyLeague") || splittedLine[1].equals("FormulaOneRacing")
                        || splittedLine[1].equals("GolfLeague") || splittedLine[1].equals("HandballLeague") || splittedLine[1].equals("IceHockeyLeague")
                        || splittedLine[1].equals("InlineHockeyLeague") || splittedLine[1].equals("LacrosseLeague") || splittedLine[1].equals("MixedMartialArtsLeague")
                        || splittedLine[1].equals("MotorcycleRacingLeague") || splittedLine[1].equals("PaintballLeague") || splittedLine[1].equals("PoloLeague")
                        || splittedLine[1].equals("RadioControlledRacingLeague") || splittedLine[1].equals("RugbyLeague") || splittedLine[1].equals("SoccerLeague")
                        || splittedLine[1].equals("SoftballLeague") || splittedLine[1].equals("SpeedwayLeague") || splittedLine[1].equals("TennisLeague")
                        || splittedLine[1].equals("VideogamesLeague") || splittedLine[1].equals("VolleyballLeague") || splittedLine[1].equals("SportsTeam")
                        || splittedLine[1].equals("AmericanFootballTeam") || splittedLine[1].equals("AustralianFootballTeam") || splittedLine[1].equals("BaseballTeam")
                        || splittedLine[1].equals("BasketballTeam") || splittedLine[1].equals("CanadianFootballTeam") || splittedLine[1].equals("CricketTeam")
                        || splittedLine[1].equals("CyclingTeam") || splittedLine[1].equals("FormulaOneTeam") || splittedLine[1].equals("HandballTeam")
                        || splittedLine[1].equals("HockeyTeam") || splittedLine[1].equals("SpeedwayTeam") || splittedLine[1].equals("Athlete")
                        || splittedLine[1].equals("ArcherPlayer") || splittedLine[1].equals("AthleticsPlayer") || splittedLine[1].equals("AustralianRulesFootballPlayer")
                        || splittedLine[1].equals("BadmintonPlayer") || splittedLine[1].equals("BaseballPlayer") || splittedLine[1].equals("BasketballPlayer")
                        || splittedLine[1].equals("Bodybuilder") || splittedLine[1].equals("Boxer") || splittedLine[1].equals("AmateurBoxer")
                        || splittedLine[1].equals("BullFighter") || splittedLine[1].equals("Canoeist") || splittedLine[1].equals("ChessPlayer")
                        || splittedLine[1].equals("Cricketer") || splittedLine[1].equals("Cyclist") || splittedLine[1].equals("DartsPlayer")
                        || splittedLine[1].equals("Fencer") || splittedLine[1].equals("GaelicGamesPlayer") || splittedLine[1].equals("GolfPlayer")
                        || splittedLine[1].equals("GridironFootballPlayer") || splittedLine[1].equals("AmericanFootballPlayer") || splittedLine[1].equals("CanadianFootballPlayer")
                        || splittedLine[1].equals("Gymnast") || splittedLine[1].equals("HandballPlayer") || splittedLine[1].equals("HighDiver")
                        || splittedLine[1].equals("HorseRider") || splittedLine[1].equals("Jockey") || splittedLine[1].equals("LacrossePlayer")
                        || splittedLine[1].equals("MartialArtist") || splittedLine[1].equals("MotorsportRacer") || splittedLine[1].equals("MotorcycleRider")
                        || splittedLine[1].equals("MotocycleRacer") || splittedLine[1].equals("SpeedwayRider") || splittedLine[1].equals("RacingDriver")
                        || splittedLine[1].equals("DTMRacer") || splittedLine[1].equals("FormulaOneRacer") || splittedLine[1].equals("NascarDriver")
                        || splittedLine[1].equals("RallyDriver") || splittedLine[1].equals("NationalCollegiateAthleticAssociationAthlete") || splittedLine[1].equals("NetballPlayer")
                        || splittedLine[1].equals("PokerPlayer") || splittedLine[1].equals("Rower") || splittedLine[1].equals("RugbyPlayer")
                        || splittedLine[1].equals("SnookerPlayer") || splittedLine[1].equals("SnookerChamp") || splittedLine[1].equals("SoccerPlayer")
                        || splittedLine[1].equals("SquashPlayer") || splittedLine[1].equals("Surfer") || splittedLine[1].equals("Swimmer")
                        || splittedLine[1].equals("TableTennisPlayer") || splittedLine[1].equals("TeamMember") || splittedLine[1].equals("TennisPlayer")
                        || splittedLine[1].equals("VolleyballPlayer") || splittedLine[1].equals("BeachVolleyballPlayer ") || splittedLine[1].equals("WaterPoloPlayer")
                        || splittedLine[1].equals("WinterSportPlayer") || splittedLine[1].equals("Biathlete") || splittedLine[1].equals("BobsleighAthlete ")
                        || splittedLine[1].equals("CrossCountrySkier") || splittedLine[1].equals("Curler") || splittedLine[1].equals("FigureSkater")
                        || splittedLine[1].equals("IceHockeyPlayer") || splittedLine[1].equals("NordicCombined") || splittedLine[1].equals("Skater")
                        || splittedLine[1].equals("Ski_jumper") || splittedLine[1].equals("Skier") || splittedLine[1].equals("SpeedSkater")
                        || splittedLine[1].equals("Wrestler") || splittedLine[1].equals("SumoWrestler") || splittedLine[1].equals("Coach")
                        || splittedLine[1].equals("AmericanFootballCoach") || splittedLine[1].equals("CollegeCoach") || splittedLine[1].equals("VolleyballCoach")
                        || splittedLine[1].equals("OrganisationMember") || splittedLine[1].equals("SportsTeamMember") || splittedLine[1].equals("SportsManager")
                        || splittedLine[1].equals("SoccerManager") || splittedLine[1].equals("SportsEvent") || splittedLine[1].equals("CyclingCompetition")
                        || splittedLine[1].equals("FootballMatch") || splittedLine[1].equals("GrandPrix") || splittedLine[1].equals("InternationalFootballLeagueEvent")
                        || splittedLine[1].equals("MixedMartialArtsEvent") || splittedLine[1].equals("NationalFootballLeagueEvent") || splittedLine[1].equals("Olympics")
                        || splittedLine[1].equals("OlympicEvent") || splittedLine[1].equals("Race") || splittedLine[1].equals("CyclingRace")
                        || splittedLine[1].equals("HorseRace") || splittedLine[1].equals("MotorRace") || splittedLine[1].equals("Tournament")
                        || splittedLine[1].equals("GolfTournament") || splittedLine[1].equals("SoccerTournament") || splittedLine[1].equals("TennisTournament")
                        || splittedLine[1].equals("WomensTennisAssociationTournament") || splittedLine[1].equals("WrestlingEvent") || splittedLine[1].equals("SportCompetitionResult")
                        || splittedLine[1].equals("OlympicResult") || splittedLine[1].equals("SnookerWorldRanking") || splittedLine[1].equals("SportsSeason")
                        || splittedLine[1].equals("MotorsportSeason") || splittedLine[1].equals("SportsTeamSeason") || splittedLine[1].equals("BaseballSeason")
                        || splittedLine[1].equals("FootballLeagueSeason") || splittedLine[1].equals("NationalFootballLeagueSeason") || splittedLine[1].equals("NCAATeamSeason")
                        || splittedLine[1].equals("SoccerClubSeason") || splittedLine[1].equals("SoccerLeagueSeason")
                ) {
                    bw.write(splittedLine[0] + "\tSPORT\n");
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
