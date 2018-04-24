package domains;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SportSpecificDomain {

    public static void specifyDomain() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/SportSpecifyDomainWithTop40Links.tsv"));
        String filePath = "C:\\Users\\Jakovcheski\\Desktop\\SportDomainWithTop40Links.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split("\\s");
                if (splittedLine[1].equals("Sport") || splittedLine[1].equals("Athletics") || splittedLine[1].equals("currentWorldChampion")
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
                        || splittedLine[1].equals("SoccerClubSeason") || splittedLine[1].equals("SoccerLeagueSeason")|| splittedLine[1].equals("Referee")
                        || splittedLine[1].equals("SportFacility") || splittedLine[1].equals("CricketGround")|| splittedLine[1].equals("GolfCourse")
                        || splittedLine[1].equals("RaceTrack") || splittedLine[1].equals("SkiArea")
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