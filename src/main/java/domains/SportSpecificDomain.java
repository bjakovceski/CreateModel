package domains;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SportSpecificDomain {

    public static void specifyDomain(String filePath, int abstractLinksLimit) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;

        BufferedWriter bwSportCoarseGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/SportCoarseGrainedTop" +
                abstractLinksLimit + "Links.tsv"));
        BufferedWriter bwSportFineGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/SportFineGrainedTop" +
                abstractLinksLimit + "Links.tsv"));

        //UNCOMMENT THIS FOR NEW PAPER ANNOTATION
//        BufferedWriter bwSportCoarseGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/SportBBCCoarseGrained.tsv"));
//        BufferedWriter bwSportFineGrained = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/SportBBCFineGrained.tsv"));

        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split("\\s");
                switch (splittedLine[1]) {
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
                        bwSportCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                        bwSportFineGrained.write(splittedLine[0] + "\tSportsClub\n");
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
                        bwSportCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                        bwSportFineGrained.write(splittedLine[0] + "\tSportsLeague\n");
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
                        bwSportCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                        bwSportFineGrained.write(splittedLine[0] + "\tSportsTeam\n");
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
                        bwSportCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                        bwSportFineGrained.write(splittedLine[0] + "\tAthlete\n");
                        break;
                    case "Coach":
                    case "AmericanFootballCoach":
                    case "CollegeCoach":
                    case "VolleyballCoach":
                        bwSportCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                        bwSportFineGrained.write(splittedLine[0] + "\tCoach\n");
                        break;
                    case "OrganisationMember":
                    case "SportsTeamMember":
                        bwSportCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                        bwSportFineGrained.write(splittedLine[0] + "\tOrganisationMember\n");
                        break;
                    case "SportsManager":
                    case "SoccerManager":
                        bwSportCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                        bwSportFineGrained.write(splittedLine[0] + "\tSportsManager\n");
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
                        bwSportCoarseGrained.write(splittedLine[0] + "\tSPORT\n");
                        bwSportFineGrained.write(splittedLine[0] + "\tSportsEvent\n");
                        break;
                    default:
                        bwSportCoarseGrained.write(splittedLine[0] + "\tO\n");
                        bwSportFineGrained.write(splittedLine[0] + "\tO\n");
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
            if (bwSportCoarseGrained != null) {
                bwSportCoarseGrained.close();
            }
            if (bwSportFineGrained != null) {
                bwSportFineGrained.close();
            }
        }
    }

//    public static void main(String[] args) {
//        try {
//            specifyDomain();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
